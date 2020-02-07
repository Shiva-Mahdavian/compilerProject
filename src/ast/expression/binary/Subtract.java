package ast.expression.binary;


import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Subtract extends BinaryExpression {

    public Subtract(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("subtract");
        getFirstOperand().codegen(cw, mv);
        getSecondOperand().codegen(cw, mv);
    }
}
