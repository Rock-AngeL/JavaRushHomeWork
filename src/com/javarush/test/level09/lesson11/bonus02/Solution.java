package com.javarush.test.level09.lesson11.bonus02;

import java.io.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Новая задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Если файла (который нужно копировать) с указанным именем не существует, то
программа должна вывести надпись «Файл не существует.» и еще раз прочитать имя файла с консоли, а уже потом считывать файл для записи.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream;

        //Считываем в цикле то, что вводится в коммандной строке
        while (true)
            try {
                String sourceFileName = reader.readLine();
                fileInputStream = new FileInputStream(sourceFileName);
                break;
                //Если указанный в ком. строке файл есть, то цикл прерываем
            }
            catch (Exception e)
            {
                System.out.println("Файл не существует.");
                String sourceFileName = reader.readLine();
                fileInputStream = new FileInputStream(sourceFileName);
                //Если указанный в ком. строке файл есть, то цикл прерываем
                break;
            }

        String destinationFileName = reader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

        //пока есть биты в файле, открытом на чтение, продолжаем цикл
        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
