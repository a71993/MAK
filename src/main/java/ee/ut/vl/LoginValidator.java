package ee.ut.vl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginValidator {
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DatabaseUtil.getConnection();  

			PreparedStatement ps=con.prepareStatement(  
					"select * from users where username=? and password=?");  
			ps.setString(1,name);  
			ps.setString(2,pass);  

			ResultSet rs=ps.executeQuery();  
			status=rs.next();  

		}catch(Exception e){
			e.printStackTrace(System.out);
		}  
		return status;  
	}  
}