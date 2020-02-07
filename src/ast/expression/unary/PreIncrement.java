package ast.expression.unary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class PreIncrement extends UnaryExpression {
    public PreIncrement(Expression operand) {
        super(operand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("preIncrement");
        getOperand().codegen(cw, mv);
    }
}
