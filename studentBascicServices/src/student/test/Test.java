package student.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import student.models.CNode;
import student.models.SNode;
import student.services.StudentServices;

public class Test {
	

	public static void main(String[] args) {
		List<SNode> students=null ;
		StudentServices service = new StudentServices();
		List<CNode> courses = new ArrayList<CNode>();
		Scanner scanner = new Scanner(System.in);
		int opt=0;
		
		do{
			System.out.println("\n=========== STUDENT SERVICE OPTIONS =============\n");
			System.out.println("1 : Adding New student data");
			System.out.println("2 : Display student data");
			System.out.println("3 : Update student data ");
			System.out.println("4 : Delete student data ");
			System.out.println("5 : Display all student data ");
			System.out.println("6 : Adding student marks ");
			System.out.println("7 : Display all student marks  ");
			System.out.println("8 : Exite ");
			System.out.println("--------------------------------------------------");
			int op=0;
			System.out.println("Enter option :");
			op=scanner.nextInt();
			switch(op) {
				case 1:
					   SNode student=new SNode();
				       CNode cours = new CNode();
				       System.out.println("------------- Adding student course data ------------------");
				       System.out.println("Cno(string) : "); cours.setCno(scanner.next());
				       System.out.println("marks(int) : "); cours.setCmark(scanner.nextInt());
				       System.out.println("uni(int)t : ");cours.setCunit(scanner.nextInt());
				       //add CNode to Cnodes array to be added to student
				       courses.add(cours);
				       System.out.println("------------- Adding student data ------------------");
				       System.out.println("Sno(int) : "); student.setSno(scanner.nextInt());
				       System.out.println("Sname(string) : "); student.setSname(scanner.next());
				       System.out.println("Sdept(string) : "); student.setSdept(scanner.next());
				       System.out.println("Sgradute(boolean) : "); student.setSgradute(scanner.nextBoolean());
			           student.setLink(courses);
			           // Call add student method
			           service.addStudent(student);break;
			           
				case 2:
					   System.out.println("-------------  Get student data by Sno ------------------");
					   System.out.println("Enter Sno(int) : ");
					   SNode studentToget = service.getStudent(scanner.nextInt());
					   System.out.println("name : "+studentToget.getSname()+"sdept : "+studentToget.getSdept()+"is radute :"
					   +studentToget.isSgradute());
					   //looping through courses list of student to printout
					   for(CNode cnode:studentToget.getLink()) {
						   System.out.println("cno : "+cnode.getCno());
						   System.out.println("cmarks : "+cnode.getCmark());
						   System.out.println("cunit : "+cnode.getCunit());  
					   }
					   System.out.println("************************************* end of get student data *********************************");
					   break;
				case 3:
					   // get the student by stduent no (Sno) to update it
					   System.out.println("**************************** Update Student ***************************/");
					   System.out.println("Sno(int) : ");
					   SNode studentToUpdate = service.getStudent(scanner.nextInt());
					   // now we can update the student data you can update any property , here we update Sdept
					   System.out.println("new Sdept :");
					   studentToUpdate.setSdept(scanner.next());
					   // Save it back again to student array
					   service.updatStudent(studentToUpdate);
					   System.out.println("**************************** End Update Student ***************************/");
					   break;
				case 4:
					   // Enter the Student no (Sno) do delete the student data 
					System.out.println("**************************** delete student data    ***************************/");
					   System.out.println("Sno(int) : ");
					   int status = service.deleteStudent(scanner.nextInt());
					  if(status == 1) System.out.println("student deleted ");
					    else System.out.println("student not Exist : enter exist Sno");
					  System.out.println("**************************** End  delete Student ***************************/");
					   break;
				case 5:
					  // to display all student data we need to call get All student and diplay all student
					 System.out.println("******************************** student details *************************************\n ");
					  List<SNode> snodes = service.getlAllStudent();
					  // looping through StudentList to display students data
	
					  for(SNode studentTodisplay:snodes) {
						  System.out.println("-------------- student Number["+studentTodisplay.getSno()+"]  ------------------\n ");
						  System.out.println("sno(int) : "+studentTodisplay.getSno());
						  System.out.println("sname(string) : "+studentTodisplay.getSname());
						  System.out.println("sdept(string) : "+studentTodisplay.getSdept());
						  System.out.println("sgradute(boolean) : "+studentTodisplay.isSgradute());
						  // looping through course do display
						  System.out.println("-----------  student course details -------------\n");
						  for(CNode course:studentTodisplay.getLink()) {
							  System.out.println("    Cno(string) : "+course.getCno());
							  System.out.println("    Cmarks(int) : "+course.getCmark());
							  System.out.println("    Cunit(int) : "+course.getCunit());
						  }
						  System.out.println("***********************************End of all student *******************************************\n");
					  }
					  
					 break;
				case 6:
					   // adding new marks to student (adding new course with result )
					 System.out.println("******************************** Adding student marks *************************************\n ");
					   System.out.println("enter the student no (Sno) : ");
					   int sno = scanner.nextInt();
					   System.out.println("enter the course no (Cno) to add marks : ");
					   String Cno = scanner.next();
					   System.out.println("enter the marks: ");
					   int marks = scanner.nextInt();
					   // call adding method to add the marks
					   int addStatus = service.addStudentMrks(sno, Cno, marks);
					   if(addStatus == 1) System.out.println("marks added ");
						 else System.out.println("Sno or Cno not exist");
					   System.out.println("******************************** Ending student details *************************************\n ");
				       break;
				case 7: 
					   // Enter the student number (Sno) to display all Marks
					 System.out.println("******************************** Display All students marks *************************************\n ");
					   System.out.println("enter Sno : ");
					   int studentNo = scanner.nextInt();
					   //get the list of courses to display the result (marks) form inside the courses by invoking geCnode() mthod
					   List<CNode> studentCourses = service.getCnode(studentNo);
					   // after Getting list of course now we looping through Course list do display all student results
					   for(CNode studentCourse:studentCourses) {
						   System.out.println(studentCourse.getCmark());
					   }
					   System.out.println("******************************** Ending of all student marks *************************************\n ");
					   break;
					   
				case 8:System.exit(0);
			} 
			System.out.println("\n---------------------------------------- ");
			System.out.println("\n To Execute other options press other than 7 ");
			opt = scanner.nextInt();
		}while (!(opt == 7));
	}
	

}
