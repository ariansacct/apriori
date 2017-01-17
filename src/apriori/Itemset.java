package apriori;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Itemset {
	
	private Set<String> items;
	
	public Set<String> getItems() {
		return items;
	}
	
	public Itemset() {
		items = new TreeSet<String>();
	}
	
	public Itemset(Set<String> s) {
		items = s;
	}
	
	public int cardinality() {
		return items.size();
	}
	
	public void addElement(String string) {
		items.add(string);
	}
	
	public static Itemset union(Itemset s1, Itemset s2) {
		
		Set<String> s1Items = s1.getItems();
		Set<String> s2Items = s2.getItems();
		Set<String> temp = new TreeSet<String>(s1Items);
		temp.addAll(s2Items);
		Itemset result = new Itemset(temp);
		return result;
		
	}
	
	public static Itemset intersect(Itemset s1, Itemset s2) {
		
		Set<String> s1Items = s1.getItems();
		Set<String> s2Items = s2.getItems();
		Set<String> temp = new TreeSet<String>(s1Items);
		temp.retainAll(s2Items);
		Itemset result = new Itemset(temp);
		return result;
		
	}
	
	public static Itemset join(Itemset s1, Itemset s2) {
		
		if (s1.cardinality() != s2.cardinality()) {
			System.out.println("Cardinalities don't match.");
			return null;
		}
		
		Set<String> s1Items = s1.getItems();
		Set<String> s2Items = s2.getItems();
		
		int cardinality = s1.cardinality();
		
		Iterator<String> s1Iterator = s1Items.iterator();
		Iterator<String> s2Iterator = s2Items.iterator();
		
		Set<String> temp = new TreeSet<String>();
		
		for (int i = 0; i <= cardinality - 2; i++) {
			String s1Element = s1Iterator.next();
			String s2Element = s2Iterator.next();
			if (! s1Element.equals(s2Element)) {
				System.out.println("Elements don't match.");
				break;
			}
			temp.add(s1Element);
		}
		temp.add(s1Iterator.next());
		temp.add(s2Iterator.next());
		
		Itemset result = new Itemset(temp);
		return result;
		
	}
	
	public void print() {
		System.out.println(items);
	}
}
