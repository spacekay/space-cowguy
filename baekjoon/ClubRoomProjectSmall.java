import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 14594

public class ClubRoomProjectSmall {
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
        int a, b;
        int x, y;
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            x = Math.min(a, b);
            y = Math.max(a, b);
            // 더 작은 쪽을 연결해 줌
            int left = parent[Math.max(find(x), find(y))] = Math.min(find(x), find(y));
            // 부모 노드부터 먼저 찾기 (자기 자신의 관계를 바꾸는 것보다, 부모 노드를 바꾸는 것이 더 빠름)
            // 작은 스케일에서는 매번 아래 포문이 돌아도 괜찮음 
          for (int j = x + 1; j <= y; j++) {
                parent[j] = left;
            }
        }
        br.close();

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
