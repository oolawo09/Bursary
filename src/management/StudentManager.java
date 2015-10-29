package management;

import java.util.ArrayList;
import java.util.List;

import actors.Actor;
import actors.Donor;
import actors.Student;

public class StudentManager {
	private List<Student> students;
	
	private static StudentManager _instance = null; 
	
	public StudentManager getDonorManager(){ 
		if(_instance == null){ 
			_instance = new StudentManager(); 
		}
		return _instance; 
	}
	
	private StudentManager(){ 
		students = new ArrayList<Student>(); 
	}

	public List<Student> getStudents() {
		return students;
	} 
	
	public void addStudent(String name, String id){ 
		Student donor = new Student(name, id); 
		students.add(donor); 
	} 
	
}
