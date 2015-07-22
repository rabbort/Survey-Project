package com.example.koalasurvey;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * Adapter to bind a ToDoItem List to a view
 */
public class ToDoItemAdapter extends ArrayAdapter<Survey> {
    public final static String EXTRA_MESSAGE = "koalasurvey";

    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public ToDoItemAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
    }

    /**
     * Returns the view for a specific item on the list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final Survey currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final Button btn = (Button) row.findViewById(R.id.checkToDoItem);;
        btn.setText(currentItem.getSurveyName());
        btn.setEnabled(true);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ToDoActivity activity = (ToDoActivity) mContext;
                Intent intent = new Intent(activity, TakeSurvey.class);
                String extraInt = currentItem.getSurveyID();
                intent.putExtra(EXTRA_MESSAGE, Integer.parseInt(currentItem.getSurveyID()));
                activity.startActivity(intent);
            }
        });

        return row;
    }

}