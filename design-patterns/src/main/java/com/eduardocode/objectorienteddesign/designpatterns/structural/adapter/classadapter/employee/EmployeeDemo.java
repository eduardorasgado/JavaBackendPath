package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.classadapter.employee;

public class EmployeeDemo {

    public static void main(String[] args) {
        EmployeeClassAdapter employeeAdapter = new EmployeeClassAdapter();
        populateEmployeeData(employeeAdapter);

        BusinessCardDesigner cardDesigner = new BusinessCardDesigner();
        System.out.println(cardDesigner.designCard(employeeAdapter));
    }

    private static void populateEmployeeData(Employee employee) {
        employee.setFullName("Elliot Alderson");
        employee.setJobTitle("Security Engineer");
        employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
    }
}
