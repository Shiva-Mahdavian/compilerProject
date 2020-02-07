package ast.expression.constant;


import ast.expression.Expression;

public class IntegerConst implements Expression {
    private int value;

    public IntegerConst(String value, int radix) {
        if (radix == 16)
            value = value.substring(2, value.length());
        this.value = Integer.parseInt(value, radix);
    }

    @Override
    public void codegen() {
        System.out.println("integer const value " + value);
    }
}
