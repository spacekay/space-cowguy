import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 24416

public class LectureFibonacci1 {
    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        f = new int[n + 1];
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        // 재귀로 하나 DP로 하나 결과는 똑같으므로 DP로만 계산함
        // 재귀는 +1 될 때마다 return 1; 라인을 호출함
        // DP는 3부터 n까지만 돌게 되므로 무조건 n - 2회 호출함
        bw.write(f[n] + " " + (n - 2) + "\n");
        bw.flush();
        bw.close();
    }
}
