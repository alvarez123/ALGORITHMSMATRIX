package algorithms.matrixchainproblem.AlgorithmMatrixMultiplication;


public class MultiplyDynamic {

	private int[][] m;
	private int[][] s;
	private int n;

	public int[][] getM() {
		return m;
	}

	public int[][] getS() {
		return s;
	}

	public int matrixChainOrder(int[] p) {

		n = p.length - 1;
		m = new int[n + 1][n + 1];
		s = new int[n + 1][n + 1];
		
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
		return getNumberOfMultiplications();
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

	public int getNumberOfMultiplications() {
		return m[1][n];
	}

}
