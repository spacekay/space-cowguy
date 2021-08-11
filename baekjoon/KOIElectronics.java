import java.util.Scanner;

public class KOIElectronics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[5];
		int calculNum = 0;
		
		for (int i = 0 ; i < 5 ; i++) {
			nums[i] = sc.nextInt();
			calculNum += nums[i]*nums[i];
		}
		
		int finalNum = calculNum%10;
		
		System.out.println(finalNum);
		
		sc.close();
	}
}
