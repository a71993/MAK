package ee.ut.vl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginValidator {
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
			Class.forName("org.hsqldb.jdbc.JDBCDriver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:hsqldb:mydatabase","SA","");  

			PreparedStatement ps=con.prepareStatement(  
					"select * from users where name=? and pass=?");  
			ps.setString(1,name);  
			ps.setString(2,pass);  

			ResultSet rs=ps.executeQuery();  
			status=rs.next();  

		}catch(Exception e){System.out.println(e);}  
		return status;  
	}  
}