package ast.expression.binary;

import ast.expression.Expression;

public class GreaterEqual extends BinaryExpression {
    public GreaterEqual(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("greaterEqual");
    }

}
