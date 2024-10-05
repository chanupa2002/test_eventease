package com.customer;

public class Feedback {
    private int feedbackId;
    private int userId; // Add userId if needed
    private int noOfStars;
    private String feedbackDescription;

    public Feedback(int feedbackId, int userId, int noOfStars, String feedbackDescription) {
        this.feedbackId = feedbackId;
        this.userId = userId; // Initialize userId
        this.noOfStars = noOfStars;
        this.feedbackDescription = feedbackDescription;
    }

    // Getter for feedbackId
    public int getFeedbackId() {
        return feedbackId;
    }

    // Getter for noOfStars
    public int getNoOfStars() {
        return noOfStars;
    }

    // Getter for feedbackDescription
    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    // Additional getters and setters as needed
}
