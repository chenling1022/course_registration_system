package Controller;
import java.util.*;
import Entity.*;
/**
 * Represents a controller which control the course registration process.
 * It consists of course related functions that will be called by the admin controller
 * @author 
 *
 */
public class courseController {

    Scanner sc = new Scanner(System.in);
    private Database_Controller Database_Controller = new Database_Controller();

    /**
     * add an index to the course that are already on the database.
     * @param coursecode
     *         coursecode is the unique code for each of the course 
     * @return newIndex 
     *          new index added to the database
     */
    public Index addIndex(String coursecode){
    
        Index newIndex = new Index();
        Course newcourse = new Course();
        WaitList newWaitList = new WaitList();
        int size = 0;
        int numberofstudent = 0;
        String str1;
        LessonType[] tempLessonType = new LessonType[10];
        
        ArrayList<Index> temp = new ArrayList<Index>();
	System.out.println("Add Index");
	System.out.println("---------------------");

        boolean check = true;
        
        do{
            System.out.println("Enter the course Index");

            newIndex.setCourseIndex(sc.next());

            temp = Database_Controller.getIndexbyCourseCode(coursecode);

            for(int i=0;i<temp.size();i++) {
            if(temp.contains(temp.get(i).getCourseIndex())){
                System.out.println("The course index already exist");
                
            }
            else{
                check = false;
            }

        }}while(check == true);

        newWaitList.setNum(0);
        newWaitList.setStudent(null);

        newIndex.setCourseIndex(coursecode);

        do{
            System.out.println("Enter the size of the particular index");
            size = sc.nextInt();
            newIndex.setSize(size);
        }while(size<=0);
        newIndex.setNumberOfStudent(size);
        newIndex.setVacancy(size);
        newIndex.setNumberOfStudent(0);
        newIndex.setWaitlist(newWaitList);
        
        System.out.println("enter the number of lesson types");
        int numberoflessontypes = sc.nextInt();
        
        for(int i=0;i<numberoflessontypes;i++) {
        	System.out.println("enter the class type");
        	String classType = sc.next();
        	System.out.println("enter the day of the week");
        	String dayOfWeek = sc.next();
        	System.out.println("enter the start time hhmm");
        	String starttime = sc.next();
        	System.out.println("enter the end time hhmm");
        	String endtime = sc.next();
        	System.out.println("enter the week");
        	String week = sc.next();
        	System.out.println("enter the venue");
        	String venue = sc.next();
        	
        	tempLessonType[i] = new LessonType(classType, dayOfWeek, starttime, endtime, week, venue);
        }

        newIndex.setLessons(tempLessonType);
        System.out.println("enter the group code");
        String group = sc.next();
        newIndex.setGroup(group);
        
        return newIndex;
	}
    
    
    
    /**
     * check the existence of an index
     * @param indexID 
     *              unique id to identify the index 
     * @return
     */
    
	public boolean indexExistsOrNot(String indexID){
		// get list of schools from database controller class // 
		if(Database_Controller.getIndexbyCourseIndex(indexID)!=null){
			return true;
		}
		else{
			return false;
	}
	}
	




		

	/**
	 *  check existence of a course in the school // 
	 * @param Coursecode
	 *               course code of the course 
	 * @return
	 */
	public boolean courseExistsOrNot(String Coursecode){
		if(Database_Controller.getCoursebyCourseCode(Coursecode)!=null){
			return true;
		}
		else{
			return false;
		}
	}


	/**
	 * method to edit the course name, code, index ID or remove an index 
	 */
    public void updateCourse(){
	        System.out.println("Update Course");
		System.out.println("---------------------");
		System.out.println("Course code of the course that needs to be updated : ");
		String courseCode = sc.nextLine().toUpperCase();

		if(courseExistsOrNot(courseCode)== true){
			Course course = Database_Controller.getCoursebyCourseCode(courseCode);
			System.out.println("Please Enter what to edit:");
			System.out.println("1. Course name");
			System.out.println("2. Course code");
		
			System.out.println("3. Add an IndexID");
			System.out.println("4. Remove an IndexID");
			System.out.println("5. Cancel");
			int choice = sc.nextInt();
			switch(choice){ 
			case 1: 
				System.out.println("Please enter new course name:");
				String newcoursename = sc.nextLine();
				course.setCourseName(newcoursename); 
				System.out.println("Course name updated!");
				break;
			case 2:
				System.out.println("Please enter new course code:");
				String newcoursecode= sc.nextLine().toUpperCase();
				course.setCourseCode(newcoursecode);
				System.out.println("Course code updated!");
				break;
			case 3: 
				System.out.println("Please add index number: ");
				String newindex = sc.next();
				if(!indexExistsOrNot(newindex)){
					ArrayList<Index> indexList=Database_Controller.getIndexbyCourseCode(course.getCourseCode());
					Index newIndex=addIndex(course.getCourseCode());
					indexList.add(newIndex);
					Index []iArr=new Index[30];
					iArr=(Index[])indexList.toArray(iArr);
					course.setIndexes(iArr);
					System.out.println("Course index added!");
					break;
				}
				else{
					System.out.println("IndexID already exists.");
					break;
				}
			case 4: 
				System.out.println("Please enter index number: ");
				String removeindex = sc.nextLine();
				if(indexExistsOrNot(removeindex)==true){
					ArrayList<Index> indexList=Database_Controller.getIndexbyCourseCode(course.getCourseCode());
					for(int i=0;i<indexList.size();i++) {
						if(indexList.get(i).getCourseIndex().equals(removeindex)) {
							indexList.remove(i);
							course.setIndexes((Index[])indexList.toArray());
							System.out.println("Course index removed!");
							break;
						}
					}
					break;
				}
				else{
					System.out.println("IndexID does not exist.");
					break;
				}
			default:
				break;
				


			}
			Database_Controller.updateCourse(course);
		}
		else{
			System.out.println("Course not found.");
		}

	}

    /**
     * method to remove a particular course from the database.
     */
	public void removeCourse(){
		System.out.println("Remove Course");
		System.out.println("---------------------");
		System.out.println("Course code of the course that needs to be removed: ");
		String courseCode = sc.nextLine().toUpperCase();
		if (courseExistsOrNot(courseCode) == false){
			System.out.println("The course does not exist!");
		}
		else{
			Database_Controller.deleteCourse(courseCode);
			
			System.out.println("Course removed");

		}

    }
    /**
     * method used to add a course to the database
     */
    public void addCourse() {
		System.out.println("Add Course");
		System.out.println("---------------------");
		System.out.println("Course code: ");
		String courseCode = sc.nextLine().toUpperCase();
		
		if (courseExistsOrNot(courseCode)== true){
			System.out.println("Course already exists! ");
			return;
		}
		else{
			Course newcourse = new Course();
			newcourse.setCourseCode(courseCode);
			System.out.println("Course name:");
			String courseName = sc.nextLine();
			newcourse.setCourseName(courseName);
			System.out.println("AU of the course:");
			int au = sc.nextInt();
			newcourse.setAu(au);
			
			System.out.println("School of the course:");
			String school = sc.next();
			newcourse.setschoolName(school);
			newcourse.setIndexes(new Index[30]);
			Database_Controller.addCourse(newcourse);
		}	
	}
    /**
     * print all courses 
     */
	public void printAllCourses(){
		System.out.println("Print All Courses");
		System.out.println("---------------------");
		System.out.println("All available course:");
		ArrayList<Course> courses = new ArrayList<Course>();
		courses = Database_Controller.readCourseList();
		for (int i=0;i<courses.size();i++){
			System.out.println(courses.get(i).getCourseCode()+"\t"+courses.get(i).getCourseName());
		}
	}
		/**
		 * method print all the course in the database irrespective of the school that it is offered in.
		 * @param courseCode
		 */
		public void printIndexForCourse(String courseCode){
			System.out.println("Print All Courses");
			System.out.println("---------------------");
			System.out.println("All available course:");
			ArrayList<Index> indexes = new ArrayList<Index>();
			indexes = Database_Controller.getIndexbyCourseCode(courseCode);
			try{
			for (int i=0;i<indexes.size();i++){
				System.out.println(indexes.get(i).getCourseIndex()+"\t"+indexes.get(i).getGroup());
			}
			}catch(Exception e) {
			}
			
	}
}