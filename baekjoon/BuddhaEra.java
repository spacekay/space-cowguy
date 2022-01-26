import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuddhaEra {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		System.out.println(n-543);
	}
}
