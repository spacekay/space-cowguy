import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023

public class InterestingPrimeNumber {
    static boolean[] prime;
    static int n, M, m;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();
        M = (int) Math.pow(10, n);
        m = (int) Math.sqrt(M);

        // 소수 거르는 로직으로 먼저 소수와 소수가 아닌 수를 분리
        prime = new boolean[m + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= m; i++) {
            for (int j = 2; i * j <= m; j++) {
                prime[i * j] = true;
            }
        }

        sb = new StringBuilder();
        // 앞에서 n, n-1, ..., 4, 3, 2, 1 자리까지 자른 숫자들도 소수인지 확인
        // 첫 자리는 반드시 한 자리 소수여야 함
        int[] arr = {2, 3, 5, 7};
        for (int i : arr) {
            findPrimeNumber(1, i);
        }

        System.out.println(sb);
    }

    static void findPrimeNumber(int digit, int x) {
        if (digit == n) {
            sb.append(x).append("\n");
            return;
        }
        digit++;
        // 2를 제외한 짝수는 소수가 아니므로 스킵
        for (int i = 1; i < 10; i = i + 2) {
            int nextNum = x * 10 + i;
            if (isPrime(nextNum)) {
                findPrimeNumber(digit, nextNum);
            }
        }
    }

    static boolean isPrime(int x) {
        if (x <= m) {
            return !prime[x];
        }

        // 2로 나누는 것을 고려할 필요가 없음
        for (int i = 2; i <= m; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

