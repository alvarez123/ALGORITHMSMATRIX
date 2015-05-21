package algorithms.matrixchainproblem.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import algorithms.matrixchainproblem.AlgorithmMatrixMultiplication.MultiplyDynamic;
import algorithms.matrixchainproblem.generator.RandomDimensionGenerator;

public class Main {
	
	private static final String outputFileName = "output.txt";
	private static final int MINIMUM_NUMBER_OF_MATRICES = 5;
	private static final Random random = new Random();
	
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of matrices [0 for random]: ");
		int numberOfMatrices = in.nextInt();
		in.nextLine();
		if(numberOfMatrices == 0) {
			numberOfMatrices = random.nextInt(96) + MINIMUM_NUMBER_OF_MATRICES; 
			System.out.println("Number of matrices: " + numberOfMatrices);
		}
		
		int[] p = new int[numberOfMatrices + 1];
		System.out.println("Should the dimensions of the matrices generated randomly? [y/n]: ");
		
		if(Character.toLowerCase(in.nextLine().charAt(0)) == 'y')
			p = new RandomDimensionGenerator().generate(numberOfMatrices);
		else {
			System.out.println("Row number of A1: ");
			p[0] = Integer.parseInt(in.nextLine());
			for(int i = 1; i < numberOfMatrices + 1; i++){
				System.out.println(String.format("Column number of A%d: ", i));
				p[i] = Integer.parseInt(in.nextLine());
			}
		}
		
		in.close();
		final String sizes = matrixSizesToString(p);
		System.out.println(sizes);
		final long inOrderMultiplicationNumOfMults = getTotalNumberOfMultiplications(p);
		System.out.println(String.format("\nIn-order multiplication\nNumber of multiplications: %d", inOrderMultiplicationNumOfMults));
		final MultiplyDynamic matrixChainMultiplication = new MultiplyDynamic();
		long orderedMultiplicationNumOfMults = matrixChainMultiplication.matrixChainOrder(p);
		final String optimalParanthesis = matrixChainMultiplication.toString();
		System.out.println(String.format("\nMultiplication with Dynamic Programming\nMatrices with paranthesis: %s\nNumber of multiplications: %d", optimalParanthesis, orderedMultiplicationNumOfMults));
		
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outputFileName))));
			writer.write(sizes);
			writer.newLine();
			writer.newLine();
			writer.write("In-order multiplication");
			writer.newLine();
			writer.write(String.format("Number of multiplications: %d", inOrderMultiplicationNumOfMults));
			writer.newLine();
			writer.newLine();
			writer.write("Multiplication with Dynamic Programming");
			writer.newLine();
			writer.write("M matrix: ");
			writer.newLine();
			int[][] temp = matrixChainMultiplication.getM();
			for(int[] arr : temp){
				writer.write(Arrays.toString(arr));
				writer.newLine();
			}
			writer.newLine();
			temp = matrixChainMultiplication.getS();
			writer.write("S matrix: ");
			writer.newLine();
			for(int[] arr : temp){
				writer.write(Arrays.toString(arr));
				writer.newLine();
			}
			writer.newLine();
			writer.write("Matrices with paranthesis: " + optimalParanthesis);
			writer.newLine();
			writer.write(String.format("Number of multiplications: %d", orderedMultiplicationNumOfMults));
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			if(writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	private static String matrixSizesToString(int[]p) {
		String out = "Matrix sizes: ";
		for(int i = 0; i < p.length - 1; i++){
			out += String.format("A%d %dx%d; ", i + 1, p[i], p[i + 1]);
		}
		return out;
	}
	
	private static long getTotalNumberOfMultiplications(int[] p) {
		long result = 0;
		int row = p[0], column = p[1];
		for(int i = 2; i < p.length; i++){
			result += row * column * p[i];
			column = p[i];
		}
		return result;
	}
}
