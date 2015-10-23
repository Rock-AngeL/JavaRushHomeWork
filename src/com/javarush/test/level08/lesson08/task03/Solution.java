package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i=0; i<10; i++){
            map.put("фамилия"+i, "имя"+i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        int count = 0;
        for (Map.Entry<String,String> pair : map.entrySet()){
            String s = pair.getValue();
            if (s.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        int count=0;
        for (Map.Entry<String,String> pair : map.entrySet()){
            String s = pair.getKey();
            if (s.equals(familiya)) count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        for (Map.Entry<String,String> pair: map.entrySet()){
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
        System.out.println("Фамилия1 встречается " + getCountTheSameLastName(map, "фамилия1"));
        System.out.println("имя7 встречается " + getCountTheSameFirstName(map, "имя7"));
    }
}
