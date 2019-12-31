package student.services;

import java.util.ArrayList;
import java.util.List;

import student.models.CNode;
import student.models.SNode;

public class StudentServices {
	private List<SNode> snodesL = new ArrayList<SNode>();
	
	//Adding Student Method 
	public void addStudent(SNode student) {
		
		snodesL.add(student);
	}
	
	// Getting and Displaying Student Data
	public SNode getStudent (int Sno) {
		
		//declare the student to be send back to display
		SNode requiredStudent=null;  // inside loop if we find the student then assign it to this and send it back 
		for(SNode student:snodesL) {
			if (student.getSno() == Sno) {
				requiredStudent = student;
			}
		}
		return requiredStudent;
	}
	
	// Updating the Student Data 
	public void updatStudent(SNode student) {
		
		// first we get the require student from the list based on student no (Sno) by looping and search insid the student array 
		for(SNode updatedstudent:snodesL) {
			
			if (updatedstudent.getSno() == student.getSno()) {
				// if the student exist we assign new data to it
				updatedstudent.setSname(student.getSname());
				updatedstudent.setSdept(student.getSdept());
				updatedstudent.setSunit(student.getSunit());
				updatedstudent.setSgradute(student.isSgradute());
				updatedstudent.setLink(student.getLink());
			}
		}
	}
	
	// Deletion of student Data  
	public int deleteStudent(int Sno) {
		int flag=0;
		for(SNode dltstudentdata:snodesL) {
			if(dltstudentdata.getSno() == Sno )
			{
				dltstudentdata.setSname(""); 
				dltstudentdata.setSdept("");
				dltstudentdata.setSunit(0);
				dltstudentdata.setSgradute(false);
				
				//loopin trou array of course to delete data
				for(CNode nodes:dltstudentdata.getLink()) {
					nodes.setCmark(0);
					nodes.setCunit(0);
				}
				flag=1;
			}	
		}
		return flag;
	}
	
	
	 // Display All Student 
	  public List<SNode> getlAllStudent(){ return snodesL; }
	 
	// Adding student Marks 
	public int addStudentMrks(int Sno, String Cno , int marks) {
		
		int flag=0;
		for (SNode student:snodesL) {
			//checking if the student exist , if yes we add new mark otherwise not
			if(student.getSno() == Sno) {
				   // looping through student courses to find the course to add the marks
				   for(CNode course:student.getLink()) {
					   //if current course equal to required cno to add 
					   if(course.getCno().equals(Cno)) {
						   course.setCmark(marks);  //add the marks
						   flag=1; // set flag to indicate adding done
					   }
				   }
				}
			}
		return flag;
		}
		
	
	// display student mark
	public List<CNode> getCnode(int Sno) {
		
		List<CNode> marks=null;
		for(SNode student:snodesL) {
			if(student.getSno() == Sno) {
				marks = student.getLink();
			}
		}
		
		return marks;
	}

}
