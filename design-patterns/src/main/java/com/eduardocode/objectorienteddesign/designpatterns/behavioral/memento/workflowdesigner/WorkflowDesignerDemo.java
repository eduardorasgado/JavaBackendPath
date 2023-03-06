package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

public class WorkflowDesignerDemo {

    public static void main(String[] args) {
        WorkflowDesigner designer = new WorkflowDesigner();
        WorkflowUndoManager undoManager = new WorkflowUndoManager();

        System.out.println("Running commands...");
        runCommands(designer, undoManager);
        System.out.println();

        System.out.println("Undoing commands...");
        undoManager.undoCommand();
        designer.print();
        System.out.println();

        undoManager.undoCommand();
        designer.print();
        System.out.println();

        undoManager.undoCommand();
        designer.print();
        System.out.println();

        undoManager.undoCommand();
        designer.print();
        System.out.println();

        undoManager.undoCommand();
        designer.print();
    }

    private static void runCommands(WorkflowDesigner designer, WorkflowUndoManager undoManager) {

        undoManager.addCommand(new CreateCommand(designer,"Leave Workflow"));
        designer.print();

        undoManager.addCommand(new AddStepCommand(designer,"Create Leave Application"));
        designer.print();

        undoManager.addCommand(new AddStepCommand(designer,"Submit Application"));
        designer.print();

        undoManager.addCommand(new AddStepCommand(designer,"Application Approved"));
        designer.print();
    }
}
