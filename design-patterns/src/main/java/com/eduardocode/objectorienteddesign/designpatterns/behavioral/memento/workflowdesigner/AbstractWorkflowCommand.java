package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

public abstract class AbstractWorkflowCommand implements WorkflowCommand{
    private WorkflowDesigner.Memento memento;

    private final WorkflowDesigner workflowDesigner;

    public AbstractWorkflowCommand(WorkflowDesigner workflowDesigner) {
        this.workflowDesigner = workflowDesigner;
    }

    protected final WorkflowDesigner.Memento getMemento() {
        return memento;
    }

    protected final void setMemento(WorkflowDesigner.Memento memento) {
        this.memento = memento;
    }

    protected final WorkflowDesigner getWorkflowDesigner() {
        return workflowDesigner;
    }

    @Override
    public void undo() {
        workflowDesigner.setMemento(memento);
    }
}
