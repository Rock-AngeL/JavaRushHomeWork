package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by APopov on 21.09.2015.
 */
public class Controller
{
    private Provider[] providers;

    public Controller(Provider... providers)
    {
        if (providers==null||providers.length==0){throw new IllegalArgumentException();}
        this.providers = providers;
    }

    @Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan()
    {
        ArrayList<Vacancy> listVacancy = new ArrayList<Vacancy>();
        for(Provider provider : providers)
        {
            listVacancy.addAll(provider.getJavaVacancies("kiev"));
        }

        System.out.println(listVacancy.size());
    }
}
