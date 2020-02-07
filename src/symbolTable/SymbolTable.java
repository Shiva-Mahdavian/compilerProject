package symbolTable;

import java.util.Hashtable;

public class SymbolTable {
    private static Hashtable<String, DSCP> vars;

    public  static Hashtable<String, DSCP> getInstance() {
        if (vars == null)
            vars = new Hashtable<>();
        return vars;
    }
}
