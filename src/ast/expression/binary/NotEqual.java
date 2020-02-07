package ast.expression.binary;

import ast.expression.Expression;

public class NotEqual extends BinaryExpression {
    public NotEqual(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("Not equal");
    }

}
