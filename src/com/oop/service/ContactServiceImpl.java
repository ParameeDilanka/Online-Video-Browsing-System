/**
 *  
 * @author Paramee Dilanka
 * 
 * @version 1.0
 * 
 */
 
package com.oop.service;

import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Contact;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class ContactServiceImpl implements IContactService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ContactServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createEmployeeTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Employees table in the database and
	 * recreate table structure to insert contact entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */
	public static void createEmployeeTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new employees table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of contacts for as a batch from the selected employee List
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * 
	 */
	@Override
	public void addContact(Contact employee) {

		String userID = CommonUtil.generateIDs(getUserIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_contact key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CONTACTS));
			connection.setAutoCommit(false);
			
			//Generate user IDs
			employee.setUserID(userID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, employee.getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, employee.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, employee.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, employee.getPhone());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, employee.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, employee.getSubject());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, employee.getMessage());
		
			// Add contact
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * Contact details can be retrieved based on the provided user ID
	 * 
	 * @param userID
	 *            - Contact details are filtered based on the ID
	 * 
	 * @see #actionOnEmployee()
	 */
	@Override
	public Contact getContactByID(String userID) {

		return actionOnEmployee(userID).get(0);
	}
	
	/**
	 * Get all list of employees
	 * 
	 * @return ArrayList<Contact> 
	 * 						- Array of employee list will be return
	 * 
	 * @see #actionOnEmployee()
	 */
	@Override
	public ArrayList<Contact> getEmployees() {
		
		return actionOnEmployee(null);
	}

	/**
	 * This method delete an contact based on the provided ID
	 * 
	 * @param userID
	 *            - Delete contact according to the filtered contact details
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	@Override
	public void removeContact(String userID) {

		// Before deleting check whether user ID is available
		if (userID != null && !userID.isEmpty()) {
			/*
			 * Remove contact query will be retrieved from ContactQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CONTACTS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs GET contact by ID and Display all contacts
	 * 
	 * @param userID
	 *            ID of the contact to remove or select from the list

	 * @return ArrayList<Contact> Array of employee list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @see #getContacts()
	 * @see #geCcontactByID(String)
	 */
	private ArrayList<Contact> actionOnEmployee(String userID) {

		ArrayList<Contact> employeeList = new ArrayList<Contact>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (userID != null && !userID.isEmpty()) {
				/*
				 * Get contact by ID query will be retrieved from
				 * ContactQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CONTACTS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
			}
			/*
			 * If contactemployee ID is not provided for get contact option it display
			 * all contacts
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CONTACTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Contact employee = new Contact();
				employee.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				employee.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				employee.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				employee.setPhone(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				employee.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				employee.setSubject(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				employee.setMessage(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				employeeList.add(employee);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return employeeList;
	}

	/**
	 * Get the updated contact
	 * 
	 * @param userID
	 *            ID of the contact to remove or select from the list
	 * 
	 * @return return the Contact object
	 * 
	 */
	@Override
	public Contact updateContact(String userID, Contact employee) {

		/*
		 * Before fetching employee it checks whether user ID is available
		 */
		if (userID != null && !userID.isEmpty()) {
			/*
			 * Update employee query will be retrieved from ContactQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CONTACTS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, employee.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, employee.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, employee.getPhone());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, employee.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, employee.getSubject());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, employee.getMessage());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, employee.getUserID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated contact
		return getContactByID(userID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of contact id list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	private ArrayList<String> getUserIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of user IDs will be retrieved from ContactQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CONTACTS_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
