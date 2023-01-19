package com.eduardocode.designpatterns.behavioral.command.bankaccount;

import java.util.ArrayDeque;
import java.util.Stack;

public class CommandHistory {
    private final Stack<Command> history = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();


    public void push(Command command) {
        command.execute();
        history.push(command);
        redoStack.clear();
    }

    public void undo() {
        System.out.println("Undoing... ");
        if(!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        System.out.println("Redoing... ");
        if(!history.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            history.push(command);
        }
    }
}
