package actors;

public class Actor {
	
	private String name;  
	private String id;  
	
	//private List<Transactions> transactions () 
	
	Actor(String name, String id){ 
		this.name = name ; 
		this.id = id; 
	}
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	
	public void Transact(){ 
		// create a transaction 
		// add it to actor's list of transactions 
	}
	
}
