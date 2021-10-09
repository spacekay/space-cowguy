import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Bufferwriter || StringBuilder || StringTokenizer || .split 활용 시 처리시간 비교 연습
public class PrefixSum11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		long[] sums = new long[n];
		long sum=0;
		st = new StringTokenizer(br.readLine()," ");
    // 반복문 한 번씩만 돌도록 설계. 중첩 반복문은 불가피할 때만 사용
		for(int i=0;i<n;i++) {
			sum+=Long.parseLong(st.nextToken());
			sums[i]=sum;
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(a!=0)
				sb.append((sums[b]-sums[a-1])+"\n");
			else
				sb.append(sums[b]+"\n");
		}	
		br.close();
		System.out.println(sb.toString());
	}
}
