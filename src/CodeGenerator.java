import ast.expression.Expression;
import ast.expression.binary.*;
import ast.expression.constant.*;
import ast.expression.unary.Negative;

import java.util.ArrayDeque;
import java.util.Deque;

public class CodeGenerator {
    public static final int RADIX_HEX = 16;
    public static final int RADIX_DECIMAL = 10;
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
            case "pushBooleanConst":
                semanticStack.push(new BoolConst((String) lexical.currentToken().getValue()));
                break;
            case "pushLongConst":
                semanticStack.push(new LongConst((String) lexical.currentToken().getValue(), RADIX_DECIMAL));
                break;
            case "pushLongHexConst":
                semanticStack.push(new LongConst((String) lexical.currentToken().getValue(), RADIX_HEX));
                break;
            case "pushFloatConst":
                semanticStack.push(new FloatConst((String) lexical.currentToken().getValue()));
                break;
            case "pushIntegerConst":
                System.out.println("pushing integer!!!");
                semanticStack.push(new IntegerConst((String) lexical.currentToken().getValue(), RADIX_DECIMAL));
                break;
            case "pushIntegerHexConst":
                System.out.println("pushing hex integer!!!");
                semanticStack.push(new IntegerConst((String) lexical.currentToken().getValue(), RADIX_HEX));
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