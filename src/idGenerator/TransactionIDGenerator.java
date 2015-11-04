package idGenerator;

public class TransactionIDGenerator {

	private static TransactionIDGenerator _instance; 
	private Integer currentID; 
	
	public static TransactionIDGenerator getTransactionIDGenerator(){ 
		if (_instance == null ){ 
			_instance = new TransactionIDGenerator(); 	
		}
		return _instance; 
	}
	
	private TransactionIDGenerator(){ 
		currentID = 0; 
	}
	
	public Integer generateID(){  
		return currentID++; 
	}
	
}
