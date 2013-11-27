package com.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MarksheetDTO;
import com.service.MarksheetService;

public class MarksheetCTL extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		MarksheetDTO marksheetDTO=new MarksheetDTO();
		MarksheetService marksheetsevice = null;
		try {
			marksheetsevice = new MarksheetService();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int rollno = 0;
		String name = null;
		int chemistry = 0;
		int physics = 0;
		int maths = 0;
		try {
			rollno = Integer.parseInt(request.getParameter("rollno"));

			name = request.getParameter("name");
			chemistry = Integer.parseInt(request.getParameter("chemistry"));
			physics = Integer.parseInt(request.getParameter("physics"));
			maths = Integer.parseInt(request.getParameter("maths"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		String operation = request.getParameter("operation");
		MarksheetDTO marksheetdto = new MarksheetDTO();
		if ("add".equalsIgnoreCase(operation)) {
			marksheetdto.setRollno(rollno);
			marksheetdto.setName(name);
			marksheetdto.setChemistry(chemistry);
			marksheetdto.setPhysics(physics);
			marksheetdto.setMaths(maths);

			try {
				marksheetsevice.add(marksheetdto);
				RequestDispatcher rp = request
						.getRequestDispatcher("Marksheet.jsp");
				rp.forward(request, response);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		if ("delete".equals(operation)) {
			System.out.println("in the ctl");
			marksheetdto.setRollno(rollno);

			try {
				marksheetsevice = new MarksheetService();
				marksheetsevice.delete(marksheetdto);
				RequestDispatcher rp = request
						.getRequestDispatcher("Marksheet.jsp");
				rp.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("Getlist".equalsIgnoreCase(operation)) {
			try {
				ArrayList list = new ArrayList();
				list = (ArrayList) marksheetsevice.getlist();
				request.setAttribute("message", list);
				RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

			}
		}

		if ("update".equalsIgnoreCase(operation)) {
			System.out.println("updated");
			marksheetdto.setName(name);
			marksheetdto.setChemistry(chemistry);
			marksheetdto.setPhysics(physics);
			marksheetdto.setMaths(maths);
			marksheetdto.setName(name);
			try {
				marksheetsevice = new MarksheetService();
				marksheetsevice.update(marksheetdto);
				RequestDispatcher rp = request
						.getRequestDispatcher("Marksheet.jsp");
				rp.forward(request, response);

			} catch (Exception e)

			{
				e.printStackTrace();//it  is a method of throwable class.

			}
		}
		if ("get".equalsIgnoreCase(operation)) {
			// marksheetdto=marksheetservice.get(marksheetdto);
			try {
				marksheetdto.setRollno(rollno);
				marksheetsevice = new MarksheetService();
				marksheetdto = marksheetsevice.get(marksheetdto);

				System.out.println("##############################"
						+ marksheetdto.getRollno() + "\t");
				System.out.println(marksheetdto.getName() + "\t");
				System.out.println(marksheetdto.getChemistry() + "\t");
				System.out.println(marksheetdto.getPhysics() + "\t");
				System.out.println(marksheetdto.getMaths() + "\t");

				request.setAttribute("list", marksheetdto);
				RequestDispatcher rp = request
						.getRequestDispatcher("Marksheet.jsp");
				rp.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		if ("List".equalsIgnoreCase(operation)) {

			RequestDispatcher rp = request
			.getRequestDispatcher("MarksheetListCTL");
	rp.forward(request, response);

		}
		
		
	}
	// out.close();

}
