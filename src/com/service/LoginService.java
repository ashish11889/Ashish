package com.service;
import java.sql.*;

import com.dto.LoginDTO;
public class LoginService {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	LoginDTO logindto=new LoginDTO();
	public LoginService()throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
	}
	public boolean checkLogin(LoginDTO logindto)throws Exception
	{
		boolean b=false;
		ps=con.prepareStatement("select * from login where Username=? and Password=?");
		ps.setString(1,logindto.getUsername());
		ps.setString(2,logindto.getPassword());
		rs=ps.executeQuery();
		
		if(rs.next())
			
		{
			b=true;
			System.out.println("valid user");
		}
		else
		{
			System.out.println("invalid user");
		}
		return b;
		
		
	}
	
	
	
	
}
