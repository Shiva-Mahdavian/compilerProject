package ast.expression.binary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class NotEqual extends BinaryExpression {
    public NotEqual(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        System.out.println("Not equal");
        getFirstOperand().codegen(cw, mv);
        getSecondOperand().codegen(cw, mv);
    }

}
