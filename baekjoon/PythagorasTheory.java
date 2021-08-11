import java.util.Scanner;

public class PythagorasTheory {

	public static void main(String[] args) {
		
		int[] a = new int[3];
		int max = 0;
		int t;
		double sum = 0;
		int[] notmax = new int[2];
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			max=0;
			t=0;
			
			for (int i = 0 ; i < 3 ; i++) {
				a[i] = sc.nextInt();
				if (max < a[i]) {
					max = a[i];
				}
			}
			
			// 0, 0, 0일 때의 경우를 별도로 
      for (int i = 0 ; i < 3 ; i++) {
				if (max > a[i]) {
					notmax[t] = a[i];
					t++;
				} else if (a[i] == 0 && i > 0) {
					notmax[t] = a[i];
					t++;
				}
			}
			
			double max2 = Math.pow(max, 2);
			double notmax0 = Math.pow(notmax[0], 2);
			double notmax1 = Math.pow(notmax[1], 2);
			
			sum = max2 + notmax0 + notmax1;
			
			if (sum == 0)
				break;
			
			if (max2 == notmax0+notmax1) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
						
		};
		
		sc.close();
	}
}
