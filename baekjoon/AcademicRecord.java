import java.io.*;
import java.util.*;

public class AcademicRecord
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String record = br.readLine();
        float score = 0;

        if (record.length() > 1) {
            score = 'E' - record.charAt(0);
            if (record.charAt(1) == '+') {
                score += 0.3;
            } else if (record.charAt(1) == '-') {
                score -= 0.3;
            }
        }

        bw.write(String.format("%.1f", score)+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
