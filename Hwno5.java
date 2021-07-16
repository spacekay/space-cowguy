package hw;

import java.util.Scanner;

public class Hwno5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = input.nextLine();
		
		System.out.print("나이 : ");
		int age = input.nextInt();
		String nulls = input.nextLine();
		// enter로도 값을 넣을 수 있도록 정리함
		
		System.out.print("주소 : ");
		String addr = input.nextLine();
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + addr+nulls);
		
		input.close();
	}
}
