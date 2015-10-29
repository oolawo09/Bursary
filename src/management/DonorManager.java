package management;

import java.util.ArrayList;
import java.util.List;

import actors.Donor;


public class DonorManager {
	private List<Donor> donors;
	
	private static DonorManager _instance = null; 
	
	public static DonorManager getDonorManager(){ 
		if(_instance == null){ 
			_instance = new DonorManager(); 
		}
		return _instance; 
	}
	
	private DonorManager(){ 
		donors = new ArrayList<Donor>(); 
	}

	public List<Donor> getDonors() {
		return donors;
	} 
	
	public void addDonor(String name, String id){ 
		Donor donor = new Donor(name, id); 
		donors.add(donor); 
	} 
	
	
	
	
	
}
