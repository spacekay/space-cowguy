package hw;

import java.util.Scanner;

public class Hwno6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 �̻��� ������ 1�� �Է��� �ּ���.");
		int n = sc.nextInt();
		char x;
		
		if (n%2 == 0) {
			x = '¦';
		} else {
			x = 'Ȧ';
		}
		
		System.out.println(x + "���Դϴ�.");
		
		sc.close();
	}

}
