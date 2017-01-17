package apriori;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MyTest {

	public static void main(String[] args) {
		
		Set<String> a = new TreeSet<String>();
		a.add("a");
		a.add("b");
		a.add("e");
		Set<String> b = new TreeSet<String>();
		b.add("a");
		b.add("b");
		b.add("d");
		int k = 4;
		System.out.println("hey: " + join(a, b, k - 2));
	}
	
	public static Set<String> join(Set<String> s1, Set<String> s2, int k) {

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

}
