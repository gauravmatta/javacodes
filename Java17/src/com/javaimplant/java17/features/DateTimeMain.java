package com.javaimplant.java17.features;

import java.time.*;
import java.util.Calendar;
import java.util.function.Function;

public class DateTimeMain {
    static void main() {
        oldMethod();
        dateClass();
        timeClass();
        Function<Integer, String> drawLine= "*"::repeat;
        System.out.println(drawLine.apply(50));
        datetimeClass();
        zoneClass();
    }

    private static void zoneClass() {
        ZoneId zonea=ZoneId.systemDefault();
        System.out.println(zonea);
        ZoneId zoneb=ZoneId.of("America/New_York");
        ZonedDateTime zna= ZonedDateTime.now(zoneb);
        System.out.println(zna);
        zoneb=ZoneId.of("America/Chicago");
        zna= ZonedDateTime.now(zoneb);
        System.out.println(zna);
        zoneb=ZoneId.of("America/Los_Angeles");
        zna= ZonedDateTime.now(zoneb);
        System.out.println(zna);
        int nn=1996;
        Year y=Year.of(nn);
        if(y.isLeap()) {
            System.out.println(y+" is leap year");
        }else {
            System.out.println("Is not Leap year");
        }
        System.out.println("London date time");
        ZoneId zlondon=ZoneId.of("Europe/London");
        ZonedDateTime znlo=ZonedDateTime.now(zlondon);
        System.out.println(znlo.getDayOfMonth()+"/"+znlo.getMonthValue()+"/"+znlo.getYear()+"Time is : "+znlo.getHour()+":"+znlo.getMinute());
    }

    private static void datetimeClass() {
        LocalDateTime dt1= LocalDateTime.of(1995, 4,28,12,45);
        System.out.println(dt1);
        LocalDateTime dt2=LocalDateTime.now();
        System.out.println("After six months");
        System.out.println(dt2.plusMonths(6));
        System.out.println("Before six months");
        System.out.println(dt2.minusMonths(6));
    }

    private static void timeClass(){
        LocalTime time= LocalTime.now();
        System.out.println("Current Time:"+time);
        int h=time.getHour();
        int m=time.getMinute();
        int s=time.getSecond();
        int n=time.getNano();
        System.out.println(h+":"+m+":"+s+":"+n);
    }

    private static void dateClass() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        int dd=date.getDayOfMonth();
        System.out.println("Day:"+dd);
        int mm=date.getMonthValue();
        System.out.println("Month:"+mm);
        int yy=date.getYear();
        System.out.println("Year:"+yy);
    }

    private static void oldMethod() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime().toLocaleString());
    }
}
