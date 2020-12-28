package com.java.util;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(String dateStr) {
        String dateArr[] = dateStr.split("-");
        year = Integer.parseInt(dateArr[0]);
        month = Integer.parseInt(dateArr[1]);
        day = Integer.parseInt(dateArr[2]);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0)
            throw new IllegalArgumentException("Year should be greater than 0");
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 12 || month < 1)
            throw new IllegalArgumentException("Invalid value for month");
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31)
            throw new IllegalArgumentException("Invalid value for day");
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }
}
