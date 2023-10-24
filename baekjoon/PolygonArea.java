import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2166

public class PolygonArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        double area = 0;

        for (int i = 0; i < n; i++) {
            double ax = x[i];
            double ay = y[i];
            double bx, by;
            if (i + 1 < n) {
                bx = x[i + 1];
                by = y[i + 1];
            } else {
                bx = x[0];
                by = y[0];
            }
            // x축, 또는 y축을 기준으로 두개의 점을 잇는 선분을 적분한 값을 부호를 살려서 더해주면 다각형의 면적이 됨
            area += (ay + by) * (bx - ax);
        }

        bw.write(String.format("%.1f", Math.abs(area / 2)) + "\n");
        bw.flush();
        bw.close();
    }
}

