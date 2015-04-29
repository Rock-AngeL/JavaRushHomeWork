package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        ArrayList<String> lst = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++)
        {
            lst.add(br.readLine());
        }

        for(int i = 0; i < 5; i++)
        {
            lst.add(lst.get(4 - i));
            lst.remove(4 - i);
        }

        for(String str: lst)
        {
            System.out.println(str);
        }

    }
}
