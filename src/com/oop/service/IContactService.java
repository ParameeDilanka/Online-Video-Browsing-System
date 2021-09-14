/**
 *  
 * @author Paramee Dilanka
 * 
 * @version 1.0
 * 
 */
package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.Contact;

public interface IContactService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IContactService.class.getName());



	public void addContact(Contact employee);

	/**
	 * Get a particular Contact
	 * 
	 * @param userID
	 * @return Employee
	 */
	public Contact getContactByID(String userID);
	
	/**
	 * Get all list of  contacts
	 * 
	 * @return ArrayList<Contact>
	 */
	public ArrayList<Contact> getEmployees();
	
	/**
	 * Update existing  contact
	 * @param userID
	 * @param employee
	 * 
	 * @return
	 */
	public Contact updateContact(String userID, Contact employee);

	/**
	 * Remove existing contact
	 * 
	 * @param userID
	 */
	public void removeContact(String userID);

}
