package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.company;

import java.util.Collection;
import java.util.Collections;

public abstract class AbstractEmployee implements Employee {
    private int performanceRating;

    private String name;

    private static int employeeIdCounter = 101;

    private int employeeId;

    public AbstractEmployee(String name) {
        this.name = name;
        employeeId = employeeIdCounter++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPerformanceRating() {
        return performanceRating;
    }

    @Override
    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public Collection<Employee> getDirectReports() {
        return Collections.emptyList();
    }

    @Override
    public void accept(Visitor visitor) {
        getDirectReports().forEach(employee -> employee.accept(visitor));
    }
}
