package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/feedbackInsert")
public class feedbackInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int user_id = Integer.parseInt(request.getParameter("user_id"));
	     int no_of_stars = Integer.parseInt(request.getParameter("no_of_stars"));
	     String feedback = request.getParameter("feedback");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.insertFeedback(user_id, no_of_stars, feedback);
		
		if(isTrue == true) {
            request.setAttribute("userId", user_id);
			RequestDispatcher dis = request.getRequestDispatcher("feedback.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	}

	
}
