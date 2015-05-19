package AlgorithmMatrix.multiplier;

import java.util.ArrayList;

public class MatrixMultiplier {
	private long totalRuntimeMilliseconds;
	private int numberOfMultiplications;
	
	public MatrixMultiplier() {
		reset();
	}
	
	private void reset(){
		totalRuntimeMilliseconds = 0L;
		numberOfMultiplications = 0;
	}
	
	public long[][] multiplyMatrices(ArrayList<long[][]> matrices) {
		reset();
		long startTime = System.nanoTime();
		long[][] result = multiplyTwoMatrices(matrices.get(0), matrices.get(1));
		for(int i = 2; i < matrices.size() - 1; i++)
			result = multiplyTwoMatrices(result, matrices.get(i));
		totalRuntimeMilliseconds = System.nanoTime() - startTime;
		return result;
	}
	
	 public long[][] multiplyTwoMatrices(long[][] matrix1, long[][] matrix2){
		if(matrix1[0].length != matrix2.length)
			throw new IllegalArgumentException("Column size of first matrix must be equal to row size of second matrix.");
		int m = matrix1.length, n = matrix1[0].length, k = matrix2[0].length; //matrix1 -> MxN, matrix2 -> NxK
		long[][] result = new long[m][k];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < k; j++){
				result[i][j] = 0;
				for(int t = 0; t < n; t++){
					result[i][j] += matrix1[i][t] * matrix2[t][j];
					numberOfMultiplications++;
				}
			}
		}
		
		return result;
	}
	
	public long getTotalRuntimeMilliseconds() {
		return totalRuntimeMilliseconds;
	}

	public int getNumberOfMultiplications() {
		return numberOfMultiplications;
	}

}
