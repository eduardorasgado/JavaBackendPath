package com.eduardocode.objectorienteddesign.designpatterns.behavioral.memento.workflowdesigner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class WorkflowDesigner {
    private Workflow workflow;

    public void createWorkflow(String name) {
        workflow = new Workflow(name);
    }

    public Workflow getWorkflow() {
        return this.workflow;
    }

    public Memento getMemento() {
        if(isNull(workflow)) {
            return new Memento();

        }

        return new Memento(workflow.getSteps(), workflow.getName());
    }

    public void setMemento(Memento memento) {
        if(memento.mementoIsNotInitialized()) {
            workflow = null;
            return;
        }

        workflow = new Workflow(memento.getWorkflowName(), memento.getSteps());
    }

    public void addStep(String step) {
        workflow.addStep(step);
    }

    public void removeStep(String step) {
        workflow.removeStep(step);
    }

    public void print() {
        System.out.println(workflow);
    }

    public class Memento {
        private String[] steps;
        private String workflowName;

        public Memento() {
        }

        public Memento(String[] steps, String workflowName) {
            this.steps = steps;
            this.workflowName = workflowName;
        }

        private String[] getSteps() {
            return steps;
        }

        private String getWorkflowName() {
            return workflowName;
        }

        private boolean mementoIsNotInitialized() {
            return isNull(getSteps()) && isNull(getWorkflowName());
        }
    }
}
