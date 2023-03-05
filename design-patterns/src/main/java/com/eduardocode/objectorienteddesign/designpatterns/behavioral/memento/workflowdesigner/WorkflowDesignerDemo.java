package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

import java.util.LinkedList;

public class WorkflowDesignerDemo {

    public static void main(String[] args) {
        WorkflowDesigner designer = new WorkflowDesigner();
        LinkedList<WorkflowCommand> commands = runCommands(designer);
        designer.print();
        System.out.println();

        undoLastCommand(commands);
        designer.print();
        System.out.println();

        undoLastCommand(commands);
        designer.print();
        System.out.println();

        undoLastCommand(commands);
        designer.print();
        System.out.println();

        undoLastCommand(commands);
        designer.print();
        System.out.println();

        undoLastCommand(commands);
        designer.print();
    }

    private static void undoLastCommand(LinkedList<WorkflowCommand> commands) {
        if(!commands.isEmpty())
            commands.removeLast().undo();
    }

    private static LinkedList<WorkflowCommand> runCommands(WorkflowDesigner designer) {
        LinkedList<WorkflowCommand> commands = new LinkedList<>();

        WorkflowCommand cmd = new CreateCommand(designer,"Leave Workflow");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer,"Create Leave Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer,"Submit Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer,"Application Approved");
        commands.addLast(cmd);
        cmd.execute();

        return commands;
    }
}
