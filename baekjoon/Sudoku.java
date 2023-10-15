import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2239

public class Sudoku {
    static int[][] board = new int[10][10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S;
        for (int k = 0; k < 9; k++) {
            S = br.readLine();
            for (int l = 0; l < 9; l++) {
                board[k + 1][l + 1] = S.charAt(l) - '0';
            }
        }
        br.close();
        DFS(1, 1);
    }

    static void DFS(int x, int y) {
        int a, b;
        if (y == 9) {
            a = x + 1;
            b = 1;
        } else {
            a = x;
            b = y + 1;
        }

        if (x == 10) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (board[x][y] > 0) {
            DFS(a, b);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (!checkHorizontal(x, i)) {
                continue;
            }
            if (!checkVertical(y, i)) {
                continue;
            }
            if (!checkSquare(x, y, i)) {
                continue;
            }
            board[x][y] = i;
            DFS(a, b);
            board[x][y] = 0;
        }
    }

    static private boolean checkSquare(int x, int y, int num) {
        // 1,2,3 : 1~3
        // 4,5,6 : 4~6
        // 7,8,9 : 7~9
        int a = ((x - 1) / 3) * 3 + 1;
        int b = ((y - 1) / 3) * 3 + 1;
        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static private boolean checkHorizontal(int x, int num) {
        for (int i = 1; i < 10; i++) {
            if (board[x][i] == num) {
                return false;
            }
        }
        return true;
    }

    static private boolean checkVertical(int y, int num) {
        for (int i = 1; i < 10; i++) {
            if (board[i][y] == num) {
                return false;
            }
        }
        return true;
    }

}
