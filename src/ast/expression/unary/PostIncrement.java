package ast.expression.unary;


import ast.expression.Expression;

public class PostIncrement extends UnaryExpression {
    public PostIncrement(Expression operand) {
        super(operand);
    }

    @Override
    public void codegen() {
        getOperand().codegen();
        System.out.println("postIncrement");
    }
}
