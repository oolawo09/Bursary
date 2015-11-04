package management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import actors.Donor;
import idGenerator.ActorIDGenerator;


public class DonorManager {
	private Map<Integer, Donor> donors;
	
	private static DonorManager _instance = null; 
	private static ActorIDGenerator idGenerator; 
	
	public static DonorManager getDonorManager(){ 
		if(_instance == null){ 
			_instance = new DonorManager(); 
		}
		return _instance; 
	}
	
	private DonorManager(){ 
		donors = new HashMap<Integer, Donor>(); 
		idGenerator = ActorIDGenerator.getActorIDGenerator(); 
	}

	public Map<Integer, Donor> getDonors() {
		return donors;
	} 
	
	public Donor getDonor(Integer id) { 
		return donors.get(id); 
	}
	
	public void donateByID(Integer amount, Integer id){ 
		Donor donor = getDonor(id); 
		donor.donate(amount); 
	}
	
	public void addDonors(){ 
		//using dummy data here
		for(Integer i=0; i<10; i++){ 
			addDonor("donor "+i.toString());
		}
	}
	
	public void addDonor(String name){ 
		Integer id = idGenerator.generateID(); 
		Donor donor = new Donor(name, id); 
		donor.donate(5000);
		donors.put(id, donor); 
	} 
	
	
	
	
	
}
