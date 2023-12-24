import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1922

public class ConnectingNetwork {

    static int N, M;
    static PriorityQueue<Node1922> nodes = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nodes.add(new Node1922(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        int sum = 0;
        int level = 0;
        // 무조건 가중치 적은 노드부터 탐색하게 됨 (크루스칼)
        // 우선순위 큐는 .poll()을 통해서만 가중치 순으로 순회 가능함
        while (!nodes.isEmpty()) {
            Node1922 node = nodes.poll();
            if (isConnectable(node.start, node.end)) {
                sum += node.cost;
                level++;
                // 전체를 이으려면 최소 N - 1번 간선이 그어져야 함 (간선이 추가될때만 판정하여도 됨)
                if (level == N - 1) {
                    break;
                }
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

    static class Node1922 implements Comparable<Node1922> {
        int start;
        int end;
        int cost;

        public Node1922(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node1922 o) {
            return this.cost - o.cost;
        }
    }
}

