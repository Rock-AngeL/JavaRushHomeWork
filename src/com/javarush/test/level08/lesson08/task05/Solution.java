package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Сталлоне", "Сильвестр");
        map.put("Мориконе", "Энио");
        map.put("Вивальди","Антонио");
        map.put("Белучи", "Моника");
        map.put("Гудини", "Гарри");
        map.put("Верди", "Джузеппе");
        map.put("Марацци", "Бруно");
        map.put("Корлионе", "Вито");
        map.put("Брацци", "Люка");
        map.put("Страдивари", "Антонио");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        ArrayList<String> valuesList = new ArrayList<String>();

        for (Map.Entry<String, String> pair : map.entrySet()) {
            valuesList.add(pair.getValue());
        }
        for (int i = 0; i < valuesList.size(); i++) {
            String nameToTest = valuesList.get(i);
            int count = 0;

            for (Map.Entry<String, String> pair : map.entrySet()) {

                if (nameToTest.equals(pair.getValue())) {
                    count++;
                }
            }

            if (count > 1) {
                removeItemFromMapByValue(map, nameToTest);
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        System.out.println(map);

    }
}
