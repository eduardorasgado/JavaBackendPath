package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

public class RemoveStepCommand extends AbstractWorkflowCommand {

    private String step;

    public RemoveStepCommand(WorkflowDesigner workflowDesigner, String step) {
        super(workflowDesigner);
        this.step = step;
    }

    @Override
    public void execute() {
        WorkflowDesigner receiver = getWorkflowDesigner();

        setMemento(receiver.getMemento());
        receiver.removeStep(step);
    }
}
