package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public class Engineer extends Employee {

    public Engineer(long id, String name, String position, Department department, int salary) {
        super(id, name, position, department, salary);
    }

    @Override
    public boolean isManager() {
        return false;
    }

    @Override
    public int teamSize() {
        return 1;
    }

    @Override
    public String teamNames() {
        return "{NA}";
    }
}
