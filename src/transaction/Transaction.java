package transaction;

import org.joda.time.DateTime;

public class Transaction {
	
	//will use joda time for this later on 
	private DateTime dateAndTime;
	private Integer amount; 
	private Integer id; 
	
	Transaction(Integer amount,Integer id){ 
		
		dateAndTime = new DateTime();
		this.amount = amount; 
		this.id = id; 
	}
	
	public DateTime getDateAndTime() {
		return dateAndTime;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getId() {
		return id;
	}
	
	
}
