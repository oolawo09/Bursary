package actors;

public class Donor extends Actor{
	
	private Integer totalAmountDonated; 

	public Donor(String name, String id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	public Integer getTotalAmountDonated() {
		return totalAmountDonated;
	}
	
	public void donate(Integer donation){ 
		//create transaction 
		//add transaction to list and move it to the bursar 
		
		//update totalAmountDonated
		totalAmountDonated += donation; 
	}

}
