import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 17609

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        String now;
        int lt, rt, countA, countB;

        for (int t = 0; t < T; t++) {
            countA = 0;
            countB = 0;
            now = br.readLine();
            lt = 0;
            rt = now.length() - 1;

            while (lt < rt) {
                if (now.charAt(lt) == now.charAt(rt)) {
                    lt++;
                    rt--;
                } else if (now.charAt(lt + 1) == now.charAt(rt)) {
                    lt++;
                    countA++;
                } else if (now.charAt(lt) == now.charAt(rt - 1)) {
                    rt--;
                    countA++;
                } else {
                    countA = 2;
                    break;
                }
                if (countA > 1) {
                    break;
                }
            }

            if (lt > 1) {
                lt = 0;
                rt = now.length() - 1;

                while (lt < rt) {
                    if (now.charAt(lt) == now.charAt(rt)) {
                        lt++;
                        rt--;
                    } else if (now.charAt(lt) == now.charAt(rt - 1)) {
                        rt--;
                        countB++;
                    } else if (now.charAt(lt + 1) == now.charAt(rt)) {
                        lt++;
                        countB++;
                    } else {
                        countB = 2;
                        break;
                    }
                    if (countB > 1) {
                        break;
                    }
                }
            } else {
                countB = 3;
            }
            bw.write(Math.min(countA, countB) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

/**
 * import java.util.*;
 * import java.io.*;
 * <p>https://www.acmicpc.net/source/70777277
 * public class Main {
 * static BufferedReader br;
 * static int n;
 * <p>
 * public static void main(String[] args) throws IOException {
 * br = new BufferedReader(new InputStreamReader(System.in));
 * n = Integer.parseInt(br.readLine().trim());
 * StringBuilder answer = new StringBuilder();
 * <p>
 * for (int i = 0; i < n; i++) {
 * String str = br.readLine().trim();
 * <p>
 * int left = 0;
 * int right = str.length() - 1;
 * int isPalindrome = 0;
 * <p>
 * while (left < right) {
 * if (str.charAt(left) != str.charAt(right)) {
 * StringBuilder deleteLeft = new StringBuilder(str).deleteCharAt(left);
 * StringBuilder deleteRight = new StringBuilder(str).deleteCharAt(right);
 * <p>
 * if (deleteRight.toString().equals(deleteRight.reverse().toString())
 * || deleteLeft.toString().equals(deleteLeft.reverse().toString())) {
 * isPalindrome = 1;
 * }else {
 * isPalindrome = 2;
 * }
 * break;
 * }
 * <p>
 * left++;
 * right--;
 * <p>
 * }
 * answer.append(isPalindrome).append('\n');
 * }
 * System.out.println(answer);
 * }
 * }
 */
