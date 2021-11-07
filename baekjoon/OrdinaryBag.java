import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OrdinaryBag {
	static int[][] value;
	static int[][] bag;
	static int k;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bag = new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// 물건이 0개일 때부터 따로 index를 부여하여야 함
		value = new int[n+1][k+1];	
		for(int i=1;i<n+1;i++) {
			for(int j=0;j<k+1;j++) {
				if(j-bag[i-1][0]>=0) {
					value[i][j] = Math.max(value[i-1][j-bag[i-1][0]]+bag[i-1][1], value[i-1][j]);
				} else {
					value[i][j] = value[i-1][j];
				}
			}
		}
		bw.write(value[n][k]+"\n");
		bw.flush();
		bw.close();
	}
}
