import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Doyoung {
    static int[][] ingredient;
    static int min = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ingredient = new int[n][2];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        boolean[] used = new boolean[n];
        Arrays.fill(used, false);

        // Backtracking으로 푸니까 속도가 늦어지긴 함
        // DFS나 부분집합(조합) 관련 로직을 활용하여 풀 수도 있음
        for (int j = 0; j < n; j++) {
            used[j] = true;
            cooking(j, ingredient[j][0], ingredient[j][1], used);
            used[j] = false;
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    public static void cooking(int now, int sour, int salty, boolean[] used) {
        min = Math.min(min, Math.abs(sour - salty));
//        System.out.println(now + ", " + sour + ", " + salty + " : " + min);

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                cooking(i, sour * ingredient[i][0], salty + ingredient[i][1], used);
                used[i] = false;
            }
        }
    }
}
