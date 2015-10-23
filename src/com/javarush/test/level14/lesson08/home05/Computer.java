package com.javarush.test.level14.lesson08.home05;

/**
 * Created by APopov on 14.05.2015.
 */
public class Computer
{
    private Mouse mouse;
    private Keyboard keyboard;
    private Monitor monitor;

    public Computer()
    {
        this.mouse = new Mouse();
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
    }

    public Computer(Mouse mouse, Keyboard keyboard, Monitor monitor)
    {
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}
