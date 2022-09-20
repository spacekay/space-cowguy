import java.io.*;
import java.util.*;

public class ChangeCapitalSmall
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        char[] inputs = input.toCharArray();

        int L = inputs.length;

        for(int i=0;i<L;i++) {
            if (inputs[i] > 'Z') {
                inputs[i] -= 32;
            } else {
                inputs[i] += 32;
            }
        }
        
        bw.write(new String(inputs)+"\n");

        br.close();
        bw.flush();
        bw.close();

    }
}
