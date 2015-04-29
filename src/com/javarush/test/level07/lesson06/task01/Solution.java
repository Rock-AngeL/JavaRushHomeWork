package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
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

        arr.add("sdfvbdfbdf");
        arr.add("sdfvbdfbd");
        arr.add("sdfvbdfb");
        arr.add("sdfvbd");
        arr.add("sdfv");

        System.out.println(arr.size());

        for(String str : arr)
        {
            System.out.println(str);
        }
    }
}
