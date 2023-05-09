import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] rings = new int[n];

        for (int i = 0; i < n; i++) {
            rings[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int gcd = GCD(rings[0], rings[i]);
            bw.write(rings[0] / gcd + "/" + rings[i] / gcd + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int GCD(int a, int b) {
        // 나머지(b)가 0이 되는 a가 최대공약수
        if (a > b) {
            if (b == 0)
                return a;
            // 나누는 수를 나눠지는 수로, 나머지를 나누는 수로
            return GCD(b, a % b);
        } else {
            if (a == 0)
                return b;
            return GCD(a, b % a);
        }
    }
}
