import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

// 29731

public class Meme {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> memes = Set.of(
                "Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
                "Never gonna stop"
        );
        int n = Integer.parseInt(br.readLine());
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (!memes.contains(br.readLine())) {
                flag = true;
            }
        }
        if (flag) {
            bw.write("Yes\n");
        } else {
            bw.write("No\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
