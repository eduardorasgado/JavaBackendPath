package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Manager extends Employee {

    private List<Employee> team;

    public Manager(long id, String name, String position, Department department, int salary) {
        super(id, name, position, department, salary);

        team = new ArrayList<>();
    }

    public boolean manages(Employee employee) {
        return getTeam().add(employee);
    }

    public boolean stopManaging(Employee employee) {
        return getTeam().remove(employee);
    }

    private List<Employee> getTeam() {
        return team;
    }

    @Override
    public boolean isManager() {
        return true;
    }

    @Override
    public int teamSize() {
        return team.stream().mapToInt(Employee::teamSize).sum();
    }

    @Override
    public String teamNames() {
        return getTeam().stream().collect(ArrayList<String>::new, (collection, employee) -> {
            collection.add(employee.getName());

            if(employee.isManager()) {
                for (String s : employee.teamNames().split(", ")) {
                    if (!collection.contains(s)) {
                        collection.add(s);
                    }
                }
            }
        }, ArrayList::addAll).stream().collect(Collectors.joining(", "));
    }
}
