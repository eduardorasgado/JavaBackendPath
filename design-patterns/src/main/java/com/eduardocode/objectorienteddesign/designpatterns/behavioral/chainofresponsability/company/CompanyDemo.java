package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.company;

import java.time.LocalDate;

public class CompanyDemo {
    private static LeaveApprover leaveApproverChain;

    public static void main(String[] args) {

        leaveApproverChain = createLeaveApproverChain();

        LeaveApplication application1 = getLeaveApplication(LeaveApplication.Type.Sick, 1);
        leaveApproverChain.processLeaveApplication(application1);
        System.out.println(application1);

        LeaveApplication application2 = getLeaveApplication(LeaveApplication.Type.Sick, 17);
        leaveApproverChain.processLeaveApplication(application2);
        System.out.println(application2);

        LeaveApplication application3 = getLeaveApplication(LeaveApplication.Type.PTO, 1);
        leaveApproverChain.processLeaveApplication(application3);
        System.out.println(application3);

        LeaveApplication application4 = getLeaveApplication(LeaveApplication.Type.PTO, 5);
        leaveApproverChain.processLeaveApplication(application4);
        System.out.println(application4);

        LeaveApplication application5 = getLeaveApplication(LeaveApplication.Type.PTO, 6);
        leaveApproverChain.processLeaveApplication(application5);
        System.out.println(application5);

        LeaveApplication application6 = getLeaveApplication(LeaveApplication.Type.PTO, 18);
        leaveApproverChain.processLeaveApplication(application6);
        System.out.println(application6);
    }

    private static LeaveApprover createLeaveApproverChain() {
        Director director = new Director(null);
        Manager manager = new Manager(director);
        ProjectLead projectLead = new ProjectLead(manager);

        return projectLead;
    }

    private static LeaveApplication getLeaveApplication(LeaveApplication.Type type, int days) {
        return LeaveApplication.getBuilder()
                .withType(type)
                .from(LocalDate.now())
                .to(LocalDate.now().plusDays(days))
                .build();
    }
}
