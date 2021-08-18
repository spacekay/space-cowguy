import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Hashing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int L = Integer.parseInt(br.readLine());
		char[] string = new char[L];
		BigInteger H = BigInteger.ZERO;
		br.read(string);
		long forAdd = 1;
		for (int i = 0 ; i < L ; i++) {	
			// string[i]-'a'+1은 무슨 일이 있어도 1234567891을 초과할 수 없음
			BigInteger ADD = BigInteger.valueOf(((string[i]-'a'+1)*forAdd) % 1234567891);
			BigInteger MOD = BigInteger.valueOf(1234567891);
			H = H.add(ADD).remainder(MOD);
			if (forAdd*31 >= 1234567891) {			
				forAdd = (forAdd*31) % 1234567891;
			} else
				forAdd *= 31;
		}		
		sb.append(H);
		System.out.println(H);
		br.close();
	}
}
