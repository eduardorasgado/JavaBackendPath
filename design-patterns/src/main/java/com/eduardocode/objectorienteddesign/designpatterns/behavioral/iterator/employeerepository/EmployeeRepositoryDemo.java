package com.eduardocode.objectorienteddesign.designpatterns.behavioral.iterator.employeerepository;

import java.util.Iterator;

public class EmployeeRepositoryDemo {

    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        repository.add(new Employee("Eduard", "IT", 10000));
        repository.add(new Employee("Mariam", "HR", 7000));
        repository.add(new Employee("Mario", "IT", 12000));

        for(Employee employee : repository) {
            System.out.println("Name: " + employee.getName() + " Department: " + employee.getDept() + " Salary: "+ employee.getSalary());
        }

        System.out.println();

        for(Iterator<Employee> iter = repository.iterator(); iter.hasNext();) {
            Employee employee = iter.next();
            System.out.println("Name: " + employee.getName() + " Department: " + employee.getDept() + " Salary: "+ employee.getSalary());
        }
    }
}
