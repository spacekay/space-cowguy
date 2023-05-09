import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Divisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        br.close();

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        boolean[] numbers = new boolean[n + 1];
        Arrays.fill(numbers, false);

        for (int i = n; i > 0; i--) {
            if (!numbers[i]) {
                if (n % i == 0) {
                    numbers[i] = true;
                    numbers[n / i] = true;
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (numbers[i]) {
                count++;

                if (count == k) {
                    bw.write(i + "\n");
                    break;
                }
            }
        }

        if (count < k)
            bw.write(0 + "\n");

        bw.flush();
        bw.close();
    }
}
