package apriori;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AprioriAlgorithm {

	private Database database;
	private double minsup;
	private int k;

	public AprioriAlgorithm(Database database, double minsup) {

		this.database = database;
		this.minsup = minsup;
		k = 0;

	}
	
	public void setK(int k) {
		this.k = k;
	}

	public Set<String> getFrequentOneItemsets() {

		Map<String, Integer> databaseItemCounts = database.getItemCounts();
		Set<String> result = new TreeSet<String>();

		for (String key : databaseItemCounts.keySet()) {
			if (databaseItemCounts.get(key) > minsup)
				result.add(key);
		}

		return result;

	}
	
	private boolean canBeJoined(Set<String> s1, Set<String> s2) {
		
		Iterator<String> s1Iterator = s1.iterator();
		Iterator<String> s2Iterator = s2.iterator();
		
		for (int i = 0; i <= k - 2; i++) {
			String s1Element = s1Iterator.next();
			String s2Element = s2Iterator.next();
			if (! s1Element.equals(s2Element)) {
				System.out.println("Elements don't match.");
				return false;
			}
		}
		return true;
	}

	public Set<String> join(Set<String> s1, Set<String> s2) {

		if (s1.size() != s2.size()) {
			System.out.println("Cardinalities don't match.");
			return null;
		}
		
		System.out.println("joining these two sets:");
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);

		int cardinality = s1.size();

		Iterator<String> s1Iterator = s1.iterator();
		Iterator<String> s2Iterator = s2.iterator();

		Set<String> result = new TreeSet<String>();

		for (int i = 0; i <= k - 1; i++) {
			String s1Element = s1Iterator.next();
			String s2Element = s2Iterator.next();
			if (! s1Element.equals(s2Element)) {
				System.out.println("Elements don't match.");
				break;
			}
			result.add(s1Element);
		}
		result.add(s1Iterator.next());
		result.add(s2Iterator.next());

		return result;

	}
	
	public void execute() {
		
		
		
	}

}
