package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.company;

public class CompanyDemo {

    public static void main(String[] args) {
        Employee employee = buildOrganization();

        System.out.println("Printing the organization: ");
        employee.accept(new PrintVisitor());

        System.out.println();

        System.out.println("Printing the organization performance rating");

        AppraisalVisitor organizationPerformanceRating = new AppraisalVisitor();
        employee.accept(organizationPerformanceRating);

        System.out.println("Id 101: " + organizationPerformanceRating.getFinalRatings().getFinalRating(101));
        System.out.println("Id 109: " + organizationPerformanceRating.getFinalRatings().getFinalRating(109));

    }

    private static Employee buildOrganization() {

        Programmer p1 = new Programmer("Rachel","C++");
        p1.setPerformanceRating(8);
        Programmer p2 = new Programmer("Andy","Java");
        p2.setPerformanceRating(10);

        Programmer p3 = new Programmer("Josh","C#");
        p3.setPerformanceRating(9);
        Programmer p4 = new Programmer("Bill","C++");
        p4.setPerformanceRating(7);

        ProjectLead pl1 = new ProjectLead("Tina", p1, p2);
        pl1.setPerformanceRating(9);
        ProjectLead pl2 = new ProjectLead("Joey", p3, p4);
        pl2.setPerformanceRating(10);

        Manager m1 = new Manager("Chad", pl1);
        m1.setPerformanceRating(8);
        Manager m2 = new Manager("Chad II", pl2);
        m2.setPerformanceRating(10);

        VicePresident vp = new VicePresident("Richard", m1,m2);
        vp.setPerformanceRating(9);

        return vp;
    }
}
