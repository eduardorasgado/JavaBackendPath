package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.company;

import static java.util.Objects.nonNull;

public abstract class Employee implements LeaveApprover {
    private String role;

    private LeaveApprover nextApprover;

    public Employee(String role, LeaveApprover nextApprover) {
        this.role = role;
        this.nextApprover = nextApprover;
    }

    @Override
    public void processLeaveApplication(LeaveApplication application) {
        if(!processRequest(application) && nonNull(nextApprover)) {
            nextApprover.processLeaveApplication(application);
        }
    }

    protected abstract boolean processRequest(LeaveApplication application);

    @Override
    public String getApproverRole() {
        return role;
    }
}
