package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.company;

public class Director extends Employee {

    public Director(LeaveApprover nextApprover) {
        super("Director", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if(!application.getType().equals(LeaveApplication.Type.PTO)) {
            return false;
        }

        if(application.getNoOfDays() > 15) {
            application.reject(getApproverRole());
            return false;
        }

        application.approve(getApproverRole());
        return true;
    }
}
