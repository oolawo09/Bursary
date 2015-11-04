package actors;

import java.util.ArrayList;
import java.util.List;

import idGenerator.TransactionIDGenerator;
import transaction.DonorTransaction;
import transaction.StudentTransaction;

public class Student extends Actor {
	
	private Integer amountNeeded; 
	private List<StudentTransaction> awards; 
	private TransactionIDGenerator idGenerator; 



	public Student(String name, Integer id) {
		super(name, id);
		amountNeeded = 0; 
		awards = new ArrayList<StudentTransaction>(); 
		idGenerator.getTransactionIDGenerator(); 
		// TODO Auto-generated constructor stub
	}
	
	public Integer getAmountNeeded() {
		return amountNeeded;
	}
	
	public void addToAmountNeeded(Integer delta){ 
		amountNeeded += delta; 
	}
	
	public void receiveAward(Integer award){ 
		//create transaction 
		//add transaction to list
		Integer id = idGenerator.generateID(); 
		StudentTransaction studentTransaction = new StudentTransaction(award, id); 
		awards.add(studentTransaction); 
		
		//update amountNeeded; 
		amountNeeded -= award; 
	}
	
	public List<StudentTransaction> getAwards(){ 
		return awards; 
	}
	
	public String toString(){
		return "name: " + name + " id: " + id +" amountNeeded: "+ amountNeeded; 	
	}
	
}
