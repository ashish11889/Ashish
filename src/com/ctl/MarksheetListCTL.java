package com.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MarksheetDTO;
import com.service.MarksheetService;

public class MarksheetListCTL extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try {
			String name = request.getParameter("name");
			String operation = request.getParameter("operation");
			MarksheetService	marksheetservice = new MarksheetService();
			MarksheetDTO marksheetdto = new MarksheetDTO();
			List list=new ArrayList();
			list =  marksheetservice.getlist();
				request.setAttribute("message", list);
				RequestDispatcher rd; 
				rd = request.getRequestDispatcher("list.jsp");
		
			if ("search".equalsIgnoreCase(operation)) {
				System.out.println("In Search");	
				marksheetdto.setName(name);
			
					list=marksheetservice.Search(marksheetdto);
					Iterator it =list.iterator();
					while(it.hasNext())
					{
						marksheetdto=(MarksheetDTO)it.next();
					System.out.print(marksheetdto.getRollno()+"\t");
					System.out.print(marksheetdto.getName()+"\t");
					System.out.print(marksheetdto.getChemistry()+"\t");
					System.out.print(marksheetdto.getPhysics()+"\t");
					System.out.println(marksheetdto.getMaths()+"\t");
					
					}
					
					
					request.setAttribute("message", list);
					rd = request.getRequestDispatcher("list.jsp");
					}
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// out.close();

}
