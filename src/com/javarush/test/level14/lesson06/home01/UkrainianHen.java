package com.javarush.test.level14.lesson06.home01;

/**
 * Created by APopov on 13.05.2015.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth(){
        return 0;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
