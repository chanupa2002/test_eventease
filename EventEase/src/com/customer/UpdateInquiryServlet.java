package com.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateInquiry")
public class UpdateInquiryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));
        String inquiryType = request.getParameter("inquiry_type");
        String inquiry = request.getParameter("inquiry");

        // Update inquiry in the database
        boolean isUpdated = CustomerDBUtil.updateInquiry(inquiryId, inquiryType, inquiry);

        if (isUpdated) {
            response.sendRedirect("inquiryView?userId=" + request.getParameter("userId"));
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
