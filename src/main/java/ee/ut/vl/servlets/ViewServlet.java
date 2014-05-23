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
import java.net.URISyntaxException;

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
		}catch (URISyntaxException e) {
			e.printStackTrace(System.out);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session=request.getSession();
		
		String pasteId = request.getParameter("id");
		String name = "";
		String paste = "";
		String syntax = "";
		String exposure = "";
		int pasteUserId = 0;
		int userId = 0;
		boolean isThisMyView = true;
		try {
		    PreparedStatement pst=con.prepareStatement("SELECT paste, syntax, exposure, user_id, name FROM pastes  WHERE pastes.id = '" + pasteId + "'");
			ResultSet result = pst.executeQuery();
			result.next();
			paste = result.getString(1);
			syntax = result.getString(2);
			exposure = result.getString(3);
			pasteUserId = result.getInt(4);
			name = result.getString(5);
			PreparedStatement pst2 = con.prepareStatement("SELECT id from users where username = '" + session.getAttribute("user").toString() + "'");
			ResultSet result2 = pst2.executeQuery();
			result2.next();
			userId = result2.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		if(pasteUserId != userId) isThisMyView = false;
		
	    session.setAttribute("id", pasteId);
	    session.setAttribute("name", name);
	    session.setAttribute("text", paste);
	    session.setAttribute("syntax", syntax);
	    session.setAttribute("exposure", exposure);
	    session.setAttribute("isThisMyView", isThisMyView);

	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/view.jsp");
	    rd.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		
		String id = request.getParameter("id");
		String button = request.getParameter("button");
		String name = request.getParameter("name");
		String text = request.getParameter("text");
		String syntax = request.getParameter("syntax");
		String exposure = request.getParameter("exposure");
		
		if (button.equals("Delete")) {
		    //delete button was pressed
		    
			try {
			    PreparedStatement pst=con.prepareStatement("DELETE FROM pastes WHERE id = '" + id + "'");
				pst.executeUpdate(); 
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}


			RequestDispatcher rd = getServletContext().getRequestDispatcher("/mypastes");
	    	rd.forward(request, response);


		} else if (button.equals("Edit")) {
			
		    session.setAttribute("name", name);
		    session.setAttribute("text", text);
		    session.setAttribute("syntax", syntax);
		    session.setAttribute("exposure", exposure);
		    
		    
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/pasteEdit.jsp");
	    	rd.forward(request, response);
		} /*else if (button == null) {
		    //no button has been selected
		} else {
		    //someone has altered the HTML and sent a different value!
		}*/
		

		
				
	}
}
