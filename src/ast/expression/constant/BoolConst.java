package ast.expression.constant;

import ast.expression.Expression;

public class BoolConst implements Expression {
    private boolean value;

    public BoolConst(String value){
        this.value = Boolean.valueOf(value);
    }

    @Override
    public void codegen() {
        System.out.println("bool const " + value);
    }
}
