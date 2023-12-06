import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14595

public class ClubRoomProjectLarge {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int[][] villain = new int[m][2];
        int a, b;
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            villain[i][0] = Math.min(a, b);
            villain[i][1] = Math.max(a, b);
        }
        br.close();

        Arrays.sort(villain, (o1, o2) -> {
            if (o2[0] != o1[0]) {
                return o2[0] - o1[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        int x, y;
        for (int i = 0; i < m; i++) {
            x = find(villain[i][0]);
            y = find(villain[i][1]);
            // 이미 탐색한 곳은 아래 포문을 또 돌게 하지 말자
            if (x == y) {
                continue;
            }

            // 더 작은 쪽을 연결해 줌
            int left = parent[Math.max(x, y)] = Math.min(x, y);

            // 부모 노드부터 먼저 찾기 (자기 자신의 관계를 바꾸는 것보다, 부모 노드를 바꾸는 것이 더 빠름)
            for (int j = x + 1; j <= y; j++) {
                parent[j] = left;
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            // 부모 배열 초기화도 끊임없이 해주는 것이 중요
            return parent[x] = find(parent[x]);
        }
    }
}
