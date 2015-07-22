using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Text;
using System.IO;
using System.Net;
using System.Runtime.Serialization.Json;
using System.Web.Script.Serialization;

public struct SurveyResults
{
    public int SurveyID;
    public String SurveyTitle;
    public int choice11, choice12, choice13, choice14,
        choice21, choice22, choice23, choice24, 
        choice31, choice32, choice33, choice34;
    public string question1, question2, question3;
    public string choiceText11, choiceText12, choiceText13, choiceText14,
        choiceText21, choiceText22, choiceText23, choiceText24,
        choiceText31, choiceText32, choiceText33, choiceText34;
};

public partial class GetJSON : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        SqlConnection con1 = new SqlConnection(SqlDataSource3.ConnectionString);
        SqlConnection con2 = new SqlConnection(SqlDataSource1.ConnectionString);
        SqlConnection con3 = new SqlConnection(SqlDataSource2.ConnectionString);
        SurveyResults SR = new SurveyResults();

        con2.Open();

        string str2SQL = "SELECT * FROM [koalasurvey].[Surveys]";
        SqlCommand cmd2 = new SqlCommand(str2SQL, con2);
        SqlDataReader reader2 = cmd2.ExecuteReader();
        reader2.Read();

        while (reader2["SurveyID"].ToString() != Request["SurveyID"])
        {
            reader2.Read();
        }
        SR.SurveyTitle = reader2["SurveyName"].ToString();

        con2.Close();
        con3.Open();

        string str3SQL = "SELECT * FROM [koalasurvey].[Question]";
        SqlCommand cmd3 = new SqlCommand(str3SQL, con3);
        SqlDataReader reader3 = cmd3.ExecuteReader();

        reader3.Read();

        while (reader3["SurveyID"].ToString() != Request["SurveyID"])
        {
            reader3.Read();
        }

        SR.question1 = reader3["QuestionText"].ToString();
        reader3.Read();
        SR.question2 = reader3["QuestionText"].ToString();
        reader3.Read();
        SR.question3 = reader3["QuestionText"].ToString();

        con3.Close();
        con1.Open();

        string str1SQL = "SELECT * FROM [koalasurvey].[Answers]";
        SqlCommand cmd = new SqlCommand(str1SQL, con1);
        SqlDataReader reader1 = cmd.ExecuteReader();

        if(reader1.Read())
        {
            SR.SurveyID = Convert.ToInt32(Request["SurveyID"]);

            while (reader1["SurveyID"].ToString() != Request["SurveyID"])
            {
                reader1.Read();
            }

            SR.choice11 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText11 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice12 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText12 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice13 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText13 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice14 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText14 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice21 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText21 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice22 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText22 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice23 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText23 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice24 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText24 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice31 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText31 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice32 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText32 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice33 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText33 = Convert.ToString(reader1["AnswerText"]);
            reader1.Read();
            SR.choice34 = Convert.ToInt32(reader1["AnswerCount"]);
            SR.choiceText34 = Convert.ToString(reader1["AnswerText"]);

            /*while(reader1["SurveyID"].ToString() == Request["SurveyID"])
            {
                SR.choices.Add(Convert.ToInt32(reader1["AnswerCount"]));
                SR.choiceText.Add(reader1["AnswerText"].ToString());
                reader1.Read();
            }*/
        }

        con1.Close();

        JavaScriptSerializer serializer = new JavaScriptSerializer();
        string strJson = serializer.Serialize(SR);

        Response.Clear();
        Response.ContentType = "application/json; charset=utf-8";
        Response.Write(strJson);
        Response.End();
    }
}