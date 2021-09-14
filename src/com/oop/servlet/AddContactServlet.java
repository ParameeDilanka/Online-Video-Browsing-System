package com.oop.servlet;

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
 * Servlet implementation class LoginServlet
 */
public class AddContactServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContactServlet() {
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
		
		employee.setName(request.getParameter("Name"));
		employee.setEmail(request.getParameter("email"));
		employee.setPhone(request.getParameter("phone"));
		employee.setAddress(request.getParameter("address"));
		employee.setSubject(request.getParameter("subject"));
		employee.setMessage(request.getParameter("message"));

		IContactService iEmployeeService = new ContactServiceImpl();
		iEmployeeService.addContact(employee);

		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListContact.jsp");
		dispatcher.forward(request, response);
	}

}
