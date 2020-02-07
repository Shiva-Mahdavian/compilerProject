package ast.statement.loop;

import ast.expression.Expression;
import ast.statement.Statement;
import ast.statement.assignment.Assignment;

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
    public void codegen() {
        if (first_step != null)
            first_step.codegen();
        condition_expression.codegen();
        if (step_expression != null)
            step_expression.codegen();
        System.out.println("for");
    }
}
