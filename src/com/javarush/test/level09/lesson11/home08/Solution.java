package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //Написать тут ваш код
        ArrayList<int[]> arrMass = new ArrayList<int[]>();
        int[] length = {5, 2, 4, 7, 0};

        for(int i : length)
        {
            int[] mass = new int[i];

            for(int j = 0; j < mass.length; j++)
            {
                mass[j] = new Random().nextInt();
            }

            arrMass.add(mass);
        }

        return arrMass;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
