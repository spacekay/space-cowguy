import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IntegerTriangle {
	static int n;
	static int[][] arr;
	static int[][] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0;j<i+1;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}	
		}
		br.close();
		sum = new int[n][n];
		// 초기화할 때 주의하기
		sum[0][0] = arr[0][0];
		if(n>1)
			sum[0][1] = arr[0][0];
    // 순수 재귀로 엄청나게 오래 걸릴 거 같다면 무조건 DP 활용
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					sum[i][j] = sum[i-1][j]+arr[i][j];
				} else if(j==i) {
					sum[i][j] = sum[i-1][j-1]+arr[i][j];
				} else {
					sum[i][j] = Math.max(sum[i-1][j]+arr[i][j], sum[i-1][j-1]+arr[i][j]);
				}
			}
		}
		int max=0;
		for(int i=0;i<n;i++) {
			if(max<sum[n-1][i])
				max=sum[n-1][i];
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
}
