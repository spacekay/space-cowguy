import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 27891

public class SpecialSchoolNameEncryption {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> schools = List.of(
                "North London Collegiate School",
                "Branksome Hall Asia", "Korea International School",
                "St Johnsbury Academy");
        Map<String, String> encrypted = new HashMap<>();
        StringBuilder stringBuilder;
        for (String school : schools) {
            String full = school.toLowerCase().replaceAll(" ", "");
            for (int i = 0; i < 26; i++) {
                stringBuilder = new StringBuilder();
                for (int j = 0; j < 10; j++) {
                    stringBuilder.append((char) ((full.charAt(j) + i - 'a') % 26 + 'a'));
                }
                String now = stringBuilder.toString();
                encrypted.put(now, school);
            }
        }
        char initial = encrypted.get(br.readLine()).charAt(0);
        if (initial == 'N') {
            bw.write("NLCS\n");
        } else if (initial == 'B') {
            bw.write("BHA\n");
        } else if (initial == 'K') {
            bw.write("KIS\n");
        } else {
            bw.write("SJA\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
