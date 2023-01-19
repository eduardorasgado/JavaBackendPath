package com.eduardocode.designpatterns.behavioral.command.bankaccount;

import java.util.Arrays;
import java.util.List;

public class BankAccountWithHistoryDemo {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<Command> commands = Arrays.asList(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 1000),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 500),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 200),
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 1000)
        );

        CommandHistory history = new CommandHistory();

        for(Command command : commands) {
            history.push(command);

            System.out.println(ba);
        }

        history.undo();
        System.out.println(ba);
        history.undo();
        System.out.println(ba);

        history.redo();
        System.out.println(ba);
    }
}