package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, byte[]> map = new TreeMap<Integer, byte[]>();
        String nameNewFile = "";
        int allCountByte = 0;
        while (true)
        {
            String s = reader.readLine();

            if("end".equals(s)){
                break;
            }

            FileInputStream fileInputStream = new FileInputStream(s);

            byte[] byteMass = new byte[fileInputStream.available()];
            allCountByte += fileInputStream.read(byteMass);

            String s1[] = s.split("\\.part"); //[someName] , partN
            int partNumber = Integer.parseInt(s1[s1.length-1]); // N

            if(nameNewFile.isEmpty()) nameNewFile = s1[0];

            map.put(partNumber, byteMass);
            fileInputStream.close();
        }

        BufferedOutputStream outBufStream = new BufferedOutputStream(new FileOutputStream(nameNewFile, true));

        for (Map.Entry<Integer, byte[]> entry : map.entrySet())
        {
            outBufStream.write(entry.getValue());
            outBufStream.flush();
        }

        outBufStream.close();
        reader.close();
    }

    /*public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        Set<File> fileset = new TreeSet<File>();
        while (!"exit".equalsIgnoreCase(name = reader.readLine())) { //!"exit".equalsIgnoreCase(  //!(name = reader.readLine()).equals("end"))
            File file = new File(name);
            fileset.add(file);
        }
        Iterator<File> itr = fileset.iterator();
        String folder = itr.next().getAbsolutePath();

        folder = folder.substring(0, folder.length() - 6);

        FileOutputStream resultFile = new FileOutputStream(folder, true);
        for (File file : fileset) {
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[in.available()];
            while (in.available() > 0) {
                in.read(buffer);
                resultFile.write(buffer);
            }
            in.close();
        }
        resultFile.close();
    }*/
}
