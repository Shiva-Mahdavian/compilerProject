import ast.BlockPart;
import ast.Program;
import ast.Start;
import ast.expression.Expression;
import ast.expression.binary.*;
import ast.expression.constant.*;
import ast.expression.unary.*;
import ast.statement.assignment.Assignment;
import ast.statement.loop.For;

import java.util.ArrayDeque;
import java.util.Deque;

public class CodeGenerator {
    public static final int RADIX_HEX = 16;
    public static final int RADIX_DECIMAL = 10;
    private Lexical lexical;
    private Deque<Object> semanticStack;
    private Program program;

    public CodeGenerator(Lexical lexical) {
        this.lexical = lexical;
        semanticStack = new ArrayDeque<>();
        program = new Program();
        semanticStack.push(program);
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
                semanticStack.push(new IntegerConst((String) lexical.currentToken().getValue(), RADIX_DECIMAL));
            break;
            case "pushIntegerHexConst":
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
            case "exprPos": {
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Positive(first));
            }
            break;
            case "exprPreDecrement": {
                System.out.println("pre dec");
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new PreDecrement(first));
            }
            break;
            case "exprPostDecrement": {
                System.out.println("post dec");
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new PostDecrement(first));
            }
            break;
            case "exprPreIncrement": {
                System.out.println("pre inc");
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new PreIncrement(first));
            }
            break;
            case "exprPostIncrement": {
                System.out.println("post inc");
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new PostIncrement(first));
            }
            break;
            case "exprBitwiseNegation": {
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new BitwiseNegation(first));
            }
            break;
            case "exprNot": {
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Not(first));
            }
            break;
            case "exprNotEqual": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new NotEqual(first, second));
            }
            break;
            case "exprEqual": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Equal(first, second));
            }
            break;
            case "exprLessEqual": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new LessEqual(first, second));
            }
            break;
            case "exprGreaterEqual": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new GreaterEqual(first, second));
            }
            break;
            case "exprGreater": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Greater(first, second));
            }
            break;
            case "exprLess": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new Less(first, second));
            }
            break;
            case "exprArithmeticAnd": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new ArithmeticAnd(first, second));
            }
            break;
            case "exprArithmeticOr": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new ArithmeticOr(first, second));
            }
            break;
            case "exprArithmeticXor": {
                Expression second = (Expression) semanticStack.pop();
                Expression first = (Expression) semanticStack.pop();
                semanticStack.push(new ArithmeticXor(first, second));
            }
            break;
            case "for": {
                //Block block = //TODO
                Expression step = (Expression) semanticStack.pop();
                Expression condition = (Expression) semanticStack.pop();
                Assignment first_step = (Assignment) semanticStack.pop();
                semanticStack.push(new For(first_step, condition, step));
            }
            break;
            case "forWithNoAdditional": {
                //Block block = //TODO
                Expression condition = (Expression) semanticStack.pop();
                semanticStack.push(new For(null, condition, null));
            }
            break;
            case "forWithStep": {
                //Block block = //TODO
                Expression step = (Expression) semanticStack.pop();
                Expression condition = (Expression) semanticStack.pop();
                semanticStack.push(new For(null, condition, step));
            }
            break;
            case "forWithAssignment": {
                //Block block = //TODO
                Expression condition = (Expression) semanticStack.pop();
                Assignment first_step = (Assignment) semanticStack.pop();
                semanticStack.push(new For(first_step, condition, null));
            }
            break;
            case "initStart": {
                program.initStart(semanticStack.size());
            }
            break;
            case "finishStart": {
                while (semanticStack.size() > program.getStart().getInitialSemanticSize()) {
                    BlockPart bp = (BlockPart) semanticStack.pop();
                    program.getStart().addToBlockParts(bp);
                }
            }
            break;
            default:
                System.out.println("Illegal semantic function: " + sem);
        }
    }
}