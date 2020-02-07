package ast.expression.unary;

import ast.expression.Expression;

public class Not extends UnaryExpression {

    public Not(Expression first) {
        super(first);
    }

    @Override
    public void codegen() {
        getOperand().codegen();
        System.out.println("not");
    }
}
