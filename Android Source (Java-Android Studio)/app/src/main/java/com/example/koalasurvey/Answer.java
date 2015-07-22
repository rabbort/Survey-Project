package com.example.koalasurvey;

public class Answer {
    private String questionText;
    public String getQuestionText() {
        return questionText;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @com.google.gson.annotations.SerializedName("AnswerID")
    private String answerID;
    public String getAnswerID() {
        return answerID;
    }
    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

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

    @com.google.gson.annotations.SerializedName("AnswerText")
    private String answerText;
    public String getAnswerText() {
        return answerText;
    }
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @com.google.gson.annotations.SerializedName("AnswerCount")
    private int answerCount;
    public int getAnswerCount() {
        return answerCount;
    }
    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    public String getmId() {
        return mId;
    }
    public void setmId(String mId) {
        this.mId = mId;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Answer && ((Answer) o).mId == mId;
    }
}
