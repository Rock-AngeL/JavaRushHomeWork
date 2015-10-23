package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by APopov on 16.07.2015.
 */
public class CurrencyManipulator
{
    private String currencyCode;

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public void addAmount(int denomination, int count)
    {
        denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int res = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            res += pair.getKey() * pair.getValue();
        }
        return res;
    }

    public boolean hasMoney()
    {
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        if (hasMoney() && getTotalAmount() >= expectedAmount)
        {
            return true;
        }
        return false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        tm.putAll(denominations);
        NavigableMap<Integer, Integer> destOrder = tm.descendingMap();

//        NavigableMap<Integer, Integer> copy = tm.descendingMap();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int req = expectedAmount;
        for (int start = 0; start < destOrder.size(); start++)
        {
            for (int j = start; j < destOrder.size(); j++)
            {
                //it
                Iterator<Map.Entry<Integer, Integer>> it = destOrder.entrySet().iterator();
                //for it
                for (int k = 0; k < j; k++)
                {
                    it.next();
                }

                Map.Entry<Integer, Integer> pair = it.next();
                Integer nominal = pair.getKey();
                Integer count = pair.getValue();
                for (int k = 0; k < count; k++)
                {
                    if (req>=nominal){
                        map.put(nominal,k+1);
                        req -= nominal;
                    }else break;
                }
            }
            if (req == 0){
                System.out.println("Good");
                break;
            }else {
                req = expectedAmount;
                map = new HashMap<Integer, Integer>();
            }
        }

        if (map.size() == 0){
            throw new NotEnoughMoneyException();
        }else {
            for (Map.Entry<Integer, Integer> pair :map.entrySet())
            {
                Integer key = pair.getKey();
                Integer count = pair.getValue();

                Integer curCount = denominations.get(key);
                int balance = curCount - count;
                if (balance == 0){
                    denominations.remove(key);
                }else {
                    denominations.put(key, balance);
                }
            }
        }

        return map;
    }
}
