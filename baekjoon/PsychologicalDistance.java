import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class PsychologicalDistance {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Map<String, Integer> mbtiMap = new HashMap<>();
    Set<String> checked = new HashSet<>();
    Queue<Integer> save = new PriorityQueue<>();
    StringTokenizer st;
    int n;

    int T = Integer.parseInt(br.readLine());

    outer:
    for (int k = 0; k < T; k++) {
      n = Integer.parseInt(br.readLine());
      mbtiMap.clear();
      bw.write(n + "====\n");
      st = new StringTokenizer(br.readLine());
      if (n > 18) {
        bw.write("0\n");
        continue;
      }
      for (int i = 0; i < n; i++) {
        String type = st.nextToken();
        int now = 0;
        if (mbtiMap.containsKey(type)) {
          now = mbtiMap.get(type);
        }
        now++;
        if (now > 2) {
          bw.write("0\n");
          continue outer;
        }
        mbtiMap.put(type, now);
      }

      Set<String> keySet = mbtiMap.keySet();
      bw.write(keySet.size() + "*\n");
      for (String key : keySet) {
        checked.add(key);
        for (String key2 : keySet) {
          if (!checked.contains(key2)) {
            save.add(checkDifference(key, key2));
          }
        }
        if (mbtiMap.get(key) > 1) {
          save.add(0);
        }
      }
      int count = 0;
      for (int j = 0; j < 3 && !save.isEmpty(); j++) {
        count += save.poll();
      }
      bw.write(count + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  private static int checkDifference(String type1, String type2) {
    int count = 0;
    for (int i = 0; i < 4; i++) {
      if (type1.charAt(i) != type2.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}
