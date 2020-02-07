package ast;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.Deque;

public class Program implements AST {
    private Deque<ProgramPart> beforeStart;
    private Start start;
    private Deque<ProgramPart> afterStart;

    public void initStart(int initialSize){
        start = new Start(initialSize);
    }

    public Start getStart() {
        return start;
    }

    public Program() {
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        if (start == null) {
            System.err.println("no start method found");
            return;
        }
        if (beforeStart != null)
            for (ProgramPart pp : beforeStart)
                pp.codegen(cw, mv);
        start.codegen(cw, mv);
        if (afterStart != null)
            for (ProgramPart pp : afterStart)
                pp.codegen(cw, mv);
    }
}
