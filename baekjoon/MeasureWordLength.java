import java.io.*;
import java.util.*;

public class MeasureWordLength
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        
        bw.write(input.length()+"\n");

        br.close();
        bw.flush();
        bw.close();

    }
}
