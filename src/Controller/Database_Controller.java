package Controller;
import Entity.*;
import java.io.*;
import java.util.*;
/**
 * 
 * controller class to interact directly with the database .dat files
 * operations include add, delete, update or get to and from the database.
 */
public class Database_Controller {
    /**
     * constant to store the file path for storing the values in the object file .
     */
	private final static String adminPath = "E:\\NTU course material\\Year 2, Sem 1\\OODP\\Stars_new2\\Stars_new 2\\Stars_new\\src\\data\\Admin.dat";
	private final static String studentPath = "E:\\NTU course material\\Year 2, Sem 1\\OODP\\Stars_new2\\Stars_new 2\\Stars_new\\src\\data\\Student.dat";
	private final static String coursePath = "E:\\NTU course material\\Year 2, Sem 1\\OODP\\Stars_new2\\Stars_new 2\\Stars_new\\src\\data\\Course.dat";
	private final static String RegCoursePath = "E:\\NTU course material\\Year 2, Sem 1\\OODP\\Stars_new2\\Stars_new 2\\Stars_new\\src\\data\\RegCourse.dat";
	private final static String UserPath = "E:\\NTU course material\\Year 2, Sem 1\\OODP\\Stars_new2\\Stars_new 2\\Stars_new\\src\\data\\User.dat";
	private final static String schoolPath = "E:\\NTU course material\\Year 2, Sem 1\\OODP\\Stars_new2\\Stars_new 2\\Stars_new\\src\\data\\School.dat";
    
    /**
     * 
     * method to edit the array list of a particular 
     * object 
     * 
     * @param list, path
     *                  list is a List object which strores the values of the object 
     *                  that has been used to store the values. path is used to store 
     *                  it in the resepective file paths. 
     */
	
	public void writeList(List list, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			//ioe.printStackTrace();
		}
		
    }
    /**
     * 
     * method to read all the values from the list. 
     * 
     * @param path 
     *            refers to the path of the list.
     * 
     * @return List according to the file path. 
     */
	
	public List readList(String path) {
		List list = null;
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (ArrayList)ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//System.out.println("ADMIN NOT FOUND, NOT ATTEMPTING TO LOAD");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/**
     * write admin objects into the file in the specific file path 
     *                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
     * @param AdminList 
     *                 array list consisiting of admin objects. 
     */
	
	public void writeAdminList(ArrayList<Admin> AdminList){
		writeList(AdminList,adminPath);
    }
    /**
     * read all the values in ArrayList containing admin objects.
     */
	
	public ArrayList<Admin> readAdminList(){

		ArrayList<Admin> adminList;
		adminList=(ArrayList)readList(adminPath);
		return adminList;

    }
    /**
     * 
     * write all the values into the file using the array list containing user objects.
     * 
     * @param UserList
     *                array list consisting of the user objects. 
     */
	
	public void writeUserList(ArrayList<User> UserList){
		writeList(UserList,UserPath);
    }
    /**
     * 
     * read all the values in the array list containing user object. 
     */
	
	public ArrayList<User> readUserList(){

		ArrayList<User> UserList;
		UserList=(ArrayList)readList(UserPath);
		return UserList;

    }
    /**
     * 
     * read all the values in the array list containing student object.
    */
	
	public ArrayList<Student> readStudentList()
	{
		ArrayList<Student> StudentList;
		StudentList=(ArrayList)readList(studentPath);
		return StudentList;
    }
    /**
     * write the values into the file using the array list consisting 
     * of student objects. 
     * 
     * @param studentList
     *                   array list consisting student objects. 
     */
	
	public void writeStudentList(ArrayList<Student> studentList){
		writeList(studentList,studentPath);
    }
    
    /**
     * write all the values into the file using the arrat list containing 
     * the courses. 
     * 
     * @param courseList
     *                  array list consisiting of ccurse objects. 
     */
	
	public void writeCourseList(ArrayList<Course> courseList){
		writeList(courseList,coursePath);
    }
    /**
     * methdod to read all the courses from the file containing
     * course objcets. 
     * 
     * @return
     */
	
	public ArrayList<Course> readCourseList()
	{
		ArrayList<Course> courseList = null;
		courseList=(ArrayList)readList(coursePath);
		return courseList;
    }
    /**
     * method to read the courses that have been registered by the student.
     * 
     * @return an array list comtaining the courses that the student is
     *         enrolled in.
     */
	
	public ArrayList<CourseRegistration> readRegCourselist() {
		ArrayList<CourseRegistration> regList = null;
		regList=(ArrayList)readList(RegCoursePath);
		return regList;
    }
    /**
     * method to write all the registered courses into the file.
     * 
     * @param RegCourseList
     *                     an array list consisting of all the registered 
     *                     courses by the student.
     */
	
	public void writeRegCourseList(ArrayList<CourseRegistration> RegCourseList) {
		writeList(RegCourseList,RegCoursePath);
    }
    /**
     * method to write an array list into the file consisting of 
     * School objects.
     * 
     * @param SchoolList
     *                  array list consisting of school objects.
     */      
	
	public void writeSchoolList(ArrayList<School> SchoolList){
		writeList(SchoolList,schoolPath);
    }
    /**
     * method to read an array list into the file containing 
     * school objects
     *
     * @return an array list consisting all the school objects.
     */
	
	public ArrayList<School> readSchoolList() {
		ArrayList<School> regList = null;
		regList=(ArrayList)readList(schoolPath);
		return regList;
    }
    /**
     * method to add another admin user .
     * 
     * @param username
     *                the username which unqiuely identifies each
     *                user account
     *  @param password
     *                 password for the admin user account 
     * @param StaffNo 
     *               refers to the unique id that each of the admins 
     *               are given to retrive data using the staffNo
     * @param FirstName
     *                 the first name of the user whose account is
     *                 being created.
     * @param LastName
     *                the last name of the user whose account is
     *                being created
     * 
     */
	
	
	public void addAdmin(String username, String password, String StaffNo, String Firstname, String Lastname)
	{
		ArrayList<Admin> Adminlist = (ArrayList<Admin>)readAdminList();
		Admin a=new Admin(Firstname, Lastname, StaffNo, username, password);
		Adminlist.add(a);
		writeAdminList(Adminlist);
    }
    /**
     * method to return the particular student with the usernam 
     * inputted by the user.
     * 
     * @param Username
     *                username inputted by the user for login. 
     * @return a student object corresponding to the particular
     *         user name.
     */
	
	public Student getStudentByUsername(String Username) {
		ArrayList<Student> studentList = (ArrayList<Student>)readStudentList();
		for (int i = 0 ; i < studentList.size() ; i++) {
			Student s = (Student)studentList.get(i);
			if (s.getUserName().equalsIgnoreCase(Username))
			{
				return s;
			}
		}
		return null;
		
    }
    /**
     * method to get the student using the matriculation number
     * 
     * @param matric
     *              matric number that uniquely identifies each 
     *              student, stored in the database for each of
     *              the students.
     * @return a Student object corresponding to the matric number.
     */
	public Student getStudentByMatric(String matric) {
		ArrayList<Student> studentList = (ArrayList<Student>)readStudentList();
		for (int i = 0 ; i < studentList.size() ; i++) {
			Student s = (Student)studentList.get(i);
			if (s.getmatricNumber().equals(matric))
			{
				return s;
			}
		}
		return null;
    }
    /**
     * method to validate if a admin account exists corresponding 
     * to the particular username and password. 
     * 
     * @param a
     *          admin object 
     * @param password
     *                the password that the user inputs to login. 
     * @return returns true of false if the particular admin
     *         object exists
     */
	
	public boolean validateAdmin(Admin a, String password)
	{
		if(a.getPassword().equals(password))
			return true;
		else
			return false;
    }
    /**
     * method to validate if a student exists corresponding to the 
     * particular student object and password.
     * 
     * @param s
     *         refers to the student object.
     * @param password
     *                password that the user inputs for login.
     * @return true or false , if the particular student object
     *         exists. 
     */
	
	public boolean validateStudent(Student s, String password)
	{
		if(s.getPassword().equals(password))
			return true;
		else
			return false;
    }
    /**
     * method to get the admin corresponding to the username
     * that the user inputs.
     * 
     * @param Username
     *                refers to the username that the user inputs
     * @return admin object is returned corresdpoding to the particular
     *         username. 
     */
	
	public Admin getAdminbyUsername(String Username) {
		ArrayList<Admin> admList = (ArrayList<Admin>)readAdminList();
		for (int i = 0 ; i < admList.size() ; i++) {
			Admin s = (Admin)admList.get(i);
			if (s.getUserName().equalsIgnoreCase(Username))
			{
				return s;
			}
		}
		return null;
		
    }
    /**
     * method to get the course using the course code.
     * 
     * @param CourseCode
     *                  CourseCode, which uniquely identifies each of the 
     *                  courses. 
     * @return course object correspoding to the particular coursecode.
     */
	
	public Course getCoursebyCourseCode(String CourseCode) {
		ArrayList<Course> cList = (ArrayList<Course>)readCourseList();
		for (int i = 0 ; i < cList.size() ; i++) {
			Course s = (Course)cList.get(i);
			if (s.getCourseCode().equalsIgnoreCase(CourseCode))
			{
				return s;
			}
		}
		return null;
    }
    /**
     * method to get the details of a particular index of a course 
     * using course Index
     * 
     * @param index
     *             index, which uniquely identifies each of class group
     *             belonging to a particular course.
     * @return index object correspoding to the particualar index. 
     */
	
	public Index getIndexbyCourseIndex(String index) {
		String cc=getCourseCodebyIndex(index);
		ArrayList<Index> ind=getIndexbyCourseCode(cc);
			if (ind!=null&&ind.size()!=0) {
				
			for (int j=0; j<ind.size(); j++) {
			if (ind.get(j).getCourseIndex().equals(index))
			{
				return ind.get(j);
			}
			}	
		
		}
		return null;
    }
    /**
     * method to all the indexes of a particular course 
     * 
     * @param CourseCode
     *                  CourseCode , which uniquely identifies each course.
     * @return an array list of index objects of a particular course. 
     */
	
	public ArrayList<Index> getIndexbyCourseCode(String CourseCode){
		ArrayList<Course> cList = (ArrayList<Course>)readCourseList();
		for (int i = 0 ; i < cList.size() ; i++) {
			Course s = (Course)cList.get(i);
			if (s.getCourseCode().equalsIgnoreCase(CourseCode))
			{
				ArrayList<Index> iList=new ArrayList<Index>(Arrays.asList(s.getIndexes()));
				return iList;
			}
		}
		return null;
    }
    /**
     * method to add a course to the database 
     * 
     * @param c
     *         course object 
     * 
     */
	
	public void addCourse(Course c)
	{
		ArrayList<Course> cList = (ArrayList<Course>)readCourseList();
		cList.add(c);
		writeCourseList(cList);
		
    }
    /**
     * method to add a student to the database
     * 
     * @param s
     *         the student object to be added 
     */
	
	public void addStudent(Student s)
	{
		ArrayList<Student> list = (ArrayList<Student>)readStudentList();
		list.add(s);
		writeStudentList(list);
		
    }
    /**
     * method to add a cousrse to the registered by the student
     * 
     * @param r
     *         refers to the CourseRegistration object.
     * 
     */
	
	public void addRegCourse(CourseRegistration r) 
	{
			ArrayList<CourseRegistration> cList = (ArrayList<CourseRegistration>)readRegCourselist();
			cList.add(r);
			writeRegCourseList(cList);
	}
	/**
     * method ti delete a course that the student is registered 
     * using the index of a particular course
     * 
     * @param s
     *         student object, to delete a course for a partucular student
     * @param index
     *              index object referring to a sepcific index a particular
     *              course
     */
	public void deleteRegCoursebyIndex(Student s, String index) 
	{
		ArrayList<CourseRegistration> cList = (ArrayList<CourseRegistration>)readRegCourselist();
		for (int i = 0 ; i < cList.size() ; i++) {
			Student stu = (Student)cList.get(i).getStudent();
			if ((s.getmatricNumber().equalsIgnoreCase(stu.getmatricNumber())) && (cList.get(i).getIndex().equals(index)))
			{
				cList.remove(i);
				break;
			}
		}
		writeRegCourseList(cList);
    }
    /**
     * method to delete a student using his matriculation number
     * 
     * @param Matric 
     *              refers to the matriculation number that uniquely 
     *              identifies each student. 
     * 
     */
	
	public void deleteStudent(String Matric)
	{
		ArrayList<Student> cList = (ArrayList<Student>)readStudentList();
		for (int i = 0 ; i < cList.size() ; i++) {
			Student s = (Student)cList.get(i);
			if (s.getmatricNumber().equalsIgnoreCase(Matric))
			{
				cList.remove(i);
				break;
			}
		}
    }
    /**
     * method to delete a course from the database
     * 
     * @param courseCode
     *                  courseCode , that uniquely identifies each course.
     */
	public void deleteCourse(String courseCode)
	{
		ArrayList<Course> cList = (ArrayList<Course>)readCourseList();
		for (int i = 0 ; i < cList.size() ; i++) {
			Course s = (Course)cList.get(i);
			if (s.getCourseCode().equalsIgnoreCase(courseCode))
			{
				cList.remove(i);
				break;
			}
		}
		writeCourseList(cList);
    }
    /**
     * method to add/delete/update a course
     * 
     * @param c
     *         Course object for which the add/delete/updation 
     *         operations need to be done.
     */
	
	public void updateCourse(Course c)
	{
		deleteCourse(c.getCourseCode());
		addCourse(c);
    }
    /**
     * method to update the student details, add new student and
     * deleting the courses that he has registered for. 
     * 
     * @param c
     *         Student object for which we need to perform the above operations.
     */
	
	public void updateStudent(Student c)
	{
		deleteCourse(c.getmatricNumber());
		addStudent(c);
	}
	/**
     * method to add a student to the waitlist of a course
     * 
     * @param s
     *         refers to student object 
     * @param ind
     *           the index of the course 
     * @param c
     *         course object
     * @param courseType
     *                  gives the course type , lecture/tutorial/lab
     *                  
     */
	public void addToWaitlist(Student s, String ind, Course c, String courseType)
	{
		Index i=getIndexbyCourseIndex(ind);
		System.out.println(i.getCourseIndex());
		WaitList w=i.getWaitlist();
		ArrayList<Student> sList;
		if (w.getStudent()!=null) {
		sList=new ArrayList<Student>( Arrays.asList(w.getStudent()));
		} else {
		 sList=new ArrayList<Student>();
		}
		sList.add(s);
		Student[]sArr=new Student[100];
		sArr=(Student[]) sList.toArray(sArr);
		w.setStudent(sArr);
		w.setNum(w.getNum()+1);
		i.setWaitlist(w);
		Index k=i;
		ArrayList<Index> iList=getIndexbyCourseCode(c.getCourseCode());
		for (int j=0; j<iList.size(); j++)
		{
			if (iList.get(j).getCourseIndex().equals(ind))
			{
				iList.get(j).setWaitlist(w);
				
				
				break;
			}
		}
		
		CourseRegistration cReg=new CourseRegistration(c.getCourseCode(), s, ind, courseType, "WL");
		addRegCourse(cReg);
		Index[] Iarr=new Index[50];
		Iarr=(Index[])iList.toArray(Iarr);
		c.setIndexes(Iarr);
		updateCourse(c);
	}
	/**
     * method to remove a student from the waitlist
     * 
     * @param s
     *         the particular student object, to be removed from the waitlist
     * @param ind
     *           the index from which the student should be removed from the waitlist
     * @param c
     *          course object
     */
	public void removeFromWaitlist(Student s, String ind, Course c) {
		Index i=getIndexbyCourseIndex(ind);
		WaitList w=i.getWaitlist();
		ArrayList<Student> sList;
		if(w.getStudent()!=null) {
			sList=new ArrayList<Student>( Arrays.asList(w.getStudent()));
		}
		else return;
		for (int j=0; j<sList.size(); j++) {
			if (sList.get(j).getmatricNumber().equalsIgnoreCase(s.getmatricNumber()))
				{sList.remove(j);
				break;}
		}
		Student[]sArr=new Student[100];
		sArr=(Student[]) sList.toArray(sArr);
		w.setStudent(sArr);
		w.setNum(w.getNum()-1);
		i.setWaitlist(w);
		Index k=i;
		ArrayList<Index> iList=getIndexbyCourseCode(c.getCourseCode());
		
		for (int j=0; j<iList.size(); j++)
		{
			if (iList.get(j).getCourseIndex().equals(ind))
			{
				iList.get(j).setWaitlist(w);
				
				
				break;
			}
		}
		deleteRegCoursebyIndex(s,ind);
		Index[] Iarr=new Index[50];
		Iarr=(Index[])iList.toArray(Iarr);
		c.setIndexes(Iarr);
		updateCourse(c);
		
    }
    /**
     * method to get the access period for the course registratiomn system
     * 
     * @param SchoolCode
     *                  School code that uniquely identifies each school
     * @return returns the access period of the school
     */
	
	public accessperiod getAccessPeriodbySchool(String SchoolCode)
	{
		ArrayList<School> cList = (ArrayList<School>)readSchoolList();
		for (int i = 0 ; i < cList.size() ; i++) {
			School s = (School)cList.get(i);
			if (s.getSchoolInitial().equalsIgnoreCase(SchoolCode))
			{
				return s.getPeriod();
			}
		}
		return null;
    }
    /**
     * updates the access period for a particular school 
     * 
     * @param a
     *          refers to the accessperiod object which stores details 
     *          of the date and time of the access period for each school.
     * @param schoolCode
     *                   refers to the school code that uniquely indentifies 
     *                   each school.
     */
	
	public void updateAccessPeriodbySchool(accessperiod a, String schoolCode)
	{
		ArrayList<School> cList = (ArrayList<School>)readSchoolList();
		for (int i = 0 ; i < cList.size() ; i++) {
			School s = (School)cList.get(i);
			if (s.getSchoolInitial().equalsIgnoreCase(schoolCode))
			{
				s.setPeriod(a);
				cList.remove(i);
				cList.add(s);
				break;
			}
		}
		writeSchoolList(cList);
    }
    /**
     * method to get all students regisetered for a course 
     * 
     * @param Coursecode 
     *                  course code for a particular course
     * @return arraylist of student object registered for the particular
     *         course
     * 
     */
	
	public ArrayList<Student> getStudentListbyCourseCode(String CourseCode){
		ArrayList<CourseRegistration> cList = (ArrayList<CourseRegistration>)readRegCourselist();
		ArrayList<Student> s=new ArrayList<Student>();
		for (int i = 0 ; i < cList.size() ; i++) {
			CourseRegistration cReg=cList.get(i);
			if(cReg.getCourse().equalsIgnoreCase(CourseCode)&& cReg.getStatus().equalsIgnoreCase("Reg"))
				s.add(cReg.getStudent());
		}
		return s;
		
    }
    /**
     * method to get the courses that a student has registered in using 
     * matriculation number 
     * 
     * @param matric
     *              matriculation number which uniquely identifies each student.
     * @return array list of string objects of each course that the student has 
     *         enrolled in. 
     */
	
	public ArrayList<CourseRegistration> getCoursebyStudentMatric(String matric)
	{
		ArrayList<CourseRegistration> cList = (ArrayList<CourseRegistration>)readRegCourselist();
		ArrayList<CourseRegistration> c=new ArrayList<CourseRegistration>();
		
		for (int i = 0 ; i < cList.size() ; i++) {
			CourseRegistration cReg=cList.get(i);
			if(cReg.getStudent().getmatricNumber().equalsIgnoreCase(matric))
				c.add(cReg);
		}
		return c;
		
     }
     
     public ArrayList<Student> getStudentListbyIndex(String IndexNum){
          ArrayList<CourseRegistration> cList = (ArrayList<CourseRegistration>)readRegCourselist();
          ArrayList<Student> s=new ArrayList<Student>();
          for (int i = 0 ; i < cList.size() ; i++) {
               CourseRegistration cReg=cList.get(i);
               if(cReg.getIndex().equalsIgnoreCase(IndexNum)&& cReg.getStatus().equalsIgnoreCase("Reg"))
                    s.add(cReg.getStudent());
          }
          return s;
          
    }

    public School getSchoolbyInitial(String initial) {
     ArrayList<School> cList = (ArrayList<School>)readSchoolList();
         for (int i = 0 ; i < cList.size() ; i++) {
              School s = (School)cList.get(i);
              if (s.getSchoolInitial().equalsIgnoreCase(initial))
              {
                   return s;
              }
         }
         return null;
     
    }
    
    public void editVacancybyIndex(String ind, Course c, char type) {
    	Index i=getIndexbyCourseIndex(ind);
    	
    	if (type=='+')
    	{
    		i.setNumberOfStudent(i.getNumberOfStudent()-1);
    		i.setVacancy(i.getVacancy()+1);
    	}
    	else if (type=='-')
    	{
    		i.setNumberOfStudent(i.getNumberOfStudent()+1);
    		i.setVacancy(i.getVacancy()-1);
    	}
    	
    	
    	ArrayList<Index> iList=getIndexbyCourseCode(c.getCourseCode());
    	
    	for (int j=0; j<iList.size(); j++)
		{
			if (iList.get(j).getCourseIndex().equals(ind))
			{
				iList.get(j).setVacancy(i.getVacancy());
				iList.get(j).setNumberOfStudent(i.getNumberOfStudent());
				
				
				break;
			}
		}
		
		
		Index[] Iarr=new Index[50];
		Iarr=iList.toArray(Iarr);
		c.setIndexes(Iarr);
		updateCourse(c);
    }
	
    public ArrayList<LessonType> getLessonTypeByIndex(String ind)
    {
    	Index i=getIndexbyCourseIndex(ind);
    	try {
    	ArrayList<LessonType> lType=new ArrayList<LessonType>(Arrays.asList(i.getLessons()));
    	return lType;
    	}catch(Exception e) {}
    	return null;
    }
    
    public Student getFirstFromWLbyIndex(String ind) {
    	Index i=getIndexbyCourseIndex(ind);
    	
    	WaitList w=i.getWaitlist();
    	Student s;
    	if (w.getStudent()!=null)
    	{
    		s=w.getStudent()[0];
        	return s;
    	}
    	
    	return null;
    		
    }
    public CourseRegistration getStudentRegObj(Student s, String ind) {
    	ArrayList<CourseRegistration> cList = (ArrayList<CourseRegistration>)readRegCourselist();
    	for (int i = 0 ; i < cList.size() ; i++) {
            CourseRegistration cReg=cList.get(i);
            if(cReg.getIndex().equalsIgnoreCase(ind)&& cReg.getStudent().getmatricNumber().equalsIgnoreCase(s.getmatricNumber()))
                 return cReg;
       }
    	return null;
    	
    }
    
    public String getCourseCodebyIndex(String Index) {
    	ArrayList<Course> cList = (ArrayList<Course>)readCourseList();
		for (int i = 0 ; i < cList.size() ; i++) {
			Index[] ind = (Index[])cList.get(i).getIndexes();
			for (int j=0; j<ind.length; j++) {
				try {
			if (ind[j].getCourseIndex().equals(Index))
			{
				return cList.get(i).getCourseCode();
			}
				}catch(Exception e) {}
		}
		}
		return null;
    }
	
}