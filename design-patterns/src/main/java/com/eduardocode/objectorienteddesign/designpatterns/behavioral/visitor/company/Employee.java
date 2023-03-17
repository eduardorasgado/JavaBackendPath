package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.company;

import java.util.Collection;

public interface Employee {

    String getName();

    int getPerformanceRating();

    void setPerformanceRating(int rating);

    Collection<Employee> getDirectReports();

    int getEmployeeId();

    void accept(Visitor visitor);
}
