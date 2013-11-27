package com.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LoginDTO;
import com.service.LoginService;

public class LoginCTL extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
        boolean b=false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String op=request.getParameter("operation");
		String op1=request.getParameter("username");
		String op2=request.getParameter("password");
		
		HttpSession session=request.getSession(true);
		LoginService loginservice=null;
		LoginDTO logindto=new LoginDTO();
		if("Login".equalsIgnoreCase(op))
		{
			try
			{
				
			
			loginservice=new LoginService();
	        logindto.setUsername(op1);
	        logindto.setPassword(op2);
	        b=loginservice.checkLogin(logindto);
	        if(b==true)
	        {
	        	session.setAttribute("user", "Deepak");
	        	session.setMaxInactiveInterval(30);
	        	System.out.println(session.getId()+"session id");
        		RequestDispatcher dispatcher=request.getRequestDispatcher("Marksheet.jsp");
        		dispatcher.forward(request,response);
	        	
	        }
	        else
	        	{
	        		request.setAttribute("msg","wrg username or password");
	        		RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
	        		dispatcher.forward(request,response);
	        	
	        
	        	}
			}
			catch(Exception e)
			{
		
		}
		}
	}
}

