package AlgorithmMatrix.AlgorithmMatrixMultiplication;

import java.util.ArrayList;

import AlgorithmMatrix.multiplier.MatrixMultiplier;

public class MultiplyDynamic {

	private int[][] m;
	private int[][] s;
	private int n;
	private MatrixMultiplier mu;
	private long totalRuntimeMilliseconds;

	public MultiplyDynamic() {
		mu=new MatrixMultiplier();
		totalRuntimeMilliseconds=0;
	}

	public int[][] multiply(ArrayList<int[][]> matrices, int[] p) {
		long startTime = System.currentTimeMillis();
		n = p.length - 1;
		m = new int[n + 1][n + 1];
		s = new int[n + 1][n + 1];
		matrixChainOrder(p);
		int result[][]= multiplication(matrices, 1, n);
		totalRuntimeMilliseconds = System.currentTimeMillis() - startTime;
		return result;
	}

	private void matrixChainOrder(int[] p) {

		for (int i = 1; i <= n; i++)
			m[i][i] = 0;

		for (int l = 2; l <= n; l++) {
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;

				for (int k = i; k < j; k++) {
					int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
	}

	private int[][] multiplication(ArrayList<int[][]> matrices, int i, int j) {
		if (i < j) {
			int[][] C = multiplication(matrices, i, s[i][j]);
			int[][] D = multiplication(matrices, s[i][j] + 1, j);
			return mu.multiplyTwoMatrices(C, D);
		} else
			return matrices.get(i-1);

	}

	private String printOptimalParens(int i, int j) {
		if (i == j)
			return "A[" + i + "]";
		else
			return "(" + printOptimalParens(i, s[i][j])
					+ printOptimalParens(s[i][j] + 1, j) + ")";
	}

	public String toString() {
		return printOptimalParens(1, n);
	}

	public int getNumberOfMultiplication() {
		return m[1][n];
	}
	
	public long getRuntimeMilliseconds() {
		return totalRuntimeMilliseconds;
	}

}
