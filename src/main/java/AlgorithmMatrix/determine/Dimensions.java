package AlgorithmMatrix.determine;

import java.util.Scanner;

public class Dimensions {

	private int[] p = null;

	public Dimensions() {

	}

	public int[] determine_multiplication(int total_matrix) {

		p = new int[total_matrix + 1];

		System.out.println("Enter number of rows matrix 1");
		p[0] = getRowandColumn();
		for (int i = 0; i < total_matrix; i++) {
			System.out.println("Enter number of columns for matrix" + i);
			p[i + 1] = getRowandColumn();
		}

		return p;

	}

	private int getRowandColumn() {
		int r;
		Scanner in = new Scanner(System.in);
		r = in.nextInt();
		while (r < 0) {
			System.out.println("Please enter a positive value:");
			r = in.nextInt();
		}
		in.close();
		return r;

	}

}
