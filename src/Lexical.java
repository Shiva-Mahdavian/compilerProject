public interface Lexical {
    Symbol nextToken() throws java.io.IOException ;
    Symbol currentToken();
}