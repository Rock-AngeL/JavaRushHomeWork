package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  maximum;
        int  minimum;

        //Напишите тут ваш код
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < 20; i++)
        {
            arr.add(Integer.parseInt(reader.readLine()));
        }

        minimum = arr.get(0);
        maximum = arr.get(0);

        for(Integer i : arr)
        {
            if(i > maximum)
                maximum = i;

            if(i < minimum)
                minimum = i;
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
