import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 2720

public class LaundryShopBoss {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int C;
        int[] coins = new int[4];
        for (int k = 0; k < T; k++) {
            C = Integer.parseInt(br.readLine());
            Arrays.fill(coins, 0);
            coins[0] = C / 25;
            C %= 25;
            coins[1] = C / 10;
            C %= 10;
            coins[2] = C / 5;
            C %= 5;
            coins[3] = C;
            bw.write(coins[0] + " " + coins[1] + " " + coins[2] + " " + coins[3] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
