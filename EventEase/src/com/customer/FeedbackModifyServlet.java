package com.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/feedbackModify")
public class FeedbackModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String feedbackIdStr = request.getParameter("feedbackId");

        if (feedbackIdStr != null && !feedbackIdStr.isEmpty()) {
            int feedbackId = Integer.parseInt(feedbackIdStr);

            // Retrieve the feedback object using the feedbackId
            Feedback feedback = CustomerDBUtil.getFeedbackById(feedbackId);

            if (feedback != null) {
                request.setAttribute("feedback", feedback);
                RequestDispatcher dispatcher = request.getRequestDispatcher("feedbackModify.jsp");
                dispatcher.forward(request, response);
            } else {
                // Handle the case where feedback is not found
                response.sendRedirect("errorPage.jsp");
            }
        } else {
            // Handle invalid feedbackId
            response.sendRedirect("errorPage.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String feedbackIdStr = request.getParameter("feedbackId");
        String noOfStarsStr = request.getParameter("no_of_stars");
        String feedbackDescription = request.getParameter("feedback");
        String userIdStr = request.getParameter("userId");

        if (feedbackIdStr != null && noOfStarsStr != null && feedbackDescription != null && userIdStr != null) {
            int feedbackId = Integer.parseInt(feedbackIdStr);
            int noOfStars = Integer.parseInt(noOfStarsStr);
            int userId = Integer.parseInt(userIdStr);

            // Update the feedback in the database
            boolean isUpdated = CustomerDBUtil.updateFeedback(feedbackId, noOfStars, feedbackDescription);

            if (isUpdated) {
                // Redirect to feedback view page after successful update
                response.sendRedirect("feedbackView.jsp?userId=" + userId);
            } else {
                // Handle update failure
                request.setAttribute("errorMessage", "Feedback update failed.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // Handle invalid parameters
            request.setAttribute("errorMessage", "Invalid feedback details.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
