package ast.expression.binary;

import ast.expression.Expression;

public class Equal extends BinaryExpression {
    public Equal(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("equal");
    }

}
