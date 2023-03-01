package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.company;

public class ProjectLead extends Employee {

    public ProjectLead(LeaveApprover nextApprover) {
        super("Project Lead", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if(!application.getType().equals(LeaveApplication.Type.Sick) || application.getNoOfDays() > 2) {
            return false;
        }

        application.approve(getApproverRole());
        return true;
    }
}
