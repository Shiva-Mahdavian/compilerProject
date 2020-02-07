package ast.varDCL;

import ast.ASMUtils;
import ast.expression.Expression;
import org.objectweb.asm.*;
import symbolTable.DSCP;
import symbolTable.SymbolTable;

public class VarDCLWithValue extends VarDCL {
    private LocalVarDCL varDCL;
    private Expression value;

    public VarDCLWithValue(LocalVarDCL varDCL, Expression value) {
        this.varDCL = varDCL;
        this.value = value;
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("local var dcl with value ");
        varDCL.codegen(cw, mv);
        value.codegen(cw, mv);
        mv.visitVarInsn(varDCL.getVarType().getOpcode(Opcodes.ILOAD), varDCL.getIndex());
    }
}

