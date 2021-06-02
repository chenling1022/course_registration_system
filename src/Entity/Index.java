package Entity;

import java.io.Serializable;

/**
 * Represents an index a Course has. An Index has a WaitList and can have many lessons.
 * 
 * @author 
 *
 */
public class Index implements Serializable {
	/**
	 * The Index Number of this Course.
	 */
	private String courseIndex;
	/**
	 * The total number of students this Index can have.
	 */
	private int size;
	/**
	 * The number of empty slot available for students in this Index.
	 */
	private int vacancy;
	/**
	 * The number of students that have been added to this Index to their account.
	 */
	private int num_students;
	/**
	 * The name of the tutorial group of this Index.
	 */
	private String group;
	/**
	 * All the lessons this Index has.
	 */
	private LessonType[] lessons;
	/**
	 * The WaitList which this Index has.
	 */
	private WaitList waitlist;
	
	/**
	 * Creates a new Index.
	 */
	public Index(){}
	public Index(String courseIndex,int size,int vacancy, int num_students,String group, LessonType[] lessons, WaitList waitList) {
		this.courseIndex = courseIndex;
		this.size = size;
		this.vacancy = vacancy;
		this.num_students = num_students;
		this.group = group;
		this.lessons = lessons;
		this.waitlist = waitList;
	}
	
	/**
	 * Gets the Course code which this Index belongs to.
	 * @return this Index's Course code.
	 */
	public String getCourseIndex() {
		return courseIndex;
	}
	
	/**
	 * Gets the total number of students this Index can have.
	 * @return this Index's size.
	 */
	
	public int getSize() {
		return size;
	}
	
	/**
	 * Gets the total number of students this Index already has.
	 * @return this Index's total number of students.
	 */
	public int getNumberOfStudent() {
		return num_students;
	}
	/**
	 * Gets the number of empty slots available for students in this Index.
	 * @return this Index's Vacancy.
	 */
		
	public int getVacancy()
	{
		return vacancy;
	}
	
	/**
	 * Gets the lessons this Index number has.
	 * @return this Index's lessons
	 */
	public LessonType[] getLessons() {
		return lessons;
	}
	/**
	 * Gets the tutorial group this Index number has.
	 * @return this Index's tutorial group.
	 */
	
	public String getGroup() {
		return group;
	}
	
	/**
	 * Gets the WaitList of this Index Number.
	 * @return this Index's WaitList.
	 */
	public WaitList getWaitlist() {
		return waitlist;
	}
	/**
	 * Changes the Course code of this Index.
	 * @param i
	 * this Index's new Course code.
	 */

	public void setCourseIndex(String i) {
		this.courseIndex = i;
	}
	/**
	 * Changes the LessonType of this Index.
	 * @param lessons 
	 * this Index's new LessonType.
	 */
	
	public void setLessons(LessonType[] lessons) {
		this.lessons = lessons;
	}
	/**
	 * Changes the number of students this Index can have.
	 * @param numberOfStudent
	 * this Index's new number of students.
	 */
	public void setNumberOfStudent(int numberOfStudent) {
		this.num_students = numberOfStudent;
	}
	/**
	 * Changes the number of student this Index can have.
	 * @param size
	 * this Index's new size.
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * Changes the number of empty slot of this Index.
	 * @param vacancy
	 * this Index's new Vacancy . 
	 */
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	/**
	 * Changes the WaitList of this Index.
	 * @param waitlist
	 * this Index's new WaitList.
	 */
	public void setWaitlist(WaitList waitlist) {
		this.waitlist = waitlist;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Index) {
			Index p = (Index)o;
			return (getCourseIndex().equalsIgnoreCase(p.getCourseIndex()));
		}
		return false;
	}
	

}