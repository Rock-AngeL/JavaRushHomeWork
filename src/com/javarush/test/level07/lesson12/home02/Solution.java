package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<String>();
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        for(int i = 0; i < N; i++)
            arr.add(reader.readLine());
        //Напишите тут ваш код

        for(int i = 0; i < M; i++)
        {
            String s = arr.get(0);
            arr.remove(0);
            arr.add(s);
        }

        for (String s : arr)
        {
            System.out.println(s);
        }
    }
}
