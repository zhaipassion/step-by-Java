package com.bob.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Bob on 2015/11/20.
 */
public class Demo {
    public static void main(String[] args) {
        Date d = new Date();
        Date date = getNextDate(null);
        System.out.println(date);
    }

    private static Date getNextDate(Date d) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(d);
        calendar.add(calendar.DATE, 1);
        return calendar.getTime();
    }


}
