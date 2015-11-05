package storage;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;

public class SuperReadWrite  {
	
	protected Gson gson; 
	protected File file; 
	
	public SuperReadWrite(String fileName){
		gson = new Gson(); 
		file = new File(fileName); 
		if(!file.exists()){ 
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
}
