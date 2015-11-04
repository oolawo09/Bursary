package management;

import java.util.ArrayList;
import java.util.List;
import transaction.DonorTransaction;
import transaction.StudentTransaction;

public class MainManager {

	private static MainManager _instance = null;
	private Accountant accountant;
	private DonorManager donorManager; 
	private StudentManager studentManager; 


	public static MainManager getManager() {
		if (_instance == null) {
			_instance = new MainManager();
		}
		return _instance;
	}

	private MainManager() {
		accountant = Accountant.getAccountant();
		donorManager = DonorManager.getDonorManager(); 
		studentManager = StudentManager.getStudentManager(); 
	}
	
	public void addDonors(){ 
		//using dummy data here
		for(Integer i=0; i<10; i++){ 
			donorManager.addDonor("donor "+i.toString());
			System.out.println(donorManager.getDonors()); 
		}
	}
	
	public void addStudents(){ 
		
	}

}
