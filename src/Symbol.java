public class Symbol {
    private TokenType type;
    private Object value;

    Symbol(TokenType type) {
        this.type = type;
    }

    Symbol(TokenType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getTokenType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }
}
