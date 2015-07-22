<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Available surveys</h1>
        <a href="TakeSurvey.aspx?SurveyID=1">Take Bird Survey</a><br /><a href="ViewSurvey.aspx?SurveyID=1">View Bird Survey Results</a><br /><br />
        <a href="TakeSurvey.aspx?SurveyID=2">Take Potato Survey</a><br /><a href="ViewSurvey.aspx?SurveyID=2">View Potato Survey Results</a><br /><br />
        <a href="TakeSurvey.aspx?SurveyID=3">Take Pizza Survey</a><br /><a href="ViewSurvey.aspx?SurveyID=3">View Pizza Survey Results</a><br /><br />
    </div>
    </form>
</body>
</html>
