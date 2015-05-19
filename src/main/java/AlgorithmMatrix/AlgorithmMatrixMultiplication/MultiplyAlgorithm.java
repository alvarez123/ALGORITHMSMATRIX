package AlgorithmMatrix.AlgorithmMatrixMultiplication;

import java.util.ArrayList;

public interface MultiplyAlgorithm {
	
	public int[][] multiply(ArrayList<int[][]> matrices, int[] array);
	public int getNumberOfMultiplication();
	public long getRuntimeMilliseconds();

}
