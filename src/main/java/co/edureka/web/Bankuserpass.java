package co.edureka.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Bankuserpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement pst;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_project2","root","Saranya@2000");
			pst = con.prepareStatement("select * from user where username=? and password=?");
			
		}catch(Exception ex) {System.out.println(ex.toString());}
			
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String user1 = request.getParameter("txt_uid");
		String pass1 = request.getParameter("txt_pwd");
		
		try {
			pst.setString(1, user1);
			pst.setString(2, pass1);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("create");
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<head><title></title></head>");
				out.println("<body bgcolor=blue text-align=center></body>");
				out.println("<h2>Banking System</h2><br><br>");
				
				
				rd.forward(request, response);
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login1.html");
				PrintWriter out = response.getWriter();
				out.println("<p style=\"text-align:center;color:yellow;font-size:18px\">Authentication Failed!!! Invalid UserName/ Password</p>");
				rd.include(request, response);
			}
		}catch(Exception ex) {System.out.println(ex.toString());}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
