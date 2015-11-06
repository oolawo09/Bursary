package management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import actors.Actor;
import actors.Donor;
import actors.Student;
import idGenerator.ActorIDGenerator;
import transaction.DonorTransaction;
import transaction.StudentTransaction;

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
	
	public List<StudentTransaction> getAwardsList(){ 
		ArrayList<StudentTransaction> transactions = new ArrayList<StudentTransaction>(); 
		Iterator it = students.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			transactions.add((StudentTransaction) pair.getValue()); 
			it.remove(); // avoids a ConcurrentModificationException
		}
		return transactions; 
	}

	public void addStudent(String name, Integer need){ 
		Integer id = idGenerator.generateID(); 
		Student student = new Student(name,id ,need); 
		students.put(id, student); 
		System.out.println(students);
	}
	
	
	
}
