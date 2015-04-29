package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //add your code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> arr3 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ArrayList<Integer> arrAll = new ArrayList<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 20; i++)
        {
            arr.add(Integer.parseInt(br.readLine()));
        }

        for(int i : arr)
        {
            if(i%3 == 0 && i%2 == 0)
            {
                arr3.add(i);
                arr2.add(i);
            }
            else if(i%3 == 0)
            {
                arr3.add(i);
            }
            else if(i%2 == 0)
            {
                arr2.add(i);
            }
            else
                arrAll.add(i);
        }

        printList(arr3);
        printList(arr2);
        printList(arrAll);
    }

    public static void printList(List<Integer> list) {
        //add your code here
        for(int i: list)
            System.out.println(i);
    }
}
