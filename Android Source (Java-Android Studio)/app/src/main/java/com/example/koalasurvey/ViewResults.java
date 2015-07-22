package com.example.koalasurvey;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.koalasurvey.R;
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

import java.net.MalformedURLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ViewResults extends Activity {

    private MobileServiceClient mClient;
    private MobileServiceTable<Answer> mAnswerTable;
    private ProgressBar mProgressBar;
    private int surveyID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        mProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);
        Intent intent = getIntent();
        surveyID = intent.getExtras().getInt(ToDoActivity.EXTRA_MESSAGE);

        // Initialize the progress bar
        //mProgressBar.setVisibility(ProgressBar.GONE);

        try {
            // Create the Mobile Service Client instance, using the provided
            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://koalasurvey.azure-mobile.net/",
                    "rjVPbFbuWAUNnAgKUcyPJhwqAAQOIe53",
                    this).withFilter(new ProgressFilter());

            // Get the Mobile Service Table instance to use
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
        getMenuInflater().inflate(R.menu.menu_view_results, menu);
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

        // Get the items that weren't marked as completed and add them in the
        // adapter

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final List<Answer> results =
                            mAnswerTable.where().field("SurveyID").
                                    eq(Integer.toString(surveyID)).execute().get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView q1 = (TextView)findViewById(R.id.textView31);
                            q1.setText(results.get(0).getQuestionText());
                            TextView q2 = (TextView)findViewById(R.id.textView30);
                            q2.setText(results.get(4).getQuestionText());
                            TextView q3 = (TextView)findViewById(R.id.textView32);
                            q3.setText(results.get(8).getQuestionText());
                            TextView tv4 = (TextView)findViewById(R.id.textView4);
                            tv4.setText(results.get(0).getAnswerText());
                            TextView tv5 = (TextView)findViewById(R.id.textView5);
                            tv5.setText(Integer.toString(results.get(0).getAnswerCount()));
                            TextView tv6 = (TextView)findViewById(R.id.textView6);
                            tv6.setText(results.get(1).getAnswerText());
                            TextView tv7 = (TextView)findViewById(R.id.textView7);
                            tv7.setText(Integer.toString(results.get(1).getAnswerCount()));
                            TextView tv8 = (TextView)findViewById(R.id.textView8);
                            tv8.setText(results.get(2).getAnswerText());
                            TextView tv9 = (TextView)findViewById(R.id.textView9);
                            tv9.setText(Integer.toString(results.get(2).getAnswerCount()));
                            TextView tv10 = (TextView)findViewById(R.id.textView10);
                            tv10.setText(results.get(3).getAnswerText());
                            TextView tv11 = (TextView)findViewById(R.id.textView11);
                            tv11.setText(Integer.toString(results.get(3).getAnswerCount()));
                            TextView tv12 = (TextView)findViewById(R.id.textView12);
                            tv12.setText(results.get(4).getAnswerText());
                            TextView tv13 = (TextView)findViewById(R.id.textView13);
                            tv13.setText(Integer.toString(results.get(4).getAnswerCount()));
                            TextView tv14 = (TextView)findViewById(R.id.textView14);
                            tv14.setText(results.get(5).getAnswerText());
                            TextView tv15 = (TextView)findViewById(R.id.textView15);
                            tv15.setText(Integer.toString(results.get(5).getAnswerCount()));
                            TextView tv16 = (TextView)findViewById(R.id.textView16);
                            tv16.setText(results.get(6).getAnswerText());
                            TextView tv17 = (TextView)findViewById(R.id.textView17);
                            tv17.setText(Integer.toString(results.get(6).getAnswerCount()));
                            TextView tv18 = (TextView)findViewById(R.id.textView18);
                            tv18.setText(results.get(7).getAnswerText());
                            TextView tv19 = (TextView)findViewById(R.id.textView19);
                            tv19.setText(Integer.toString(results.get(7).getAnswerCount()));
                            TextView tv20 = (TextView)findViewById(R.id.textView20);
                            tv20.setText(results.get(8).getAnswerText());
                            TextView tv21 = (TextView)findViewById(R.id.textView21);
                            tv21.setText(Integer.toString(results.get(8).getAnswerCount()));
                            TextView tv22 = (TextView)findViewById(R.id.textView22);
                            tv22.setText(results.get(9).getAnswerText());
                            TextView tv23 = (TextView)findViewById(R.id.textView23);
                            tv23.setText(Integer.toString(results.get(9).getAnswerCount()));
                            TextView tv24 = (TextView)findViewById(R.id.textView24);
                            tv24.setText(results.get(10).getAnswerText());
                            TextView tv25 = (TextView)findViewById(R.id.textView25);
                            tv25.setText(Integer.toString(results.get(10).getAnswerCount()));
                            TextView tv26 = (TextView)findViewById(R.id.textView26);
                            tv26.setText(results.get(11).getAnswerText());
                            TextView tv27 = (TextView)findViewById(R.id.textView27);
                            tv27.setText(Integer.toString(results.get(11).getAnswerCount()));
                        }
                    });
                } catch (Exception e){
                    createAndShowDialog(e, "Error");

                }

                return null;
            }
        }.execute();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run(){
                refreshItemsFromTable();
            }
        }, 1000);
    }

    /**
     * Creates a dialog and shows it
     *
     * @param exception
     *            The exception to show in the dialog
     * @param title
     *            The dialog title
     */
    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if(exception.getCause() != null){
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }

    /**
     * Creates a dialog and shows it
     *
     * @param message
     *            The dialog message
     * @param title
     *            The dialog title
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
                    if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.VISIBLE);
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
