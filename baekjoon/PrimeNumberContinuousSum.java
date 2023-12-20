import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 1644

public class PrimeNumberContinuousSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();
        boolean[] prime = new boolean[N + 1];
        int max = (int) Math.sqrt(N + 1);
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= max; i++) {
            for (int j = 2; i * j <= N; j++) {
                prime[i * j] = true;
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) {
                primes.add(i);
            }
        }
        int count = getCount(primes, N);
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    private static int getCount(ArrayList<Integer> primes, int N) {
        int size = primes.size();
        int sum = 0;
        int count = 0;
        outer:
        for (int i = 0; i < size; i++) {
            sum += primes.get(i);
            if (sum >= N) {
                if (sum == N) {
                    count++;
                }
                sum = 0;
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                sum += primes.get(j);
                if (sum >= N) {
                    if (sum == N) {
                        count++;
                    }
                    sum = 0;
                    continue outer;
                }
            }
        }
        return count;
    }
}
