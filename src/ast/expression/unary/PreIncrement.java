package ast.expression.unary;

import ast.expression.Expression;

public class PreIncrement extends UnaryExpression {
    public PreIncrement(Expression operand) {
        super(operand);
    }

    @Override
    public void codegen() {
        System.out.println("preIncrement");
    }
}
