import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 30676

public class ColorOfStars {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lambda = Integer.parseInt(br.readLine());
        if (lambda < 425) {
            System.out.println("Violet");
        } else if (lambda < 450) {
            System.out.println("Indigo");
        } else if (lambda < 495) {
            System.out.println("Blue");
        } else if (lambda < 570) {
            System.out.println("Green");
        } else if (lambda < 590) {
            System.out.println("Yellow");
        } else if (lambda < 620) {
            System.out.println("Orange");
        } else {
            System.out.println("Red");
        }
    }
}

