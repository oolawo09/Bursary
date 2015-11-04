package idGenerator;

public class ActorIDGenerator {

	private static ActorIDGenerator _instance; 
	private Integer currentID; 
	
	public static ActorIDGenerator getActorIDGenerator(){ 
		if (_instance == null ){ 
			_instance = new ActorIDGenerator(); 	
		}
		return _instance; 
	}
	
	private ActorIDGenerator(){ 
		currentID = 0; 
	}
	
	public Integer generateID(){  
		return currentID++; 
	}
	
}
