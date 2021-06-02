package Entity;

import java.io.Serializable;

/**
 * Represents a school. A school can have many Students and many Courses.
 * @author 
 *
 */
public class School implements Serializable{
	/**
	 * The full name of this School.
	 */

	private String schoolName;
	/**
	 * The initial of this School that is unique which can be used to identify
	 * the School.
	 */
	private String schoolInitial;
	/**
	 * Students enrolled in this School.
	 */
	private Student[] students;
	/**
	 * The access period for students under this School.
	 */
	private accessperiod period;
	/**
	 * Gets the initial of this School.
	 * 
	 * @return this School's initial
	 */
	public School() {}
	public School(String schoolName, String schoolInitial, accessperiod period) {
		this.schoolName = schoolName;
		this.schoolInitial = schoolInitial;
		this.period = period;
	}
	

	public String getSchoolInitial() {
		return schoolInitial;
	}
	/**
	 * Gets the full name of this School.
	 * 
	 * @return this School's full name
	 */

	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * Gets Students rolled in this School.
	 * 
	 * @return this School's students
	 */

	public Student[] getStudents() {
		return students;
	}
	/**
	 * Gets access period of this School.
	 * @return this School's accessperiod.
	 */
	public accessperiod getPeriod(){
		return period;
	}
	/**
	 * Changes the initial of this School.
	 * 
	 * @param schoolInitial
	 *            This School's new initial.
	 */

	public void setSchoolInitial(String schoolInitial) {
		this.schoolInitial = schoolInitial;
	}
	/**
	 * Changes the full name of this School.
	 * 
	 * @param schoolName
	 *            This Schools's new full name.
	 */

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/**
	 * Changes the Students in this School.
	 * 
	 * @param students
	 *            This Schools's new students.
	 */
	

	public void setStudents(Student[] students) {
		this.students = students;
	}
	/**
	 * Changes the accessperiod of this School.
	 * @param period
	 * This School's new access period.
	 */
	public void setPeriod(accessperiod period){
		this.period=period;
	}
	public boolean equals(Object o) {
		if (o instanceof School) {
			School p = (School)o;
			return (getSchoolInitial().equalsIgnoreCase(p.getSchoolInitial()));
		}
		return false;
	}
}