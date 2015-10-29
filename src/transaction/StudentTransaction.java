package transaction;

public class StudentTransaction extends Transaction {
	//id of the student associated with the transaction. 
	//Differs to the the transaction id
	private String studentID; 

	StudentTransaction(String dateAndTime, Integer amount, 
			String transactionID, String studentID) {
		super(dateAndTime, amount, transactionID);
		// TODO Auto-generated constructor stub
		
		this.studentID = studentID; 
	}

	public String getStudentID() {
		return studentID;
	}
	
}
