package ee.ut.vl.servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ee.ut.vl.DatabaseUtil;
import ee.ut.vl.resources.Paste;
import java.net.URISyntaxException;

public class MyPastesServlet extends HttpServlet{
	
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
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		String myUsername = session.getAttribute("user").toString();
		List<Paste> pastes = new ArrayList<Paste>();
		Paste paste = new Paste();
		int totalPastes = 0;
		try {
		    PreparedStatement pst1=con.prepareStatement("SELECT name, paste, posted_time, syntax, exposure, pastes.id FROM pastes JOIN users ON users.id = pastes.user_id WHERE users.username = '" + myUsername + "' ORDER BY posted_time DESC");
			ResultSet result1 = pst1.executeQuery();
			while(result1.next()){
				paste = new Paste(result1.getLong(6), result1.getString(1),result1.getString(2),result1.getTimestamp(3), result1.getString(4),result1.getString(5), result1.getLong(6));
				pastes.add(paste);
			}
			PreparedStatement pst2=con.prepareStatement("select username, count(pastes.id) from users JOIN pastes ON users.id = pastes.user_id where users.username = '" + myUsername + "' GROUP BY username");
			ResultSet result2 = pst2.executeQuery();
			result2.next();
			totalPastes = result2.getInt(2);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

	    session.setAttribute("pastes", pastes);
	    session.setAttribute("totalPastes", totalPastes);

	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/archive.jsp");
	    rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
