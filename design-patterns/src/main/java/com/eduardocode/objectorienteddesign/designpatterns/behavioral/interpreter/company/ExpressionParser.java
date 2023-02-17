package com.eduardocode.objectorienteddesign.designpatterns.behavioral.interpreter.company;

public class ExpressionParser {

    protected static final String NAME = "name";
    protected static final String POS = "position";
    protected static final String DEPTT = "deptt";
    protected static final String MANAGES = "manages";
    protected static final String SALARY = "salary";

    public static Expression parseExpression(String contextString) {
        Expression expression = null;
        String[] parts = contextString.split(",");

        for (String part : parts) {
            String[] keyValue = part.split(":");
            Expression newExpression = getExpression(keyValue[0].toLowerCase().trim(), keyValue[1].trim());

            if(expression == null) {
                expression = newExpression;
            }
            else {
                expression = new AndExpression(expression, newExpression);
            }
        }

        return expression;
    }

    private static Expression getExpression(String key, String value) {
        switch (key) {
            case NAME:
                return new NameExpression(value);
            case POS:
                return new PositionExpression(value);
            case DEPTT:
                return new DepartmentExpression(value);
            case MANAGES:
                return new ManagesExpression(value);
            case SALARY:
                return new SalaryExpression(value);
            default:
                throw new IllegalArgumentException("The given value does not match a valid expression");
        }
    }
}
