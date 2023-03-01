package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.company;

public class Manager extends Employee {

    public Manager(LeaveApprover nextApprover) {
        super("Manager", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if (!application.getType().equals(LeaveApplication.Type.Sick)
                && !application.getType().equals(LeaveApplication.Type.PTO)) {
            return false;
        }

        if(application.getType().equals(LeaveApplication.Type.PTO) && application.getNoOfDays() > 5) {
            return false;
        }

        application.approve(getApproverRole());
        return true;
    }
}
