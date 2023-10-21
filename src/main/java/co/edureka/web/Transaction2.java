package co.edureka.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;


  

public class Transaction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection con;
	public CallableStatement cst;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_project2","root","Saranya@2000");
		cst=con.prepareCall("{call  draw229_holders5_bal(?,?,?,?,?,?)}");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		String Uname=String.valueOf(request.getParameter("t1"));
		Integer Uacc	=Integer.valueOf(request.getParameter("t2"));
		
		String Hname=String.valueOf(request.getParameter("t3"));
		Integer Hacc=Integer.valueOf(request.getParameter("t4"));

		String s3=String.valueOf(request.getParameter("t5"));
		Float  Depo=Float.valueOf(request.getParameter("t6"));
		Float Withdr=Float.valueOf(request.getParameter("t7"));
		
		Float updated_bal;
		
		cst.setString(1,Hname);
		cst.setInt(2, Uacc);
		cst.registerOutParameter(3,Types.FLOAT);
		cst.setFloat(4,Depo);
		cst.setFloat(5, Withdr);
		cst.registerOutParameter(6,Types.FLOAT);
		
		cst.execute();	
		out.println("Transaction done Sucessfully!!!");
		
		
		
		}catch(Exception ex) {System.out.println(ex.toString());
		System.out.println("Transaction failed");
				
		}
		
		try {
			cst.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
				
			
			
			}
		
			
		
	
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
