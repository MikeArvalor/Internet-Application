package jspClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.lang.String.format;

public class Regimex {
    private Calendar calendar;

    public Regimex() {
        calendar = Calendar.getInstance();
    }

    public Regimex(final Calendar calendar) {
        this.calendar = calendar;
    }

    public int getHours() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinutes() {
        return calendar.get(Calendar.MINUTE);
    }

    public int getSeconds() {
        return calendar.get(Calendar.SECOND);
    }

    public int getDay() {
        return calendar.get(Calendar.DATE);
    }

    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public String getDayByDate(final int day, final int month, final int year) {
        final String dateString = format("%d-%d-%d", day, month, year);
        try {
            final Date date = new SimpleDateFormat("d-M-yyyy").parse(dateString);
            Calendar calendar=Calendar.getInstance();
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,day);
            return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date)+"-"+(((calendar.get(Calendar.DAY_OF_WEEK)+3)%7)+1);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
