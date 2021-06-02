package Entity;

import java.util.*;
import java.io.Serializable;
/**
 * Represents a Student enrolled in the School which is an User of StarsPlanner. A
 * Student can have multiple CourseRegistation.
 * 
 * @author
 *
 */

public class Student extends User implements Serializable{
	

	/**
	 * The matriculation number of this Student.
	 */
	private String matricNumber;
	/**
	 * The country which this Student is born.
	 */
	private String nationality;
	/**
	 * The current study year which this Student is in.
	 */
	private int study_year ;
	/**
	 * School where this Student is enrolled in.
	 */
	private String school ;
	/**
	 * The current programme which this Student is in.
	 */
	private String program ;
	/**
	 * The specialization which this Student is taking.
	 */
	private String specialisation ;
	/**
	 * The gender of this Student.
	 */
	private String gender ;
	/**
	 * The email address of this Student used for Course registered email
	 * notification.
	 */
	private String email;
	/**
	 * The mobile phone number of this Student used for Course registered SMS
	 * notification.
	 */
	private String mobileNumber;
	/**
	 * Creates a Student.
	 * @param firstName
	 * @param lastName
	 * @param matricNumber
	 * @param gender
	 * @param nationality
	 * @param study_year
	 * @param school
	 * @param program
	 * @param specialization
	 * @param email
	 * @param mobileNumber
	 * @param username
	 * @param password
	 */

	public Student(String firstName, String lastName, String matricNumber, String gender, String nationality, int study_year, String school, String program, String specialization, String email,String mobileNumber, String username, String password) {
		super(firstName, lastName, 'S', username , password );
		this.setFirstName(firstName.toUpperCase()) ;
		this.setLastName(lastName.toUpperCase());
		this.matricNumber = matricNumber;
		this.nationality = nationality;
		this.study_year = study_year;
		this.school = school;
		this.program = program;
		this.specialisation = specialization;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * Gets the country which this Students is born.
	 * 
	 * @return this Student's nationality.
	 */

	public String getnationality(){
		return nationality;
	}
	/**
	 * Changes the nationality of this Student.
	 * 
	 * @param nationality
	 *            this Student's new nationality.
	 */

	public void setnationality(String nationality){
		this.nationality = nationality;
	}
	/**
	 * Gets the current study year of this Student.
	 * 
	 * @return this Student's study year.
	 */

	public int getstudy_year(){
		return study_year;
	}
	
	/**
	 * Changes the current study year of this Student.
	 * 
	 * @param study_year
	 *            this Student's new study year.
	 */

	public void setstudy_year(int study_year){
		this.study_year = study_year;
	}
	/**
	 * Gets the School which this Student is enrolled in.
	 * 
	 * @return this Student's school.
	 */
	

	public String getSchool(){
		return school;
	}
	/**
	 * Changes the School of this Student.
	 * 
	 * @param school
	 *            this Student's new School.
	 */

	public void setSchool(String school){
		this.school = school;
	}
	/**
	 * Gets the programme that this Student is currently taking.
	 * 
	 * @return this Student's programme.
	 */

	public String getprogram(){
		return program;
	}
	/**
	 * Changes the programme that this Student's is taking.
	 * 
	 * @param program
	 *            this Student's new programme.
	 */

	public void setprogram(String program){
		this.program = program;
	}
	/**
	 * Gets the specialization this Student is take on.
	 * 
	 * @return this Student's specialization.
	 */

	public String getSpecilization(){
		return specialisation;
	}
	
	/**
	 * Changes the specialization of this Student.
	 * 
	 * @param specialization
	 *            this Student's new specialization.
	 */

	public void setSpecilization(String specialization){
		this.specialisation = specialization;
	}
	/**
	 * Gets the matriculation number of this Student.
	 * 
	 * @return this Students matriculation number.
	 */

	public String getmatricNumber(){
		return matricNumber;
	}
	/**
	 * Changes the matriculation number of this Student.
	 * 
	 * @param matricNumber
	 *            this Student's new matriculation number.
	 */

	public void setmatricNumber(String matricNumber){
		this.matricNumber = matricNumber;
	}
	/**
	 * Gets the email address of this Student.
	 * 
	 * @return this Student's email.
	 */
	

	public String getemail(){
		return email;
	}
	/**
	 * Changes the email of this Student.
	 * 
	 * @param email
	 *            this Student's new email.
	 */

	public void setemail(String email){
		this.email = email;
	}
	
	/**
	 * Gets the mobile phone number of this Student.
	 * 
	 * @return this Student's mobile phone number
	 */
		
	public String getmobileNumber(){
		return mobileNumber;
	}
	/**
	 * Changes the mobile phone number of this Student.
	 * 
	 * @param mobileNo
	 *            this Student's new mobile phone number.
	 */

	public void setmobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}
	/**
	 * Gets the gender of this Student.
	 * @return this Student's gender
	 */
	public String getGender(){
		return gender;
	}
	/**
	 * Changes to the gender of this Student
	 * @param gender
	 * this Student's new gender.
	 */
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student p = (Student)o;
			return (getUserName().equalsIgnoreCase(p.getUserName()));
		}
		return false;
	}
}
