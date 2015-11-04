package actors;

public class Student extends Actor {
	
	private Integer amountNeeded; 



	public Student(String name, Integer id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}
	
	public Integer getAmountNeeded() {
		return amountNeeded;
	}
	
	public void receive(Integer award){ 
		//create transaction 
		//add transaction to list 
		
		//update amountNeeded; 
		amountNeeded -= award; 
	}
	
	
	
	
}
