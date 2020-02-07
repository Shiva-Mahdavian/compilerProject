package ast.expression.unary;

import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class BitwiseNegation extends UnaryExpression {

    public BitwiseNegation(Expression operand) {
        super(operand);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("bitwise Negation");
        getOperand().codegen(cw, mv);
    }
}
