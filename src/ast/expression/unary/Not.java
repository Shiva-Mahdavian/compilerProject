package ast.expression.unary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Not extends UnaryExpression {

    public Not(Expression first) {
        super(first);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("not");
        getOperand().codegen(cw, mv);
    }
}
