package ast.expression.binary;

import ast.expression.Expression;

public class ArithmeticXor extends BinaryExpression{

    public ArithmeticXor(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen() {
        getFirstOperand().codegen();
        getSecondOperand().codegen();
        System.out.println("Arithmetic xor");
    }
}
