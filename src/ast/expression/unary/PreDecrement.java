package ast.expression.unary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class PreDecrement extends UnaryExpression {
    public PreDecrement(Expression operand) {
        super(operand);
    }


    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        System.out.println("preDecrement");
        getOperand().codegen(cw, mv);
    }
}
