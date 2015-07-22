<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TakeSurvey.aspx.cs" Inherits="TakeSurvey"%>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <a href="Default.aspx">Home</a><br />
        <asp:PlaceHolder runat="server" ID="PlaceHolder1"></asp:PlaceHolder>
        <asp:Panel ID="Panel1" runat="server">

        </asp:Panel>
        <asp:Button ID="Button1" runat="server" Text="Submit Answers" OnClick="Submit" />
    </div>    
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:project1ConnectionString %>" SelectCommand="SELECT * FROM [Surveys]"></asp:SqlDataSource>  
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:project1ConnectionString %>" SelectCommand="SELECT * FROM [Question]"></asp:SqlDataSource>
        <asp:SqlDataSource ID="SqlDataSource3" runat="server" ConnectionString="<%$ ConnectionStrings:project1ConnectionString %>" SelectCommand="SELECT * FROM [Answers]"></asp:SqlDataSource>
    </form>
</body>
</html>
