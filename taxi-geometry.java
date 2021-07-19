package geometry;

import java.util.Scanner;

public class N3053 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		
		double r2 = Math.pow(r, 2);
		
		double A1 = Math.PI*r2;
		double A2 = 2*r2;
		
		System.out.printf("%f %f", A1, A2);
		
		sc.close();
	}
}
