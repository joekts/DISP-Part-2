package com.example.workflow.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surveyID;
    private String surveyResponse;

    // Getter and setter for surveyId
    public int getSurveyId() {
        return surveyID;
    }

    public void setSurveyId(int surveyID) { this.surveyID = surveyID; }

    // Getter and setter for response
    public String getSurveyResponse() {
        return surveyResponse;
    }

    public void setSurveyResponse(String surveyResponse) {
        this.surveyResponse = surveyResponse;
    }
}
