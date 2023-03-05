package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

public class CreateCommand extends AbstractWorkflowCommand {

    private final String name;

    public CreateCommand(WorkflowDesigner workflowDesigner, String name) {
        super(workflowDesigner);
        this.name = name;
    }

    @Override
    public void execute() {
        WorkflowDesigner receiver = getWorkflowDesigner();

        setMemento(receiver.getMemento());
        receiver.createWorkflow(name);
    }
}
