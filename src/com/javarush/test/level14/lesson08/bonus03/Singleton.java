package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by APopov on 14.05.2015.
 */
public class Singleton
{
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    private Singleton() {}
}
