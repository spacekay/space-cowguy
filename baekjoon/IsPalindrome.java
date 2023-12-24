import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 10942

public class IsPalindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[N + 1];
        boolean[][] dp = new boolean[N + 1][N + 1];
        num[1] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }
        for (int i = 2; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < i; j++) {
                if (dp[j + 1][i - 1] && num[j] == num[i]) {
                    dp[j][i] = true;
                    dp[i][j] = true;
                }
            }
            if (num[i] == num[i - 1]) {
                dp[i][i - 1] = true;
                dp[i - 1][i] = true;
            }
        }
        int a, b;
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (dp[a][b]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

