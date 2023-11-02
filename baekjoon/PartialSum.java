import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1806

public class PartialSum {
    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] save = new int[n];
        int min = n + 1;
        // 각 지점에서의 누적합과, 현재까지의 누적합을 이루는 숫자의 개수를 기록함
        int[][] sum = new int[n][2];

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            save[i] = Integer.parseInt(st.nextToken());
            if (save[i] >= s) {
                flag = true;
            }
        }
        br.close();

        if (flag) {
            min = 1;
        } else {
            sum[0][0] = save[0];
            sum[0][1] = 1;

            for (int i = 1; i < n; i++) {
                sum[i][0] = sum[i - 1][0] + save[i];
                sum[i][1] = sum[i - 1][1] + 1;

                if (sum[i][0] >= s) {
                    while (sum[i][0] - save[i - (sum[i][1] - 1)] >= s) {
                        sum[i][0] = sum[i][0] - save[i - (sum[i][1] - 1)];
                        sum[i][1] = sum[i][1] - 1;
                    }
                    min = Math.min(min, sum[i][1]);
                }
            }
        }
        if (min > n) {
            min = 0;
        }
        System.out.println(min);
    }
}

