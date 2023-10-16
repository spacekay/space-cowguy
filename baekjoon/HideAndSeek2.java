import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek2 {

    static Queue<Integer> bfs = new LinkedList<>();
    static int[] distance;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();
        int time = BFS(n, k);
        System.out.println(time);
        System.out.println(count);
    }

    private static int BFS(int n, int k) {
        int max;
        if (n > k) {
            max = n;
        } else {
            max = k;
        }
        bfs.offer(n);
        distance = new int[max + 2];
        Arrays.fill(distance, -1);
        distance[n] = 0;
        while (!bfs.isEmpty()) {
            int v = bfs.poll();
            if (v == k) {
                count++;
                continue;
            }
            // 일반 숨바꼭질 문제에서는 하나만 맞는 케이스를 찾으면 되었지만 이번에는 중복 방문을 허용해야 함
            // distance가 -1인 것만 허용하면 최초 1개의 경로만 탐색
            // 현재의 distance에 시간 1초를 더한 값이 다음 distance 값과 같으면 유효한 경로로 인식
            if (v - 1 >= 0 && (distance[v - 1] == -1 || distance[v - 1] == distance[v] + 1)) {
                bfs.offer(v - 1);
                distance[v - 1] = distance[v] + 1;
            }

            if (v + 1 <= max + 1 && (distance[v + 1] == -1 || distance[v + 1] == distance[v] + 1)) {
                bfs.offer(v + 1);
                distance[v + 1] = distance[v] + 1;
            }

            if (v * 2 <= max + 1 && (distance[v * 2] == -1 || distance[2 * v] == distance[v] + 1)) {
                bfs.offer(v * 2);
                distance[v * 2] = distance[v] + 1;
            }
        }
        return distance[k];
    }
}
