import java.util.*;

public class CroAlphabet {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String raw = sc.next();
		
		String[] croAl = new String[8];
		croAl[0] = "c=";
		croAl[1] = "c-";
		croAl[2] = "dz=";
		croAl[3] = "d-";
		croAl[4] = "lj";
		croAl[5] = "nj";
		croAl[6] = "s=";
		croAl[7] = "z=";
  
    // 차후 걸러내고자 하는 문자열의 종류가 늘어나더라도 쉽게 대치 가능하도록 
		for (int i = 0 ; i < 8 ; i++) {
			raw = raw.replace(croAl[i], "#");
		}
		
		System.out.println(raw.length());
	
		sc.close();
	}
}
