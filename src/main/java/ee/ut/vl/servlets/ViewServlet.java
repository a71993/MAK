package ee.ut.vl.servlets;

import java.io.IOException;
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

public class ViewServlet extends HttpServlet{
	
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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String name = request.getParameter("name");
		String paste = "";
		try {
		    PreparedStatement pst=con.prepareStatement("SELECT paste FROM pastes  WHERE pastes.name = '" + name + "'");
			ResultSet result = pst.executeQuery();
			result.next();
			paste = result.getString(1);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
		HttpSession session=request.getSession();
	    session.setAttribute("name", name);
	    session.setAttribute("text", paste);

	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/view.jsp");
	    rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		
		String button = request.getParameter("button");
		String name = request.getParameter("name");
		String text = request.getParameter("text");
		
//		
		
		String act = request.getParameter("button");
		if (button.equals("delete")) {
		    //delete button was pressed
		    
			try {
			    PreparedStatement pst=con.prepareStatement("DELETE FROM pastes WHERE name = '" + name + "' AND paste = '" + text + "'");
				ResultSet result = pst.executeQuery(); 
				result.next();
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}


			RequestDispatcher rd = getServletContext().getRequestDispatcher("/archive.jsp");
	    	rd.forward(request, response);


		} /*else if (button.equals("edit")) {
		    //update button was pressed
		    
		} else if (button == null) {
		    //no button has been selected
		} else {
		    //someone has altered the HTML and sent a different value!
		}*/
		

		
				
	}
}
