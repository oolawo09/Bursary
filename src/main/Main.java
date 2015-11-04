package main;

import management.MainManager;

public class Main {

		private static MainManager mainManager; 
		
		public static void main(String []args){ 
			Main main = new Main(); 
			main.mainManager = MainManager.getManager(); 
			mainManager.accountant.donorManager.addDonors();
			System.out.println(mainManager.accountant.getDeposits()); 
			mainManager.accountant.studentManager.addStudents(); 
			
		}
		
	
}
