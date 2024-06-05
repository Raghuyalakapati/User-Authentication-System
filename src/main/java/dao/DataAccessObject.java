package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modalclasses.LoginModal;
import modalclasses.RegisterModal;


public class DataAccessObject implements DaoInterface{
	
	
	// Registration DAO method to insert the data 
	
	public String insertData(RegisterModal rm) {
		
		String status="";
		
		// DAO Data
       String fn=rm.getFname();	
       String ln = rm.getLname();
       String mn=rm.getMobile();
       
       String email=rm.getEmail();
       String pwd=rm.getPwd();
	   System.out.println("Dao Layer:"+fn+" "+ln +" "+mn +" "+email +" "+pwd);
		
		// Database Connectivity JDBC //
	   
	   try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserData","root","root");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO Users (fname, lname, mobile, email, password) VALUES (?, ?, ?, ?, ?)");
			
			ps.setString(1,fn);
			ps.setString(2,ln);
			ps.setString(3,mn);
			ps.setString(4,email);
			ps.setString(5,pwd);
			
			int n=ps.executeUpdate();
			if(n>0) {
				status="SUCCESS";
				System.out.println(n+ "rows inserted..");
			}
			else {
				status="FAILURE";
				System.out.println("Something is went Wrong..");
			}		
		
	} catch (ClassNotFoundException e) {
		 e.printStackTrace();
	}
	   catch (SQLException e) {
			e.printStackTrace();
		}
		   
		
		return status;
	}

	public String checkData(LoginModal lm) {
		
		String status = "";
		
		System.out.println("Dao Layer:"+lm.getEmail()+" "+lm.getPassword());
		
 		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserData","root","root");
 		
 		
 		PreparedStatement ps = con.prepareStatement("select count(*) from users where email=? and password=?");
 		ps.setString(1,lm.getEmail());
 		ps.setString(2, lm.getPassword());
 		
 		ResultSet rs = ps.executeQuery();
 		if(rs.next()) {
 			int n= rs.getInt("count(*)");
 			if(n>0) {
 				status="SUCCESS";
 				System.out.println(n+" Login Succesfully");
 			}
                 			 
 		}
 		else {
 			status="FAILURE";
 			System.out.println("Something is wrong");
 		}
	}
 		catch(SQLException se) {
 			se.printStackTrace();
 		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}
