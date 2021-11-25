import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 비슷한 문제들 복습하자
public class NQueen {
	static int n;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		br.close();	
		for(int i=1;i<=n;i++) {
			int[] board = new int[n+1];
			// 1행에는 i열에 퀸이 놓여있음
			board[1] = i;
			findQueen(1, board);
		}
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
	}
  
	public static void findQueen(int level, int[] board) {
		if(level==n) {
			cnt++;		
			return;
		} else {
			// 다음 열은 어디일지 아직 모름!
			for(int i=1;i<=n;i++) {
				board[level+1] = i;
				if(check(level+1, board)) {
					findQueen(level+1, board);
				}
			}
		}
	}

	public static boolean check(int level, int[] board) {
		// 내가 오기 전 열까지만 검색
		for(int j=1;j<level;j++) {
			// 같은 열에 하나 더 있는 경우 (fail)
			if(board[j]==board[level]) {
				return false;
				// 행 사이 차이의 절대값 == 열 사이 차이의 절대값 -> 대각선 방향
			} else if (Math.abs(j-level)==Math.abs(board[j]-board[level])) {
				return false;
			}
		}
		return true;
	}
}
