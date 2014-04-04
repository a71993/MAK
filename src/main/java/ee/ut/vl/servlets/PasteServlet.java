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

public class PasteServlet extends HttpServlet{
	
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
		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String paste=request.getParameter("paste");
		String syntax=request.getParameter("syntax");
		String exposure=request.getParameter("exposure");
		if(name != "" && paste != "") {
			try {
				PreparedStatement pst1 = con.prepareStatement("select id from users where username = '" + session.getAttribute("user").toString() + "'");
				ResultSet result = pst1.executeQuery();
				result.next();
			    PreparedStatement pst2=con.prepareStatement("insert into pastes (user_id, name, paste, syntax, exposure) values (?,?,?,?,?)");
				pst2.clearParameters();
				pst2.setInt(1, result.getInt(1));
				pst2.setString(2, name);
				pst2.setString(3, paste);
				pst2.setString(4, syntax);
				pst2.setString(5, exposure);
				int i=pst2.executeUpdate();
				out.write(i);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}

		    session.setAttribute("name", name);
		    session.setAttribute("text", paste);

		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/view.jsp");
		    rd.forward(request, response);
		}
	}
	

}
