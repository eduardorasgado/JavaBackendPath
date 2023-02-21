package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.employee;

public class EmployeeObjectAdapter implements Customer {

    private final Employee employee;

    public EmployeeObjectAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return employee.getFullName();
    }

    @Override
    public String getDesignation() {
        return employee.getJobTitle();
    }

    @Override
    public String getAddress() {
        return employee.getOfficeLocation();
    }
}
