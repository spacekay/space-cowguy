import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Multiply {
	static int a;
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		long result = getResult(b);
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
	public static long getResult(int b) {
		if(b==0) {
			return 1;
		} 
		long tmp = getResult(b/2);
		if(b%2==0){
			return tmp*tmp%c;
		} else {
			// long 범위조차 매 연산에서 쉽게 넘을 수 있음을 기억하자
			return (tmp*tmp%c)*a%c;
		}
	}
}
