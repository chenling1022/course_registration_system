package Controller;
import Entity.*;
import java.util.*;
import Boundary.StarsApp;

/**
 * 
 * represents a controller which will be used by a student. It 
 * contains funcions which student can fo on Stars. 
 * 
 * @author
 */
public class StudentController {
	
	Scanner sc = new Scanner(System.in);
	Student CurrentUser;
	Database_Controller db=new Database_Controller();
	courseController cs= new courseController();
	public StudentController(Student S)
	{
		CurrentUser = S;
	}
	/**
	 * 
	 * a method for the student to add course.
	 */
	public void addCourse()
	{
		System.out.println("Add a Course ");
		System.out.println("---------------------");
		String add;
		Index courseIndexObj = new Index();
		System.out.println("The following indexes are available:");
		cs.printAllCourses();
		System.out.println("Enter the course code: ");
		String courseCode = sc.next();
		System.out.println("The following indexes are available:");
		cs.printIndexForCourse(courseCode);
		System.out.println("Enter the Index number of the course that you would like to add:");
		add= sc.next();
		ArrayList<CourseRegistration> CourseList;
		CourseList = db.getCoursebyStudentMatric(CurrentUser.getmatricNumber());
		if (CourseList!=null) {
		for (int j = 0; j < CourseList.size(); j++) {
		if ((CourseList.get(j).getCourse().equals(courseCode))) {
			System.out.println(
								"Error. You have already registered for the course.");
						System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				return;		
			}
		}
		}
		
		Index IObj=db.getIndexbyCourseIndex(add);
		if (IObj == null || db.getCourseCodebyIndex(add).equals(courseCode)==false) {
			System.out.println("Error. Please Enter correct Index.\n");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			return;
		}
		else
		{	
			Course CObj = db.getCoursebyCourseCode(courseCode);
			
			
			CourseList = db.getCoursebyStudentMatric(CurrentUser.getmatricNumber());
			if (CourseList!=null) {
			for (int j = 0; j < CourseList.size(); j++) {
			if ((CourseList.get(j).getIndex().equals(add))) {
				System.out.println(
									"Error. You have already registered for the course.");
							System.out.println("------------------------------------------------------------------------------------------------------------------------------");
					return;		
				}
			}
			}
			
			//checks if the time clashes for the new course to be added
				boolean isclash = false;
				if (CourseList != null) {
					if (CourseList.size() != 0) {
						for (int i = 0; i < CourseList.size(); i++) {
							String temp = CourseList.get(i).getIndex();
							isclash = isTimeClashBIndexes(temp, add);
							if (isclash) {
								System.out.println("You can't add this course index because of day/time clash.");
								System.out.println("------------------------------------------------------------------------------------------------------------------------------");
								return;
							}
						}
					}
	
				}
				String courseType="";
			System.out.println("Select appropriate course type for " + add);
			
				System.out.println(
						"1. Core\n" + "2. Prescribed\n" + "3. Unrestricted\n" + "4. Cancel and return to main menu");
				int choice;
				do {
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						courseType = "Core";
						break;
					case 2:
						courseType = "Prescribed";
						break;
					case 3:
						courseType = "Unrestricted";
						break;
					case 4:
						return;
					default:
						System.out.println("Please enter a valid choice");
						break;
					}
				} while (choice < 0 || choice > 4);
					if(IObj.getVacancy()==0)
				{
					/*WaitList WObj = new WaitList();
					WObj=IObj.getWAitlist();
					WObj.setNum(WObj.getNum()+1);*/
					System.out.println("Class is full, added to waiting list.");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
					db.addToWaitlist(CurrentUser, add, CObj, courseType);
					return;
				}
					else {
						CourseRegistration cReg=new CourseRegistration(CObj.getCourseCode(),CurrentUser, add, courseType, "Reg");
						db.addRegCourse(cReg);
					}
				db.editVacancybyIndex(add,CObj, '-');
	
				System.out.println("Registered successfully!");
				NotificationController.SendEmail(CurrentUser.getemail(), CObj.getCourseCode(), add);
				NotificationController.sendSMS(CurrentUser.getmobileNumber());
				System.out.println("Course Name: " + CObj.getCourseName());
				System.out.println("Course Type: " + courseType);
				System.out.println("Index number: " + add);

		}
	}
		
/**
 * 
 * a method for the student to drop the course from his list of registered
 * courses. 
 * 
 * @param accountId
 *                 accountID is the matriculation number of the user. 
 */
	public void dropCourse()
	{
		ArrayList<CourseRegistration> studentCourseList;
		studentCourseList = db.getCoursebyStudentMatric(CurrentUser.getmatricNumber());
		int choice;
		Scanner sc = new Scanner(System.in);
		if (studentCourseList==null)
		{
			System.out.println("You have no course Registered");
			return;
		}
		if (studentCourseList.size() != 0) {
			do {
				printSchedule();
				System.out.println("Enter " + (studentCourseList.size() + 1) + " to cancel and return to main menu");
				choice = sc.nextInt();
				if (choice <= 0 || choice > studentCourseList.size() + 1) {
					System.out.println("Please enter a valid choice or press " + (studentCourseList.size() + 1) + " to exit.");if (choice == studentCourseList.size() + 1) {
					
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
					return;
				}
				}
			} while (choice <= 0 || choice > (studentCourseList.size() + 1));
			if (choice==(studentCourseList.size() + 1))
				return;

			if (studentCourseList.get(choice - 1).getStatus().equalsIgnoreCase("Reg")) {
				
				db.deleteRegCoursebyIndex(CurrentUser, studentCourseList.get(choice - 1).getIndex());
				db.editVacancybyIndex(studentCourseList.get(choice - 1).getIndex(), db.getCoursebyCourseCode(studentCourseList.get(choice - 1).getCourse()), '+');
				System.out.println("Successfully dropped index" + studentCourseList.get(choice - 1).getIndex() + ".");
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------");
				Student nextUser = db.getFirstFromWLbyIndex(studentCourseList.get(choice - 1).getIndex());
				if (nextUser != null) {
					CourseRegistration cReg=new CourseRegistration(studentCourseList.get(choice - 1).getCourse(), nextUser, studentCourseList.get(choice - 1).getIndex(), db.getStudentRegObj(nextUser,studentCourseList.get(choice - 1).getIndex()).getCourseType(),"Reg");
					db.editVacancybyIndex(studentCourseList.get(choice - 1).getIndex(), db.getCoursebyCourseCode(studentCourseList.get(choice - 1).getCourse()),'-');
					NotificationController.SendEmail(nextUser.getemail(), studentCourseList.get(choice - 1).getCourse(), studentCourseList.get(choice - 1).getIndex());
					}
				}
			else {
				db.removeFromWaitlist(CurrentUser, studentCourseList.get(choice - 1).getIndex(), db.getCoursebyCourseCode(studentCourseList.get(choice - 1).getCourse()));
				System.out.println("Successfully removed " + studentCourseList.get(choice - 1).getCourse() + " from waiting list.");
				System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			}
		} else
			System.out.println("You currently got no course registered under your account.");

	}
		/**
		 * 
		 * print all the registered courses for a particular student.
		 */
	
	public void printSchedule()
	{
		System.out.println("Print/check your Registered Courses ");
		System.out.println("---------------------");
		System.out.println("you have registered the following courses:");
		
		ArrayList<CourseRegistration> studentCourseList=db.getCoursebyStudentMatric(CurrentUser.getmatricNumber());
		int aucount=0;
		if(studentCourseList==null||studentCourseList.size()==0)
		{
			System.out.println("You currently got no course registered under your account.");
			return;
		}
		System.out.println(
				"+--------------------------------------------------------------------------------------------------------+");
		System.out.format("|%-7s|%-30s|%-7s|%-7s|%-15s|%-7s|%n", "Course", "Course Name", "AU", "Index",
				"Course Type", "Status");
		System.out.println(
				"+--------------------------------------------------------------------------------------------------------+");
		if(studentCourseList==null||studentCourseList.size()==0)
		{
			System.out.println("You currently got no course registered under your account.");
			return;
		}
		for(int i=0;i<studentCourseList.size();i++)
		{
						
			System.out.println(studentCourseList.get(i).getCourse()+"\t"+db.getCoursebyCourseCode(studentCourseList.get(i).getCourse()).getCourseName()+"\t"+db.getCoursebyCourseCode(studentCourseList.get(i).getCourse()).getAu()+"\t"+studentCourseList.get(i).getIndex()+"\t"+"\t"+studentCourseList.get(i).getCourseType()+"\t"+studentCourseList.get(i).getStatus());
			if (studentCourseList.get(i).getStatus().equals("Reg"))
							aucount += db.getCoursebyCourseCode(studentCourseList.get(i).getCourse()).getAu();
			
				
		} 
		System.out.println("+--------------------------------------------------------------------------------------------------------+");
		System.out.println("Total AU registered: " + aucount);
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------");


		
		
	}
	/** 
	 * method to get the vacancy of a particular course.
	 * 
	 */
	public void viewIndexDetails()
	{
		System.out.println("Check for Index Details");
		System.out.println("---------------------");
		int count;//counts the total number of vacancies available
		System.out.println("Enter Index to check details");
		String indexNo = sc.next();
		Index indexdetails=db.getIndexbyCourseIndex(indexNo);
		
		if (indexdetails!=null) {
			System.out.println("Course Index: "+indexdetails.getCourseIndex()+"\t"+"Group: "+indexdetails.getGroup());
			System.out.println("Size: "+indexdetails.getSize()+"\t"+" Vacancy: "+indexdetails.getVacancy());
			
			System.out.println("+--------------------------------------------------+");
			System.out.format("|%-11s|%-4s|%-10s|%-7s|%-8s|%-5s|%n", "Type", "Day", "Time", "Venue", "Week"
					);
			System.out.println("+--------------------------------------------------+");
			for (int i = 0; i < indexdetails.getLessons().length; i++) {
				System.out.format("|%-11s|%-4s|%-4s-%-5s|%-7s|%-8s|%-5s|%n", indexdetails.getLessons()[i].getClassType(),
						indexdetails.getLessons()[i].getDay(), indexdetails.getLessons()[i].getStarttime(),
						indexdetails.getLessons()[i].getEndtime(), indexdetails.getLessons()[i].getVenue(),
						indexdetails.getLessons()[i].getWeek());
			}
	}
	}
	public void vacancy() throws NullPointerException
	{
		System.out.println("Check for Available Vacancies");
		System.out.println("---------------------");
		int count;//counts the total number of vacancies available
		System.out.println("Enter course code");
		String CourseCode = sc.next();
		Course C = db.getCoursebyCourseCode(CourseCode);
		ArrayList<Index> IndexList= db.getIndexbyCourseCode(CourseCode); 
		if (C == null) {
			System.out.println("Invalid course.\nReturning to main menu...");
			return;
		} else {
		if (IndexList != null) {try {
			for(int i=0; i<IndexList.size(); i++)
			{
			System.out.println(
					"(Size/Vacancy/Waitlist) for " + IndexList.get(i).getCourseIndex() + ": " + IndexList.get(i).getSize()+"/"+IndexList.get(i).getVacancy()+"/"+IndexList.get(i).getWaitlist().getNum());
			
			
		}
				
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------");
		}catch(Exception e) {
			
		}
		}
			}
			
		}
		
	
	/** 
	 * method to change the index of a course that the student is 
	 * registered in. 
	 * 
	 * @param accountid
	 *                 accountid is the matriculation number of 
	 *                 the student.
	 */
		public void changeIndex()
		{
			System.out.println("Change the Index Number of a Course");
			System.out.println("---------------------");
			ArrayList<CourseRegistration> studentCourseList;

			studentCourseList = db.getCoursebyStudentMatric(CurrentUser.getmatricNumber());
			sc = new Scanner(System.in);
			System.out.println("Enter your current index number and the index you want to change it to");
			String current=sc.next();
			String next=sc.next();
			boolean registered=false;
			Index oldIndexObj = new Index();
			String CourseCode="";
			boolean indexflag=false;
			oldIndexObj = db.getIndexbyCourseIndex(current);
			if (oldIndexObj == null) {
			System.out.println("Error. Course index does not exist.");
			return;
			
		}
			for (int i = 0; i < studentCourseList.size(); i++) {
			if ((studentCourseList.get(i).getIndex().equals(current)) && studentCourseList.get(i).getStatus().equalsIgnoreCase("Reg"))
				{
				registered = true;
				CourseCode=studentCourseList.get(i).getCourse();
				ArrayList<Index> iList=db.getIndexbyCourseCode(CourseCode);
				for(int j=0; j<iList.size(); j++) {
					if (iList.get(j).equals(next)) {
						indexflag=true;
						break;
					}
				}
				}
			}
			if (registered == false) {
			System.out.println("Error. You are not registerd for this index.");
			return;
		}
			Index newIndexObj = new Index();
			newIndexObj = db.getIndexbyCourseIndex(next);
			if (newIndexObj == null) {
				System.out.println("Error. Course index does not exist.");
				return;
			} else if (newIndexObj.getVacancy()==0) {
				System.out.println("Error. Course index is full.");
				return;
			} else if (!db.getCourseCodebyIndex(current).equalsIgnoreCase(db.getCourseCodebyIndex(next))) {
				System.out.println("Error. Different course code between the two indexes.");
				return;
			} else if (current.equals(next)) {
				System.out.println("Error. Entered the same index.\nReturning to main menu...");
				return;
			}
                boolean isclash = false;
		if (studentCourseList != null) {
			if (studentCourseList.size() != 0) {
				for (int i = 0; i < studentCourseList.size(); i++) {
					String tempindex = studentCourseList.get(i).getIndex();
					if (!tempindex.equals(current)) {
						isclash = isTimeClashBIndexes(tempindex, next);
						if (isclash) {
							System.out.println("You can't change to this course index because of day/time clash with the new index.");
							return;
						}
					}
				}
			}
		}
		CourseRegistration cReg= db.getStudentRegObj(CurrentUser, current);
		db.deleteRegCoursebyIndex(CurrentUser, current);
		db.editVacancybyIndex(current, db.getCoursebyCourseCode(CourseCode), '+');
		CourseRegistration cRegNew= new CourseRegistration(cReg.getCourse(), CurrentUser, next, cReg.getCourseType(), "Reg");
		db.addRegCourse(cRegNew);
		db.editVacancybyIndex(next,db.getCoursebyCourseCode(CourseCode), '-');
		System.out.println("Index " + current + " has been changed to " + next + " successfully!!");
		NotificationController.SendEmail(CurrentUser.getemail(), CourseCode, next);	
}
		
		/**
		 * 
		 * ,method to swap the index of a course that the particular student 
		 * is registered in, with another index of the same course that
		 * another student is registered in. 
		 * 
		 * @param accouuntId
		 *                  accountId is the matriculation number of 
		 *                  student. 
		 */
	public  void swapIndex()
	{
		String currentUserIndex, otherUserIndex;
		Student newStudent;
		boolean registered = false, otherRegistered = false;
		ArrayList<CourseRegistration> studentCourseList;
		studentCourseList = db.getCoursebyStudentMatric(CurrentUser.getmatricNumber());
		System.out.println("Swap Index with Another Student");
			System.out.println("---------------------");
		System.out.println("Current user Matric Number: " + CurrentUser.getmatricNumber());
		System.out.println("Enter your course index number: ");
		currentUserIndex = sc.next();
		Index currentUserIndexObj = new Index();
		currentUserIndexObj = db.getIndexbyCourseIndex(currentUserIndex);
		for (int i = 0; i < studentCourseList.size(); i++) {
			if ((studentCourseList.get(i).getIndex().equals(currentUserIndex))
					&& studentCourseList.get(i).getStatus().equals("Reg"))
				registered = true;
		}
		if (currentUserIndexObj == null) {
			System.out.println("Error. Course index does not exist.");
			return;
		} else if (registered == false) {
			System.out.println("Error. You are not registerd for this index.");
			return;
		}
		System.out.println("Please login to the other student to verify");
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		newStudent = db.getStudentByUsername(username);
		if (db.validateStudent(newStudent, StarsApp.generateHashedPassword(password))==false) {
			System.out.println("Unable to verify student.");
			return;
		} else {
			
			if (newStudent.getmatricNumber().equals(CurrentUser.getmatricNumber())) {
				System.out.println("Sorry, you cannot swap index with yourself.");
				return;
			}
			ArrayList<CourseRegistration> otherStudentCourseList;
			otherStudentCourseList = db.getCoursebyStudentMatric(newStudent.getmatricNumber());
			System.out.println("Enter the index you want to change to:");
			String Index2=sc.next();
			Index otherUserIndexObj = new Index();
			otherUserIndexObj = db.getIndexbyCourseIndex(Index2);
			
			for (int i = 0; i < otherStudentCourseList.size(); i++) {
				if ((otherStudentCourseList.get(i).getIndex().equals(Index2))
						&& otherStudentCourseList.get(i).getStatus().equals("Reg"))
					otherRegistered = true;
			}
			if (otherUserIndexObj == null) {
				System.out.println("Error. Course index does not exist.");
				return;
			} else if (otherRegistered == false) {
				System.out.println("Error. Second student is not registered for this index.");
				return;
			} else if (!db.getCourseCodebyIndex(currentUserIndexObj.getCourseIndex()).equals(db.getCourseCodebyIndex(otherUserIndexObj.getCourseIndex()))) {
				System.out.println("Error. Different course code between the two indexes.");
				return;
			}
		        boolean isclash = false;
			if (studentCourseList != null) {
				if (studentCourseList.size() != 0) {
					for (int i = 0; i < studentCourseList.size(); i++) {
						String tempindex = studentCourseList.get(i).getIndex();
						if (!tempindex.equals(currentUserIndex)) {
							isclash = isTimeClashBIndexes(tempindex, Index2);
							if (isclash) {
								System.out.println("You can't change to this course index because of day/time clash with the index from other student.");
								return;
							}
						}
					}
				}
			}
			if (otherStudentCourseList != null) {
				if (otherStudentCourseList.size() != 0) {
					for (int i = 0; i < otherStudentCourseList.size(); i++) {
						String tempindex = otherStudentCourseList.get(i).getIndex();
						if (!tempindex.equals(Index2)) {
							isclash = isTimeClashBIndexes(tempindex, currentUserIndex);
							if (isclash) {
								System.out.println("You can't change to this course index because the other student has a day/time clash with your index.");
								return;
							}
						}
					}
				}
			}
		
			CourseRegistration cReg1=db.getStudentRegObj(CurrentUser, currentUserIndexObj.getCourseIndex());
			CourseRegistration cReg2=db.getStudentRegObj(newStudent, otherUserIndexObj.getCourseIndex());
			db.deleteRegCoursebyIndex(CurrentUser, currentUserIndexObj.getCourseIndex());
			
			
			db.deleteRegCoursebyIndex(newStudent, otherUserIndexObj.getCourseIndex());
			
			CourseRegistration newCur=new CourseRegistration(cReg1.getCourse(), CurrentUser, Index2, cReg1.getCourseType(), "Reg");
			db.addRegCourse(newCur);
			CourseRegistration newOther=new CourseRegistration(cReg2.getCourse(), newStudent, currentUserIndexObj.getCourseIndex(), cReg2.getCourseType(), "Reg");
			db.addRegCourse(newOther);
			System.out.println("Index swapped successfully!");	
			NotificationController.SendEmail(CurrentUser.getemail(), cReg1.getCourse(), Index2);
			NotificationController.SendEmail(newStudent.getemail(), cReg1.getCourse(), cReg1.getIndex());
			
		
		
		
		}
	}
	/**
	 * 
	 * method to check if there is a time clash between different indexes. 
	 * 
	 * @param oldindex , newindex
	 *                           oldindex refers to the index which has the time clash
	 *                           and the newindex refers to the the index that has been 
	 *                           changed to avoid tine clash.
	 *                        
	 *                       
	 */
public boolean isTimeClashBIndexes(String oldindex, String newindex) {
		boolean isClash = false;
		ArrayList<LessonType> list = db.getLessonTypeByIndex(oldindex);
		ArrayList<LessonType> newlist = db.getLessonTypeByIndex(newindex);
		if (list != null & newlist != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).isTimeClashBLesson(newlist))
					return true;
			}
		}
		if (isClash)
			return true;
		else
			return false;
	}
	


/**
 *
 *method to update the password of the student account. 
 */
public static void UpdateStudentPassword() {
	}

					   
	
}