import ast.expression.Expression;
import ast.expression.binary.*;
import ast.expression.constant.DoubleConst;
import ast.expression.constant.FloatConst;
import ast.expression.constant.IntegerConst;
import ast.expression.constant.LongConst;
import ast.expression.unary.Negative;

import java.util.ArrayDeque;
import java.util.Deque;

public class CodeGenerator {
    private Lexical lexical;
    private Deque<Object> semanticStack;

    public CodeGenerator(Lexical lexical) {
        this.lexical = lexical;
        semanticStack = new ArrayDeque<>();
    }

    public Expression getResult() {
        return (Expression) semanticStack.getFirst();
    }

    public void doSemantic(String sem) {
        switch (sem) {
            case "pushLongConst":
                semanticStack.push(new LongConst((String) lexical.currentToken().getValue()));
                break;
            case "pushFloatConst":
                semanticStack.push(new FloatConst((String) lexical.currentToken().getValue()));
                break;
            case "pushIntegerConst":
                System.out.println("pushing integer!!!");
                semanticStack.push(new IntegerConst((String) lexical.currentToken().getValue()));
                break;
            case "pushDoubleConst":
                semanticStack.push(new DoubleConst((String) lexical.currentToken().getValue()));
                break;
            case "exprPlus": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Sum(first, second));
            }
            break;
            case "exprMinus": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Subtract(first, second));
            }
            break;
            case "exprDivide": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Divide(first, second));
            }
            break;
            case "exprMultiply": {
                System.out.println("got a exprMultiply");
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Multiply(first, second));
            }
            break;
            case "exprMod": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Mod(first, second));
            }
            break;
            case "exprNeg": {
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Negative(first));
            }
            break;
            default:
                System.out.println("Illegal semantic function: " + sem);
        }
    }
}