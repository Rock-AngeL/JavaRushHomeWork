package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //Напишите тут ваш код
        HashSet<String> set = new HashSet<String>();

        set.add("Лама");
        set.add("Лапа");
        set.add("Луна");
        set.add("Лампа");
        set.add("Локоть");
        set.add("Лошадь");
        set.add("Лимон");
        set.add("Лена");
        set.add("Леня");
        set.add("Лифт");
        set.add("Лимфа");
        set.add("Лоб");
        set.add("Лепешка");
        set.add("Лайм");
        set.add("Липа");
        set.add("Лоза");
        set.add("Лак");
        set.add("Лекало");
        set.add("Лицо");
        set.add("Лопость");


        return set;
    }
}
