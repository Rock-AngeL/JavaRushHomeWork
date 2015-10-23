package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by APopov on 16.07.2015.
 */
public final class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory()
    {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){return cMMap.values();}

    private static Map<String, CurrencyManipulator> cMMap = new HashMap<String, CurrencyManipulator>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        CurrencyManipulator manipulator = cMMap.get(currencyCode);
        if (manipulator == null)
        {
            manipulator = new CurrencyManipulator(currencyCode);
            cMMap.put(currencyCode, manipulator);
        }
        return manipulator;
    }
}
