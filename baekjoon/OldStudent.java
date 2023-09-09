import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 21736

public class OldStudent {

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int[][] conn;
    static boolean[][] checked;
    static int n, m;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int a = -1;
        int b = -1;
        conn = new int[n][m];
        checked = new boolean[n][m];
        String line;
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'O') {
                    conn[i][j] = 1;
                } else if (line.charAt(j) == 'P') {
                    conn[i][j] = 2;
                } else if (line.charAt(j) == 'I') {
                    a = i;
                    b = j;
                }
            }
        }
        br.close();

        BFS(a, b);

        if (count > 0) {
            bw.write(count + "\n");
        } else {
            bw.write("TT\n");
        }
        bw.flush();
        bw.close();
    }

    static void BFS(int a, int b) {
        Queue<Position> bfs = new LinkedList<>();
        checked[a][b] = true;
        bfs.offer(new Position(a, b));
        while (!bfs.isEmpty()) {
            Position position = bfs.poll();
            int x = position.x;
            int y = position.y;

            if (conn[x][y] == 2) {
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (!checked[nx][ny] && conn[nx][ny] > 0) {
                    checked[nx][ny] = true;
                    bfs.offer(new Position(nx, ny));
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
