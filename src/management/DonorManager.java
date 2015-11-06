package management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import actors.Donor;
import idGenerator.ActorIDGenerator;
import transaction.DonorTransaction;


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

	public List<DonorTransaction> getDonationList(){ 
		ArrayList<DonorTransaction> transactions = new ArrayList<DonorTransaction>(); 
		Iterator it = donors.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			transactions.add((DonorTransaction) pair.getValue()); 
			it.remove(); // avoids a ConcurrentModificationException
		}
		return transactions; 
	}


	public void addDonor(String name, Integer donation){ 
		Integer id = idGenerator.generateID(); 
		Donor donor = new Donor(name, id, donation); 
		donors.put(id, donor);
		System.out.println(donors);
	} 





}
