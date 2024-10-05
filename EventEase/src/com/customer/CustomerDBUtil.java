package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class CustomerDBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/eventease";
    private static final String USER = "root";
    private static final String PASS = "Athsara@123";

    // Method to validate user credentials
    public static List<Customer> validate(String userName, String password) {
        ArrayList<Customer> cus = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?")) {
                
                pstmt.setString(1, userName);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String email = rs.getString(3);
                    String userU = rs.getString(4);
                    String passU = rs.getString(5);

                    Customer c = new Customer(id, name, email, userU, passU);
                    cus.add(c);
                } else {
                    System.out.println("User not found.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while validating user.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return cus;
    }

    // Insert feedback into the database
    public static boolean insertFeedback(int user_id, int no_of_stars, String feedback) {
        boolean isSuccess = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("INSERT INTO feedback (user_id, no_of_stars, feedback) VALUES (?, ?, ?)")) {
                
                pstmt.setInt(1, user_id);
                pstmt.setInt(2, no_of_stars);
                pstmt.setString(3, feedback);

                isSuccess = pstmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while inserting feedback.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Get feedback by user ID
    public static List<Feedback> getFeedbackByUserId(int userId) {
        List<Feedback> feedbackList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback WHERE user_id = ?")) {
                
                pstmt.setInt(1, userId);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    int feedbackId = rs.getInt("feedback_id"); // Assuming there's a feedback_id column
                    int noOfStars = rs.getInt("no_of_stars");
                    String feedbackDescription = rs.getString("feedback");

                    Feedback feedback = new Feedback(feedbackId, userId, noOfStars, feedbackDescription);
                    feedbackList.add(feedback);
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while retrieving feedback by user ID.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return feedbackList;
    }

    // Get feedback by feedback ID
    public static Feedback getFeedbackById(int feedbackId) {
        Feedback feedback = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback WHERE feedback_id = ?")) {
                
                pstmt.setInt(1, feedbackId);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    int userId = rs.getInt("user_id");
                    int noOfStars = rs.getInt("no_of_stars");
                    String feedbackDescription = rs.getString("feedback");
                    
                    feedback = new Feedback(feedbackId, userId, noOfStars, feedbackDescription);
                } else {
                    System.out.println("Feedback with ID " + feedbackId + " not found.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while retrieving feedback by ID.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return feedback;
    }

    // Update feedback by ID
    public static boolean updateFeedback(int feedbackId, int noOfStars, String feedbackDescription) {
        boolean isSuccess = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("UPDATE feedback SET no_of_stars = ?, feedback = ? WHERE feedback_id = ?")) {
                
                pstmt.setInt(1, noOfStars);
                pstmt.setString(2, feedbackDescription);
                pstmt.setInt(3, feedbackId);

                isSuccess = pstmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while updating feedback.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Delete feedback by ID
    public static boolean deleteFeedback(int feedbackId) {
        boolean isSuccess = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("DELETE FROM feedback WHERE feedback_id = ?")) {
                
                pstmt.setInt(1, feedbackId);
                isSuccess = pstmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while deleting feedback.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Insert inquiry into the database
    public static boolean insertInquiry(int user_id, String inquiry_type, String inquiry) {
        boolean isSuccess = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("INSERT INTO inquiry (user_id, inquiry_type, inquiry) VALUES (?, ?, ?)")) {
                
                pstmt.setInt(1, user_id);
                pstmt.setString(2, inquiry_type);
                pstmt.setString(3, inquiry);

                isSuccess = pstmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while inserting inquiry.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Get inquiries by user ID
    public static List<Inquiry> getInquiriesByUserId(int userId) {
        List<Inquiry> inquiryList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM inquiry WHERE user_id = ?")) {
                
                pstmt.setInt(1, userId);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    int inquiryId = rs.getInt("inquiry_id");
                    String inquiryType = rs.getString("inquiry_type");
                    String inquiryDescription = rs.getString("inquiry");

                    Inquiry inquiry = new Inquiry(inquiryId, userId, inquiryType, inquiryDescription);
                    inquiryList.add(inquiry);
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while retrieving inquiries by user ID.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return inquiryList;
    }

    // Get all inquiries
    public static List<Inquiry> getAllInquiries() {
        List<Inquiry> inquiryList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM inquiry")) {
                
                while (rs.next()) {
                    int inquiryId = rs.getInt("inquiry_id");
                    int userId = rs.getInt("user_id");
                    String inquiryType = rs.getString("inquiry_type");
                    String inquiryDescription = rs.getString("inquiry");

                    Inquiry inquiry = new Inquiry(inquiryId, userId, inquiryType, inquiryDescription);
                    inquiryList.add(inquiry);
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while retrieving all inquiries.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return inquiryList;
    }

    // Delete inquiry by ID
    public static boolean deleteInquiry(int inquiryId) {
        boolean isSuccess = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("DELETE FROM inquiry WHERE inquiry_id = ?")) {
                
                pstmt.setInt(1, inquiryId);
                isSuccess = pstmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while deleting inquiry.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return isSuccess;
    }
    
 // Update inquiry by ID
    public static boolean updateInquiry(int inquiryId, String inquiryType, String inquiry) {
        boolean isSuccess = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement("UPDATE inquiry SET inquiry_type = ?, inquiry = ? WHERE inquiry_id = ?")) {
                
                pstmt.setString(1, inquiryType);
                pstmt.setString(2, inquiry);
                pstmt.setInt(3, inquiryId);

                isSuccess = pstmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found. Please check your JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while updating inquiry.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        return isSuccess;
    }
    
    
    
    
}
