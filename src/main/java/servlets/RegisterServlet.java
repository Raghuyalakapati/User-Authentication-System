package servlets;

import java.io.IOException;

import dao.DataAccessObject;

/**
 * Servlet implementation class RegisterServlet
 */


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modalclasses.RegisterModal;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String FirstName=request.getParameter("FirstName");
		String LastName=request.getParameter("LastName");
		String Mobile=request.getParameter("Mobile");
		String Email=request.getParameter("Email");
		String Password=request.getParameter("Password");
		
		System.out.println("Controller Layer:"+FirstName+" "+LastName+" "+Mobile+" "+Email+" "+Password);
		
		
		RegisterModal rm = new RegisterModal();
		              rm.setFname(FirstName);
		              rm.setLname(LastName);
		              rm.setMobile(Mobile);
		              rm.setEmail(Email);
		              rm.setPwd(Password);
		              
		              System.out.println(rm);
		              
		  DataAccessObject dao = new  DataAccessObject();  
		         String status=dao.insertData(rm);
		         
		         if(status.equals("SUCCESS")) {
		        	 RequestDispatcher rd = request.getRequestDispatcher("login.html");
		        	   rd.forward(request, response);
		         }
		         else {
		        	 RequestDispatcher rd = request.getRequestDispatcher("register.html");
		        	   rd.include(request, response);
		         }    	
	}

}
