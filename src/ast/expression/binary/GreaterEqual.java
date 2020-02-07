package ast.expression.binary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class GreaterEqual extends BinaryExpression {
    public GreaterEqual(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("greaterEqual");
        getFirstOperand().codegen(cw, mv);
        getSecondOperand().codegen(cw, mv);
    }

}
