package seattle.algostar.ps.acmicpc.dp;

import org.junit.Test;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class CombinatorTest {
	int n;
	int[] A;
	boolean[] used;

	@Test
	public void test() {

		// Create the initial vector of 3 elements (apple, orange, cherry)
		ICombinatoricsVector<String> originalVector = Factory.createVector(new String[] {"1", "2", "3"});

		// Create the permutation generator by calling the appropriate method in
		// the Factory class
		Generator<String> gen = Factory.createPermutationGenerator(originalVector);

		// Print the result
		for (ICombinatoricsVector<String> perm : gen)
			System.out.println(perm);
	}
}
