package ua.com.alevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateApiMain {

    public static void main(String[] args) {
//        baseDate();
//        calendar();
        dateTime();
    }

    private static void baseDate() {
        Date date = new Date();
        System.out.println("date = " + date.getTime());
        System.out.println(System.currentTimeMillis());

        date = new Date(Long.MAX_VALUE);
        System.out.println("date = " + date);

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("timeZone = " + timeZone);

        System.out.println(2 * 60 * 60 * 1000);
    }

    private static void calendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar.getTime());
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        calendar.add(Calendar.MONTH, 1);
        System.out.println("calendar = " + calendar.getTime());
    }

    private static void dateTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        LocalDate of = LocalDate.of(2022, 1, 1);
        System.out.println("of = " + of);
        LocalDate localDate1 = of.plusDays(1);
        System.out.println("localDate1 = " + localDate1);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime = " + offsetDateTime);
    }
}
