package ast.expression.unary;

import ast.expression.Expression;

public class BitwiseNegation extends UnaryExpression {

    public BitwiseNegation(Expression operand) {
        super(operand);
    }

    @Override
    public void codegen() {
        getOperand().codegen();
        System.out.println("bitwise Negation");
    }
}
