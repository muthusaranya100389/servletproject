package co.edureka.web;

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
import java.sql.Statement;


public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_project2","root","Saranya@2000");
			Statement st=con.createStatement();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Integer n1=Integer.valueOf(request.getParameter("t1"));
		Integer n2=Integer.valueOf(request.getParameter("t2"));
		Integer s1=Integer.valueOf(request.getParameter("t3"));
		Float  f1=Float.valueOf(request.getParameter("t4"));
		Float f2=Float.valueOf(request.getParameter("t5"));
		
		int ACnumber=n1;
		int Ifsc=s1;
		float Depositamt=f1;
		float Withdrawamt=f2;
		con.setAutoCommit(false);
		
		if(n1==ACnumber && n2==ACnumber &&s1==Ifsc) {
			
	st.addBatch("update holders set Depositamt=(Depositamt+f1) ,Balance= Balance=(Depositamt+Withdrawamt)where ACnumber=n2");
	st.addBatch("update holders set Depositamt=(Depositamt-f2), Balance=(Depositamt-Withdrawamt) where ACnumber=n1" );	
		
		}
		
			
			
		
		else {
			out.println("Enter account number is invalid,Check ur account number and ifsc code!!!");
		}
		
		
		try {
			int[] n=st.executeBatch();
			
			for(int x:n)
			{
			out.println("Amount credited sucessfully!!!");
			
			}
			con.commit();
			
		}catch(Exception ex) {System.out.println(ex.toString()); con.rollback();}
		
		
		con.close();
		st.close();
		
	}catch(Exception ex) {System.out.println(ex.toString());}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
