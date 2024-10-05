package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifyInquiry")
public class ModifyInquiryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));

        // Fetch inquiry by ID
        List<Inquiry> inquiry = CustomerDBUtil.getInquiriesByUserId(inquiryId);
        request.setAttribute("inquiry", inquiry);

        // Forward to modifyInquiry.jsp
        request.getRequestDispatcher("modifyInquiry.jsp").forward(request, response);
    }
}
