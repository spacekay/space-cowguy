import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 3003

public class Chess {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        List<Integer> setNumber = new ArrayList<>();
        setNumber.add(1);
        setNumber.add(1);
        setNumber.add(2);
        setNumber.add(2);
        setNumber.add(2);
        setNumber.add(8);
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(setNumber.get(i) - Integer.parseInt(stringTokenizer.nextToken()));
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
    }
}
