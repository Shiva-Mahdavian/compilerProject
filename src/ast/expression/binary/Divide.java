package ast.expression.binary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Divide extends BinaryExpression {

    public Divide(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("divide");
        getFirstOperand().codegen(cw, mv);

        getSecondOperand().codegen(cw, mv);

        mv.visitInsn(Opcodes.IDIV);
    }
}
