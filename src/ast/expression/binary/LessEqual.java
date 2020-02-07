package ast.expression.binary;

import ast.expression.Expression;

public class LessEqual extends BinaryExpression {
    public LessEqual(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("Less equal");
    }
}
