import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 4386

public class MakingConstellation {

    static int N;
    static PriorityQueue<Node4386> nodes = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        double[][] star = new double[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            star[i][0] = Double.parseDouble(st.nextToken());
            star[i][1] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double cost = Math.sqrt(
                        Math.pow(star[j][0] - star[i][0], 2)
                                + Math.pow(star[j][1] - star[i][1], 2));
                nodes.add(new Node4386(i, j, cost));
            }
        }
        double sum = 0;
        int level = 0;
        // 무조건 가중치 적은 노드부터 탐색하게 됨 (크루스칼)
        // 우선순위 큐는 .poll()을 통해서만 가중치 순으로 순회 가능함
        while (!nodes.isEmpty()) {
            Node4386 node = nodes.poll();
            if (isConnectable(node.start, node.end)) {
                sum += node.cost;
                level++;
                // 전체를 이으려면 최소 N - 1번 간선이 그어져야 함 (간선이 추가될때만 판정하여도 됨)
                if (level == N - 1) {
                    break;
                }
            }
        }
        bw.write(((double) Math.round(sum * 100) / 100) + "\n");
        bw.flush();
        bw.close();
    }

    private static boolean isConnectable(int a, int b) {
        int A = find(a);
        int B = find(b);
        // 이미 사이클이 있는 경우는 피해야 함
        if (A == B) {
            return false;
            // 이제 이 둘은 연결된 것임 (공통 부모 노드를 가진 각 마을은 한 번씩만 연결됨)
            // 아무리 많이 이어져도 두 갈래까지만 이어지도록 처리
        } else {
            parent[B] = A;
            return true;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            // 부모 배열 초기화도 끊임없이 해주는 것이 중요
            return parent[x] = find(parent[x]);
        }
    }

    static class Node4386 implements Comparable<Node4386> {
        int start;
        int end;
        double cost;

        public Node4386(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node4386 o) {
            if (this.cost - o.cost > 0) {
                return 1;
            } else if (this.cost - o.cost < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

