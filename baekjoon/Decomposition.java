import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Decomposition {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = br.readLine();
		int n = Integer.parseInt(N);
		boolean flag = false;
		int M;
		int m;
		int sum;
		for (m = 1 ; m < n ; m++) {
			M = m;
			sum = M;
      // casting은 최소화하는 것이 가장 빠르다.
			while (M > 0) {
				sum += (M%10);
				M /= 10;
			}
			if (sum == n) {
				flag = true;
				break;
			}
		}	
		if (flag) {
			bw.write(m+"\n");
		} else {
			bw.write("0\n");
		}		
		bw.flush();
		bw.close();
		br.close();
	}
}
