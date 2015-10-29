package transaction;

public class DonorTransaction extends Transaction {

	private String donorID; 

	DonorTransaction(String dateAndTime, Integer amount, 
			String transactionID, String donorID) {
		
		super(dateAndTime, amount, transactionID);
		// TODO Auto-generated constructor stub
		
		this.donorID = donorID; 
	}
	
	public String getDonorID() {
		return donorID;
	}
	
	

}
