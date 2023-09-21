import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2693

public class NthBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] num = new int[10];
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(num, -1);
            for (int j = 0; j < 10; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            bw.write(num[7] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
