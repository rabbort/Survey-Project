package com.example.koalasurvey;

public class Question {
    @com.google.gson.annotations.SerializedName("QuestionID")
    private String questionID;
    public String getQuestionID() {
        return questionID;
    }
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    @com.google.gson.annotations.SerializedName("SurveyID")
    private String surveyID;
    public String getSurveyID() {
        return surveyID;
    }
    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    @com.google.gson.annotations.SerializedName("QuestionText")
    private String questionText;
    public String getQuestionText() {
        return questionText;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @com.google.gson.annotations.SerializedName("QuestionType")
    private int questionType;
    public int getQuestionType() {
        return questionType;
    }
    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    public String getmId() {
        return mId;
    }
    public void setmId(String mId) {
        this.mId = mId;
    }

    @com.google.gson.annotations.SerializedName("complete")
    private boolean mComplete;
    public boolean ismComplete() {
        return mComplete;
    }
    public void setmComplete(boolean mComplete) {
        this.mComplete = mComplete;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Question && ((Question) o).mId == mId;
    }
}
