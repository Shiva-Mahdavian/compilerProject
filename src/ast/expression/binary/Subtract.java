package ast.expression.binary;


import ast.expression.Expression;

public class Subtract extends BinaryExpression {

    public Subtract(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("subtract");
    }
}
