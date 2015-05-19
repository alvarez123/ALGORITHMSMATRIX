package AlgorithmMatrix.multiplier;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixMultiplierTest {

	private final int[][] m1 = { { 0, 1, 3, 5, 1, 9, 2 },
			{ 1, 9, 33, 25, 14, 19, 2 }, { 68, 112, 31, 15, 145, 19, 23 },
			{ 0, 1, 23, 5, 1, 9, 2 }, { 31, 1, 33, 5, 1, 9, 2 },
			{ 51, 1, 3, 5, 1, 9, 2 }, { 89, 2, 15, 79, 23, 22, 90 },
			{ 0, 1, 35, 5, 1, 9, 2 }, { 89, 12, 15, 79, 23, 22, 90 },
			{ 829, 23, 15, 79, 23, 22, 90 }, { 389, 2, 15, 79, 236, 22, 90 },
			{ 839, 31, 15, 79, 23, 22, 90 }, { 879, 2, 15, 79, 23, 22, 90 },
			{ 189, 2, 15, 79, 23, 22, 90 }, { 893, 32, 15, 729, 23, 22, 90 } };

	private final int[][] m2 = { { 1, 2, 3 }, { 3, 2, 3 }, { 6, 22, 36 },
			{ 3, 4, 5 }, { 8, 12, 13 }, { 5, 15, 25 }, { 12, 23, 532 } };

	private final int[][] result = { { 113, 281, 1438 }, { 532, 1345, 3064 },
			{ 2166, 3656, 16327 }, { 233, 721, 2158 }, { 324, 1003, 2611 },
			{ 164, 383, 1591 }, { 1796, 3504, 49937 }, { 305, 985, 2590 },
			{ 1826, 3524, 49967 }, { 2599, 5026, 52220 },
			{ 3800, 6660, 53606 }, { 2633, 5062, 52274 },
			{ 2586, 5084, 52307 }, { 1896, 3704, 50237 }, { 4640, 7772, 55689 } };
	
	@Test
	public void multiplyTwoMatricesTest() throws Exception {
		assertArrayEquals(result, new MatrixMultiplier().multiplyTwoMatrices(m1, m2));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void multiplyTwoMatricesTest2() throws Exception {
		new MatrixMultiplier().multiplyTwoMatrices(m2, m1);
	}
}
