package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager extends AbstractEmployee {

    private List<Employee> directReports;

    public Manager(String name, Employee... employees) {
        super(name);

        directReports = new ArrayList<>();
        Arrays.stream(employees).forEach(directReports::add);
    }

    @Override
    public List<Employee> getDirectReports() {
        return directReports;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        super.accept(visitor);
    }
}
