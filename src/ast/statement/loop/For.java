package ast.statement.loop;

import ast.expression.Expression;
import ast.statement.Statement;
import ast.statement.assignment.Assignment;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class For implements Statement {
    private Assignment first_step;
    private Expression condition_expression;
    private Expression step_expression;
//TODO    private Block block;

    public For(Assignment first, Expression condition, Expression step) {
        this.first_step = first;
        this.condition_expression = condition;
        this.step_expression = step;
    }


    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        System.out.println("for");
        if (first_step != null) {
            first_step.codegen(cw, mv);
        }
        condition_expression.codegen(cw, mv);
        if (step_expression != null) {
            step_expression.codegen(cw, mv);
        }
    }
}
