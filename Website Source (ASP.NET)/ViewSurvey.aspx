<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ViewSurvey.aspx.cs" Inherits="ViewSurvey" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>



</head>
<body>
    <form id="form1" runat="server">
    <div>
        <a href="Default.aspx">Home</a><br />
        <h1 id="SurveyTitle"></h1>
        <table border="1"><tr><td id ="Question1Text"></td></tr>
        <tr><td id="Choice11Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice11Value"><tr><td  style="background-color:red;"></td></tr></table></td><td id="Choice11Number"></td></tr>
		<tr><td id="Choice12Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice12Value"><tr><td  style="background-color:green;"></td></tr></table></td><td id="Choice12Number"></td></tr>
		<tr><td id="Choice13Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice13Value"><tr><td  style="background-color:blue;"></td></tr></table></td><td id="Choice13Number"></td></tr>
		<tr><td id="Choice14Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice14Value"><tr><td  style="background-color:yellow;"></td></tr></table></td><td id="Choice14Number"></td></tr>
        <tr><td id ="Question2Text"></td></tr>
        <tr><td id="Choice21Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice21Value"><tr><td  style="background-color:red;"></td></tr></table></td><td id="Choice21Number"></td></tr>
		<tr><td id="Choice22Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice22Value"><tr><td  style="background-color:green;"></td></tr></table></td><td id="Choice22Number"></td></tr>
		<tr><td id="Choice23Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice23Value"><tr><td  style="background-color:blue;"></td></tr></table></td><td id="Choice23Number"></td></tr>
		<tr><td id="Choice24Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice24Value"><tr><td  style="background-color:yellow;"></td></tr></table></td><td id="Choice24Number"></td></tr>
        <tr><td id ="Question3Text"></td></tr>
        <tr><td id="Choice31Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice31Value"><tr><td  style="background-color:red;"></td></tr></table></td><td id="Choice31Number"></td></tr>
		<tr><td id="Choice32Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice32Value"><tr><td  style="background-color:green;"></td></tr></table></td><td id="Choice32Number"></td></tr>
		<tr><td id="Choice33Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice33Value"><tr><td  style="background-color:blue;"></td></tr></table></td><td id="Choice33Number"></td></tr>
		<tr><td id="Choice34Text"></td><td style="height:40px; width:400px;"><table style="height:40px; width:10px;" id="Choice34Value"><tr><td  style="background-color:yellow;"></td></tr></table></td><td id="Choice34Number"></td></tr>
        </table>
    </div>
    </form>

<script>
    var SurveyID = <%OutputSurveyID();%>;

    function DoIt() {
        var xmlhttp = new XMLHttpRequest();
        var url = "GetJSON.aspx?SurveyID="+SurveyID;

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var myArr = JSON.parse(xmlhttp.responseText);
                myFunction(myArr);

            }
        }
        xmlhttp.open("GET", url, true);
        xmlhttp.send();

        function myFunction(arr) {
            document.getElementById("SurveyTitle").innerHTML =
				arr.SurveyTitle+" Results";

            document.getElementById("Question1Text").innerHTML =
                "Question 1: "+arr.question1;
            document.getElementById("Question2Text").innerHTML =
                "Question 2: "+arr.question2;
            document.getElementById("Question3Text").innerHTML =
                "Question 3: "+arr.question3;

            document.getElementById("Choice11Text").innerHTML =
				arr.choiceText11;
            document.getElementById("Choice12Text").innerHTML =
				arr.choiceText12;
            document.getElementById("Choice13Text").innerHTML =
				arr.choiceText13;
            document.getElementById("Choice14Text").innerHTML =
                arr.choiceText14;
            document.getElementById("Choice21Text").innerHTML =
				arr.choiceText21;
            document.getElementById("Choice22Text").innerHTML =
				arr.choiceText22;
            document.getElementById("Choice23Text").innerHTML =
				arr.choiceText23;
            document.getElementById("Choice24Text").innerHTML =
                arr.choiceText24;
            document.getElementById("Choice31Text").innerHTML =
				arr.choiceText31;
            document.getElementById("Choice32Text").innerHTML =
				arr.choiceText32;
            document.getElementById("Choice33Text").innerHTML =
				arr.choiceText33;
            document.getElementById("Choice34Text").innerHTML =
                arr.choiceText34;

            var total = arr.choice11 + arr.choice12 + arr.choice13 + arr.choice14;
            var c1 = (arr.choice11 * 400) / total;
            document.getElementById("Choice11Value").style.width = "" + c1 + "px";
            document.getElementById("Choice11Number").innerHTML = arr.choice11;
            var c2 = (arr.choice12 * 400) / total;
            document.getElementById("Choice12Value").style.width = "" + c2 + "px";
            document.getElementById("Choice12Number").innerHTML = arr.choice12;
            var c3 = (arr.choice13 * 400) / total;
            document.getElementById("Choice13Value").style.width = "" + c3 + "px";
            document.getElementById("Choice13Number").innerHTML = arr.choice13;
            var c4 = (arr.choice14 * 400) / total;
            document.getElementById("Choice14Value").style.width = "" + c4 + "px";
            document.getElementById("Choice14Number").innerHTML = arr.choice14;

            var total2 = arr.choice21 + arr.choice22 + arr.choice23 + arr.choice24;
            var c21 = (arr.choice21 * 400) / total;
            document.getElementById("Choice21Value").style.width = "" + c21 + "px";
            document.getElementById("Choice21Number").innerHTML = arr.choice21;
            var c22 = (arr.choice22 * 400) / total;
            document.getElementById("Choice22Value").style.width = "" + c22 + "px";
            document.getElementById("Choice22Number").innerHTML = arr.choice22;
            var c23 = (arr.choice23 * 400) / total;
            document.getElementById("Choice23Value").style.width = "" + c23 + "px";
            document.getElementById("Choice23Number").innerHTML = arr.choice23;
            var c24 = (arr.choice24 * 400) / total;
            document.getElementById("Choice24Value").style.width = "" + c24 + "px";
            document.getElementById("Choice24Number").innerHTML = arr.choice24;

            var total3 = arr.choice31 + arr.choice32 + arr.choice33 + arr.choice34;
            var c31 = (arr.choice31 * 400) / total;
            document.getElementById("Choice31Value").style.width = "" + c31 + "px";
            document.getElementById("Choice31Number").innerHTML = arr.choice31;
            var c32 = (arr.choice32 * 400) / total;
            document.getElementById("Choice32Value").style.width = "" + c32 + "px";
            document.getElementById("Choice32Number").innerHTML = arr.choice32;
            var c33 = (arr.choice33 * 400) / total;
            document.getElementById("Choice33Value").style.width = "" + c33 + "px";
            document.getElementById("Choice33Number").innerHTML = arr.choice33;
            var c34 = (arr.choice34 * 400) / total;
            document.getElementById("Choice34Value").style.width = "" + c34 + "px";
            document.getElementById("Choice34Number").innerHTML = arr.choice34;

            setTimeout("DoIt()", 1000);
        }
    }

    DoIt();
</script>

</body>
</html>
