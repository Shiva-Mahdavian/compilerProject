package ast.expression.binary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class LogicalAnd extends BinaryExpression {

    public LogicalAnd(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        System.out.println("Logical and");
        getFirstOperand().codegen(cw, mv);
        getSecondOperand().codegen(cw, mv);
    }
}
