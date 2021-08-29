import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ChessBoardPaint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] count = new boolean[n][m];
		char[][] board = new char[n][m];
		String line = "";
		for (int i = 0 ; i < n ; i++) {
			line = br.readLine();
			for (int j = 0 ; j < m ; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
    // 보드 전체의 연결 정보를 한 번 기록하는 차원
		count[0][0] = true;
    for (int i = 1 ; i < n ; i++) {
			if (board[i][0] != board[i-1][0] && count[i-1][0])
				count[i][0] = true;
			else if (board[i][0] == board[i-1][0] && !count[i-1][0])
				count[i][0] = true;
		}
		for (int i = 1 ; i < m ; i++) {
			if (board[0][i] != board[0][i-1] && count[0][i-1])
				count[0][i] = true;
			else if (board[0][i] == board[0][i-1] && !count[0][i-1])
				count[0][i] = true;
		}
		for (int i = 1 ; i < n ; i++) {
			for (int j = 1 ; j < m ; j++) {
				if ( (board[i][j] != board[i-1][j] && count[i-1][j]) && (board[i][j] != board[i][j-1] && count[i][j-1]) ) {
					count[i][j] = true;
				} else if ( (board[i][j] == board[i-1][j] && !count[i-1][j]) && (board[i][j] == board[i][j-1] && !count[i][j-1]) ) {
					count[i][j] = true;
				} else if ( (board[i][j] != board[i-1][j] && count[i-1][j]) && (board[i][j] == board[i][j-1] && !count[i][j-1]) ) {
					count[i][j] = true;
				} else if ( (board[i][j] == board[i-1][j] && !count[i-1][j]) && (board[i][j] != board[i][j-1] && count[i][j-1]) ) {
					count[i][j] = true;
				}
			}
		}
		int r = 0;
		int s = 0;
		int min = 64;
    
    // Bruthforce algorithm으로 모든 8x8의 경우를 다 확인하여 범위별 t값을 구하고, 그 중 최솟값을 출력하여야 함
		while (r+8 <= n) {
			int t = 0;
			for (int i = r ; i < r+8 ; i++) {
				for (int j = s ; j < s+8 ; j++) {
					if (count[i][j]) {
						t++;
					}
				}
			}
			if (t > 32)
				t = 64 - t;			
			if (t < min)
				min = t;		
			s++;			
			if (s+7 == m) {
				s = 0;
				r++;
			}	
		}
		bw.write(min+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
