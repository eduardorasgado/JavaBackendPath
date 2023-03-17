package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.company;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Programmer programmer) {
        System.out.println(
                "Programmer name: " + programmer.getName() + ", programming language: " + programmer.getProgrammingLanguage());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Manager name: " + manager.getName() + ", works with: "
                + getNamesSeparatedByCommas(manager.getDirectReports()));
    }

    @Override
    public void visit(ProjectLead projectLead) {
        System.out.println("Project lead name: " + projectLead.getName() + " lead project with "
                + getNamesSeparatedByCommas(projectLead.getDirectReports()));
    }

    @Override
    public void visit(VicePresident vicePresident) {
        System.out.println("VicePresident name: " + vicePresident.getName() + ", leads a company and leads to "
                + getNamesSeparatedByCommas(vicePresident.getDirectReports()));
    }

    private String getNamesSeparatedByCommas(Collection<Employee> employees) {
        return String.join(", ", getEmployeeNames(employees));
    }

    private Collection<String> getEmployeeNames(Collection<Employee> employees) {
        return employees.stream()
                .map(this::getEmployeeSignature)
                .collect(Collectors.toList());
    }

    private String getEmployeeSignature(Employee employee) {
        return employee.getName() + "(" + employee.getClass().getSimpleName() + ")";
    }
}
