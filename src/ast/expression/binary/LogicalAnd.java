package ast.expression.binary;

import ast.expression.Expression;

public class LogicalAnd extends BinaryExpression {

    public LogicalAnd(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("Logical and");
    }
}
