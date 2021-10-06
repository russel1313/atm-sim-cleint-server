package com.russel.atm.simulator.common;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class DateTime implements Serializable{

    private static final long serialVersionUID = -8514459569308804082L;

    /**
     * The year.
     */
    private int year;

    /**
     * The month.
     */
    private int month;

    /**
     * The day.
     */
    private int day;

    private int hourOfDay;

    /**
     * The minute.
     */
    private int minute;

    /**
     * The second.
     */
    private int second;

    /**
     * The fraction.
     */
    private int fraction;

    private String format;

    private int utcOffsetHour;

    private int utcOffsetMinute;

    /**
     * Instantiates a new date time.
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     */
    public DateTime(int year, int month, int day) {
        this(year,month,day,0,0);
    }

    public DateTime(int year, int month, int day, int hourOfDay, int minute) {
        this(year,month,day,hourOfDay,minute,0);
    }

    public DateTime(int year, int month, int day, int hourOfDay, int minute, int second) {
        Assert.notNull(year);
        Assert.notNull(month);
        Assert.notNull(day);
        this.year = year;
        this.month = month;
        this.day = day;
        this.hourOfDay = hourOfDay;
        this.minute = minute;
        this.second = second;
    }

    public Date toDate() {
        if (year == 0 && month == 0 && day == 0 && hourOfDay == 0
                && minute == 0 && fraction == 0) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        if (utcOffsetHour != 0 || utcOffsetMinute != 0) {

            if (utcOffsetHour > 23) {
                throw new IllegalArgumentException("UtcOffsetHour:" + utcOffsetHour +
                        "should be below 23");
            }
            char sign = utcOffsetHour >= 12 ? '+' : '-';
            int gmtOffset = utcOffsetHour >= 12 ? (23 - 12) : utcOffsetHour;
            cal.setTimeZone(TimeZone.getTimeZone("GMT" + sign + gmtOffset));
        }
        cal.set(year, month, day, hourOfDay, minute, second);
        cal.set(Calendar.MILLISECOND, fraction);
        return cal.getTime();
    }


    /**
     * Gets the year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year.
     *
     * @param year the new year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the month.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month.
     *
     * @param month the new month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Gets the day.
     *
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day.
     *
     * @param day the new day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Gets the minute.
     *
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Sets the minute.
     *
     * @param minute the new minute
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * Gets the second.
     *
     * @return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * Sets the second.
     *
     * @param second the new second
     */
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * Gets the fraction.
     *
     * @return the fraction
     */
    public int getFraction() {
        return fraction;
    }

    /**
     * Sets the fraction.
     *
     * @param fraction the new fraction
     */
    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getUtcOffsetHour() {
        return utcOffsetHour;
    }

    public void setUtcOffsetHour(int utcOffsetHour) {
        this.utcOffsetHour = utcOffsetHour;
    }

    public int getUtcOffsetMinute() {
        return utcOffsetMinute;
    }

    public void setUtcOffsetMinute(int utcOffsetMinute) {
        this.utcOffsetMinute = utcOffsetMinute;
    }
}
