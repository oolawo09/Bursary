package management;

import java.util.ArrayList;
import java.util.List;

import actors.Actor;
import actors.Donor;
import actors.Student;
import idGenerator.ActorIDGenerator;

public class StudentManager {
	private List<Student> students;
	
	private static StudentManager _instance = null; 
	private static ActorIDGenerator idGenerator; 
	
	public static StudentManager getStudentManager(){ 
		if(_instance == null){ 
			_instance = new StudentManager(); 
		}
		return _instance; 
	}
	
	private StudentManager(){ 
		students = new ArrayList<Student>(); 
		idGenerator = ActorIDGenerator.getActorIDGenerator(); 
	}

	public List<Student> getStudents() {
		return students;
	} 
	
	public void addStudent(String name, String id){ 
		Student donor = new Student(name, idGenerator.generateID()); 
		students.add(donor); 
	} 
	
}
