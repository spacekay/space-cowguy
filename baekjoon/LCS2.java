import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS2 {
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
					if(table[i-1][j]>table[i][j-1]) {
						table[i][j] = table[i-1][j];
					} else {
						table[i][j] = table[i][j-1];
					}
				}
			}
		}
		bw.write(table[L][l]+"\n");
    // LC 조건 만족하는 Sequence 역추적
		StringBuilder sb = new StringBuilder();
		int j= l;
		for(int i=L;i>0;i--) {
			for(;j>0;j--) {
				// 같은 조건일 때는 이왕이면 더 윗줄(S 인덱스 한칸 앞)로 올라가기
				if(table[i][j]==table[i-1][j])
					break;
				// P에서 이번 인덱스는 겹치지 않음
				if(table[i][j]==table[i][j-1])
					continue;
				// 계속 한 칸 씩 앞으로 가면서 맨 앞에 기록 후 S의 인덱스도 바꿔줌
				sb.insert(0,P.charAt(--j));
				break;
			}
		}
		sb.append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
