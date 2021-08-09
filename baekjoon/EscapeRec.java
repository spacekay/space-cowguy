import java.util.Scanner;

public class EscapeRec {

	public static void main(String[] args) {
		int x, y, w, h;
		try (Scanner sc = new Scanner(System.in)) {
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		}
		
		if ((w-x) >= x && (h-y) >= y) {
			if (x > y)
				System.out.println(y);
			else
				System.out.println(x);
		}
		else if ((w-x) < x && (h-y) >= y) {
			if ((w-x) > y)
				System.out.println(y);
			else
				System.out.println(w-x);
		}	
		else if ((w-x) < x && (h-y) < y) {
			if ((w-x) > (h-y))
				System.out.println(h-y);
			else
				System.out.println(w-x);
		}
		else {
			if (x > (h-y))
				System.out.println(h-y);
			else
				System.out.println(x);
		}
	}
}
