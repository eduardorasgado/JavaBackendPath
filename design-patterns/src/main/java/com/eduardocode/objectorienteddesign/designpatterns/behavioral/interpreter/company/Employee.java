package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public abstract class Employee {

    private long id;
    private String name;
    private String position;
    private Department department;
    private int salary;

    public Employee(long id, String name, String position, Department department, int salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    public abstract boolean isManager();
    public abstract int teamSize();
    public abstract String teamNames();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String fullDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [").append(getId()).append(", ").append(getName()).append(", ")
                .append(getPosition()).append(", ").append(getDepartment()).append(", ").append(getSalary()).append(", TeamSize=")
                .append(teamSize()).append(", Team=").append(teamNames()).append("]");
        return builder.toString();
    }

    public String shortDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("'").append(getName()).append("'");
        return builder.toString();
    }

    @Override
    public String toString() {
        return fullDetails();
    }
}
