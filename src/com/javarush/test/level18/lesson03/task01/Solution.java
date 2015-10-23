package com.javarush.test.level18.lesson03.task01;

import java.io.FileInputStream;
import java.util.Scanner;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inStream = new FileInputStream(new Scanner(System.in).nextLine());
        int max = Integer.MIN_VALUE;
        int n = inStream.available();
        for (int i = 0; i < n; i++)
        {
            int data = inStream.read();
            max = max > data? max: data;
        }
        inStream.close();
        System.out.println(max);
    }
}
