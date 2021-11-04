import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Combination {
	// BigInteger class 활용법
	static BigInteger[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());		
		arr = new BigInteger[n+1];
		arr[0]=BigInteger.ONE;
		for(int i=1;i<n+1;i++) {
			arr[i]=BigInteger.ZERO;
		}
		bw.write(getCom(n,k)+"\n");
		bw.flush();
		bw.close();
	}
	public static BigInteger getCom(int n, int k) {
		if(!arr[k].equals(BigInteger.ZERO)) {
			return arr[k];
		} else if(!arr[n-k].equals(BigInteger.ZERO)) {
			arr[k]=arr[n-k];
			return arr[k];
		} else {
			arr[k] = getCom(n,k-1).multiply(BigInteger.valueOf(n-k+1)).divide(BigInteger.valueOf(k));
			return arr[k];
		}
	}
}
