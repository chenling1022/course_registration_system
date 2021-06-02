package Controller;
import Entity.*;
import java.util.*;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * represents a controller which will be used by an administrator.
 * It contains functions which admin can do on MyStars
 * @author 
 *
 */
public class AdminController{
	
	Admin CurrentUser;
	Scanner sc = new Scanner(System.in);
	StudentController studentController = new StudentController(null);
	courseController courseController = new courseController();
	
	public AdminController(Admin a){
		CurrentUser=a;
	}
	/**
	 * Creates an instance of Database_Controller
	 */
	Database_Controller Database_Controller = new Database_Controller();
	School school = new School();
	



	/**
	 * edit the access period for each school. 
	 */
	public void editAccessPeriod() {
		System.out.println("Edit Student Access Period");
		System.out.println("---------------------");
		System.out.println("Enter the school of the access period:");
		String schoolid=sc.nextLine();
		school = Database_Controller.getSchoolbyInitial(schoolid);
		if(school!=null){
			if(school.getPeriod()!=null){
				System.out.println("The current Start Date is :"+school.getPeriod().getstartDate());
				System.out.println("The current End Date is :"+school.getPeriod().getendDate());


			}
			else{
				System.out.println("The current start and end date is: Not Set.");
			}
			if(school.getPeriod()!=null){
			
			System.out.println("Please enter start date(year):");
			int sdy= sc.nextInt();
			System.out.println("Please enter start date(month):");
			int sdm= sc.nextInt();
			System.out.println("Please enter start date(date):");
			int sdd= sc.nextInt();
			
			System.out.println("Please enter end date(year):");
			int edy= sc.nextInt();
			System.out.println("Please enter end date(month):");
			int edm= sc.nextInt();
			System.out.println("Please enter end date(date):");
			int edd= sc.nextInt();

			Date sd = new Date(sdy-1900,sdm-1,sdd,10,00,00);
			Date ed= new Date(edy-1900,edm-1,edd,22,00,00);
			accessperiod period=new accessperiod(sd,ed);
			
			Database_Controller.updateAccessPeriodbySchool(period,school.getSchoolInitial());
			System.out.println("The updated Start Date is :"+period.getstartDate());
			System.out.println("The update End Date is :"+period.getendDate());
			
		}
		else{
			System.out.println("School not found! ");

		}
		}
  }	
	/**
	 * add a student to the database
	 */
	public void addStudent() {
		
		System.out.println("Add a Student");
		System.out.println("---------------------");
		// check for whether student exists or not // 
		System.out.println("Enter the matriculation number of the student:");
		String matricNumber = sc.next();
		if( Database_Controller.getStudentByMatric(matricNumber)!=null){
			System.out.println("Student already exists!");
			return;
		}

		
		else{
          System.out.println("First name of student: ");
          String firstName = sc.next();
          System.out.println("Last name of student:");
          String lastName = sc.next();
          System.out.println("Gender of student:");
          String gender= sc.next();
			System.out.println("Nationality of student:");
			String nationality = sc.next();
			System.out.println("Study year of student:");
          int study_year = sc.nextInt();
          System.out.println("School of student:");
			String school = sc.next();
			System.out.println("Program of student:");
			String program = sc.next();
			System.out.println("Specialization of student:");
			String specialization = sc.next();
			System.out.println("Email of student:");
			String email = sc.next();
			System.out.println("Mobile number of student:");
			String mobileNumber = sc.next();
			System.out.println("Username of the student:");
			String username = sc.next();
			System.out.println("Password of the student:");
			String password= sc.next();
			Student newstudent = new Student(firstName,lastName,matricNumber,gender,nationality, study_year,school, program, specialization, email, mobileNumber,username,password);
			Database_Controller.addStudent(newstudent);

		}	
		printStudentDetails();
	}
	
	
	/**
	 * delete the student from the database 
	 */
	public void deleteStudent(){
		System.out.println("Remove a Student");
		System.out.println("---------------------");
		// find if the student is in the database or not // 
		System.out.println("Enter the matriculation number of the student:");
		String matricNumber = sc.nextLine();
		if( Database_Controller.getStudentByMatric(matricNumber)==null){
			System.out.println("Student does not exist!");

		}
		else{
			Database_Controller.deleteStudent(matricNumber);// remove the student from the database 
			System.out.println("Student removed!");

		}
	}
	/**
	 * update/add/delete a course to the database
	 */
	public void addUpdateCourseAdmin(){
		System.out.println("Add/Update/Delete a Course");
		System.out.println("---------------------");
		int choice=0;
		do{
			System.out.println("\nWhat do you wish to do:");
			System.out.println("1. Print All Courses\n" + "2. Add Course\n" + "3. Update Existing Course\n"
					+ "4. Delete Course\n"+"5.Cancel");
			
			while(!sc.hasNextInt()){
				sc.next();
				System.out.println("Please enter valid option:");
				
			}
			choice = sc.nextInt();
			switch(choice){
				case 1: 
					courseController.printAllCourses();
					break;
				case 2:
					courseController.addCourse();
					break;
				case 3:
					courseController.updateCourse();
					break;
				case 4: 
					courseController.removeCourse();
					break;
				
				default: 
					System.out.println("Please enter a valid choice number.");
					break;
			}
		}while(choice<5 );
	}


	
	/**
	 * check the vacancy of a course according to matric number
	 */
	public void checkVacancy() {
		
		studentController.vacancy();
		
	}
	/**
	 * prints the list of students with their names and matric number.
	 */
	public void printStudentDetails() {
		ArrayList<Student>students = new ArrayList<Student>();
		students=Database_Controller.readStudentList();
		if (students!=null) {
			System.out.println("Student Name"+"\t"+" Student matric");
			for(int i=0; i<students.size(); i++) {
				System.out.println(students.get(i).getFirstName()+" "+students.get(i).getLastName()+"\t"+students.get(i).getmatricNumber());
				
			}
		}
	}


	/**
	 *  print all students who are enrolled to one particular index
	 */
	public void printStudentListByIndex() {
		System.out.println("Show Student List by Index Number");
		System.out.println("---------------------");
		System.out.println("Enter index you wish to print student list:");
		String index= sc.nextLine();
		ArrayList<Student>students = new ArrayList<Student>();
		students = Database_Controller.getStudentListbyIndex(index);
		if (students.size()!= 0){
			System.out.println("\nIndex:"+ index);
			for(int i=0;i<students.size();i++){
				System.out.println("Name:" + students.get(i).getFirstName()+ students.get(i).getLastName());
				System.out.println("Gender:" + students.get(i).getGender());
				System.out.println("Nationality:"+ students.get(i).getnationality());
			}
		}
		else{
			System.out.println(index+"does not have any students.");
		}
	}
	
	/**
	 *  print all students who are enrolled to one particular course
	 */
	public void printStudentListByCourse() {
		System.out.println("Show Student List by Course");
		System.out.println("---------------------");
		Course course_temp = new Course();
		System.out.println("Enter course code of the course that you wish to print student list:");
		String courseCode=sc.nextLine().toUpperCase();
		course_temp = Database_Controller.getCoursebyCourseCode(courseCode);
		if(course_temp!=null){
			ArrayList<Index> index_temp = new ArrayList<Index>();
			index_temp = Database_Controller.getIndexbyCourseCode(courseCode);
			if(index_temp.size()!=0){
				for(int i=0; i<index_temp.size();i++){
					ArrayList<Student>students = new ArrayList<Student>();
					try {
					students = Database_Controller.getStudentListbyIndex(index_temp.get(i).getCourseIndex());
					System.out.println("\nIndex : "+ index_temp.get(i).getCourseIndex());
					if (students.size()!=0){
						for(int j=0; j<students.size();j++){
							System.out.println("Name:" + students.get(j).getFirstName()+ students.get(j).getLastName());
							System.out.println("Gender:" + students.get(j).getGender());
							System.out.println("Nationality:"+ students.get(j).getnationality());
						}
					}
					else{
						System.out.println(index_temp.get(i).getCourseIndex()+"does not have any students.");
				}}catch(Exception e) {}
			}
			}
			else{
				System.out.println("Error. There is no course index under this course (" + courseCode + ").\n");
			}
		}
		else{
			System.out.println("Error. Course (" + courseCode + ") does not exist.\n");
			
		}
						   
			
		
		
	}
	
}