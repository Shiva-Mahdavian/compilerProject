package ast.expression.constant;


import ast.expression.Expression;

public class IntegerConst implements Expression {
    private int value;

    public IntegerConst(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public void codegen() {
        System.out.println("integer const value " + value);
    }
}
