package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.classadapter.employee;

public class EmployeeClassAdapter extends Employee implements Customer{

    @Override
    public String getName() {
        return getFullName();
    }

    @Override
    public String getDesignation() {
        return getJobTitle();
    }

    @Override
    public String getAddress() {
        return getOfficeLocation();
    }
}
