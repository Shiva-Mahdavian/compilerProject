package ast.expression.binary;

import ast.expression.Expression;

public class ArithmeticOr extends BinaryExpression {

    public ArithmeticOr(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("Arithmetic or");
    }
}
