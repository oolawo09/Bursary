package management;

import java.util.ArrayList;
import java.util.List;

import actors.Donor;
import transaction.DonorTransaction;
import transaction.StudentTransaction;

public class Accountant {
	private Integer totalFundsAvailable; 
	private Integer fundsDisbursed; 
	
	private DonorManager donorManager; 
	private StudentManager studentManager; 
	
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
		List<Donor>donors = donorManager.getDonors(); 
		Integer deposits = 0; 
		for(Donor donor: donors){ 
			deposits += donor.getTotalAmountDonated(); 
		}	
		return deposits; 
	}
	
	public void disburseEverything(){ 
		
	}
}
