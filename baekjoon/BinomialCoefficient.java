import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int biCo = 1;
    
    // 모든 n값에 대해서 올바른 값을 얻을 수 있어야 한다. (특정 값 기준으로만 테스트 X)
		if (k > n/2) {
			k = n - k;
		}
		for (int i = 0 ; i < k ; i++) {
			biCo *= (n-i);
			biCo /= (i+1);
		}
		if (k > n) {
			biCo = 0;
		}
		sb.append(biCo);
		System.out.println(sb.toString());
		br.close();
	}
}
