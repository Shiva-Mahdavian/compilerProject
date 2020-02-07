package ast.expression.unary;


import ast.expression.Expression;

public class Negative extends UnaryExpression {

    public Negative(Expression operand) {
        super(operand);
    }

    @Override
    public void codegen() {
        getOperand().codegen();
        System.out.println("negative");
    }
}
