//package AlgorithmMatrix.MultiplyTest;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Random;
//import java.util.Scanner;
//
//import algorithms.matrixchainproblem.AlgorithmMatrixMultiplication.MultiplyDynamic;
//import algorithms.matrixchainproblem.determine.Dimensions;
//import algorithms.matrixchainproblem.generator.RandomDimensionGenerator;
//import algorithms.matrixchainproblem.generator.RandomMatrixGenerator;
//import AlgorithmMatrix.multiplier.MatrixMultiplier;
//
//public class MultiplyRun {
//
//	private static final String resultsFileName = "results.txt";
//	private static final String statisticsFileName = "runtime_statistics.txt";
//
//	public static void main(String[] args) {
//		final int NUM_OF_ITERATIONS = 3;
//		int total;
//		Random r = new Random();
//		Scanner in = new Scanner(System.in);
//
//		System.out.println("Number of matrices: Random or Manual?Random=Yes");
//		String input = in.nextLine();
//		
//		if (input.equalsIgnoreCase("Yes")) {
//			total = r.nextInt(5) + NUM_OF_ITERATIONS;
//			System.out.println("Multiply " + total + " matrices");
//		} else {
//			System.out.println("How many matrices would you like to multiply?");
//			total = in.nextInt();
//			in.nextLine();
//		}
//
//		int p[] = new int[total + 1];
//
//		System.out
//				.println("Dimension of Matrices: Random or Manual?Random=Yes");
//
//		input = in.nextLine();
//
//		if (input.equalsIgnoreCase("Yes")) {
//			RandomDimensionGenerator generator = new RandomDimensionGenerator();
//			p = generator.generate(total);
//		} else {
//			Dimensions d = new Dimensions();
//			p = d.determine_multiplication(total);
//		}
//
//		matrixwithDimension(p, total);
//		ArrayList<long[][]> matrixlist = matrixlist(p);
//
//		MatrixMultiplier bruteforce = new MatrixMultiplier();
//		bruteforce.multiplyMatrices(matrixlist);
//
//		System.out.println("\nBRUTE FORCE");
//		System.out.println("Brute force number of multiplication:"
//				+ bruteforce.getNumberOfMultiplications());
//		System.out.println("Brute force Run time:"
//				+ bruteforce.getTotalRuntimeMilliseconds());
//
//		System.out.println("\nDYNAMIC");
//		MultiplyDynamic dynamic = new MultiplyDynamic();
//		long[][] result = dynamic.multiply(matrixlist, p);
//
//		System.out.println("Optimal Parenthesization");
//		System.out.println(dynamic.toString());
//
//		System.out.println("Minimum multiplication cost");
//		System.out.println(dynamic.getNumberOfMultiplication());
//		System.out.println("Dynamic Run time:"
//				+ dynamic.getRuntimeMilliseconds());
//
//		in.close();
//		BufferedWriter writer = null;
//		try {
//			writer = new BufferedWriter(new FileWriter(
//					new File(resultsFileName)));
//			writer.write("Input Matrices:");
//			writer.newLine();
//			for (int i = 0; i < matrixlist.size(); i++) {
//				writer.write("A" + (i + 1) + ": ");
//				writer.newLine();
//				long[][] currentArray = matrixlist.get(i);
//				for (long[] arr : currentArray) {
//					writer.write(Arrays.toString(arr));
//					writer.newLine();
//					writer.newLine();
//				}
//				writer.newLine();
//				writer.newLine();
//			}
//			writer.write("Output Matrix:");
//			writer.newLine();
//			for (long[] arr : result) {
//				writer.write(Arrays.toString(arr));
//				writer.newLine();
//				writer.newLine();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//
//			if (writer != null)
//				try {
//					writer.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		}
//
//		try {
//			writer = new BufferedWriter(new FileWriter(new File(
//					statisticsFileName)));
//			writer.write("Matrix sizes: ");
//			for (int i = 0; i < matrixlist.size(); i++) {
//				long[][] currMatrix = matrixlist.get(i);
//				writer.write(String.format("A%d %d x %d; ", i + 1,
//						currMatrix.length, currMatrix[0].length));
//			}
//			int[][] s = dynamic.getS();
//			int[][] m = dynamic.getM();
//			writer.newLine();
//			writer.newLine();
//			writer.write("In Order Multiplication");
//			writer.newLine();
//			writer.write("Number of multiplication: "
//					+ bruteforce.getNumberOfMultiplications());
//			writer.newLine();
//			writer.write("Run time (nanosec): "
//					+ bruteforce.getTotalRuntimeMilliseconds());
//			writer.newLine();
//			writer.newLine();
//			writer.write("Multiplication with Dynamic Programming");
//			writer.newLine();
//			writer.write("Table for dynamic programming");
//			// Table for dynamic programming
//			writer.newLine();
//			writer.write("M matrice:");
//			writer.newLine();
//			for (int[] arr : m) {
//				writer.write(Arrays.toString(arr));
//				writer.newLine();
//				writer.newLine();
//			}
//			writer.write("S matrice:");
//			writer.newLine();
//			for (int[] arr : s) {
//				writer.write(Arrays.toString(arr));
//				writer.newLine();
//				writer.newLine();
//			}
//			writer.write("Matrices with paranthesis: " + dynamic.toString());
//			writer.newLine();
//			writer.write("Number of multiplication: "
//					+ dynamic.getNumberOfMultiplication());
//			writer.newLine();
//			writer.write("Run time (nanosec): "
//					+ dynamic.getRuntimeMilliseconds());
//			writer.newLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (writer != null)
//				try {
//					writer.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
//	}
//
//	public static void matrixwithDimension(int[] p, int total_matrices) {
//		System.out.print("[" + p[0] + "]");
//		for (int i = 1; i < total_matrices + 1; i++) {
//			System.out.print("[" + p[i] + "]");
//			if (i < total_matrices)
//				System.out.print("x[" + p[i] + "]");
//		}
//	}
//
//	public static ArrayList<long[][]> matrixlist(int[] dimensions) {
//
//		RandomMatrixGenerator generator = new RandomMatrixGenerator();
//		ArrayList<long[][]> matrixlist = new ArrayList<long[][]>();
//
//		for (int i = 0; i < dimensions.length - 1; i++) {
//			long[][] matrix = generator.generate(dimensions[i],
//					dimensions[i + 1]);
//			matrixlist.add(matrix);
//		}
//
//		return matrixlist;
//	}
//
//}
