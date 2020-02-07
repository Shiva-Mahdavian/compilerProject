package ast.statement.loop;

import ast.expression.Expression;
import ast.statement.Statement;

public class RepeatUntil implements Statement {
    //    private Block block;
    private Expression condition;

    public RepeatUntil(Expression condition) {
        this.condition = condition;
    }

    @Override
    public void codegen() {
        condition.codegen();

        System.out.println("repeat");
    }
}

