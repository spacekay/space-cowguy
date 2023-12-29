import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1343

public class Polyomino {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        br.close();
        StringBuilder stringBuilder = new StringBuilder();
        int now = 0;
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) != '.') {
                now++;
                if (now % 4 == 0) {
                    stringBuilder.append("AAAA");
                    now -= 4;
                } else if (i == board.length() - 1) {
                    if (now % 2 == 0) {
                        stringBuilder.append("BB");
                    } else {
                        stringBuilder = new StringBuilder("-1");
                    }
                }
            } else {
                if (now % 2 != 0) {
                    stringBuilder = new StringBuilder("-1");
                    break;
                } else if (i > 0 && now > 0 && board.charAt(i - 1) != '.') {
                    stringBuilder.append("BB");
                    now = 0;
                    stringBuilder.append(".");
                } else {
                    stringBuilder.append(".");
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
