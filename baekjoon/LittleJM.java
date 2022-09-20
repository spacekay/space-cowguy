import java.io.*;
import java.util.*;

public class LittleJM
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        long number = 0;

        while(st.hasMoreTokens()) {
            number += Long.parseLong(st.nextToken());
        }

        bw.write(number+"\n");
        bw.flush();
        bw.close();
    }
}
