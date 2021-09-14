/**
 *  
 * @author Paramee Dilanka
 * 
 * @version 1.0
 * 
 */
package com.oop.util;
import java.sql.*;
/**
 * This is the common constants file for Java Web project.
 * 
*  
 * @author Paramee Dilanka
 * 
 * @version 1.0
 * 
 */

public class CommonConstants {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in EmployeeQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in EmployeeQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for employee id prefix */
	public static final String EMPLOYEE_ID_PREFIX = "C00";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_table in EmployeeQuery.xml */
	public static final String QUERY_ID_DROP_TABLE = "drop_table";

	/** Constant for query id of create_table in EmployeeQuery.xml */
	public static final String QUERY_ID_CREATE_TABLE = "create_employee_table";

	/** Constant for query id of insert employees in EmployeeQuery.xml */
	public static final String QUERY_ID_INSERT_CONTACTS = "insert_contact";

	/** Constant for query id of get an employee in EmployeeQuery.xml */
	public static final String QUERY_ID_GET_CONTACTS = "contact_by_id";

	/** Constant for query id of get all employees in EmployeeQuery.xml */
	public static final String QUERY_ID_ALL_CONTACTS = "all_contacts";

	/** Constant for query id of remove a employee in EmployeeQuery.xml */
	public static final String QUERY_ID_REMOVE_CONTACTS = "remove_contact";

	/** Constant for query id of update a employee in EmployeeQuery.xml */
	public static final String QUERY_ID_UPDATE_CONTACTS = "update_contact";

	/** Constant for query id of get all employee ids in EmployeeQuery.xml */
	public static final String QUERY_ID_GET_CONTACTS_IDS = "contact_ids";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	

}
