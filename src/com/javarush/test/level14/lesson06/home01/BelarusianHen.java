package com.javarush.test.level14.lesson06.home01;

/**
 * Created by APopov on 13.05.2015.
 */
public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth(){
        return 50;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
