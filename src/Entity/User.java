package Entity;


import java.io.Serializable;
/**
 * Represents an user of StarPlanner. A user can be Admin or Student.
 * 
 * @author
 *
 */
public class User implements Serializable {
	/**
	 * The user type of the user, either Admin or Student.
	 */
	private char usertype;
	/**
	 * The username of this User which will be used for login.
	 */
	private String username;
	/**
	 * The account password of this User which will be used for login.
	 */
	private String password ;
	/**
	 * The first name of this user.
	 */
	private String firstName;
	/**
	 * The last name of this user.
	 */
	private String lastName;
	/**
	 * Creates a User.
	 * @param firstName
	 * @param lastName
	 * @param usertype
	 * @param username
	 * @param password
	 */
	public User (String firstName, String lastName, char usertype, String username, String password) {
		this.usertype = usertype;
		this.firstName = firstName;
		this.lastName = lastName; 
		this.password = password;
		this.username = username;
	}
	/**
	 * Gets the first name of this User.
	 * @return this User's first name.
	 */
	public String getFirstName(){
		return firstName;	
	}
	/**
	 * Gets the last name of this User.
	 * @return this User's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Gets the user name of this User.
	 * @return this User's user name.
	 */

	public String getUserName() {
		return username;
	}
	/**
	 * Gets the user type of this User.
	 * @return this User's user type.
	 */
	public char getUsertype() {
		return usertype;
	}
	/**
	 * Gets the password of this User.
	 * @return this User's password.
	 */

	public String getPassword(){
		return password;
	}
	/**
	 * Changes to the first name of this Student.
	 * @param firstName
	 *  this User's new first name.
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	/**
	 * Changes to the last name of this Student.
	 * @param lastName
	 *  this User's new last name.
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Changes the password of this User.
	 * 
	 * @param password
	 *            this User's new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Changes the user type  of this User.
	 * 
	 * @param usertype
	 *            this User's new user type
	 */

	public void setUsertype(char usertype) {
		this.usertype = usertype; 
	}
	/**
	 * Changes the username of this User.
	 * 
	 * @param UserName
	 *            this User's new username.
	 */

	public void setUserName(String UserName) {
		this.username = UserName; 
	}
	
	public boolean equals(Object o) {
		if (o instanceof User) {
			User p = (User)o;
			return (getUserName().equalsIgnoreCase(p.getUserName()));
		}
		return false;
	}

}