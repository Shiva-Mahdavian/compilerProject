package ast.expression.constant;


import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class DoubleConst implements Expression {
    private double value;

    public DoubleConst(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception  {
        System.out.println("double const val " + value);
        mv.visitLdcInsn(value);
    }
}
