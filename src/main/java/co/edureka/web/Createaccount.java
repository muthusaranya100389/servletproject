package co.edureka.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Createaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title></title></head>");
		
		out.println("<h2>Banking System</h2>");
		out.println("<body bgcolor=cyan text-align:center></body>");
		out.println("<h3><a href=\"form1.html\">Create Account</a></h3>");
		
		out.println("<h3><a href=\"form2.html\">Transactiont</a></h3>");

		
		
		
		
		
		
		
		
		
		
		
		
		
		out.println("<h3><a href=\\\"\\\">Display Bank Statement</a></h3>");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
