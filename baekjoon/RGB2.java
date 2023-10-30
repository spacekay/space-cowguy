import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17404

public class RGB2 {
    static int[][] arr;
    static int n;
    static int[][] sum;
    static int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        sum = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 로직을 직관적으로 따라가기
        // 시작점이 0인 경우, 1인 경우, 2인 경우를 나눔
        // 각각 시작점과 같은 색으로 칠해진 경우의 값은 고려하지 않으며,
        // 매 탐색마다 초기화를 적절하게 진행함 (최소비용이므로 MAX로 초기화)
        int min = MAX;
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(sum[j], MAX);
            }
            sum[0][k] = arr[0][k];
            for (int i = 1; i < n; i++) {
                sum[i][0] = Math.min(sum[i - 1][1], sum[i - 1][2]) + arr[i][0];
                sum[i][1] = Math.min(sum[i - 1][0], sum[i - 1][2]) + arr[i][1];
                sum[i][2] = Math.min(sum[i - 1][0], sum[i - 1][1]) + arr[i][2];
            }
            for (int j = 0; j < 3; j++) {
                if (k != j) {
                    min = Math.min(sum[n - 1][j], min);
                }
            }
        }
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}

