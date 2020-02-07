package ast.expression.constant;


import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class IntegerConst implements Expression {
    private int value;

    public IntegerConst(String value, int radix) {
        if (radix == 16)
            value = value.substring(2, value.length());
        this.value = Integer.parseInt(value, radix);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        System.out.println("integer const value " + value);
    }
}
