package management;

import java.util.ArrayList;
import java.util.List;
import transaction.DonorTransaction;
import transaction.StudentTransaction;

public class MainManager {

	private static MainManager _instance = null;
	public Accountant accountant;
	


	public static MainManager getManager() {
		if (_instance == null) {
			_instance = new MainManager();
		}
		return _instance;
	}

	public MainManager() {
		accountant = Accountant.getAccountant();
	}

}
