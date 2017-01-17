package apriori;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeSet;

public class AprioriAlgorithmTest {

	public static void main(String[] args) throws FileNotFoundException {

		Database database = new Database("in/categories.txt");
		AprioriAlgorithm aprioriAlgorithm = new AprioriAlgorithm(database, 0.4);
		Set<String> frequentOneItemsets = aprioriAlgorithm.getFrequentOneItemsets();

//		Set<String> chos = new TreeSet<String>();
//		
//		chos.add("kir");
//		chos.add("choskos1");
//		chos.add("choskos2");
//		
//		Set<String> kos = new TreeSet<String>();
//		kos.add("choskos1");
//		kos.add("kos");
//		kos.add("choskos2");
//		Set<String> choskos = AprioriAlgorithm.join(chos, kos);
//		for (String string : choskos)
//			System.out.print(string + " ");
		aprioriAlgorithm.setK(2);
		Set<String> result = aprioriAlgorithm.join(frequentOneItemsets, frequentOneItemsets);
		System.out.println(result);
		System.out.println("ay " + result.size());
		
	}

}