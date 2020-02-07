package ast.varDCL;

import ast.ASMUtils;
import org.objectweb.asm.*;
import symbolTable.DSCP;
import symbolTable.SymbolTable;

public class LocalVarDCL extends VarDCL {
    private Type varType;
    private String varDescriptor;
    private String varName;
    private int index;
    private Label end;
    private Label start;

    public LocalVarDCL(String varType, String varName) {

        this.varName = varName;
        this.varDescriptor = ASMUtils.type2descriptor.get(varType);
        this.varType = Type.getType(varDescriptor);
    }

    public void set(int index, Label start, Label end) {
        System.err.println("in setIndex");
        this.index = index;
        this.start = start;
        this.end = end;
    }

    public int getIndex() {
        return index;
    }

    public Type getVarType() {
        return varType;
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("local var dcl " + varName);
        if (SymbolTable.getInstance().containsKey(varName)) {
            throw new Exception(varName + " is already declared.");
        }
        SymbolTable.getInstance().put(varName, new DSCP(varType, false, index));
//        mv.visitLocalVariable(varName, varDescriptor, null, start, end, index);
        mv.visitVarInsn(varType.getOpcode(Opcodes.ISTORE), index);
    }
}
