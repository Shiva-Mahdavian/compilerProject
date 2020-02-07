package ast.expression.unary;

import ast.expression.Expression;

public class PreDecrement extends UnaryExpression {
    public PreDecrement(Expression operand) {
        super(operand);
    }


    @Override
    public void codegen() {
        System.out.println("preDecrement");
    }
}
