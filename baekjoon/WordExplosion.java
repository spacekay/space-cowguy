import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

// 9935

public class WordExplosion {
    static Stack<Character> stack = new Stack<>();
    static char[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        P = br.readLine().toCharArray();
        String S = br.readLine();
        br.close();

        P = checkString(S);
        
        for (char c : P) {
            if (c == '*') {
                break;
            }
            bw.write(c);
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    private static char[] checkString(String S) {
        int n = checkLength();
        int m = S.length();
        stack.clear();

        for (int i = 0; i < n; i++) {
            stack.add(P[i]);
            int l = stack.size();
            // 탐색한 텍스트의 분량이 폭발 텍스트 길이 이상이면 폭발 텍스트 길이만큼 이전 인덱스부터 다시 탐색함
            // for문이 터지지 않으면 flag = true이므로 문자열이 폭발하게 됨
            if (l >= m) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (stack.get(l - m + j) != S.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < m; j++) {
                        stack.pop();
                    }
                }
            }
        }

        Arrays.fill(P, '*');
        int count = 0;
        if (stack.isEmpty()) {
            P[0] = 'F';
            P[1] = 'R';
            P[2] = 'U';
            P[3] = 'L';
            P[4] = 'A';
        } else {
            for (Character c : stack) {
                P[count] = c;
                count++;
            }
        }
        return P;
    }

    private static int checkLength() {
        int count = 0;
        for (char c : P) {
            if (c == '*') {
                break;
            }
            count++;
        }
        return count;
    }
}
