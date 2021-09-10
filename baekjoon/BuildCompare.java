import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BuildCompare {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] ppl = new int[n][2];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			ppl[i][0] = Integer.parseInt(st.nextToken());
			ppl[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		int t;
		for(int i=0;i<n;i++) {
			t = 1;
			for(int j=0;j<n;j++) {
				if(ppl[i][0]<ppl[j][0] && ppl[i][1]<ppl[j][1]) {
					t++;
				}
			}
			bw.write(t+" ");
		}	
		bw.flush();
		bw.close();
	}
}
