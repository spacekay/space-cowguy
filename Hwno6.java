package hw;

import java.util.Scanner;

public class Hwno6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 이상의 정수를 1개 입력해 주세요.");
		int n = sc.nextInt();
		char x;
		
		if (n%2 == 0) {
			x = '짝';
		} else {
			x = '홀';
		}
		
		System.out.println(x + "수입니다.");
		
		sc.close();
	}

}
