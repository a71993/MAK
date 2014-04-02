package ee.ut.vl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ee.ut.vl.DatabaseUtil;


public class RegisterServlet extends HttpServlet {
	
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
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String email=request.getParameter("email1");
		String password=request.getParameter("password1");
		if(username != "" && email != "" && password != "") {
			try {
			    PreparedStatement pst=con.prepareStatement("insert into users (rights_lvl, username, first_name, last_name, email, password) values (?,?,?,?,?,?)");
				pst.clearParameters();
				pst.setInt(1, 0);
				pst.setString(2, username);
				pst.setString(3, "None");
				pst.setString(4, "None");
				pst.setString(5, email);
				pst.setString(6, password);
				int i=pst.executeUpdate();
				out.write(i);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
	}
	
}