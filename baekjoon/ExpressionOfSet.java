import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1717

public class ExpressionOfSet {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int a, b;
        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (st.nextToken().charAt(0) == '0') {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                // 부모 노드부터 먼저 찾기 (자기 자신의 관계를 바꾸는 것보다, 부모 노드를 바꾸는 것이 더 빠름
                x = find(a);
                y = find(b);
                // 더 작은 쪽을 연결해 줌
                parent[Math.max(x, y)] = Math.min(x, y);
            } else {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if (parent[find(a)] == parent[find(b)]) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        br.close();
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

