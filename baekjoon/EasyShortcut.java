import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14940 (2에서부터 시작해서 한칸씩 늘려가는 방식)

public class EasyShortcut {

    static int n, m, a, b;
    static boolean[][] conn;
    static boolean[][] checked;
    static Queue<ShortcutPoint> bfs = new LinkedList<>();
    static int[][] shortcut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        conn = new boolean[n + 1][m + 1];
        checked = new boolean[n + 1][m + 1];
        int now;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                now = Integer.parseInt(st.nextToken());
                if (now == 1) {
                    conn[i][j] = true;
                } else if (now == 2) {
                    conn[i][j] = true;
                    a = i;
                    b = j;
                }
            }
        }

        shortcut = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(shortcut[i], -1);
        }

        BFS(a, b);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (conn[i][j]) {
                    sb.append(shortcut[i][j]);
                } else {
                    sb.append(0);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int BFS(int a, int b) {
        checked[a][b] = true;
        bfs.offer(new ShortcutPoint(a, b, 0));
        while (!bfs.isEmpty()) {
            ShortcutPoint point = bfs.poll();
            int x = point.x;
            int y = point.y;
            int path = point.path;
            shortcut[x][y] = path;

            // 양방향(+/-)으로 탐색할 수 있어야 빙빙 꼬인 케이스도 커버할 수 있음
            // 목적지가 왼쪽에 있어도 오른쪽도 갈 수 있어야 함
            if (y < m && conn[x][y + 1] && !checked[x][y + 1]) {
                bfs.offer(new ShortcutPoint(x, y + 1, path + 1));
                checked[x][y + 1] = true;
            }
            if (y > 1 && conn[x][y - 1] && !checked[x][y - 1]) {
                bfs.offer(new ShortcutPoint(x, y - 1, path + 1));
                checked[x][y - 1] = true;
            }
            if (x > 1 && conn[x - 1][y] && !checked[x - 1][y]) {
                bfs.offer(new ShortcutPoint(x - 1, y, path + 1));
                checked[x - 1][y] = true;
            }
            if (x < n && conn[x + 1][y] && !checked[x + 1][y]) {
                bfs.offer(new ShortcutPoint(x + 1, y, path + 1));
                checked[x + 1][y] = true;
            }
        }
        return -1;
    }

    static class ShortcutPoint {
        int x;
        int y;
        int path;

        public ShortcutPoint(int x, int y, int path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}
