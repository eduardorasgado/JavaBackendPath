package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

import java.util.LinkedList;

import static java.util.Objects.isNull;

public class WorkflowUndoManager {

    private final LinkedList<WorkflowCommand> commands;

    public WorkflowUndoManager() {
        commands = new LinkedList<>();
    }

    public void addCommand(WorkflowCommand command) {
        commands.add(command);
        command.execute();
    }

    public WorkflowCommand undoCommand() {
        if(!canUndo()) {
           return null;
        }

        WorkflowCommand command = commands.removeLast();
        command.undo();
        return command;
    }

    private boolean canUndo() {
        return !commands.isEmpty();
    }
}
