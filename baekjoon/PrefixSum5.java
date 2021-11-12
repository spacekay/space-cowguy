import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PrefixSum5 {
	static int[][] arr;
	static int[][] sum;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<n+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 디테일을 챙기는 연습도 필요하다. (2차원 DP + 구간합 연습)
		sum = new int[n+1][n+1];
		sum[1][1]=arr[1][1];
		for(int i=2;i<n+1;i++) {
			sum[1][i]=arr[1][i]+sum[1][i-1];
			sum[i][1]=arr[i][1]+sum[i-1][1];
		}

		for(int i=2;i<n+1;i++) {
			for(int j=2;j<n+1;j++) {
				if(sum[i][j]==0) {
					sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+arr[i][j];
				}
			}
		}

		int[] now = new int[4];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<4;j++) {
				now[j] = Integer.parseInt(st.nextToken());
			}
			bw.write(getSum(now)+"\n");
		}
		bw.flush();
		bw.close();
	}
	public static int getSum(int[] now) {
		int localSum = sum[now[2]][now[3]];
		localSum-=sum[now[2]][now[1]-1];
		localSum-=sum[now[0]-1][now[3]];
		localSum+=sum[now[0]-1][now[1]-1];
		return localSum;
	}
}
