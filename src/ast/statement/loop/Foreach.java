package ast.statement.loop;

import ast.statement.Statement;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Foreach implements Statement {


    public Foreach() {

    }


    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception {
        System.out.println("foreach");
    }
}
