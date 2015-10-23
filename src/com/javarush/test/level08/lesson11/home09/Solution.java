package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String date = "MAY 1 2013";
        System.out.println(date + " = " + isDateOdd(date));

    }

    public static boolean isDateOdd(String date)
    {
        Date d = new Date(date);
        Date yearStartTime = new Date();

        yearStartTime.setMonth(0);
        yearStartTime.setDate(0);
        yearStartTime.setYear(d.getYear());

        long Distance = d.getTime() - yearStartTime.getTime();
        long msDay = 24*60*60*1000;

        int CountDay = (int)(Distance/msDay);

        if (CountDay%2 == 0)
        {return true;}
        else return false;
    }
}
