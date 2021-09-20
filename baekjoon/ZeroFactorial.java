import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ZeroFactorial {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		br.close();
		int t=0;
		for(int i=1;i<=n;i++) {
			int k=i;
			// 팩토리얼을 만드는 과정에서 보통 2는 충분히 곱해져 있다. 짝수는 전체 수의 절반이기 때문이다.
			// 그러나 5의 배수가 더 드물기 때문에 5의 배수가 등장하는 만큼 0의 수가 증가하는 것을 고려하면 된다.
			if(k%125==0) {
				k/=125;
				t+=3;
			} else if (k%25==0) {
				k/=25;
				t+=2;
			} else if (k%5==0) {
				k/=5;
				t++;
			}
		}
		bw.write(t+"\n");
		bw.flush();
		bw.close();
	}
}
