package ast.statement.assignment;

import ast.expression.Expression;
import ast.expression.variable.Variable;
import ast.statement.Statement;

public abstract class Assignment implements Statement {
    private Variable var;
    private Expression value;

    public Assignment(Variable var, Expression value) {
        this.value = value;
        this.var = var;
    }
}
