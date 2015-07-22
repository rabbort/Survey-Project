using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Web.Configuration;
using System.Data.SqlClient;
using System.Text;
using System.Collections.Generic;

public partial class TakeSurvey : System.Web.UI.Page
{
    List<RadioButton> rButtons = new List<RadioButton>();
    List<CheckBox> cBoxes = new List<CheckBox>();
    RadioButton p1;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            GetSurvey(Convert.ToInt32(Request["SurveyID"]));
        }
        if(Cache["test"] != null)
        {
            Panel test = Cache["test"] as Panel;
            test.ID = "Panel2";
            PlaceHolder1.Controls.Add(test);
        }
    }

    private void GetSurvey(int survID)
    {
        Label newLabel;

        string surveySQL = "SELECT * FROM [koalasurvey].[Surveys]";

        SqlConnection con = new SqlConnection(SqlDataSource1.ConnectionString);
        SqlCommand surveycmd = new SqlCommand(surveySQL, con);

        SqlDataReader reader;

        con.Open();
        reader = surveycmd.ExecuteReader();
        while(reader.Read())
        {
            if ((int)reader["SurveyID"] == survID)
                break;
        }

        newLabel = new Label();
        newLabel.Text = reader["SurveyName"].ToString() + "<br />";
        Panel1.Controls.Add(newLabel);

        insertQuestions((int)reader["SurveyID"]);

        Panel1.DataBind();
        Cache["test"] = Panel1;
        con.Close();
    }

    private void insertQuestions(int surveyID)
    {
        Label newLabel;
        int i = 0;

        string questionSQL = "SELECT * FROM [koalasurvey].[Question]";

        SqlConnection con = new SqlConnection(SqlDataSource2.ConnectionString);
        SqlCommand questioncmd = new SqlCommand(questionSQL, con);

        SqlDataReader reader;

        con.Open();
        reader = questioncmd.ExecuteReader();

        while(reader.Read())
        {
            if ((int)reader["SurveyID"] != surveyID)
                continue;

            newLabel = new Label();
            newLabel.Text = reader["QuestionText"].ToString() + "<br />";
            Panel1.Controls.Add(newLabel);

            insertAnswers((int)reader["QuestionID"], (int)reader["QuestionType"]);
        }

        con.Close();
    }

    private void insertAnswers(int questionID, int questionType)
     {
        int i = 1;
        RadioButton newRB;
        CheckBox newCB;

        string answerSQL = "SELECT * FROM [koalasurvey].[Answers]";

        SqlConnection con = new SqlConnection(SqlDataSource3.ConnectionString);
        SqlCommand answercmd = new SqlCommand(answerSQL, con);

        SqlDataReader reader;

        con.Open();
        reader = answercmd.ExecuteReader();
        
        while(reader.Read())
        {
            if ((int)reader["QuestionID"] != questionID)
                continue;
        
            if(questionType == 1)
            {
                newRB = new RadioButton();
                newRB.Text = reader["AnswerText"].ToString() + "<br />";
                newRB.GroupName = questionID.ToString();
                newRB.ID = questionID.ToString()+i++;
                Panel1.Controls.Add(newRB);
                rButtons.Add(newRB);
            }
            if(questionType == 2)
            {
                newCB = new CheckBox();
                newCB.Text = reader["AnswerText"].ToString() + "<br />";
                newCB.ID = questionID.ToString() + i++;
                newCB.AccessKey = (reader["AnswerID"].ToString().Length - reader["QuestionID"].ToString().Length).ToString();
                Panel1.Controls.Add(newCB);
                cBoxes.Add(newCB);
            }
        }

        con.Close();
    }

    protected void Submit(object sender, EventArgs e)
    {
        SqlConnection con = new SqlConnection(SqlDataSource3.ConnectionString);
        con.Open();
        string strSQL;
        SqlCommand cmd;

        Panel test = Cache["test"] as Panel;

        for(int i = 0; i < test.Controls.Count; i++)
        {
            if(test.Controls[i] is RadioButton)
            {
                if(((RadioButton)test.Controls[i]).Checked)
                {
                    strSQL = String.Format("update [koalasurvey].[Answers] set {0}={0}+1 where AnswerID={1} and QuestionID={2}", "AnswerCount", ((RadioButton)test.Controls[i]).ID, ((RadioButton)test.Controls[i]).GroupName);
                    cmd = new SqlCommand(strSQL, con);
                    cmd.ExecuteNonQuery();
                }
            }
            else if(test.Controls[i] is CheckBox)
            {
                if(((CheckBox)test.Controls[i]).Checked)
                {
                    int questionID = Convert.ToInt32(((CheckBox)test.Controls[i]).ID) / (int)(Math.Pow(10, Convert.ToInt32(((CheckBox)test.Controls[i]).AccessKey)));
                    strSQL = String.Format("update [koalasurvey].[Answers] set {0}={0}+1 where AnswerID={1} and QuestionID={2}", "AnswerCount", ((CheckBox)test.Controls[i]).ID, questionID);
                    cmd = new SqlCommand(strSQL, con);
                    cmd.ExecuteNonQuery();
                }
            }
        }

        con.Close();
    }
}