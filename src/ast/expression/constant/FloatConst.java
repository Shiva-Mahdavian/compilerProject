package ast.expression.constant;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class FloatConst implements Expression {
    private float value;

    public FloatConst(String value) {
        this.value = Float.parseFloat(value);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        System.out.println("Float const value " + value);
    }
}
