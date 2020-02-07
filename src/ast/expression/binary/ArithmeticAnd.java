package ast.expression.binary;

import ast.expression.Expression;

public class ArithmeticAnd extends BinaryExpression{

    public ArithmeticAnd(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("Arithmetic and");
    }
}
