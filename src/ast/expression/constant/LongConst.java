package ast.expression.constant;

import ast.expression.Expression;

public class LongConst implements Expression {
    private long value;

    public LongConst(String value) {
        this.value = Long.parseLong(value);
    }

    @Override
    public void codegen() {
        System.out.println("long const value " + value);
    }
}
