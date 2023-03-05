package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

public interface WorkflowCommand {
    void execute();

    void undo();
}
