import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;

public class Fibonacci3 {
	static LinkedHashMap<Long,Long> map = new LinkedHashMap<>();
	static final int constant = 1000000;
	static long n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Long.parseLong(br.readLine());
		br.close();
		bw.write(getResult(n)+"\n");
		bw.flush();
		bw.close();
	}
	// 연산 과정에 자료형 범위를 넘어서면 최종 값이 달라진다.
	public static long getResult(long x) {
		if (x==0) {
			return 0;
		} else if(x==1||x==2) {
			return 1;
		} else if(map.containsKey(x)) {
			return map.get(x);
		} else {
			long dcn;
			// x= x/2+x/2
			long result1 = getResult(x/2-1);
			long result2 = getResult(x/2);
			long result3 = getResult(x/2+1);
			if(x%2==0) {
				dcn = ((result1*result2)%constant+(result2*result3)%constant)%constant;
			} else {
				// x=(x/2+1)+x/2=m+n
				dcn = ((result2*result2)%constant+(result3*result3)%constant)%constant;
			}
			map.put(x, dcn);
			return dcn;
		}
	}
}
