package transaction;

public class StudentTransaction extends Transaction {
	//id of the student associated with the transaction. 
	//Differs to the the transaction id

	StudentTransaction(Integer amount, 
			Integer transactionID, String studentID) {
		super(amount, transactionID);
		// TODO Auto-generated constructor stub
		
	}

}
