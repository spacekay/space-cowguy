import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// 4803

public class Tree {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashSet<Integer> roots = new HashSet<>();
        HashSet<Integer> cycledChilds = new HashSet<>();
        HashSet<Integer> cycledRoots = new HashSet<>();
        int n, m;
        int T;
        int count = 0;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            count++;
            parent = new int[n + 1];
            roots.clear();
            cycledChilds.clear();
            cycledRoots.clear();
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
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
                    cycledChilds.add(x);
                }
                // 더 작은 쪽을 연결해 줌
                parent[Math.max(x, y)] = Math.min(x, y);
            }
            for (int i = 1; i <= n; i++) {
                roots.add(find(i));
            }
            for (int child : cycledChilds) {
                cycledRoots.add(find(child));
            }
            T = roots.size() - cycledRoots.size();
            bw.write("Case ");
            bw.write(Integer.toString(count));
            if (T == 0) {
                bw.write(": No trees.\n");
            } else if (T == 1) {
                bw.write(": There is one tree.\n");
            } else {
                bw.write(": A forest of ");
                bw.write(Integer.toString(T));
                bw.write(" trees.\n");
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


/* https://www.acmicpc.net/source/69732553
public class Main {

    public static void main(String[] args) throws IOException {

     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            tree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = i;
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                a = findTree(a);
                b = findTree(b);

                if (a > b) {
                    union(b, a);
                } else {
                    union(a, b);
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {

                int x = findTree(i);

                if (tree[x] == i) {
                    count++;
                }
            }

            sb.append("Case ").append(T++);
            switch (count) {
                case 0:
                    sb.append(": No trees.\n");
                    break;

                case 1:
                    sb.append(": There is one tree.\n");
                    break;
                default:
                    sb.append(": A forest of ").append(count).append(" trees.\n");
                    break;
            }

        }
        System.out.println(sb.toString().trim());
    }

    static int[] tree;

    static int findTree(int x) {
        if (tree[x] == x) {
            return x;
        }

        return tree[x] = findTree(tree[x]);
    }

    static void union(int a, int b) {

        if (a == b) {
            tree[a] = 0;
            return;
        }

        tree[b] = a;

    }
}


*/
