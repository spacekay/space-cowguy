import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 20040

public class CycleGame {
    static int[] parent;
    // union find 는 신이다. 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int count = 0;
        int a, b;
        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            // 부모 노드부터 먼저 찾기 (자기 자신의 관계를 바꾸는 것보다, 부모 노드를 바꾸는 것이 더 빠름
            x = find(a);
            y = find(b);
            // 직속 부모가 같은 노드가 2개 이상 생기는 경우를 체크하면 됨
            if (x == y) {
                // i = 0일 때 count는 1(첫번째)이어야 함
                count = i + 1;
                break;
            }
            // 더 작은 쪽을 연결해 줌
            parent[Math.max(x, y)] = Math.min(x, y);
        }
        br.close();

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

