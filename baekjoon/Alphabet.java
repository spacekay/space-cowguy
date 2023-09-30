import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1987

public class Alphabet {
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = -1;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R + 1][C + 1];
        String S;
        for (int k = 0; k < R; k++) {
            S = br.readLine();
            for (int l = 0; l < C; l++) {
                board[k + 1][l + 1] = S.charAt(l) - 'A';
            }
        }
        br.close();
        // Backtracking을 위한 방문 기록 진행
        boolean[] check = new boolean[26];
        check[board[1][1]] = true;
        DFS(1, 1, 1, check);
        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }

    static void DFS(int x, int y, int level, boolean[] checked) {
        max = Math.max(max, level);
        // 다음 칸 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 0 && ny > 0 && nx <= R && ny <= C) {
                if (!checked[board[nx][ny]]) {
                    // Backtracking
                    checked[board[nx][ny]] = true;
                    DFS(nx, ny, level + 1, checked);
                    checked[board[nx][ny]] = false;
                }
            }
        }
    }
}
