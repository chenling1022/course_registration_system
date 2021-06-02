package Entity;


import java.util.*;
import java.util.Scanner;
import java.io.Serializable; 
/**
 * Represents a WaitList an Index has.
 * 
 * @author
 *
 */
public class WaitList implements Serializable {
	

	/**
	 * The number of students in this WaitList.
	 */
	private int num;
	/**
	 * The list of students under this WaitList. Stores matriculation number of
	 * Students and course type.
	 */
	private Student[] student;
	/**
	 * Creates a new WaitList.
	 */
	public WaitList(){
	}
	public WaitList(int mum, Student[] student) {
		this.num = num;
		this.student = student;
	}
	/**
	 * Gets the number of students in this WaitList.
	 * 
	 * @return this WaitList's number of students.
	 */
	public int getNum() {
		return num;
	}
	
	public Student[] getStudent() {
		return student;
	}
	/**
	 * Changes the number of students in this WaitList.
	 * 
	 * @param num
	 *            this WaitList's new number of students.
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * Changes the list of students this WaitList have.
	 * 
	 * @param studentWaitList
	 *            this WaitList's new students list.
	 */
	public void setStudent(Student[] studentWaitList) {
		this.student = studentWaitList;
	}
	
	public boolean equals(Object o) {
		if (o instanceof WaitList) {
			WaitList p = (WaitList)o;
			return (getNum()==(p.getNum()));
		}
		return false;
	}

}