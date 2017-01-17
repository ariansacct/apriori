package apriori;

import java.util.Set;
import java.util.TreeSet;

public class Transaction {
	
	Set<String> items;
	
	public Transaction(String line) {
		items = new TreeSet<String>();
		String[] tokens = line.split(";");
		for (String token : tokens)
			items.add(token);
	}
	
	public Set<String> getItems() {
		return items;
	}
	
	public String toString() {
		return items.toString();
	}
}
