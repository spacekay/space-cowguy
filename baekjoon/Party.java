import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1238 (뒤집어서도 짜보자)

public class Party {

    static int n, m, x;
    static ArrayList<ArrayList<Node>> time;
    static ArrayList<ArrayList<Node>> timeReverse;
    static int max = -1;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        time = new ArrayList<>();
        timeReverse = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            time.add(new ArrayList<>());
            timeReverse.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            time.get(start).add(new Node(end, t));
            timeReverse.get(end).add(new Node(start, t));
        }
        br.close();

        // for 문으로 돌리지 않고 메소드 안에서 한번에 처리하면 됨 (cost array에 담긴 값 자체가 최단거리)
        // x -> n
        int[] going = dijkstra(time);
        // n -> x
        int[] coming = dijkstra(timeReverse);
        for (int i = 1; i <= n; i++) {
            max = Math.max(going[i] + coming[i], max);
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    private static int[] dijkstra(ArrayList<ArrayList<Node>> timeList) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        cost[x] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(x, 0));
        boolean[] visited = new boolean[n + 1];

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.arrive;
            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for (Node next : timeList.get(now)) {
                if (cost[next.arrive] > cost[now] + next.cost) {
                    cost[next.arrive] = cost[now] + next.cost;
                    queue.offer(new Node(next.arrive, cost[next.arrive]));
                }
            }
        }
        return cost;
    }

    static class Node implements Comparable<Node> {
        int arrive;
        int cost;

        Node(int arrive, int cost) {
            this.arrive = arrive;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
