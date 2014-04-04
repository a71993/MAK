package ee.ut.vl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ee.ut.vl.LoginValidator;


public class LoginServlet extends HttpServlet {  
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(LoginValidator.validate(username, password)){
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			session.setMaxInactiveInterval(30*60);
			Cookie sessionCookie = new Cookie("sessionKuki", username);
			sessionCookie.setMaxAge(30*60);
			response.addCookie(sessionCookie);
			RequestDispatcher rd=request.getRequestDispatcher("paste.html");
		    rd.forward(request,response);  
		}
		else{  
			out.print("Sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
		}
		
		out.close(); 
	}
}
