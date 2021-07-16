package hw;

import java.util.Scanner;

public class Hwno7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("자연수 하나를 입력해주세요.");
		long n = sc.nextLong();
		
		if (n%5 == 0) {
			System.out.println("5의 배수입니다.");
		} else {
			System.out.println("5의 배수가 아닙니다.");
		}
		
		sc.close();
	}
}
