import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2467

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] sol = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int phAbsMin = 2_000_000_001;
        int ph;
        // 끝에서 중앙으로 가야 치우친 케이스도 확인할 수 있음
        int start = 1;
        int end = n;
        int startMin = start;
        int endMin = end;
        for (int i = 0; i < n; i++) {
            if (end == start) {
                break;
            }
            ph = sol[start] + sol[end];

            if (phAbsMin > Math.abs(ph)) {
                startMin = start;
                endMin = end;
                phAbsMin = Math.abs(ph);
            }
            if (ph == 0) {
                break;
            } else if (ph < 0) {
                start++;
            } else {
                end--;
            }

        }
        bw.write(sol[startMin] + " " + sol[endMin] + "\n");
        bw.flush();
        bw.close();
    }
}
