import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2217

public class Rope {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(rope);
        int max = -1;
        for (int i = n - 1; i > -1; i--) {
            max = Math.max(max, rope[i] * (n - i));
        }
        System.out.println(max);
    }
}
