package com.javarush.test.level26.lesson15.big01;

/**
 * Created by APopov on 16.07.2015.
 */
public enum Operation
{
    LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        try
        {
            if(i == 0)
            {
                throw new IllegalArgumentException();
            }
            return values()[i];
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }
}
