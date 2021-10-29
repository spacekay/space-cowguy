import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Longest Increasing Subsequence : 가장 긴 증가하는 부분수열
public class LIS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] length = new int[n];
		// 각 인덱스마다 자신의 왼쪽에서 자기보다 작을 수 있는 케이스를 다 검색
		for(int j=0;j<n;j++) {
			// 자기 자신만 가능할 때
			length[j]=1;
			for(int i=0;i<j;i++) {
				if(arr[i]<arr[j]) {
					// 어떤 원소가 지금 원소보다 더 작을 때마다 수열의 길이는 왼쪽으로 1 길어질 수 있음.
					// 하지만 해당 원소를 포함할 때 길이가 더 짧아질 수 있으므로 Math.max를 지정해야 함
					length[j] = Math.max(length[j],length[i]+1);
				}
			}
		}
		int max=0;
		for(int one:length) {
			if(max<one)
				max=one;
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
}
