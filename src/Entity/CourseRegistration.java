package Entity;
import java.io.Serializable;
/**
 * Represents a CourseRegistation which belong to a Student. It stores an Index
 * along with a Student.
 * 
 * @author
 *
 */
public class CourseRegistration implements Serializable{
	/**
	 * Course code of the CourseRegistration.
	 *
	 */
	private String courseCode; 
	/**
	 * 	Student of the CourseRegistration.
	 */
    private Student student; 
    /**
	 * 	Index number of the CourseRegistration.
	 */
    private String indexNum;
    /**
     * Course type of the CourseRegistration.
     */
    private String courseType;
    /**
     * Status of the CourseRegistration.
     */
    private String status;
    
    /**
     * Creates a CourseRegistration.
     * @param course
     * @param student
     * @param Index
     * @param courseType
     * @param status
     */

    public CourseRegistration(String course, Student student, String Index, String courseType, String status){
        this.indexNum = Index;
        this.courseCode = course;
        this.student = student;
        this.courseType=courseType;
        this.status=status;
        
    }
    
    /**
     * Gets the courseCode of the CourseRegistration.
     * @return this CourseRegistration's courseCode.
     */

	public String getCourse(){
		return courseCode;

	}
	/**
	 * Changes the courseCode of the CourseRegistration.
	 * @param course
	 * this CourseRegistration's new courseCode.
	 */
	public void setCourse(String course){
		this.courseCode = course;
	}
	
	/**
	 * Gets the student of the CourseRegistration.
	 * @return this CourseRegistration's student.
	 */
	public Student getStudent(){
		return student;
	}
	/**
	 * Changes the student of the CourseRegistration.
	 * @param student
	 * this CourseRegistration's new student.
	 */
	public void setStudent(Student student){
		this.student = student ; 
    }
    /**
     * Gets the Index of the CourseRegistration.
     * @return this CourseRegistration's Index.
     */
    public String getIndex(){
		return indexNum;
	}
    /** 
     * Changes the Index of the Course.
     * @param Index
     * this CourseRegistration's new Index.
     */
	public void setIndex(String Index){
		this.indexNum = Index ; 
    }
	/**
	 * Gets the Course Type of this CourseRegistration.
	 * @return this CourseRegistration's courseType.
	 */
	public String getCourseType(){
		return courseType;

	}
	/**
	 * Changes the course type of the CourseRegistration.
	 * @param course
	 * this CourseRegistration's new course.
	 */
	public void setCourseType(String course){
		this.courseType = course;
	}
	/**
	 * Gets the status of this CourseRegistration.
	 * @return this CourseRegistration's new status.
	 */
	public String getStatus()
	{
		return status;
	}
	/**
	 * Changes to the status of this CourseRegistration.
	 * @param status
	 * this CourseRegistration's new status.
	 */
	public void setStatus(String status)
	{
		this.status=status;
	}
	
	public boolean equals(Object o) {
		if (o instanceof CourseRegistration) {
			CourseRegistration p = (CourseRegistration)o;
			return (getStudent().getUserName().equalsIgnoreCase(p.getStudent().getUserName())&&getIndex().equals(p.getIndex()));
		}
		return false;
	}
    
}