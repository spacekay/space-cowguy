package hw;

import java.util.Scanner;

public class Hwno4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("1���� 30 ������ ���ڸ� �Է��Ͻÿ�.");
		int x = input.nextInt();
		
		if ( x > 0 && x <= 10) {
			System.out.println("1 ~ 10 ������ ���Դϴ�.");
		} else if (0 < x && x <= 20) {
			System.out.println("11 ~ 20 ������ ���Դϴ�.");
		} else if ( 0 < x && x <= 30) {
			System.out.println("21 ~ 30 ������ ���Դϴ�.");
		} else {
			System.out.println("�Է� ������ ��� ���Դϴ�.");
		}
		
		input.close();
	}

}
