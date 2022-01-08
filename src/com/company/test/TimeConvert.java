package com.company.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeConvert {
    public static void main(String[] args) {
        String timeAM = "07:05:45PM";
        getPM(timeAM);
    }

    private static String getPM(String s) {
        LocalTime time = LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ssa"));
        return time.toString();
    }
}
