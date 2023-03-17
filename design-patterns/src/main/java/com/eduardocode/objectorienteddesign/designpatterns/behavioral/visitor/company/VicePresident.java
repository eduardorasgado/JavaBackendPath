package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class VicePresident extends AbstractEmployee {

    private final List<Employee> directReports = new ArrayList<>();

    public VicePresident(String name, Employee... employees) {
        super(name);
        directReports.addAll(Arrays.asList(employees));
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
