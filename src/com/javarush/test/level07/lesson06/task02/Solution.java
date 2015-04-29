package com.javarush.test.level07.lesson06.task02;

/* 5 строчек: «101», «102», «103», «104», «105»
1. Создай список строк.
2. Добавь в него 5 строчек: «101», «102», «103», «104», «105».
3. Удали первую, среднюю и последнюю.
4. Используя цикл выведи на экран его содержимое, каждое значение с новой строки.
5. Выведи его размер. (После удаления одного элемента индексы остальных меняются.
Например, если удалить 0-й элемент, то тот, который был 1-м, станет 0-м. И т.д.)
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        String s1 = "101";
        String s2 = "102";
        String s3 = "103";
        String s4 = "104";
        String s5 = "105";

        ArrayList<String> arr = new ArrayList<String>();

        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);
        arr.add(s5);

        arr.remove(0);
        arr.remove(arr.size() / 2 - 1);
        arr.remove(arr.size() - 1);

        for(String str : arr)
            System.out.println(str);

        System.out.println(arr.size());
    }
}
