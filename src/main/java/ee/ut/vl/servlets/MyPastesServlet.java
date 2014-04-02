package ee.ut.vl.servlets;

import java.io.IOException;
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
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String myUsername = "kapa";
		List<Paste> pastes = new ArrayList<Paste>();
		Paste paste = new Paste();
		int totalPastes = 0;
		try {
		    PreparedStatement pst1=con.prepareStatement("SELECT name, paste, posted_time, syntax, exposure FROM pastes JOIN users ON users.id = pastes.user_id WHERE users.username = '" + myUsername + "' ORDER BY posted_time DESC");
			ResultSet result1 = pst1.executeQuery();
			while(result1.next()){
				paste = new Paste(result1.getString(1),result1.getString(2),result1.getTimestamp(3), result1.getString(4),result1.getString(5));
				pastes.add(paste);
			}
			PreparedStatement pst2=con.prepareStatement("select username, count(pastes.id) from users JOIN pastes ON users.id = pastes.user_id where users.username = '" + myUsername + "' GROUP BY username");
			ResultSet result2 = pst2.executeQuery();
			result2.next();
			totalPastes = result2.getInt(2);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		HttpSession session=request.getSession();
	    session.setAttribute("pastes", pastes);
	    session.setAttribute("totalPastes", totalPastes);

	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/archive.jsp");
	    rd.forward(request, response);
	}
}
