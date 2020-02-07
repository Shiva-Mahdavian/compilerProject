package ast.expression.binary;

import ast.expression.Expression;

public class Greater extends BinaryExpression {
    public Greater(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("greater");
    }
}
