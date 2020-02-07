package symbolTable;

import org.objectweb.asm.Type;

public class DSCP {
    private Type type;
    private int index;
    private boolean isConst;


    public DSCP(Type type, boolean isConst, int index) {
        this.type = type;
        this.isConst = isConst;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Type getType() {
        return type;
    }

    public boolean isConst() {
        return isConst;
    }
}
