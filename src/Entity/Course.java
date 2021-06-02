package Entity;

import java.io.Serializable;


/**
 * Represents a course in the school. A course can has many Indexes.
 * 
 * @author 
 *
 */
public class Course implements Serializable {
	/**
	 * The unique code of this Course.
	 * 
	 */
	private String courseCode;
	/**
	 *  The full course name of this Course.
	 *  
	 */
	private String courseName;
	/**
	 * The instructors of the Course.
	 */
	private String[] instructors;
	/**
	 * The number of AUs of this Course.
	 */
	private int au;
	/**
	 * The Indexes under this Course.
	 * 
	 */
	private Index[] indexes;
	/**
	 * The school which this Course belongs to.
	 */
	private String schoolName; 
	
	
	/**
	 * Creates a Course.
	 * 
	 */
	public Course(){}
	public Course(String CourseCode, String CourseName, int au, Index[] i, String SchoolName) {
		this.courseCode=CourseCode;
		this.courseName=CourseName;
		this.au=au;
		this.indexes=i;
		this.schoolName=SchoolName;
	}
	/**
	 * Gets the AU of this Course.
	 * 
	 * @return this Course AU.
	 */
	public int getAu() {
		return au;
	}
	/**
	 * Gets the course code of this Course.
	 * @return this Course's course code.
	 */

	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * Gets the name of this Course.
	 * @return this Course's full name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Gets the Indexes of the Course.
	 * @return the Indexes of the Course.
	 */
	public Index[] getIndexes() {
		return indexes;
	}
	
	/**
	 * Gets the instructors of the Course.
	 * @return the Instructors of the Course.
	 */
	public String[] getInstructors() {
		return instructors;
	}
	/**
	 * Changes the AU of this Course.
	 * 
	 * @param au
	 * this Course's new AU.
	 */
	public void setAu(int au) {
		this.au = au;
	}
	
	/**
	 * Changes the courseCode of this Course.
	 * @param courseCode
	 * this Course's new course code.
	 */

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	/**
	 * Changes the courseName of this Course.
	 * 
	 * @param courseName
	 * this Course's new course name.
	 */

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * Changes the Indexes of this Course.
	 * 
	 * @param indexes
	 * this Course's new Indexes.
	 */

	public void setIndexes(Index[] indexes) {
		this.indexes = indexes;
	}
	
	/**
	 * Changes the instructors of the Course.
	 * 
	 * @param instructors
	 * this Course's new Instructors.
	 */
	
	public void setInstructors(String[] instructors) {
		this.instructors=instructors;
	}
	/**
	 * Gets School which this Course belongs to.
	 * @return this Course's School.
	 */
	public String getschoolName(){
		return schoolName;
	}
	
	/**
	 * Changes the School of this Course.
	 * 
	 * @param schoolName
	 * this Course's new School.
	 */
	public void setschoolName(String schoolName){
		this.schoolName = this.schoolName;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Course) {
			Course p = (Course)o;
			return (getCourseCode().equalsIgnoreCase(p.getCourseCode()));
		}
		return false;
	}

}