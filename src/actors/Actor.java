package actors;

public class Actor {
	
	protected String name;  
	
	//look for ways to autogenerate unique ids
	protected Integer id;  
	
	//private List<Transactions> transactions () 
	
	Actor(String name, Integer id){ 
		this.name = name ; 
		this.id = id; 
	}
	
	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	
	public void Transact(){ 
		// create a transaction 
		// add it to actor's list of transactions 
	}
	
}
