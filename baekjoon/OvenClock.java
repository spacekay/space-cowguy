import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2525

public class OvenClock {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        br.close();
        int H = h;
        if (m + t >= 60) {
            H += (m + t) / 60;
        }
        H = H > 23 ? H - 24 : H;
        bw.write(H + " ");
        bw.write((t + m) % 60 + "\n");
        bw.flush();
        bw.close();
    }
}
