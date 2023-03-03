package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.report;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionBuilder {
    private final Stack<PermissionExpression> permissions;
    private final Stack<String> operators;

    public ExpressionBuilder() {
        permissions = new Stack<>();
        operators = new Stack<>();
    }

    public PermissionExpression build(Report report) {
        parse(report.getPermission());
        buildExpressions();

        if(permissions.size() > 1 || !operators.isEmpty()) {
            throw new IllegalStateException("permission expression is not correctly structured");
        }

        return permissions.pop();
    }

    private void parse(String permission) {
        StringTokenizer tokenizer = new StringTokenizer(permission.toLowerCase());

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if(token.equals("and") || token.equals("not") || token.equals("or")) {
                operators.add(token);
            } else {
                permissions.add(new Permission(token));
            }
        }
    }

    private void buildExpressions() {
        while(!operators.isEmpty()) {
            String operator = operators.pop();

            PermissionExpression permissionLeft;
            PermissionExpression permissionRight;
            PermissionExpression expression;

            switch (operator) {
                case "not":
                    permissionLeft = permissions.pop();
                    expression = new NotExpression(permissionLeft);
                    break;
                case "and":
                    permissionRight = permissions.pop();
                    permissionLeft = permissions.pop();

                    expression = new AndExpression(permissionLeft, permissionRight);
                    break;
                case "or":
                    permissionRight = permissions.pop();
                    permissionLeft = permissions.pop();

                    expression = new OrExpression(permissionLeft, permissionRight);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }

            permissions.push(expression);
        }
    }

    public static void main(String[] args) {
        String permission = "NOT ADMIN AND SPECIFIC_USER OR GENERAL_USER";
        Report report = new Report("Eduardo", permission);

        ExpressionBuilder expressionBuilder = new ExpressionBuilder();

        //expressionBuilder.parse(permission);
        System.out.println(expressionBuilder.build(report));
    }
}
