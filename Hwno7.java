package hw;

import java.util.Scanner;

public class Hwno7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ڿ��� �ϳ��� �Է����ּ���.");
		long n = sc.nextLong();
		
		if (n%5 == 0) {
			System.out.println("5�� ����Դϴ�.");
		} else {
			System.out.println("5�� ����� �ƴմϴ�.");
		}
		
		sc.close();
	}
}
