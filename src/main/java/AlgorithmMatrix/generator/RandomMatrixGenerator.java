package AlgorithmMatrix.generator;

import java.util.Random;

public class RandomMatrixGenerator {

	private Random random;
	private static final int NUM_OF_ITERATIONS=5;

	public RandomMatrixGenerator() {
		random = new Random();
	}


	public int[] generate(int n) {
		int[] array = new int[n+1];

		array[0]=random.nextInt(95)+NUM_OF_ITERATIONS;
		for (int i = 0; i < n; i++)
			array[i+1] = random.nextInt(95)+NUM_OF_ITERATIONS;

		return array;
	}

}
