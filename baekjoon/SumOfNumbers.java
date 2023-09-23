import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1789

public class SumOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long S = Long.parseLong(br.readLine());
        br.close();
        for (long N = 1; N <= S; N++) {
            if (((N + 1 * N) / 2) <= S && ((N + 2) * (N + 1) / 2) > S) {
                bw.write(N + "\n");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
