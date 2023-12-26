import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 10813

public class ChangingBall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            basket[i] = i;
        }
        int a, b, x;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            x = basket[a];
            basket[a] = basket[b];
            basket[b] = x;
        }
        br.close();
        for (int i = 1; i <= n; i++) {
            bw.write(basket[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}

