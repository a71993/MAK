package ee.ut.vl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ee.ut.vl.DatabaseUtil;

public class PasteEditServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	Connection con;
	
    @Override
    public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		}
		try {
			con = DatabaseUtil.getConnection();
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		
		String name = (String) session.getAttribute("name");
		String paste = (String) session.getAttribute("text");
		
		PrintWriter out=response.getWriter();
		String nameNew=request.getParameter("name");
		String pasteNew=request.getParameter("paste");
		String syntaxNew=request.getParameter("syntax");
		String exposureNew=request.getParameter("exposure");
		if(nameNew != "" && pasteNew != "") {
			try {
//				PreparedStatement pst1 = con.prepareStatement("select id from users where username = '" + session.getAttribute("user").toString() + "'");
//				ResultSet result = pst1.executeQuery();
//				result.next();
			    PreparedStatement pst2=con.prepareStatement("update pastes set name = ?, paste = ?, syntax = ?, exposure = ? where name = ? AND paste = ?");
				pst2.clearParameters();
				pst2.setString(1, nameNew);
				pst2.setString(2, pasteNew);
				pst2.setString(3, syntaxNew);
				pst2.setString(4, exposureNew);
				pst2.setString(5, name);
				pst2.setString(6, paste);
				int i=pst2.executeUpdate();
				out.write(i);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}

		    session.setAttribute("name", nameNew);
		    session.setAttribute("text", pasteNew);
		    session.setAttribute("syntax", syntaxNew);
		    session.setAttribute("exposure", exposureNew);

		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/view.jsp");
		    rd.forward(request, response);
		}
	}
	

}
