package com.jt.test.chp12;

/**
 * @author he
 * @since 2015/4/7
 */
public class SmartDate implements Comparable<SmartDate> {

    private int year;
    private int month;
    private int day;

    public SmartDate(String s) {

    }

    public int year() {
        return year;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public SmartDate(int year, int month, int day) {
        if (year < 0 || month > 13 || month < 0 || day < 0 || day > 32) {
            throw new IllegalArgumentException("not ok");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }


    @Override
    public int compareTo(SmartDate o) {
        return 0;
    }
}
