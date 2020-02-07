package ast.varDCL;

import ast.ASMUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class LocalVarDCL extends VarDCL {
    private String varType;
    private String varDescriptor;
    private String varName;
    private int index;
    private Label end;
    private Label start;

    public LocalVarDCL(String varType, String varName) {

        this.varName = varName;
        this.varType = varType;
        this.varDescriptor = ASMUtils.type2descriptor.get(varType);
    }

    public void set(int index, Label start, Label end) {
        System.err.println("in setIndex");
        this.index = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        System.out.println("local var dcl");
        mv.visitLocalVariable(varName, varDescriptor, null, start, end, 2);
    }
}
