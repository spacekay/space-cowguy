package hw;

import java.util.Scanner;

public class Hwno4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("1에서 30 사이의 숫자를 입력하시오.");
		int x = input.nextInt();
		
		if ( x > 0 && x <= 10) {
			System.out.println("1 ~ 10 사이의 수입니다.");
		} else if (0 < x && x <= 20) {
			System.out.println("11 ~ 20 사이의 수입니다.");
		} else if ( 0 < x && x <= 30) {
			System.out.println("21 ~ 30 사이의 수입니다.");
		} else {
			System.out.println("입력 범위를 벗어난 수입니다.");
		}
		
		input.close();
	}

}
