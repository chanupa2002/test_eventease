package com.customer;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inquiryView")
public class InquiryViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Fetch inquiry list from DB using userId
        List<Inquiry> inquiryList = CustomerDBUtil.getInquiriesByUserId(userId);
        request.setAttribute("inquiryList", inquiryList);

        // Forward to inquiryView.jsp
        request.getRequestDispatcher("inquiryView.jsp").forward(request, response);
    }
}
