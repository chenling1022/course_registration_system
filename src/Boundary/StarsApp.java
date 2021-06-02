package Boundary;
import Controller.*;
import java.util.*;
import Entity.*;
import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * 
 * represents the main boundary class for Stars. 
 * 
 * @author
 * 
 */

public class StarsApp {
    /**
     * 
     * SALT used for password hashing.
     * 
     */
    private static final String SALT = "mySTARSSALT";
    /**
     * 
     * Flag for authentication.
     * 
     */
    private static boolean isAuthenticated = false;
    /**
     * 
     * variable used for storing username.
     * 
     */
    private static String Username = null;
    /**
     * 
     * variable usded for storing password.
     * 
     */
    private static String PassWord = null;
     /**
     * 
     * variable used for storing a student object.
     * 
     */
    private static Student Student ;
     /**
     * 
     * variable used to store admin object
     * 
     */
    private static Admin admin;
    /**
     * 
     * variable to used for stroing usertype - student(s) and Admin(A).
     */
    private static String UserType;
     /**
     * 
     * variable used for storing the password once its hashed .
     * 
     */
    private static String PasswordHashed;
     /**
     * 
     * Flag to check if the student with a particular username and password exists.
     * 
     */
    private static boolean ValidateStudent;
     /**
     * 
     * flag to check if the admin with a particular username and password exists
     * 
     */
    private static boolean ValidateAdmin;
     /**
     * 
     * varible to check if the user input is either A or S (ignoring case) for user type.
     * 
     */
    private static boolean ValidateUserType;
    
    private static accessperiod period;
    /** 
     * 
     * Main program method.
     * 
     * @param args
     * 
     * */
    static Scanner sc = new Scanner(System.in);
    static Database_Controller Database_Controller = new Database_Controller();
    
    public static void main(String Args[]){
        Welcome();
        if(Login()==true){
            if(UserType.equalsIgnoreCase("S")){
                studentMenu.display(Student);
            }
            else{
                AdminMenu.display(admin);
            }
        }
    }
    /**
     * display the welcome message. 
     */

    private static void Welcome(){
        System.out.println("#\t\tWelcome to Stars Planner\t\t#");
    } 
    /**
     * 
     * static method for user login, return true if the login is successful if not it returns false.
     * 
     * @return true or false.
     */

    public static boolean Login(){
    	do {
    	Date date = new Date();
        Console cs = System.console();
            System.out.print("Username : ");
            Username = sc.nextLine().toUpperCase();
            System.out.print("password : ");
            if(cs!=null){
                char[] passString = cs.readPassword();
                PassWord = new String(passString);
            }else {
                PassWord = sc.nextLine();
            }
       
            System.out.print("Enter the type of user , Student - S and Admin - A");
            UserType= sc.nextLine().toUpperCase();
            PasswordHashed = generateHashedPassword(PassWord);
            if(UserType.equalsIgnoreCase("S")){
                Student = Database_Controller.getStudentByUsername(Username);
                if (Student==null)
                {
                	System.out.println("Invalid Username or password, please try again");
                	return false;
                	
                }
                period = Database_Controller.getAccessPeriodbySchool(Student.getSchool());
                if(Student != null){
                    ValidateStudent = Database_Controller.validateStudent(Student,PasswordHashed);
                    
                    if(ValidateStudent==true){
                    	
                    	if(date.compareTo(period.getstartDate()) > 0 && date.compareTo(period.getendDate())<=0 ) {
                    		isAuthenticated = true;
                    		return true;}
                    	else
                    	{
                    		System.out.println("You are not allowed to access now : "+ period.getstartDate()+" "+period.getendDate());
                    	}
                    }else {
                        System.out.println("Invalid Username or password, please try again");
                }
            }
            }else {
                admin = Database_Controller.getAdminbyUsername(Username);
                if(admin != null){
                    ValidateAdmin = Database_Controller.validateAdmin(admin,PasswordHashed);
                    if(ValidateAdmin==true){
                        isAuthenticated = true;
                        return true;
                    }else{
                        System.out.println("Invalid username or password");
                    }
                }else {
                	System.out.println("Invalid username or password");
                }
            }
    	}while(!isAuthenticated);
        return false;
        
    }
    /**
     * 
     * logout user.
     */
    
    protected static void logout() {
    	isAuthenticated = false;
    	main(null);
    	
    }
    /**
     * 
     * turns plain text into SHA-256 hash.
     * 
     * @param input 
     *             plain text 
     * @return hash.
     */

    private static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-256"); // use SHA-256 Algorithm
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; idx++) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// failed to generate hash
		}

		return hash.toString();
	}
    /**
     * 
     * turns plain text into hashed password.
     * 
     * @param password
     *                plain password.
     * @return hashed password. 
     */
    public static String generateHashedPassword(String password) {
		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);
		return hashedPassword;
	}
    

}