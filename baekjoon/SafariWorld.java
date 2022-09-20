import java.io.*;
import java.util.*;

public class SafariWorld
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);

        long result = 0;
        
        if (n >= m) {
            result = n-m;
        } else {
            result = m-n;
        }
        
        br.close();

        bw.write(result+"\n");
        bw.flush();
        bw.close();

    }
}
