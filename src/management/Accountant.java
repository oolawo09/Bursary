package management;

import java.util.ArrayList;
import java.util.List;

import transaction.DonorTransaction;
import transaction.StudentTransaction;

public class Accountant {
	private Integer totalFundsAvailable; 
	private Integer fundsDisbursed; 
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
		totalFundsAvailable = 0;
		fundsDisbursed = 0; 
		donations = new ArrayList<DonorTransaction>(); 
		awards = new ArrayList<StudentTransaction>(); 
	}
}
