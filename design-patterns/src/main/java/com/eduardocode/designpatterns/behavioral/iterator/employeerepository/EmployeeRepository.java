package com.eduardocode.designpatterns.behavioral.iterator.employeerepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeRepository implements Iterable<Employee> {
    private List<Employee> employees;

    public EmployeeRepository() {
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public Iterator<Employee> iterator() {
        return employees.iterator();
    }
}
