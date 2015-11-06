package actors;

import java.util.ArrayList;
import java.util.List;

import idGenerator.TransactionIDGenerator;
import transaction.DonorTransaction;

public class Donor extends Actor{
	
	private Integer totalAmountDonated; 
	private List<DonorTransaction> donations; 
	private TransactionIDGenerator idGenerator = TransactionIDGenerator.getTransactionIDGenerator(); 

	public Donor(String name, Integer id, Integer donation) {
		super(name, id);
		totalAmountDonated = 0; 
		donations  = new ArrayList<DonorTransaction>(); 
		donate(donation); 
		// TODO Auto-generated constructor stub
	}

	public Integer getTotalAmountDonated() {
		return totalAmountDonated;
	}
	
	public void donate(Integer donation){ 
		//create transaction 
		//add transaction to list and move it to the bursar 
		Integer id = idGenerator.generateID(); 
		DonorTransaction donorTransaction = new DonorTransaction(donation, id); 
		donations.add(donorTransaction); 
		
		//update totalAmountDonated
		totalAmountDonated += donation; 
	}
	
	public List<DonorTransaction> getDonations(){ 
		return donations; 
	}
	
	public String toString(){
		return "name: " + name + "\n id: " + id +"\n TotalAmountDonated: "+ totalAmountDonated
				+"\n list of donations: \n"
				+"-------------------------\n"
				+donations; 	
	}

}
