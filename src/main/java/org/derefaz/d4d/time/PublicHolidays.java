package org.derefaz.d4d.time;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public class PublicHolidays {

    static {
        System.setProperty("user.timezone", "Africa/Abidjan");
    }

    TimeZone coteDIvoireTZ = TimeZone.getTimeZone("Africa/Abidjan");

    Calendar prophetBirthday = Calendar.getInstance(coteDIvoireTZ);

    private static HashMap<Integer, List<Integer>> dates = new HashMap<Integer, List<Integer>>();

    public PublicHolidays() {
        dates.put(Calendar.JANUARY, Arrays.asList(new Integer[] { 1 }));
        dates.put(Calendar.FEBRUARY, Arrays.asList(new Integer[] { 5, 13 }));
        dates.put(Calendar.APRIL, Arrays.asList(new Integer[] { 9 }));
        dates.put(Calendar.MAY, Arrays.asList(new Integer[] { 1, 17, 28 }));
        dates.put(Calendar.AUGUST, Arrays.asList(new Integer[] { 7, 15, 16, 19 }));
        dates.put(Calendar.OCTOBER, Arrays.asList(new Integer[] { 26 }));
        dates.put(Calendar.NOVEMBER, Arrays.asList(new Integer[] { 1, 15 }));
        dates.put(Calendar.DECEMBER, Arrays.asList(new Integer[] { 25 }));
    }

    public boolean isHoliday(Calendar _day) {
        List<Integer> month = dates.get(_day.get(Calendar.MONTH));
        return (month != null) && month.contains(_day.get(Calendar.DAY_OF_MONTH));
    }

    public static void main(String[] args) {
        PublicHolidays holidays = new PublicHolidays();
        TimeZone coteDIvoireTZ = TimeZone.getTimeZone("Africa/Abidjan");
        Calendar day = Calendar.getInstance(coteDIvoireTZ);

        day.set(2012, Calendar.JANUARY, 1);
        System.out.println(day.getTime() + " ? " + holidays.isHoliday(day));

        day.set(2012, Calendar.MARCH, 1);
        System.out.println(day.getTime() + " ? " + holidays.isHoliday(day));

        day.set(2012, Calendar.NOVEMBER, 1);
        System.out.println(day.getTime() + " ? " + holidays.isHoliday(day));

        day.set(2012, Calendar.NOVEMBER, 15);
        System.out.println(day.getTime() + " ? " + holidays.isHoliday(day));
    }

}
