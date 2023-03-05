package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

public class AddStepCommand extends AbstractWorkflowCommand {

    private final String step;

    public AddStepCommand(WorkflowDesigner workflowDesigner, String step) {
        super(workflowDesigner);
        this.step = step;
    }

    @Override
    public void execute() {
        WorkflowDesigner receiver = getWorkflowDesigner();

        setMemento(receiver.getMemento());
        receiver.addStep(step);
    }
}
