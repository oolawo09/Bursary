package management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import actors.Donor;
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
	
	public void disburseEqually(){ 
		
		
	}
	
	public void disburseEverything(){ 
		
	}
}
