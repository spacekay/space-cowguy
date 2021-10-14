import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 이런 저런 트릭으로 연산횟수를 최소화할 수 있음
// 컨디션 좋을 때 시도해 볼듯
public class DistributedProcessing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st =  new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long cases = 1;
			for(int j=0;j<b;j++) {
				// 단순 곱셈은 매우 빠를 수 있다.
				cases *= a;
				cases %= 10;
			}
			if(cases==0)
				cases=10;
			bw.write(cases+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
