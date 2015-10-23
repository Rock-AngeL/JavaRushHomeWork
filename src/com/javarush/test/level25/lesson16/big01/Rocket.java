package com.javarush.test.level25.lesson16.big01;

/**
 * Created by APopov on 15.07.2015.
 */
public class Rocket extends BaseObject
{
    public Rocket(double x, double y)
    {
        super(x, y, 1);
    }

    /**
     * ����� ������ ���� ������ �� "�������".
     */
    @Override
    public void draw(Canvas canvas)
    {
        canvas.setPoint(x,y,'R');
    }

    /**
     * ������� ���� ����� �� ���� ���.
     */
    @Override
    public void move()
    {
        y--;
    }
}
