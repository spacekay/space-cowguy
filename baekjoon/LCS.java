import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Longest Common 'Sequence' (더 어려움)
// 공통 부분이 중간중간 떨어져 나와도 다 확인해야 하므로 L*l 만큼의 탐색이 필요
public class LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		String P = br.readLine();
		br.close();
		int L = S.length();
		int l = P.length();
		int[][] table = new int[L+1][l+1];
		table[0][0]=0;
		// P에서 S의 i번째부터 시작하는 단어와 겹치는 경우를 기록함
		for(int i=1;i<=L;i++) {
			char s = S.charAt(i-1);
			for(int j=1;j<=l;j++) {
				char p = P.charAt(j-1);
				if(s==p) {
					// 둘 다 한 칸 전인 시점보다 길이가 하나 긴 것과 같음
					table[i][j] = table[i-1][j-1]+1;
				} else {
					// 현 시점 기준 누적된 수열 길이 중에 큰 쪽을 취함
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
			}
		}
		int max=0;
		for(int i=1;i<=L;i++) {
			max = Math.max(max, table[i][l]);
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
}
