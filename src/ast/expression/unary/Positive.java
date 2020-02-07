package ast.expression.unary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Positive extends UnaryExpression{

    public Positive(Expression operand){
        super(operand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("positive");
        getOperand().codegen(cw, mv);
    }
}
