package com.javarush.test.level15.lesson12.home06;

/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name
*/

public class Solution {


    {
        System.out.println("non-static block");  //4
        printAllFields(this);
    }

    public int i = 6;

    public String name = "First name";  //9

    static { //2
        init();
    }

    static {
        System.out.println("Static block"); //1
    }

    public Solution() {
        System.out.println("Solution constructor");  //8
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()"); //2
    }

    public static void main(String[] args) {
        System.out.println("public static void main");  //3
        Solution s = new Solution();
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");  //5
        System.out.println(obj.i);  //10
        System.out.println(obj.name); //6

    }
}
