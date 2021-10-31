package backtracking0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BackTracking3 {
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
		DFS(0, result);
		bw.flush();
		bw.close();
	}
  // 4번 문제보다 Parameter를 더 단순하게 할 수 있다.
  // 다만 String += 연산이 속도가 느린 탓에 규모가 커지는 경우는 방문 배열을 사용하는 것이 좋을 것이다.
	public static void DFS(int level, String result) throws IOException {
		if(level==m) {
			bw.write(result+"\n");
		} else {
			if (level>0)
				result+=" ";
			for(int i=1;i<=n;i++) {
				DFS(level+1, result+Integer.toString(i));
			}
		}
	}
}
