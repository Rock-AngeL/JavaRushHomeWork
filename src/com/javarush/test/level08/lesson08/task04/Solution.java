package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне1", new Date("JUNE 1 1980"));
        map.put("Сталлоне2", new Date("JUNE 2 1981"));
        map.put("Сталлоне3", new Date("JUNE 3 1982"));
        map.put("Сталлоне4", new Date("JUNE 4 1983"));
        map.put("Сталлоне5", new Date("JUNE 5 1984"));
        map.put("Сталлоне6", new Date("JUNE 6 1985"));
        map.put("Сталлоне7", new Date("JUNE 7 1986"));
        map.put("Сталлоне8", new Date("JUNE 8 1987"));
        map.put("Сталлоне9", new Date("JUNE 9 1988"));
        map.put("Сталлоне10", new Date("JUNE 10 1989"));
        //Напишите тут ваш код

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            //записываем для краткости значение месяца в переменную
            int mounth = iterator.next().getValue().getMonth();
            //проверяется месяц, начиная с 0
            if ((mounth >= 5) && (mounth <= 7))
            {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args)
    {
        HashMap<String, Date> sd = createMap();
        removeAllSummerPeople(sd);


    }
}
