import java.util.Scanner;

public class DialTime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int l = a.length();
		int t = 0;
		
		for (int i = 0 ; i < l ; i++) {
			t += 2;
			switch(a.charAt(i)) {
			case 'A' : case 'B' : case 'C' :
				t += 1;
				break;
			case 'D' : case 'E' : case 'F' :
				t += 2;
				break;
			case 'G' : case 'H' : case 'I' :
				t += 3;
				break;
			case 'J' : case 'K' : case 'L' :
				t += 4;
				break;
			case 'M' : case 'N' : case 'O' :
				t += 5;
				break;
			case 'P' : case 'Q' : case 'R' : case 'S' : 
				t += 6;
				break;
			case 'T' : case 'U' : case 'V' :
				t += 7;
				break;
			case 'W' : case 'X' : case 'Y' : case 'Z' :
				t += 8;
				break;
			}
		}
		
		System.out.println(t);
		
		sc.close();
	}
}
