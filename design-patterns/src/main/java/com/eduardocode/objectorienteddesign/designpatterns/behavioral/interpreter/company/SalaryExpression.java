package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public class SalaryExpression implements Expression {
    private String value;

    public SalaryExpression(String value) {
        this.value = value;
    }


    @Override
    public boolean interpret(Employee employee) {
        return evalSalary(employee.getSalary());
    }

    private boolean evalSalary(int salary) {
        int integerToCompare;
        try {
            integerToCompare = Integer.parseInt(value);
            return integerToCompare == salary;
        } catch (NumberFormatException ignored) {
            integerToCompare = Integer.parseInt(value.substring(1));
        }

        return evalSalary(salary, integerToCompare, value.charAt(0));
    }

    private boolean evalSalary(int salary, int integerToCompare, char operator) {
        switch (operator) {
            case '>':
                return salary > integerToCompare;
            case '<':
                return salary < integerToCompare;
            default:
                return false;
        }
    }
}
