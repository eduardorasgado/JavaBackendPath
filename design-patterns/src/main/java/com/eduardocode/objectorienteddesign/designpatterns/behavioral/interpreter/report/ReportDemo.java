package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.report;

public class ReportDemo {

    public static void main(String[] args) {
        User eduardo = new User("Eduardo", "FINANCE_USER", "LOGISTICS_USER");
        User pedro = new User("Pedro", "LOGISTICS_USER");
        User marcus = new User("Marcus", "WAREHOUSE_MANAGER");

        Report report = new Report("Logistics roadmap report", "NOT FINANCE_USER AND LOGISTICS_USER OR WAREHOUSE_MANAGER"); //

        ExpressionBuilder expressionBuilder = new ExpressionBuilder();
        PermissionExpression expression = expressionBuilder.build(report);

        System.out.println("EXPRESSION: " + expression);

        hasUserAccessToReport(eduardo, report, expression);
        hasUserAccessToReport(pedro, report, expression);
        hasUserAccessToReport(marcus, report, expression);
        }

    private static void hasUserAccessToReport(User user, Report report, PermissionExpression expression) {
        System.out.println(
                user.getUsername() + " has permission to " + report.getName() + ": " + expression.interpret(user));
    }
}
