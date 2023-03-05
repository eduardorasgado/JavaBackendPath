package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

public abstract class AbstractWorkflowCommand implements WorkflowCommand{
    private WorkflowDesigner.Memento memento;

    private final WorkflowDesigner workflowDesigner;

    public AbstractWorkflowCommand(WorkflowDesigner workflowDesigner) {
        this.workflowDesigner = workflowDesigner;
    }

    protected WorkflowDesigner.Memento getMemento() {
        return memento;
    }

    protected void setMemento(WorkflowDesigner.Memento memento) {
        this.memento = memento;
    }

    protected WorkflowDesigner getWorkflowDesigner() {
        return workflowDesigner;
    }

    @Override
    public void undo() {
        workflowDesigner.setMemento(memento);
    }
}
