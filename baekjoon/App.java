import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 7579

public class App {
    static int[][] app;
    static int n;
    static int m;
    static int[][] dp;

    // if문 실행 횟수를 최소한으로 하여야 작업 속도가 빨라짐 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        app = new int[n + 1][2];

        int count;
        int costSum = 0;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            count = 0;
            while (st.hasMoreElements()) {
                app[count][i] = Integer.parseInt(st.nextToken());
                if (i == 1) {
                    costSum += app[count][i];
                }
                count++;
            }
        }
        br.close();

        // dp[사용 프로그램 개수][누적 비용] = 확보 메모리
        dp = new int[n + 1][costSum + 1];

        // i : 사용한 프로그램 개수
        for (int i = 0; i < n; i++) {
            // j : 가능한 최소 비용 찾기 (1부터)
            for (int j = 0; j <= costSum; j++) {
                if (i == 0) {
                    if (j >= app[i][1]) {
                        dp[i][j] = app[i][0];
                    }
                } else {
                    if (j >= app[i][1]) {
                        dp[i][j] = Math.max(dp[i - 1][j - app[i][1]] + app[i][0], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        int cost = 0;
        for (int j = 0; j <= costSum; j++) {
            if (dp[n - 1][j] >= m) {
                cost = j;
                break;
            }
        }

        bw.write(cost + "\n");
        bw.flush();
        bw.close();
    }
}

