import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TodayDate
{
    public static void main(String[] args)
    {
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(formatter));
    }
}
