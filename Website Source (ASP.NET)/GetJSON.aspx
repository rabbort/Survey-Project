<%@ Page Language="C#" AutoEventWireup="true" CodeFile="GetJSON.aspx.cs" Inherits="GetJSON" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:project1ConnectionString %>" SelectCommand="SELECT * FROM [Surveys]"></asp:SqlDataSource>  
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:project1ConnectionString %>" SelectCommand="SELECT * FROM [Question]"></asp:SqlDataSource>
        <asp:SqlDataSource ID="SqlDataSource3" runat="server" ConnectionString="<%$ ConnectionStrings:project1ConnectionString %>" SelectCommand="SELECT * FROM [Answers]"></asp:SqlDataSource>
    </div>
    </form>
</body>
</html>
