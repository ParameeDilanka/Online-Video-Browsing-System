package com.oop.servlet;

import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Contact;
import com.oop.service.ContactServiceImpl;
import com.oop.service.IContactService;

/**
 * Update contacts servlet
 */
public class UpdateContactServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateContactServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Contact employee = new Contact();
		String userID = request.getParameter("userID");	
		employee.setUserID(userID);
		employee.setName(request.getParameter("Name"));
		employee.setEmail(request.getParameter("email"));
	    employee.setPhone(request.getParameter("phone"));
		employee.setAddress(request.getParameter("address"));
		employee.setSubject(request.getParameter("subject"));
		employee.setMessage(request.getParameter("message"));
		
		
		IContactService iEmployeeService = new ContactServiceImpl();
		iEmployeeService.updateContact(userID, employee);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListContact.jsp");
		dispatcher.forward(request, response);
	}

}
