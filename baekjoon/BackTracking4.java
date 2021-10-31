package backtracking0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BackTracking4 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		br.close();
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		String result="";
		DFS(1, 0, result);
		bw.flush();
		bw.close();
	}
  // 비교적 조건이 쉬운 문제였음 (방문처리 최소화하되, 이후 탐색하는 숫자들이 앞 숫자보다 크거나 같으면 됨)
	public static void DFS(int a, int level, String result) throws IOException {
		if(level==m) {
			bw.write(result+"\n");
		} else {
			if (level>0)
				result+=" ";
			for(int i=a;i<=n;i++) {
				DFS(i, level+1, result+Integer.toString(i));
			}
		}
	}
}
