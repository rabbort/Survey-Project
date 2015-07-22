using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            this.BindListView();
        }
    }

    private void BindListView()
    {
        //get the current textbox count    
        int count = 1;
        if (ViewState["textboxCount"] != null)
            count = (int)ViewState["textboxCount"];
        if (ViewState["ansboxCount"] != null)
            count += (int)ViewState["ansboxCount"];

        //create an enumerable range based on the current count     
        IEnumerable<int> enumerable = Enumerable.Range(1, count);

        //bind the listview     
        this.tbList.DataSource = enumerable;
        this.tbList.DataBind();
    }

    private void IncrementTextboxCount()
    {
        int count = 1;
        if (ViewState["textboxCount"] != null)
            count = (int)ViewState["textboxCount"];

        count++;
        ViewState["textboxCount"] = count;
    }
    private void IncrementTextboxCounttest()
    {
        int count = 1;
        if (ViewState["ansboxCount"] != null)
            count = (int)ViewState["ansboxCount"];

        count++;
        ViewState["ansboxCount"] = count;
    }

    private void DecrementTextboxCount()
    {
        int count = 1;

        if(ViewState["textboxCount"] != null)
        {
            count = (int)ViewState["textboxCount"];
        }

        count--;
        ViewState["textboxCount"] = count;
    }

    protected void btnAddTextBox_Click(object sender, EventArgs e)
    {
        IList<string> text = this.GetValues();
        IList<string> ansText = this.GetAnswers();
        TextBox txt = null;
        TextBox ans = null;
        int i = 0;
        this.IncrementTextboxCount();
        this.BindListView();
        foreach (ListViewItem item in this.tbList.Items)
        {
            if (item is ListViewDataItem)
            {
                txt = (TextBox)item.FindControl("txtText");
                if(i < text.Count)
                    txt.Text = text[i++];
            }
        }

        i = 0;
        foreach (ListViewItem item in this.tbList.Items)
        {
            if (item is ListViewDataItem)
            {
                ans = (TextBox)item.FindControl("ansText");
                if (i < ansText.Count)
                    ans.Text = ansText[i++];
            }
        }
    }

    protected void btnDeleteTextBox_Click(object sender, EventArgs e)
    {
        IList<string> text = this.GetValues();
        IList<string> ansText = this.GetAnswers();
        TextBox txt = null;
        TextBox ans = null;
        int i = 0;
        this.DecrementTextboxCount();
        this.BindListView();
        foreach(ListViewItem item in this.tbList.Items)
        {
            if(item is ListViewDataItem)
            {
                txt = (TextBox)item.FindControl("txtText");
                if (i < text.Count)
                    txt.Text = text[i++];
            }
        }

        i = 0;
        foreach (ListViewItem item in this.tbList.Items)
        {
            if (item is ListViewDataItem)
            {
                ans = (TextBox)item.FindControl("ansText");
                if (i < ansText.Count)
                    ans.Text = ansText[i++];
            }
        }
    }

    protected void btnAddAnswer_Click(object sender, EventArgs e)
    {
        IList<string> text = this.GetValues();
        IList<string> ansText = this.GetAnswers();
        TextBox txt = null;
        TextBox ans = null;
        int i = 0;
        this.IncrementTextboxCounttest();
        this.BindListView();
        foreach (ListViewItem item in this.tbList.Items)
        {
            if (item is ListViewDataItem)
            {
                ans = (TextBox)item.FindControl("ansText");
                if (i < ansText.Count)
                    ans.Text = ansText[i++];
            }
        }

        i = 0;
        foreach (ListViewItem item in this.tbList.Items)
        {
            if (item is ListViewDataItem)
            {
                txt = (TextBox)item.FindControl("txtText");
                if (i < text.Count)
                    txt.Text = text[i++];
            }
        }
    }

    private IList<string> GetValues()
    {
        List<string> values = new List<string>();
        TextBox txt = null;
        foreach (ListViewItem item in this.tbList.Items)
        {
            if (item is ListViewDataItem)
            {
                txt = (TextBox)item.FindControl("txtText");
                values.Add(txt.Text);
            }
        }
        return values;
    }

    private IList<string> GetAnswers()
    {
        List<string> values = new List<string>();
        TextBox txt = null;
        foreach (ListViewItem item in this.tbList.Items)
        {
            if (item is ListViewDataItem)
            {
                txt = (TextBox)item.FindControl("ansText");
                values.Add(txt.Text);
            }
        }
        return values;
    }
}