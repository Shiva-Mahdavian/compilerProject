package ast.expression.constant;

import ast.expression.Expression;

public class FloatConst implements Expression {
    private float value;

    public FloatConst(String value) {
        this.value = Float.parseFloat(value);
    }

    @Override
    public void codegen() {
        System.out.println("Float const value " + value);
    }
}
