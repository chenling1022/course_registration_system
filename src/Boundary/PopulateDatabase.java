package Boundary;
import Entity.*;
import Controller.*;
import java.util.*;

public class PopulateDatabase {

	public static void main(String[] args) {
		Database_Controller db=new Database_Controller();
		// TODO Auto-generated method stub
		Student s1=new Student("Kiran", "Bodipati", "U1922759J", "Male","Indian", 2, "SCSE", "CS", "DSAI", "KIRAN006@e.ntu.edu.sg", 
				"82474652","Kiran006",StarsApp.generateHashedPassword("password"));
		Student s2=new Student("Abhishek", "Vaidyanathan", "U1923980D", "Male","Indian", 2, "SCSE", "CS", "DSAI", "ABHISHEK033@e.ntu.edu.sg", 
				"82474652","Abhishek033",StarsApp.generateHashedPassword("password"));
		Student s3=new Student("Chenling", "Cui", "U1924759J", "Female","Chinese", 2, "SCSE", "CS", "Cyber Security", "java.oodp.stars@gmail.com", 
				"82474652","CuiChenling002",StarsApp.generateHashedPassword("password"));
		Student s4=new Student("Varun", "Iyengar", "U2022759J", "Male","Indian", 2, "SCSE", "BS", "Life sciences", "VARUNSRI001@e.ntu.edu.sg", 
				"82474652","Varun001",StarsApp.generateHashedPassword("password"));
		Student s5=new Student("Atul", "Acharya", "U1922758R", "Male","Indian", 2, "MAE", "ME", "Robotics", "java.oodp.stars@gmail.com", 
				"82474652","Atul005",StarsApp.generateHashedPassword("password"));
		Student s6=new Student("Ananya", "Singh", "U2024759J", "Female","Indian", 2, "SCSE", "CE", "Robotics", "VARUNSRI001@e.ntu.edu.sg", 
				"82474652","Ananya003",StarsApp.generateHashedPassword("password"));
		Student s7=new Student("Zhong", "Zin", "U1922758Q", "Male","Singaporean", 2, "SPMS", "Mathematics", "Time series", "java.oodp.stars@gmail.com", 
				"82474652","ZZ005",StarsApp.generateHashedPassword("password"));
		Student s8=new Student("TestStudent1", "Test", "U3000758Q", "Male","Singaporean", 2, "SPMS", "Mathematics", "Time series", "java.oodp.stars@gmail.com", 
				"82474652","STU001",StarsApp.generateHashedPassword("password"));
		Student s9=new Student("TestStudent2", "Test", "U2000229J", "Female","Singaporean", 2, "SPMS", "Physics", "Quantum Studies", "java.oodp.stars@gmail.com", 
				"82474652","STU002",StarsApp.generateHashedPassword("password"));
		Student s10=new Student("TestStudent2", "Test", "U2012229J", "Male","Singaporean", 2, "SPMS", "Mathematics", "Time series", "java.oodp.stars@gmail.com", 
				"82474652","STU003",StarsApp.generateHashedPassword("password"));
		
		ArrayList<Student> sList=new ArrayList<Student>();
		sList.add(s1);sList.add(s2);sList.add(s3);sList.add(s4);sList.add(s5);sList.add(s6);sList.add(s7);sList.add(s8);sList.add(s9);sList.add(s10);
		
		Admin a1 = new Admin("Carolina","Tan","A0223","CarolinaTan001",StarsApp.generateHashedPassword("password"));
		Admin a2 = new Admin("Andrew","Tan","A0221","Andrew005",StarsApp.generateHashedPassword("password"));
		Admin a3 = new Admin("Evelina","Tan","A0210","Evelina002",StarsApp.generateHashedPassword("password"));
		Admin a4 = new Admin("Rahul","Tan","A0300","Rahul001",StarsApp.generateHashedPassword("password"));
		
		ArrayList<Admin> aList = new ArrayList<Admin>();
		aList.add(a1);aList.add(a2);aList.add(a3);aList.add(a4);
		
		
		LessonType l1 = new LessonType("lec", "Monday","1000","1100", "Odd", "LT1A");
		LessonType l2 = new LessonType("lec", "Wednesday","0800","0900", "Even", "LT2A");
		LessonType l3 = new LessonType("lec", "Thursday","1000","1200", "Even", "LT3");
		LessonType l4 = new LessonType("lec", "Friday","1200","1400", "Odd", "LT4");
		LessonType l5 = new LessonType("lec", "Tuesday","1000","1400", "Even", "LT5");
		LessonType l6 = new LessonType("lec", "Monday","1000","1100", "Odd", "LT6");
		
		LessonType l7 = new LessonType("Tut","Monday","1500","1600","Odd","Tr+19");
		LessonType l8 = new LessonType("Tut","Wednesday","1200","1400","Even","LHN Tr+19");
		LessonType l9 = new LessonType("Tut","Tuesday","1500","1600","Odd"," LHS Tr+19");
		LessonType l10 = new LessonType("Tut","Monday","1500","1600","Even","Tr+25");
		LessonType l11 = new LessonType("Tut","Thursday","1500","1600","Odd","Tr+30");
		LessonType l12 = new LessonType("Tut","Monday","1200","1300","Even","Tr+10");
		
		LessonType l13 = new LessonType("Lab","Monday","0800","1000","Odd","Tr+19");
		LessonType l14 = new LessonType("Lab","Tuesday","1430","1630","Odd","Tr+19");
		LessonType l15 = new LessonType("Lab","Friday","1400","1600","Odd","Tr+19");
		LessonType l16 = new LessonType("Lab","thursday","1000","1200","Odd","Tr+19");
		LessonType l17 = new LessonType("Lab","Monday","0800","1000","Odd","Tr+19");
		LessonType l18 = new LessonType("Lab","MOnday","1000","1200","Odd","Tr+19");
		
		LessonType[] Lesson1= {l1, l7, l13};
		LessonType[] Lesson2= {l2, l8};
		LessonType[] Lesson3=  {l3,l9};
		LessonType[] Lesson4 = {l4,l12};
		LessonType[] Lesson5= {l5,l12};
		LessonType[] Lesson6= {l6,l9};
		LessonType[] Lesson7 = {l1,l13};
		LessonType[] Lesson8 = {l2,l14};
		LessonType[] Lesson9 = {l3,l17};
		LessonType[] Lesson10 = {l4,l18};
		LessonType[] Lesson11 = {l5,l16};
		LessonType[] Lesson12 = {l6,l14};
		
		WaitList w1 = new WaitList(0,null);
		
		Index i1 = new Index("10001",25,25,0,"DSAI1",Lesson1,w1);
		Index i2 = new Index("10002",25,25,0,"CE1",Lesson2,w1);
		Index i3 = new Index("10003",25,25,0,"CS1",Lesson3,w1);
		Index i4 = new Index("10004",25,25,0,"CE2",Lesson4,w1);
		Index i5 = new Index("10005",25,25,0,"CS2",Lesson5,w1);
		Index i6 = new Index("10006",25,25,0,"DSAI2",Lesson6,w1);
		Index i7 = new Index("10007",25,25,0,"DSAI1",Lesson7,w1);
		Index i8 = new Index("10008",25,25,0,"CE1",Lesson8,w1);
		Index i9 = new Index("10009",25,25,0,"CS1",Lesson9,w1);
		Index i10 = new Index("10011",25,25,0,"CE2",Lesson10,w1);
		Index i11 = new Index("10012",25,25,0,"CS2",Lesson11,w1);
		Index i12 = new Index("10013",1,1,0,"DSAI2",Lesson12,w1);
		
		Index[] il1= {i1,i2};
		Index[] il2= {i3,i4};
		Index[] il3= {i5,i6};
		Index[] il4= {i7,i8};
		Index[] il5= {i9};
		Index[] il6= {i10,i11,i12};
		
		Course c1 = new Course("MH2100", "Calculus 3", 3 , il1,"SPMS");
		Course c2 = new Course("MH2500", "Probability and Statistics", 3 , il2,"SPMS");
		Course c3 = new Course("CZ2001", "Algorithms", 3 , il3,"SSCE");
		Course c4 = new Course("CZ2002", "OODP", 3 , il4,"SCSE");
		Course c5 = new Course("CZ2007", "Databases", 3 , il5,"SCSE");
		Course c6 = new Course("CZ2004", "Human Computer Intraction", 3 , il6,"SCSE");
		
		ArrayList<Course> cList = new ArrayList<Course>();
		cList.add(c1);cList.add(c2);cList.add(c3);cList.add(c4);cList.add(c5);cList.add(c6);
		
		Date sd1 = new Date(120,9,11,10,00,00);
		Date ed1 = new Date(120,11,30,22,00,00);
		
		Date sd2 = new Date(119,8,11,10,00,00);
		Date ed2 = new Date(119,8,22,22,00,00);
		
		Date sd3 = new Date(121,8,11,10,00,00);
		Date ed3 = new Date(121,8,22,22,00,00);
		
		
		accessperiod ap1 = new accessperiod(sd1,ed1);
		accessperiod ap2 = new accessperiod(sd2,ed2);
		accessperiod ap3=new accessperiod(sd3, ed3);
		
		School sc1 = new School("School of computer science and engineering","SCSE",ap1 );
		School sc2 = new School("School of Physical and Mathematical Sciences ", "SPMS",ap2);
		School sc3 = new School("Mechanical and Aeronautical Engineering ", "MAE",ap3);
		
		ArrayList<School> scl = new ArrayList<School>();
		scl.add(sc1);scl.add(sc2);scl.add(sc3);
		
		db.writeStudentList(sList);
		db.writeAdminList(aList);
		db.writeCourseList(cList);
		db.writeSchoolList(scl);
		System.out.print("Done");
		
		CourseRegistration cReg=new CourseRegistration("", s10, "", "", "");
		ArrayList<CourseRegistration> crList=new ArrayList<CourseRegistration> ();
		crList.add(cReg);
		db.writeRegCourseList(crList);
		
	}

}
