package co.edureka.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AccountCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PreparedStatement pst;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_project2","root","Saranya@2000");
		pst=con.prepareStatement("insert into holders values(?,?,?,?,?)");
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
			pst.setString(1,String.valueOf(request.getParameter("t1")));
			pst.setInt(2,Integer.valueOf(request.getParameter("t2")));
			pst.setFloat(3, Float.valueOf(request.getParameter("t3")));
			pst.setFloat(4, Float.valueOf(request.getParameter("t4")));
			pst.setFloat(5, Float.valueOf(request.getParameter("t5")));
			
			
		int n=pst.executeUpdate();
			
			RequestDispatcher rd = request.getRequestDispatcher("account");
			out.println("<body bgcolor:green>");
			out.println("<p style=/text-align:center;clolor:yellow;fong-size=20px\">Account created sucessfully!!!</p>");	
			
			pst.close();
			
		} catch (Exception ex) {
				
			System.out.println(ex.toString());
		}	
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
