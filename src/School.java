import java.util.ArrayList;

public class School {
	
	private String schoolName; 
	private ArrayList<Student> students;
	private Integer currentID; 
	
	School(String schoolName){ 
		this.schoolName = schoolName; 
		students = new ArrayList<Student>(); 
		currentID = 0; 
	}
	
	public void addStudent(String name){ 
		students.add(new Student(name, currentID)); 
		currentID++; 
	}
	
	public void payFees(Integer studentId, Integer feeToPay){ 
		Student student = getStudent(studentId); 
		student.pay(feeToPay);
	}
	
	public Student getStudent(Integer id){ 
		for(Student student: students){ 
			if(student.getID() == id){
				return student; 
			}
		}	
		
		return null;
	}
	
}
