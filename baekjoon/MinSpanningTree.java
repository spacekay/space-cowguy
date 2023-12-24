import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1197

public class MinSpanningTree {

    static int V, E;
    static PriorityQueue<Node1197> nodes = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nodes.add(new Node1197(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        int sum = 0;
        int level = 0;
        // 무조건 가중치 적은 노드부터 탐색하게 됨 (크루스칼)
        // 우선순위 큐는 .poll()을 통해서만 가중치 순으로 순회 가능함
        while (!nodes.isEmpty()) {
            Node1197 node = nodes.poll();
            if (isConnectable(node.start, node.end)) {
                sum += node.cost;
                level++;
            }
            if (level == E - 1) {
                break;
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

    private static boolean isConnectable(int a, int b) {
        int A = find(a);
        int B = find(b);
        // 이미 사이클이 있는 경우는 피해야 함
        if (A == B) {
            return false;
            // 이제 이 둘은 연결된 것임
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

    static class Node1197 implements Comparable<Node1197> {
        int start;
        int end;
        int cost;

        public Node1197(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node1197 o) {
            return this.cost - o.cost;
        }
    }
}

