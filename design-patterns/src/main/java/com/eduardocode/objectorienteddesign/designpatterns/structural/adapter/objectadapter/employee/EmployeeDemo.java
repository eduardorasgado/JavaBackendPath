package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.employee;

public class EmployeeDemo {

    public static void main(String[] args) {
        Employee employee = new Employee();
        populateEmployeeData(employee);

        EmployeeObjectAdapter employeeAdapter = new EmployeeObjectAdapter(employee);

        BusinessCardDesigner cardDesigner = new BusinessCardDesigner();
        System.out.println(cardDesigner.designCard(employeeAdapter));
    }

    private static void populateEmployeeData(Employee employee) {
        employee.setFullName("Elliot Alderson");
        employee.setJobTitle("Security Engineer");
        employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
    }
}
