package ast.expression.unary;


import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Negative extends UnaryExpression {

    public Negative(Expression operand) {
        super(operand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("negative");
        getOperand().codegen(cw, mv);
    }
}
