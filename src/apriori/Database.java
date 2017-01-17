package apriori;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Database {
	
	private List<Transaction> transactions;
	private Map<Set<String>, Integer> counts;
	
	private Scanner getFileScanner(String filename) throws FileNotFoundException {
		
		File file = new File(filename);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Scanner scanner = new Scanner(bufferedReader);
		return scanner;
		
	}
	
//	private Itemset getAnItemset(Scanner scanner) {
//		
//		String line = scanner.nextLine();
//		String[] tokens = line.split(";");
//		Set<String> items = new TreeSet<String>();
//		for (String string : tokens) {
//			items.add(string);
//			if (counts.containsKey(string)) {
//				Integer oldCount = counts.get(string);
//				counts.put(string, oldCount + 1);
//			}
//			else
//				counts.put(string, new Integer(1));
//		}
//		Itemset result = new Itemset(items);
//		return result;
//		
//	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	public Map getCounts() {
		return counts;
	}
	
//	public Database(String filename) throws FileNotFoundException {
//		
//		transactions = new ArrayList<Itemset>();
//		counts = new HashMap<String, Integer>();
//		Scanner scanner = getFileScanner(filename);
//		while (scanner.hasNextLine()) {
//			Itemset itemset = getAnItemset(scanner);
//			transactions.add(itemset);
//		}
//		scanner.close();
//		
//	}
	
	public Map<String, Integer> getItemCounts() {
		
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (Transaction transaction : transactions) {
			Set<String> transactionItems = transaction.getItems();
			for (String item : transactionItems) {
				if (counts.containsKey(item)) {
					Integer oldCount = counts.get(item);
					counts.put(item, oldCount + 1);
				}
				else
					counts.put(item, new Integer(1));
			}
		}
		return counts;
		
	}
	
	private Transaction getATransaction(Scanner scanner) {
		String line = scanner.nextLine();
		return new Transaction(line);
	}
	
	public Database(String filename) {
		transactions = new ArrayList<Transaction>();
		Scanner scanner = new Scanner(filename);
		while (scanner.hasNextLine()) {
			transactions.add(getATransaction(scanner));
		}
		System.out.println("Loaded the database.");
	}
	
}
