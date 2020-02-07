package ast.expression.constant;


import ast.expression.Expression;

public class DoubleConst implements Expression {
    private double value;

    public DoubleConst(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public void codegen() {
        System.out.println("double const val " + value);
    }
}
