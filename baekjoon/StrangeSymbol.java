import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StrangeSymbol {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] numbers = br.readLine().split(" ");
		Long a = Long.parseLong(numbers[0]);
		Long b = Long.parseLong(numbers[1]);
		Long result = (a+b)*(a-b);
		
		bw.write(result+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
