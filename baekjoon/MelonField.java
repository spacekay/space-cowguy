import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2477

public class MelonField {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] hexa = new int[6][2];
        
        String[] side;
        int[][] count = new int[5][2];
        int longX = -1, longY = -1;
        int shortX = -1, shortY = -1;
        for (int i = 0; i < 6; i++) {
            side = br.readLine().split(" ");
            hexa[i][0] = Integer.parseInt(side[0]);
            hexa[i][1] = Integer.parseInt(side[1]);
            count[hexa[i][0]][0]++;
            count[hexa[i][0]][1] = i;
        }

        int t = 0;
        for (int j = 1; j < 3; j++) {
            if (count[j][0] == 1) {
                longX = count[j][1];
                shortX = longX + 3 > 5 ? longX - 3 : longX + 3;
            }
        }
        for (int j = 3; j < 5; j++) {
            if (count[j][0] == 1) {
                longY = count[j][1];
                shortY = longY + 3 > 5 ? longY - 3 : longY + 3;
            }
        }
        int big = hexa[longX][1] * hexa[longY][1];
        int small = hexa[shortX][1] * hexa[shortY][1];
        System.out.println((big - small) * n);
    }
}
