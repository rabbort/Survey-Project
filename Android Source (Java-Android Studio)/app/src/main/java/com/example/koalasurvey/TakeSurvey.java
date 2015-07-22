package com.example.koalasurvey;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.*;

import com.example.koalasurvey.R;

public class TakeSurvey extends Activity {

    private MobileServiceClient mClient;
    private MobileServiceTable<Question> mQuestionTable;
    private MobileServiceTable<Answer> mAnswerTable;
    private ProgressBar mProgressBar;
    private int surveyID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_survey);

        Intent intent = getIntent();
        surveyID = intent.getExtras().getInt(ToDoItemAdapter.EXTRA_MESSAGE);

        mProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        // Initialize the progress bar
        mProgressBar.setVisibility(ProgressBar.GONE);

        try {
            // Create the Mobile Service Client instance, using the provided
            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://koalasurvey.azure-mobile.net/",
                    "rjVPbFbuWAUNnAgKUcyPJhwqAAQOIe53",
                    this).withFilter(new ProgressFilter());

            // Get the Mobile Service Table instance to use
            mQuestionTable = mClient.getTable("Question", Question.class);
            mAnswerTable = mClient.getTable("Answers", Answer.class);

            // Load the items from the Mobile Service
            refreshItemsFromTable();

        } catch (MalformedURLException e) {
            createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_take_survey, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Refresh the list with the items in the Mobile Service Table
     */
    private void refreshItemsFromTable() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final List<Question> results =
                            mQuestionTable.where().field("SurveyID").
                                    eq(surveyID).execute().get();
                    final List<Answer> answers =
                            mAnswerTable.where().field("SurveyID").
                                    eq(surveyID).execute().get();

                    Button btn = (Button)findViewById(R.id.button);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View arg0) {
                            if(((RadioButton)findViewById(R.id.radioButton1)).isChecked())
                            {
                                Answer a = answers.get(0);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((RadioButton)findViewById(R.id.radioButton2)).isChecked())
                            {
                                Answer a = answers.get(1);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((RadioButton)findViewById(R.id.radioButton3)).isChecked())
                            {
                                Answer a = answers.get(2);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((RadioButton)findViewById(R.id.radioButton4)).isChecked())
                            {
                                Answer a = answers.get(3);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((CheckBox)findViewById(R.id.checkBox1)).isChecked())
                            {
                                Answer a = answers.get(4);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((CheckBox)findViewById(R.id.checkBox2)).isChecked())
                            {
                                Answer a = answers.get(5);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((CheckBox)findViewById(R.id.checkBox3)).isChecked())
                            {
                                Answer a = answers.get(6);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((CheckBox)findViewById(R.id.checkBox4)).isChecked())
                            {
                                Answer a = answers.get(7);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((RadioButton)findViewById(R.id.radioButton5)).isChecked())
                            {
                                Answer a = answers.get(8);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((RadioButton)findViewById(R.id.radioButton6)).isChecked())
                            {
                                Answer a = answers.get(9);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((RadioButton)findViewById(R.id.radioButton7)).isChecked())
                            {
                                Answer a = answers.get(10);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                            if(((RadioButton)findViewById(R.id.radioButton8)).isChecked()) {
                                Answer a = answers.get(11);
                                a.setAnswerCount(a.getAnswerCount() + 1);
                                mAnswerTable.update(a);
                            }
                        }
                    });

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int i = 1;
                            int j = 1;

                            for (Question item : results) {
                                if(i == 1)
                                {
                                    TextView tv = (TextView) findViewById(R.id.question1);
                                    tv.setText(item.getQuestionText());
                                }
                                else if(i == 2)
                                {
                                    TextView tv = (TextView) findViewById(R.id.question2);
                                    tv.setText(item.getQuestionText());
                                }
                                else if(i == 3)
                                {
                                    TextView tv = (TextView) findViewById(R.id.question3);
                                    tv.setText(item.getQuestionText());
                                }
                                i++;
                                for(Answer item2 : answers) {
                                    if(j == 1)
                                    {
                                        RadioButton rb = (RadioButton)findViewById(R.id.radioButton1);
                                        rb.setText(item2.getAnswerText());
                                    }
                                    if(j == 2)
                                    {
                                        RadioButton rb = (RadioButton)findViewById(R.id.radioButton2);
                                        rb.setText(item2.getAnswerText());
                                    }
                                    if(j == 3)
                                    {
                                        RadioButton rb = (RadioButton)findViewById(R.id.radioButton3);
                                        rb.setText(item2.getAnswerText());
                                    }
                                    if(j == 4)
                                    {
                                        RadioButton rb = (RadioButton)findViewById(R.id.radioButton4);
                                        rb.setText(item2.getAnswerText());
                                    }
                                    if(j == 5)
                                    {
                                        CheckBox cb = (CheckBox)findViewById(R.id.checkBox1);
                                        cb.setText(item2.getAnswerText());
                                    }
                                    if(j == 6)
                                    {
                                        CheckBox cb = (CheckBox)findViewById(R.id.checkBox2);
                                        cb.setText(item2.getAnswerText());
                                    }
                                    if(j == 7)
                                    {
                                        CheckBox cb = (CheckBox)findViewById(R.id.checkBox3);
                                        cb.setText(item2.getAnswerText());
                                    }
                                    if(j == 8)
                                    {
                                        CheckBox cb = (CheckBox)findViewById(R.id.checkBox4);
                                        cb.setText(item2.getAnswerText());
                                    }
                                    if(j == 9)
                                    {
                                        RadioButton rb = (RadioButton)findViewById(R.id.radioButton5);
                                        rb.setText(item2.getAnswerText());
                                    }
                                    if(j == 10)
                                    {
                                        RadioButton rb = (RadioButton)findViewById(R.id.radioButton6);
                                        rb.setText(item2.getAnswerText());
                                    }
                                    if(j == 11)
                                    {
                                        RadioButton rb = (RadioButton)findViewById(R.id.radioButton7);
                                        rb.setText(item2.getAnswerText());
                                    }
                                    if(j == 12)
                                    {
                                        RadioButton rb = (RadioButton)findViewById(R.id.radioButton8);
                                        rb.setText(item2.getAnswerText());
                                    }
                                    j++;
                                }
                            }
                        }
                    });
                } catch (Exception e) {
                    createAndShowDialog(e, "Error");

                }

                return null;
            }
        }.execute();
    }

    /**
     * Creates a dialog and shows it
     *
     * @param exception The exception to show in the dialog
     * @param title     The dialog title
     */
    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if (exception.getCause() != null) {
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }

    /**
     * Creates a dialog and shows it
     *
     * @param message The dialog message
     * @param title   The dialog title
     */
    private void createAndShowDialog(final String message, final String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }

    private class ProgressFilter implements ServiceFilter {

        @Override
        public ListenableFuture<ServiceFilterResponse> handleRequest(ServiceFilterRequest request, NextServiceFilterCallback nextServiceFilterCallback) {

            final SettableFuture<ServiceFilterResponse> resultFuture = SettableFuture.create();


            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    //if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.VISIBLE);
                }
            });

            ListenableFuture<ServiceFilterResponse> future = nextServiceFilterCallback.onNext(request);

            Futures.addCallback(future, new FutureCallback<ServiceFilterResponse>() {
                @Override
                public void onFailure(Throwable e) {
                    resultFuture.setException(e);
                }

                @Override
                public void onSuccess(ServiceFilterResponse response) {
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.GONE);
                        }
                    });

                    resultFuture.set(response);
                }
            });

            return resultFuture;
        }
    }
}
