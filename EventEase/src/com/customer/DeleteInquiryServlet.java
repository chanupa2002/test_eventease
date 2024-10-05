package com.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteInquiry")
public class DeleteInquiryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));

        // Delete the inquiry from the database
        boolean isDeleted = CustomerDBUtil.deleteInquiry(inquiryId);

        if (isDeleted) {
            response.sendRedirect("inquiryView?userId=" + request.getParameter("userId"));
        } else {
            response.sendRedirect("unsuccess.jsp");
        }
    }
}
