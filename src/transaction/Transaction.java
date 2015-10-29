package transaction;

public class Transaction {
	
	//will use joda time for this later on 
	private String dateAndTime;
	private Integer amount; 
	private String id; 
	
	Transaction(String dateAndTime, 
			Integer amount,String id){ 
		
		this.dateAndTime= dateAndTime;
		this.amount = amount; 
		this.id = id; 
	}
	
	public String getDateAndTime() {
		return dateAndTime;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getId() {
		return id;
	}
	
	
}
