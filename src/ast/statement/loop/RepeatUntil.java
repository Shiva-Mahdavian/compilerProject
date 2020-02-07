package ast.statement.loop;

import ast.expression.Expression;
import ast.statement.Statement;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class RepeatUntil implements Statement {
    //    private Block block;
    private Expression condition;

    public RepeatUntil(Expression condition) {
        this.condition = condition;
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        System.out.println("repeat");
        condition.codegen(cw, mv);

    }
}

