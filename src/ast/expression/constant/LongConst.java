package ast.expression.constant;

import ast.expression.Expression;

public class LongConst implements Expression {
    private long value;

    public LongConst(String value, int radix) {
        if (value != null && value.length() > 0 && (value.charAt(value.length() - 1) == 'l' || value.charAt(value.length() - 1) == 'L')) {
            System.out.println("removing last l");
            value = value.substring(0, value.length() - 1);
            if (radix == 16)
                value = value.substring(2, value.length());
        }
        this.value = Long.parseLong(value, radix);
    }

    @Override
    public void codegen() {
        System.out.println("long const value " + value);
    }
}
