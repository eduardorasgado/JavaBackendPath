package com.eduardocode.designpatterns.behavioral.command.bankaccount;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BankAccountDemo {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<Command> commands = Arrays.asList(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
        );

        for(Command command : commands) {
            command.execute();
            System.out.println(ba);
        }

        Collections.reverse(commands);

            for (Command command: commands) {
            command.undo();
            System.out.println(ba);
        }
    }
}