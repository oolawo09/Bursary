package storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer extends SuperReadWrite {
	
	private FileWriter fileWriter; 
	private BufferedWriter bufferedWriter; 
	
	public Writer(String fileName){ 
		super(fileName); 
		
		try {
			fileWriter = new FileWriter(file.getAbsoluteFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		bufferedWriter = new BufferedWriter(fileWriter); 
	}
	
	public void write(Object obj){ 
		String out = gson.toJson(obj);
		
		try {
			bufferedWriter.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
