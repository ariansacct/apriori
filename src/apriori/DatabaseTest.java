package apriori;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class DatabaseTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		Database database = new Database("in/categories.txt");
		List<Transaction> databaseTransactions = database.getTransactions();
		Map<String, Integer> databaseCounts = database.getCounts();
		for (Transaction transaction : databaseTransactions) {
			System.out.println(transaction);
		}
	}

}
