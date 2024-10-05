package com.customer;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/feedbackView")
public class FeedbackViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Fetch feedback for the logged user
        List<Feedback> feedbackList = CustomerDBUtil.getFeedbackByUserId(userId);
        
        request.setAttribute("feedbackList", feedbackList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedbackDisplay.jsp");
        dispatcher.forward(request, response);
    }
}

