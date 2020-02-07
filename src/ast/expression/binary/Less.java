package ast.expression.binary;

import ast.expression.Expression;

public class Less extends BinaryExpression {
    public Less(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("less");
    }

}
