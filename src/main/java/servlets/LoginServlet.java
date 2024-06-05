package servlets;

import java.io.IOException;

import dao.DataAccessObject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modalclasses.LoginModal;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		System.out.println("Controller Layer:"+email+" "+password);
		
		
		LoginModal lm = new LoginModal();
		           lm.setEmail(email);
		           lm.setPassword(password);
	        	   System.out.println(lm);
	        	   
	        	   
	   DataAccessObject dao = new  DataAccessObject();  
                String status = dao.checkData(lm);

                
                if(status.equals("SUCCESS")) {
                	
                	RequestDispatcher rd = request.getRequestDispatcher("index.html");
                	rd.forward(request, response);		
                	
                }
                else {
                	RequestDispatcher rd = request.getRequestDispatcher("login.html");
                	rd.include(request,response);
                }
                        
		
	}

}
