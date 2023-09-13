import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SleepSchedule {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sleep = Integer.parseInt(br.readLine());
        int wake = Integer.parseInt(br.readLine());
        br.close();
        if (sleep > 19) {
            bw.write((wake + 24 - sleep)+"\n");
        } else {
            bw.write((wake - sleep)+"\n");   
        }
        bw.flush();
        bw.close();
    }
}
