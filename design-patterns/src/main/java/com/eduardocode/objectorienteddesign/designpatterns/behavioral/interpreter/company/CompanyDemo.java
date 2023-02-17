package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public class CompanyDemo {

    public static void main(String[] args) {
        Engineer eduardo = new Engineer(1001l, "Eduardo", "Backend Developer", Department.ENGINEERING, 75000);
        Engineer martin = new Engineer(1002l, "Martin", "SSr FullStack Developer", Department.ENGINEERING, 90000);
        Engineer francisco = new Engineer(1003l, "Francisco", "Sr Backend Developer", Department.ENGINEERING, 100000);
        Engineer marco = new Engineer(1004l, "Marco", "Data Scientist", Department.ENGINEERING, 70000);
        Engineer mario = new Engineer(1005l, "Mario", "Frontend Developer", Department.ENGINEERING, 95000);
        Engineer lucas = new Engineer(1006l, "Lucas", "QA Engineer", Department.ENGINEERING, 85000);

        Manager rodolfo = new Manager(1007l, "Rodolfo", "Sr Manager", Department.ENGINEERING, 110000);
        Manager isis = new Manager(1008l, "Isis", "Product Manager", Department.ENGINEERING, 140000);
        Manager brenda = new Manager(1009l, "Brenda", "Manager", Department.ENGINEERING, 90000);

        brenda.manages(francisco);
        brenda.manages(mario);
        brenda.manages(lucas);

        rodolfo.manages(eduardo);
        rodolfo.manages(martin);
        rodolfo.manages(brenda);

        isis.manages(marco);
        isis.manages(brenda);
        isis.manages(rodolfo);

        //System.out.println(isis.teamNames());
        //System.out.println(rodolfo.teamNames());

        String contextString = "Position:manager, Deptt:engineering, Manages:Mario, Salary:>89000";
        Expression expression =  ExpressionParser.parseExpression(contextString);
        System.out.println("Context String= " + contextString);

        System.out.println();

        System.out.println(brenda);
        System.out.printf("For '%s', %s: %s.\n", brenda.getName(), expression, expression.interpret(brenda));

        System.out.println();

        contextString = "Position:QA Engineer, salary: <90000";
        expression = ExpressionParser.parseExpression(contextString);
        System.out.println("ContexString= " + contextString);

        System.out.println();

        System.out.println(lucas);
        System.out.printf("For '%s', %s: %s.\n", lucas.getName(), expression, expression.interpret(lucas));
    }
}
