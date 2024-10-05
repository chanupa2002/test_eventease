package com.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/feedbackDelete")
public class FeedbackDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String feedbackIdParam = request.getParameter("feedbackId");
        boolean isDeleted = false;

        try {
            // Ensure feedbackId is a valid integer
            int feedbackId = Integer.parseInt(feedbackIdParam);
            isDeleted = CustomerDBUtil.deleteFeedback(feedbackId);
        } catch (NumberFormatException e) {
            // Handle the case where feedbackId is not a valid integer
            System.err.println("Invalid feedback ID: " + feedbackIdParam);
            request.setAttribute("errorMessage", "Invalid feedback ID provided.");
        } catch (Exception e) {
            // Handle any unexpected errors
            System.err.println("An error occurred while deleting feedback: " + e.getMessage());
            request.setAttribute("errorMessage", "An error occurred while deleting feedback. Please try again.");
        }

        // If deletion was successful or an error occurred, redirect back to feedback.jsp
        if (isDeleted) {
            // Optionally, you could add a success message
            request.setAttribute("successMessage", "Feedback deleted successfully.");
        }

        // Forward to feedback.jsp to display messages
        request.getRequestDispatcher("feedback.jsp").forward(request, response);
    }
}
