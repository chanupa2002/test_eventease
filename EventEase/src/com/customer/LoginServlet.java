package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("uid");
        String password = request.getParameter("pass");
        
        
        try {
            List<Customer> cusDetails = CustomerDBUtil.validate(username, password);
            
            
            if (cusDetails != null) {
                // If customer details are found, login is successful
                request.setAttribute("cusDetails", cusDetails);
                
                System.out.println("Login succesfull");
                
                // Forward to user account page
                RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                System.out.println("1 huththo");
                
                try {
                	dis.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
	                System.out.println(e.getMessage() + " ERROR EKAK ITHIN");

				}
                

            } else {
                // If no customer details found, login failed
                request.setAttribute("errorMessage", "Invalid Username or Password");
                
                System.out.println("Login unsuccesfull");
                
                // Redirect back to login page
                RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                dis.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
