package ast.expression.constant;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class BoolConst implements Expression {
    private boolean value;

    public BoolConst(String value){
        this.value = Boolean.valueOf(value);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception  {
        System.out.println("bool const " + value);
        mv.visitLdcInsn(value);
    }
}
