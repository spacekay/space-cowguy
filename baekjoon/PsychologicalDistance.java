import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 20529

public class PsychologicalDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> mbtiMap = new HashMap<>();
        StringTokenizer st;
        int n;

        int T = Integer.parseInt(br.readLine());

        outer:
        for (int l = 0; l < T; l++) {
            n = Integer.parseInt(br.readLine());
            mbtiMap.clear();
            st = new StringTokenizer(br.readLine());

          // 비둘기집의 원리 적용
            if (n > 32) {
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
              // 같은 MBTI가 3명 이상이면 무조건 결과값은 0
                if (now > 2) {
                    bw.write("0\n");
                    continue outer;
                }
                mbtiMap.put(type, now);
            }

            List<String> keyList = new ArrayList<>(mbtiMap.keySet());
            // 개수가 많은 MBTI부터 먼저 탐색하도록 함
            keyList.sort((v1, v2) -> (mbtiMap.get(v2).compareTo(mbtiMap.get(v1))));

            int size = keyList.size();
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
              // 똑같은 MBTI가 2명인 경우 둘 간의 거리는 0이 됨
                if (mbtiMap.get(keyList.get(i)) == 2) {
                    for (int j = i + 1; j < size; j++) {
                        min = Math.min(min, checkDifference(keyList.get(i), keyList.get(i), keyList.get(j)));
                        if (min == 0) {
                            bw.write("0\n");
                            break outer;
                        }
                    }
                } else {
                    for (int j = i + 1; j < size; j++) {
                     // 똑같은 MBTI가 2명인 경우 둘 간의 거리는 0이 됨
                        if (mbtiMap.get(keyList.get(j)) == 2) {
                            for (int k = j + 1; k < size; k++) {
                                min = Math.min(min, checkDifference(keyList.get(i), keyList.get(j), keyList.get(j)));
                                if (min == 0) {
                                    bw.write("0\n");
                                    break outer;
                                }
                            }
                        } else {
                            for (int k = j + 1; k < size; k++) {
                                min = Math.min(min, checkDifference(keyList.get(i), keyList.get(j), keyList.get(k)));
                                if (min == 0) {
                                    bw.write("0\n");
                                    break outer;
                                }
                            }
                        }
                    }
                }
            }
            bw.write(min + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

  // 3가지 MBTI의 거리를 한 번에 측정할 수 있는 메소드
    private static int checkDifference(String type1, String type2, String type3) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (type1.charAt(i) != type2.charAt(i)) {
                count += 1;
            }
            if (type1.charAt(i) != type3.charAt(i)) {
                count += 1;
            }
            if (type2.charAt(i) != type3.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }
}
