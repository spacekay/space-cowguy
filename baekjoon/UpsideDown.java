import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 10811

public class UpsideDown {

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
        int a, b, x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= (b - a) / 2; j++) {
                x = basket[a + j];
                y = basket[b - j];
                basket[a + j] = y;
                basket[b - j] = x;
            }
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
