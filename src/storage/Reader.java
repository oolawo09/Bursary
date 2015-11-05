package storage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;

import actors.Actor;


public class Reader extends SuperReadWrite{

	private BufferedReader bufferedReader; 
	private String fileName; 
	
	public Reader(String fileName) {
		super(fileName);
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// TODO Auto-generated constructor stub
	}
	
	public HashMap<Integer,Actor> read(){ 
		String out=""; 
		try {
			while((out = bufferedReader.readLine()) != null ){ 
				System.out.println(out); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			try{ 
				if (bufferedReader != null) 
					bufferedReader.close(); 
			} catch (IOException ex) { 
				ex.printStackTrace();
			}
			
		}
		
		return gson.fromJson(out, HashMap.class) ; 

	}
	

	
	



}
