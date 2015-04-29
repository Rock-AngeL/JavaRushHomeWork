package com.javarush.test.level07.lesson06.task04;

/* 5 строчек в начало списка
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        ArrayList<String> arr = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++)
        {
            arr.add(0, br.readLine());
        }

        for(String str: arr)
        {
            System.out.println(str);
        }
    }
}
