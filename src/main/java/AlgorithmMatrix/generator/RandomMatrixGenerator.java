package AlgorithmMatrix.generator;

import java.util.Random;

public class RandomMatrixGenerator {

	private static final int BOUND = 20;

	private Random random;

	public RandomMatrixGenerator() {
		random = new Random();
	}

	public long[][] generate(int m, int n) {
		long[][] matrix = new long[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = random.nextInt(BOUND);

		return matrix;
	}
}
