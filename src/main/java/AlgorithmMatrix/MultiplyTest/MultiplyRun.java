package AlgorithmMatrix.MultiplyTest;

import java.util.Random;
import java.util.Scanner;

import AlgorithmMatrix.AlgorithmMatrixMultiplication.MultiplyAlgorithm;
import AlgorithmMatrix.AlgorithmMatrixMultiplication.MultiplyDynamic;
import AlgorithmMatrix.determine.Dimensions;
import AlgorithmMatrix.generator.RandomDimensionGenerator;

public class MultiplyRun {

	public static void main(String[] args) {
		final int NUM_OF_ITERATIONS = 5;
		int total;
		Random r = new Random();
		Scanner in = new Scanner(System.in);

		System.out.println("Number of matrices: Random or Manual?Random=Yes");
		String input = in.nextLine();

		if (input.equalsIgnoreCase("Yes")) {
			total = r.nextInt(5) + NUM_OF_ITERATIONS;
			System.out.println("Multiply " + total + " matrices");
		} else {
			System.out.println("How many matrices would you like to multiply?");
			total = in.nextInt();
		}

		int p[] = new int[total + 1];

		System.out
				.println("Dimension of Matrices: Random or Manual?Random=Yes");
		input = in.nextLine();

		if (input.equalsIgnoreCase("Yes")) {
			RandomDimensionGenerator generator = new RandomDimensionGenerator();
			p = generator.generate(total);
		} else {
			Dimensions d = new Dimensions();
			p = d.determine_multiplication(total);
		}
		
		
		matrixwithDimension(p, total);

		MultiplyAlgorithm dynamic = new MultiplyDynamic();
		dynamic.multiply(p);

		System.out.println("\nOptimal Parenthesization");
		System.out.println(dynamic.toString());

		System.out.println("Minimum multiplication cost");
		System.out.println(dynamic.getNumberOfMultiplication());

	}
	
	public static void matrixwithDimension(int []p,int total_matrices)
	{
		System.out.print("[" + p[0] + "]");
		for(int i=1;i<total_matrices+1;i++)
		{
			System.out.print("[" + p[i] + "]");
			if(i<total_matrices)
				System.out.print("x[" + p[i] + "]");
		}
	}

}
