package com.javarush.test.level24.lesson14.big01;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by APopov on 14.07.2015.
 */
public class Arcanoid
{
    //������ � ������
    private int width;
    private int height;

    //������ ��������
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    //�����
    private Ball ball;
    //���������
    private Stand stand;

    //���� ���������?
    private boolean isGameOver = false;

    public Arcanoid(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public ArrayList<Brick> getBricks()
    {
        return bricks;
    }

    public Ball getBall()
    {
        return ball;
    }

    public void setBall(Ball ball)
    {
        this.ball = ball;
    }

    public Stand getStand()
    {
        return stand;
    }

    public void setStand(Stand stand)
    {
        this.stand = stand;
    }

    /**
     * ������ �� ������ ������� � ��� �������.
     */
    public void draw(Canvas canvas)
    {
        //������� �������
        canvas.print();
        //������� �������
        for (Brick brick :bricks)
        {
            brick.draw(canvas);
        }

        //������� �����
        ball.draw(canvas);
        //������� ���������
        stand.draw(canvas);
    }

    /**
     * ������ �� ������ �������
     */
    private void drawBoders(Canvas canvas)
    {
        //draw game
        for (int i = 0; i < width + 2; i++)
        {
            for (int j = 0; j < height + 2; j++)
            {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++)
        {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++)
        {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }
    }

    /**
     *  �������� ���� ���������.
     *  ��� ���������� ��� ������ ��������
     */
    public void run() throws Exception
    {
        //������� ����� ��� ���������.
        Canvas canvas = new Canvas(width, height);

        //������� ������ "����������� �� �����������" � �������� ���.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //��������� ����, ���� ���� �� ��������
        while (!isGameOver)
        {
            //"�����������" �������� ������� � ������� ������?
            if (keyboardObserver.hasKeyEvents())
            {
                KeyEvent event = keyboardObserver.getEventFromTop();

                //���� "������� �����" - �������� ������� �����
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    stand.moveLeft();
                    //���� "������� ������" - �������� ������� ������
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    stand.moveRight();
                    //���� "������" - ��������� �����
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ball.start();
            }

            //������� ��� �������
            move();

            //��������� ������������
            checkBricksBump();
            checkStandBump();

            //���������, ��� ����� ��� ������� ����� ���.
            checkEndGame();

            //������������ ��� �������
            canvas.clear();
            draw(canvas);
            canvas.print();

            //�����
            Thread.sleep(300);
        }

        //������� ��������� "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * ������� ����� � ���������.
     */
    public void move()
    {
        //������ �����
        ball.move();
        //������ ���������
        stand.move();
    }

    /**
     * ��������� ������������ � ���������.
     * ���� ������������ ���� - ����� �������� � ��������� ����������� 0..360 ��������
     */
    public void checkBricksBump()
    {
        //��� ������� - ���������� �� ����� � ��������.
        List<Brick> copy = new ArrayList<Brick>(bricks);
        for (Brick brick :copy)
        {
            if (ball.isIntersec(brick)){
                //���� �� - ������� �������, � ����� ��������� � �������� �����������.
                bricks.remove(brick);
                ball.setDirection(Math.random()*360);
                return;
            }
        }

    }

    /**
     * ��������� ������������ � ����������.
     * ���� ������������ ���� - ����� �������� � ��������� �����������  ����� 80..100 ��������.
     */
    public void checkStandBump()
    {
        //��� ������� - ���������� �� ����� � ����������.
        if (ball.isIntersec(stand)){
            //���� �� - ��������� �����  ����� �� 80..100 ��������.
            ball.setDirection(Math.random()*20 + 80);
        }
    }

    /**
     * ��������� - �� ������ �� ����� ����� ���.
     * ���� �� - ���� �������� (isGameOver = true)
     */
    public void checkEndGame()
    {
        //���� ����� ������ �� ������ ������� - ���� ��������.
        if (ball.y > height) isGameOver = true;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public static Arcanoid game;

    public static void main(String[] args) throws Exception
    {
        game = new Arcanoid(20, 30);

        Ball ball = new Ball(10, 29, 2,  95);
        game.setBall(ball);

        Stand stand = new Stand(10, 30);
        game.setStand(stand);

        game.getBricks().add(new Brick(3, 3));
        game.getBricks().add(new Brick(7, 5));
        game.getBricks().add(new Brick(12, 5));
        game.getBricks().add(new Brick(16, 3));

        game.run();
    }
}
