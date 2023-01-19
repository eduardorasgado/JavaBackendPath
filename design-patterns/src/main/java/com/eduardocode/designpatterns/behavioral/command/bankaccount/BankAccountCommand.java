package com.eduardocode.designpatterns.behavioral.command.bankaccount;

import java.util.HashMap;
import java.util.Map;

public class BankAccountCommand implements Command {
    private final BankAccount bankAccount;
    private final Action action;
    private final int amount;
    private boolean success;
    private Map<Action, Runnable> actionMap;

    public BankAccountCommand(BankAccount bankAccount, Action action, int amount) {
        this.bankAccount = bankAccount;
        this.action = action;
        this.amount = amount;

        actionMap = new HashMap<>();
        actionMap.put(Action.DEPOSIT, () -> {
           bankAccount.deposit(amount);
           success = true;
        });
        actionMap.put(Action.WITHDRAW, () -> {
            success = bankAccount.withdraw(amount);
        });
    }

    @Override
    public void execute() {
        actionMap.get(action).run();
    }

    @Override
    public void undo() {
        if(action.equals(Action.DEPOSIT)) {
            actionMap.get(Action.WITHDRAW).run();
        } else {
            actionMap.get(Action.DEPOSIT).run();
        }
    }

    public Action getAction() {
        return action;
    }

    public boolean isSuccess() {
        return success;
    }

    public enum Action {
        WITHDRAW,
        DEPOSIT;
    }
}
