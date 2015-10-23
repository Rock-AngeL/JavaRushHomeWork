package com.javarush.test.level14.lesson08.home09;

/**
 * Created by APopov on 14.05.2015.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName(){
        return "USD";
    }
}
