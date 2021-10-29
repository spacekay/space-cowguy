import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RGBDistance {
	static int[][] arr;
	static int n;
	static int[][] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		sum = new int[n][3];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		br.close();
		sum[0][0] = arr[0][0];
		sum[0][1] = arr[0][1];
		sum[0][2] = arr[0][2];
		// 인덱스가 0부터 시작하므로 끝은 n-1. 만약 n을 끝 인덱스로 하려고 했다면 그냥 n 적었어도 될 것이다.
		bw.write(Math.min(getSum(n-1,0),Math.min(getSum(n-1,1), getSum(n-1,2)))+"\n");
		bw.flush();
		bw.close();
	}
	public static int getSum(int now, int c) {
		// red : 0, green : 1, blue : 2		
		if(sum[now][c]==0) {
			// 한 칸 씩 뒤로 들어가다가 첫번째 칸에 도달하면 멈춘다.
			// 색의 종류가 더 많은 경우 반복문으로 처리 (i!=c)
			if(c==0) {
				sum[now][0] =arr[now][0]+Math.min(getSum(now-1, 1), getSum(now-1, 2));
			} else if(c==1) {
				sum[now][1] =arr[now][1]+Math.min(getSum(now-1, 0), getSum(now-1, 2));
			} else if(c==2) {
				sum[now][2] =arr[now][2]+Math.min(getSum(now-1, 1), getSum(now-1, 0));
			}
		}
		return sum[now][c];
	}
}
