package com.example.koalasurvey;

public class Survey {
    @com.google.gson.annotations.SerializedName("SurveyID")
    private String surveyID;
    public String getSurveyID() { return surveyID; }
    public void setSurveyID(String surveyID) { this.surveyID = surveyID; }

    @com.google.gson.annotations.SerializedName("UserID")
    private String userID;
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    @com.google.gson.annotations.SerializedName("SurveyName")
    private String surveyName;
    public String getSurveyName() { return surveyName; }
    public void setSurveyName(String surveyName) { this.surveyName = surveyName; }

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    public String getmId() { return mId; }
    public void setmId(String mId) { this.mId = mId; }

    /**
     * Indicates if the item is completed
     */
    @com.google.gson.annotations.SerializedName("complete")
    private boolean mComplete;

    /**
     * ToDoItem constructor
     */
    public Survey() {

    }

    @Override
    public String toString() {
        return getSurveyName();
    }

    /**
     * Initializes a new ToDoItem
     *
     * @param text
     *            The item text
     * @param id
     *            The item id
     */
    public Survey(String text, String id) {
        this.setSurveyName(text);
        this.setSurveyID(id);
    }

    /**
     * Indicates if the item is marked as completed
     */
    public boolean isComplete() {
        return mComplete;
    }

    /**
     * Marks the item as completed or incompleted
     */
    public void setComplete(boolean complete) {
        mComplete = complete;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Survey && ((Survey) o).mId == mId;
    }
}
