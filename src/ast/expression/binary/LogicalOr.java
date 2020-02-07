package ast.expression.binary;

import ast.expression.Expression;

public class LogicalOr extends BinaryExpression {

    public LogicalOr(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("logical or");
    }
}
