import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 25304

public class Receipt {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sum += a * b;
        }
        br.close();

        if (sum == X) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
        bw.close();
    }
}
