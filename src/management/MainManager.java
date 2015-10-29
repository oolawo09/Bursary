package management;

import java.util.ArrayList;
import java.util.List;
import transaction.DonorTransaction;
import transaction.StudentTransaction;


public class MainManager {
	
	
	
	private static MainManager _instance = null;
	private Accountant accountant; 
	
	public static MainManager getManager(){ 
		if (_instance == null) { 
			_instance = new MainManager(); 
		}
		return _instance; 
	}
	
	private MainManager(){ 
		accountant = Accountant.getAccountant(); 
	}
	
	

	
	

}