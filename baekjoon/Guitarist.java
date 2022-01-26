import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Guitarist {
	static int max = -2;
	static int[] v;
	static int[][] nows;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		v = new int[n];
		nows = new int[n+1][m+1];
    // -2 : 미방문, -1 : 불가능
		Arrays.fill(nows[0], -2);
		for(int i=0;i<n;i++) {
			v[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(nows[i+1], -2);
		}
		br.close();

		bw.write(maxVolume(s,0)+"\n");
		bw.flush();
		bw.close();
	}
	static int maxVolume(int now, int order) {
		if(nows[order][now]>-2) {
			return nows[order][now];
		} else if(order==n) {
      // 마지막 곡에서의 볼륨
			return now;
		} else {
			int plus = now+v[order];
			int minus = now-v[order];
			int tmp = -2;
			if(plus>m && minus<0) {
        // 방법을 찾을 수 없음
				nows[order][now] = -1;
			} else {
				if(plus<=m) {
					nows[order][now] = maxVolume(plus, order+1);
				}
				if(minus>=0) {
					tmp = maxVolume(minus, order+1);
				}
				nows[order][now] = Math.max(nows[order][now], tmp);
			}
			return nows[order][now];
		}
	}
}
