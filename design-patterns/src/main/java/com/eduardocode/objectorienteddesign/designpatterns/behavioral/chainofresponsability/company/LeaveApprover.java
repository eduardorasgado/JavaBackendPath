package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.company;

public interface LeaveApprover {
    void processLeaveApplication(LeaveApplication application);

    String getApproverRole();
}
