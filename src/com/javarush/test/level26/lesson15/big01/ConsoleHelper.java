package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by APopov on 16.07.2015.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static void printExitMessage(){
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            try
            {
                ConsoleHelper.writeMessage(res.getString("choose.operation"));
                ConsoleHelper.writeMessage(res.getString("operation.INFO"));
                ConsoleHelper.writeMessage(res.getString("operation.DEPOSIT"));
                ConsoleHelper.writeMessage(res.getString("operation.WITHDRAW"));
                ConsoleHelper.writeMessage(res.getString("operation.EXIT"));
                int i = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(i);
            }catch (NumberFormatException ignor){
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
            String s = readString();
            if (s.length() == 3){
                return s.toUpperCase();
            }
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        while (true){
            try
            {
                ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
                String[] split = readString().split("\\s");
                int i1 = Integer.parseInt(split[0]);
                int i2 = Integer.parseInt(split[1]);
                if (i1 > 0 && i2 > 0)
                {
                    return split;
                } else
                {
                    ConsoleHelper.writeMessage(res.getString("invalid.data"));
                }
            }catch (NumberFormatException e){
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String readString() throws InterruptOperationException
    {
        String line = null;
        try
        {
            line = reader.readLine();
            if ("EXIT".equalsIgnoreCase(line))
                throw new InterruptOperationException();
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
        return line;
    }
}
