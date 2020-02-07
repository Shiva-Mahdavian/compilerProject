package ast.expression.unary;

import ast.expression.Expression;

public class PostDecrement extends UnaryExpression  {
    public PostDecrement(Expression operand)
    {
        super(operand);
    }

    @Override
    public void codegen() {
        System.out.println("postDecrement");
    }
}
