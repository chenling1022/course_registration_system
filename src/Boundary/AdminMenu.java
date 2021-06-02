package Boundary;

import java.util.*;
import Controller.AdminController;
import Entity.*;
/**  
 * Boundary class for disaplying administrator options. It implements menu. 
 * 
 * @author
 * 
*/

public class AdminMenu implements menu {
    /** 
     * Choice selected by the user
     */
    private static int userChoice;
    /** 
     * 
     * A method to display the admin functions.
     * 
     * */
    private static AdminController AdminController;
    public static void display(Admin Admin){
    	AdminController = new AdminController(Admin);
    	do {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice");
		System.out.println("1. Edit Student Access Period");
		System.out.println("2. Add a Student");
		System.out.println("3. Remove a Student");
		System.out.println("4. Add/update/delete a Course");
		System.out.println("5. Check for Available Vacancies");
		System.out.println("6. Show Student List by Index Number");
		System.out.println("7. Show Student List by Course");
		System.out.println("8. Print All Students");
        System.out.println("9. Logout");
        userChoice= sc.nextInt();
        switch(userChoice)
		{
		
        case 1: 
        
        AdminController.editAccessPeriod();
		break;
		case 2: AdminController.addStudent();
		break;
        case 3: 
        
        AdminController.deleteStudent();
		break;
		case 4: AdminController.addUpdateCourseAdmin();
		break;
		case 5: AdminController.checkVacancy();
		break;
		case 6: AdminController.printStudentListByIndex();
		break;
		
        case 7: 
        
        AdminController.printStudentListByCourse();
        break;
        case 8: AdminController.printStudentDetails();
        		break;
      case 9:
    	  break;
        
        default: System.out.println("Invalid");

		
		}
    }while(userChoice!=9);
    }
}
