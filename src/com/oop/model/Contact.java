/**
 *  
 * @author Paramee Dilanka
 * 
 * @version 1.0
 * 
 */
package com.oop.model;

/**
 * This is the Contact model class
 * 
 * @author Paramee Dilanka
 * @version 1.0
 */
public class Contact {

	private String UserID;
	
	private String Name;

	private String Email;

	private String Phone;
	
	private String Address;
	
	private String Subject;
	
	private String Message;

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return UserID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		UserID = userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return Phone;
	}

	/**
	 * @param phonef the phone to set
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return Subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		Subject = subject;
	}
	/**
	 * @return the Message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		Message = message;
	}


	
	
	@Override
	public String toString() {
		
		return "User ID = " + UserID + "\n" + " Name = " + Name + "\n" + "Email = " + Email+ "\n"
				+ "Phone= " + Phone + "\n" + "Address = " + Address + "\n" + "Subject = "
				+ Subject + "\n" + "Message = " + Message;
	}
}
