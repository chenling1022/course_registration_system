package Entity;

import java.util.*;
import java.io.Serializable;

/**
 * Represents an administrator which is an User of StarPlanner.
 * 
 * 
 * @author 
 *
 */
public class Admin extends User implements Serializable{
	
	
	
	/**
	 * The staff ID of this Admin.
	 */

	private String staffId;
	
	/**
	 * Creates an Admin
	 * @param FirstName
	 * @param LastName
	 * @param staffId
	 * @param Username
	 * @param Password
	 */
	public Admin(String FirstName, String LastName, String staffId, String Username, String Password) {
		super(FirstName, LastName, 'A', Username, Password);
		this.staffId = staffId;
	}

	/**
	 * Gets the staff ID of this Admin.
	 * 
	 * @return this Admin's staff ID.
	 */
	public String getstaffId(){
		return staffId;
	}
	
	/**
	 * Changes the staff ID of this Admin.
	 * @param staffId 
	 * 	this Admin's new staff ID.
	 */

	public void setstaffId(String staffId){
		this.staffId = staffId;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Admin) {
			Admin p = (Admin)o;
			return (getUserName().equalsIgnoreCase(p.getUserName()));
		}
		return false;
	}
	
}
