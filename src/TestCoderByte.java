import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;

public class TestCoderByte {

  public static void main(String[] args) {
    String[] strArr = "8:00pm-11:00am".toUpperCase().split("-");

    DateTimeFormatter format = DateTimeFormatter.ofPattern("h:mma");
    LocalTime time01 = LocalTime.parse(strArr[0], format);
    LocalTime time02 = LocalTime.parse(strArr[1], format);

    LocalDateTime dateTime01 = LocalDateTime.of(LocalDate.now(), time01);
    LocalDateTime dateTime02 = LocalDateTime.of(LocalDate.now(), time02);

    Duration duration = Duration.between(dateTime01, dateTime02);
    if (duration.isNegative()) {
      dateTime02 = dateTime02.plusHours(24);
      duration = Duration.between(dateTime01, dateTime02);
    }
    long sss = duration.getSeconds();

    long minutes = sss / 60;
    System.out.println(minutes);
  }
}
