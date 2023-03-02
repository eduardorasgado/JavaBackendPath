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

        return null;
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
        //
    }
}
