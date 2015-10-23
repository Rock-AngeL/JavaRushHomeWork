package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.*;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by APopov on 16.07.2015.
 */
public final class CommandExecutor
{
    private static Map<Operation, Command> map = new HashMap<Operation, Command>();

    private CommandExecutor()
    {
    }

    static
    {
        map.put(Operation.LOGIN, new LoginCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.EXIT, new ExitCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        map.get(operation).execute();
    }
}

class ExitCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"exit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString();
        if (res.getString("yes").equalsIgnoreCase(answer.trim()))
            ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
}

class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        //1.1
        String curCode = ConsoleHelper.askCurrencyCode();
        //1.2
        CurrencyManipulator man = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode);
        //1.3
        while (true)
        {
            try
            {
                //1.3.1
                ConsoleHelper.writeMessage(res.getString("specify.amount"));

                int amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount < 0)
                {
                    throw new NumberFormatException();
                }
                //1.3.3
                if (!man.isAmountAvailable(amount))
                {
                    //go to 1.3
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    continue;
                }
                //1.3.4
                Map<Integer, Integer> map = man.withdrawAmount(amount);
                //1.3.5
                TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
                tm.putAll(map);
                NavigableMap<Integer, Integer> destOrder = tm.descendingMap();
                for (Map.Entry<Integer, Integer> pair : destOrder.entrySet())
                {
                    ConsoleHelper.writeMessage(String.format("\t%d - %d", pair.getKey(), pair.getValue()));
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, curCode));
                break;
            }
            catch (NumberFormatException e)
            {
                //1.3.2
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
            catch (NotEnoughMoneyException ignor)
            {
                //NOP
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
        }
    }
}

class LoginCommand implements Command
{

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards"),
            res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        while (true)
        {
            String tryCardNumb = ConsoleHelper.readString();
            String tryPin = ConsoleHelper.readString();
            if (tryCardNumb.matches("\\d{12}") && tryPin.matches("\\d{4}"))
            {
                if (validCreditCards.keySet().contains(tryCardNumb) && validCreditCards.getString(tryCardNumb).equals(tryPin))
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), tryCardNumb));
                    break;
                }
                else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), tryCardNumb));
                }
            } else
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}

class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        String curCode = ConsoleHelper.askCurrencyCode();

        CurrencyManipulator man = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode);

        String[] ar = ConsoleHelper.getValidTwoDigits(curCode);

        int denomination = Integer.parseInt(ar[0]);
        int count = Integer.parseInt(ar[1]);

        man.addAmount(denomination, count);

        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denomination * count, curCode));
    }
}

class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().size() == 0)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }

        boolean hasMoney = false;
        for (CurrencyManipulator currencyManipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (currencyManipulator.hasMoney())
            {
                ConsoleHelper.writeMessage(String.format("%s - %d\n", currencyManipulator.getCurrencyCode(), currencyManipulator.getTotalAmount()));
                hasMoney = true;
            }
        }
        if (!hasMoney)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}

interface Command
{
    void execute() throws InterruptOperationException;
}
