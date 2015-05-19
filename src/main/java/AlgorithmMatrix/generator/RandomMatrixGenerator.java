package AlgorithmMatrix.generator;

import java.util.Random;

public class RandomMatrixGenerator {

	private Random random;

	public RandomMatrixGenerator() {
		random = new Random();
	}


	public int[] generate(int n) {
		int[] array = new int[n];

		for (int i = 0; i < n; i++)
			array[i] = random.nextInt();

		return array;
	}

}
