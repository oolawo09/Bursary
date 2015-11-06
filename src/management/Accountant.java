package management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import actors.Donor;
import actors.Student;
import transaction.DonorTransaction;
import transaction.StudentTransaction;

public class Accountant {
	private Integer totalFundsAvailable; 
	private Integer fundsDisbursed; 
	
	public DonorManager donorManager; 
	public StudentManager studentManager; 
	
	private List<DonorTransaction> donations; 
	private List<StudentTransaction> awards; 

	private static Accountant _instance = null; 
	
	public static Accountant getAccountant(){ 
		if(_instance == null) { 
			_instance = new Accountant(); 
		}
		return _instance; 
	}
	
	private Accountant(){
		donorManager = DonorManager.getDonorManager(); 
		studentManager = StudentManager.getStudentManager();
		
		totalFundsAvailable = getDeposits();
		fundsDisbursed = 0; 
		
		donations = new ArrayList<DonorTransaction>(); 
		awards = new ArrayList<StudentTransaction>(); 
	}
	
	public Integer getDeposits(){ 
		Map<Integer, Donor> donors = donorManager.getDonors(); 
		Integer deposits = 0; 
		Iterator it = donors.entrySet().iterator(); 
		while(it.hasNext()){ 
			Map.Entry pair = (Map.Entry) it.next(); 
			deposits += (Integer)((Donor) pair.getValue()).getTotalAmountDonated(); 
		}	
		return deposits; 
	}
	
	public Integer calculateAmountToAward(Integer totalFundsAvailable, 
			Integer numberOfStudents){ 
		
		Integer amountToAward = totalFundsAvailable/numberOfStudents; 
		if (amountToAward > 200){ 
			return amountToAward; 
		}
		else return 200; 
	}
	
	public void disburseEqually(){ 
		HashMap<Integer, Student> students = 
				(HashMap<Integer, Student>) studentManager.getStudents(); 
			
		Integer amountToAward = calculateAmountToAward(getDeposits(), students.size()); 
			
		Iterator it = students.entrySet().iterator();
		while (it.hasNext() && totalFundsAvailable != 0) {
			Map.Entry pair = (Map.Entry)it.next();
			Student student = (Student) pair.getValue(); 
			student.receiveAward(amountToAward); 
			totalFundsAvailable -= amountToAward; 
			it.remove(); // avoids a ConcurrentModificationException
		}
	}
	
	
	public Integer getTotalFundsAvailable(){ 
		return totalFundsAvailable; 
	}
	
	public void disburseEverything(){ 
		
	}
}
