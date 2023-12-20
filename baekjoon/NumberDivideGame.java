import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 27172

public class NumberDivideGame {
    static int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] number = new boolean[MAX];
        int N = Integer.parseInt(br.readLine());
        int[] player = new int[N];
        int[] point = new int[MAX];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int now;
        int max = -1;
        for (int i = 0; i < N; i++) {
            now = Integer.parseInt(st.nextToken());
            max = Math.max(max, now);
            number[now] = true;
            player[i] = now;
        }
        br.close();

        for (int i : player) {
            for (int j = i * 2; j <= max; j += i) {
                if (number[j]) {
                    point[i]++;
                    point[j]--;
                }
            }
        }
        for (int i : player) {
            bw.write(point[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
