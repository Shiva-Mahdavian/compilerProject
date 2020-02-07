package ast;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Start implements ProgramPart {
    private int numOfVar;
    private int initialSemanticSize;
    private Deque<BlockPart> blockParts;
    public Start(int initialSemanticSize) {
        this.numOfVar = 0;
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
        for (BlockPart bp : blockParts)
            bp.codegen(cw, mv);
    }
}
