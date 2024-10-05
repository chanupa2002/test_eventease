package com.customer;

public class Inquiry {
    private int inquiryId;
    private int userId;
    private String inquiryType;
    private String inquiry;

    public Inquiry(int inquiryId, int userId, String inquiryType, String inquiry) {
        this.inquiryId = inquiryId;
        this.userId = userId;
        this.inquiryType = inquiryType;
        this.inquiry = inquiry;
    }

    // Getters
    public int getInquiryId() {
        return inquiryId;
    }

    public int getUserId() {
        return userId;
    }

    public String getInquiryType() {
        return inquiryType;
    }

    public String getInquiry() {
        return inquiry;
    }
}
