package AlgorithmMatrix.MultiplyTest;

import java.util.Random;
import java.util.Scanner;

import AlgorithmMatrix.AlgorithmMatrixMultiplication.MultiplyAlgorithm;
import AlgorithmMatrix.AlgorithmMatrixMultiplication.MultiplyDynamic;
import AlgorithmMatrix.determine.Dimensions;

public class MultiplyRun {

	public static void main(String[] args) {
		final int NUM_OF_ITERATIONS = 5;
		int total;
		Scanner in = new Scanner(System.in);

		System.out.print("Number or matrices: Random or Manual?Random=Yes");
		String input = in.nextLine();

		if (input.equalsIgnoreCase("Yes")) {
			Random r = new Random();
			total = r.nextInt(5) + NUM_OF_ITERATIONS;
			System.out.println("Multiply "+total+" matrices");
		} else {
			System.out.println("How many matrices would you like to multiply?");
			total = in.nextInt();
		}

		Dimensions d = new Dimensions();
		MultiplyAlgorithm dynamic = new MultiplyDynamic();
		dynamic.multiply(d.determine_multiplication(total));

		System.out.println("Optimal Parenthesization");
		System.out.println(dynamic.toString());

		System.out.println("Minimum multiplication cost");
		System.out.println(dynamic.getNumberOfMultiplication());

	}

}
