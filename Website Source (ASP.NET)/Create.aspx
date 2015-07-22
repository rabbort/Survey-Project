<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Create.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:ListView ID="tbList" runat="server" ItemPlaceholderID="itemPlaceholder">
                <LayoutTemplate>
                    <table>
                        <asp:PlaceHolder ID="itemPlaceholder" runat="server">
                        </asp:PlaceHolder>     
                    </table>   
                </LayoutTemplate>  
                <ItemTemplate>  
                    <p>
                        <table>
                            Question <asp:Label ID="label" AssociatedControlID="txtText" Text='<%# Container.DataItemIndex + 1 %>' runat="server"></asp:Label>: 
                            <asp:TextBox ID="txtText" TextMode ="MultiLine" Columns="80" Rows="1" runat="server">      
                            </asp:TextBox>
                            <asp:Button ID="btnDeleteTextBox" runat="server" Text="Delete Question" onclick="btnDeleteTextBox_Click" />
                            <p>
                                  Answer Type: 
                                <asp:DropDownList ID="ddlAnswerType" runat="server">
                                    <asp:ListItem>Multiple choice</asp:ListItem>
                                    <asp:ListItem>Check box</asp:ListItem>
                                    <asp:ListItem>Short answer</asp:ListItem>
                                </asp:DropDownList>
                            </p>
                            <p>
                                <asp:TextBox ID="ansText" TextMode ="MultiLine" Columns="80" Rows="1" runat="server"></asp:TextBox>
                            </p>
                            <p>
                                <asp:Button ID="btnAddAnswerBox" runat="server" Text="Add Answer" OnClick="btnAddAnswer_Click" />
                            </p>
                        </table>  
                     </p>
                 </ItemTemplate>      
            </asp:ListView>
            <asp:Button ID="btnAddTextBox" runat="server" Text="Add Question" onclick="btnAddTextBox_Click" />
        </div>
    </form>
</body>
</html>
