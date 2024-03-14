import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1049

public class GuitarString {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int min = 1_000_000;
    int p = 1_000_000;
    int o = 1_000_000;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      p = Math.min(p, Integer.parseInt(st.nextToken()));
      o = Math.min(o, Integer.parseInt(st.nextToken()));
    }
    br.close();

    // 그룹 가격을 택하지 않는 경우
    p = Math.min(o * 6, p);
    min = Math.min(min, Math.min(N / 6 * p + (N % 6) * o, (N / 6 + 1) * p));

    bw.write(min + "\n");
    bw.flush();
    bw.close();
  }
}
