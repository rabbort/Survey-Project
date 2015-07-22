using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class ViewSurvey : System.Web.UI.Page
{
    public void OutputSurveyID()
    {
        Response.Write(Convert.ToString(Request["SurveyID"]));
    }

    protected void Page_Load(object sender, EventArgs e)
    {

    }
}