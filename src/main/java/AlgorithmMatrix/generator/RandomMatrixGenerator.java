package AlgorithmMatrix.generator;

import java.util.Random;

public class RandomMatrixGenerator {

	private static final int BOUND = 1000;

	private Random random;

	public RandomMatrixGenerator() {
		random = new Random();
	}

	public int[][] generate(int m, int n) {
		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = random.nextInt(BOUND);

		return matrix;
	}
}
