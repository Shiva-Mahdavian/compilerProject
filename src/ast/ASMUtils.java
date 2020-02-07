package ast;

import java.util.HashMap;
import java.util.Map;

public class ASMUtils {
    public static Map<String, String> type2descriptor;

    public static void init() {
        type2descriptor = new HashMap<>();
        type2descriptor.put("boolean", "Z");
        type2descriptor.put("char", "C");
        type2descriptor.put("int", "I");
        type2descriptor.put("float", "F");
        type2descriptor.put("long", "J");
        type2descriptor.put("double", "D");
        type2descriptor.put("Object", "Ljava/lang/Object;");
    }
}
