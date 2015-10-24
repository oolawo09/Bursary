
public class Student {
	private String name; 
	private Integer id; 
	private Integer amountDue; 
	private Integer amountPaid; 
	private Integer balance; 
	
	Student(String name, Integer id){ 
		this.name = name ; 
		this.amountDue = 0; 
		this. amountPaid = 0; 
		this.balance = 0; 
		this.id = id; 
	}
	public String getName(){ 
		return name; 
	}
	
	public Integer getID(){ 
		return id; 
	}
	
	public void pay(Integer toPay){
		amountPaid += toPay;  
	}
	
	public Integer getBalance(){ 
		return balance; 
	}
	
	public Integer getAmountPaid(){ 
		return amountPaid; 
	}
	

}
