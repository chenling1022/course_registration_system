package Boundary;
import Controller.*;
import Entity.*;
import java.util.*;

/**
 * 
 * A boundary class for displaying student options. It implements Menu. 
 * 
 * @author
 */

public class studentMenu implements menu{
	/** 
	 * 
	 * Choice selected by the user.
	 * 
	*/

	private static int userChoice ;
	
	/**
	 * 
	 *  method to display student options. 
	 * 
	 * @param user 
	 *            user who called this method. 
	*/
	static StudentController studentController;

    public static void display(Student student){
    	do {
    	studentController=new StudentController(student);
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add a Course.");
		System.out.println("2. Drop a Course.");
		System.out.println("3. Print/check your Registered Courses.");
		System.out.println("4. Check for Available Vacancies.");
		System.out.println("5. Change the Index Number of a Course.");
		System.out.println("6. Swop Index with Another Student.");
		System.out.println("7. Check for Details of a particular Index");
        System.out.println("8. Exit.");
        userChoice = sc.nextInt();
		
		switch(userChoice)
		{
		
		case 1: studentController.addCourse();
		break;
		case 2: studentController.dropCourse();
		break;
		case 3: studentController.printSchedule();
		break;
		case 4: studentController.vacancy();
		break;
		case 5: studentController.changeIndex();
		break;
		case 6: studentController.swapIndex();
		break;
		case 7: studentController.viewIndexDetails();
		break;
		case 8: break;
		default: System.out.println("Invalid");
		}
		
	}while(userChoice!=8);
    }
		
    
}