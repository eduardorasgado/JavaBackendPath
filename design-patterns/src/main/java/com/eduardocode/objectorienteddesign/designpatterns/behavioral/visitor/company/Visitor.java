package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.company;

public interface Visitor {

    void visit(Programmer programmer);

    void visit(Manager manager);

    void visit(ProjectLead projectLead);

    void visit(VicePresident vicePresident);
}
