package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public class DepartmentExpression implements Expression {

    private final String value;

    public DepartmentExpression(String value) {
        this.value = value;
    }


    @Override
    public boolean interpret(Employee employee) {
        return employee.getDepartment().name().equalsIgnoreCase(value);
    }

    @Override
    public String toString() {
        return "DepartmentExpression{" +
                "value='" + value + '\'' +
                '}';
    }
}
