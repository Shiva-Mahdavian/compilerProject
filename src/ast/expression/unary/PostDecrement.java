package ast.expression.unary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class PostDecrement extends UnaryExpression  {
    public PostDecrement(Expression operand)
    {
        super(operand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("postDecrement");
        getOperand().codegen(cw, mv);
    }
}
