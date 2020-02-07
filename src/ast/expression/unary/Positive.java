package ast.expression.unary;

import ast.expression.Expression;

public class Positive extends UnaryExpression{

    public Positive(Expression operand){
        super(operand);
    }

    @Override
    public void codegen() {
        getOperand().codegen();
        System.out.println("positive");
    }
}
