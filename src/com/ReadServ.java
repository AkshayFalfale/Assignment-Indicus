package com;

import java.io.IOException; 

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
/**
 * Servlet implementation class ReadServ
 */
@WebServlet("/ReadServ")
public class ReadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		       response.setContentType("text/html");
		       
		       ServletContext context=getServletContext();
		       String s2=context.getInitParameter("DRIVER"); 
		       String s3=context.getInitParameter("URL"); 
			   String s4=context.getInitParameter("DBUSER");
			   String s5=context.getInitParameter("DBPASS");

			   try { 
			       PrintWriter pw=response.getWriter();
				   Class.forName(s2);
			   Connection con=DriverManager.getConnection(s3,s4,s5); 
			   PreparedStatement pst=con.prepareStatement("select * from bookdata");
			   ResultSet rs=pst.executeQuery();
			   pw.println("<html><body>"
			   		+ "<h1>Book Data</h1>"
			   		+ "<table border='5'><tr><td>Book</td><td>Author</td><td>Price</td><td>Category</td><tr>");
			   while(rs.next())
			   {
				   pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+
						   "</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			   }
			   pw.print("</table></body></html>");
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
		      
	}

}
