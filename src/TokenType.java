public class TokenType {
    private Type type;

    private String subType;

    public TokenType(Type type, String subType) {
        this.type = type;
        this.subType = subType;
    }

    public Type getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    @Override
    public String toString() {
        return type.toString() + " " + subType;
    }
}
