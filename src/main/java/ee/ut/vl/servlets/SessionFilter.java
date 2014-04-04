package ee.ut.vl.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter{
	
//	private ServletContext context;

	public void init(FilterConfig filterConfig) throws ServletException {
		//this.context = filterConfig.getServletContext();
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();

		HttpSession session = req.getSession(false);
		
		if(uri.endsWith(".css")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(uri.endsWith(".js")) {
			chain.doFilter(request, response);
			return;
		}
//		session.getAttribute("user");
//		Cookie[] cookies = req.getCookies();

		if(session == null && !(uri.endsWith("html") || uri.endsWith("login"))){
			res.sendRedirect("login.html");
		}else{
			chain.doFilter(request, response);
		}

	}


	public void destroy() {
	}
}
