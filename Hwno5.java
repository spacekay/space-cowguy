package hw;

import java.util.Scanner;

public class Hwno5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = input.nextLine();
		
		System.out.print("���� : ");
		int age = input.nextInt();
		String nulls = input.nextLine();
		// enter�ε� ���� ���� �� �ֵ��� ������
		
		System.out.print("�ּ� : ");
		String addr = input.nextLine();
		
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("�ּ� : " + addr+nulls);
		
		input.close();
	}
}
