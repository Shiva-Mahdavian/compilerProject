package ast;

import java.util.Deque;

public class Program implements AST {
    private Deque<ProgramPart> beforeStart;
    private ProgramPart start;
    private Deque<ProgramPart> afterStart;

    public Program() {

    }

    @Override
    public void codegen() {

    }
}
