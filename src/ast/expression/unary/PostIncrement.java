package ast.expression.unary;


import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class PostIncrement extends UnaryExpression {
    public PostIncrement(Expression operand) {
        super(operand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("postIncrement");
        getOperand().codegen(cw, mv);
    }
}
