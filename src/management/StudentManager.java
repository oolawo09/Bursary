package management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import actors.Actor;
import actors.Donor;
import actors.Student;
import idGenerator.ActorIDGenerator;

public class StudentManager {
	private Map<Integer, Student> students;
	
	private static StudentManager _instance = null; 
	private static ActorIDGenerator idGenerator; 
	
	public static StudentManager getStudentManager(){ 
		if(_instance == null){ 
			_instance = new StudentManager(); 
		}
		return _instance; 
	}
	
	private StudentManager(){ 
		students = new HashMap<Integer, Student>(); 
		idGenerator = ActorIDGenerator.getActorIDGenerator(); 
	}

	public Student getStudent(Integer id){ 
		return students.get(id); 
	}
	
	public Map<Integer, Student> getStudents() {
		return students;
	} 
	
	public void addStudents(){ 
		//using dummy data here
		for(Integer i=0; i<10; i++){ 
			addStudent("student "+i.toString());
			System.out.println(getStudent(10+i)); 
		}
	}
	
	public void addStudent(String name){ 
		Integer id = idGenerator.generateID(); 
		Student student = new Student(name,id ); 
		students.put(id, student); 
	}
	
	
	
}
