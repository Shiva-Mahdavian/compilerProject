package ast;

import ast.varDCL.LocalVarDCL;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Start implements ProgramPart {
    private int numOfVar;
    private int initialSemanticSize;
    private Deque<BlockPart> blockParts;
    public Start(int initialSemanticSize) {
        this.numOfVar = 1;
        this.initialSemanticSize = initialSemanticSize;
        this.blockParts = new ArrayDeque<>();
    }

    public int getInitialSemanticSize() {
        return initialSemanticSize;
    }

    public void addToBlockParts(BlockPart bp) {
        blockParts.push(bp);
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) {
        mv = cw.visitMethod(Opcodes.ACC_STATIC | Opcodes.ACC_PUBLIC,
                "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();
        Label start = new Label();
        mv.visitLabel(start);
        Label end = new Label();
        mv.visitLineNumber(15, end);
        //mv.visitLabel(end);
        for (BlockPart bp : blockParts) {
            if (bp instanceof LocalVarDCL)
                ((LocalVarDCL) bp).set(numOfVar++, start, end);
            bp.codegen(cw, mv);
        }
        //mv.visitMaxs(20, 20);
        //mv.visitEnd();
    }
}
