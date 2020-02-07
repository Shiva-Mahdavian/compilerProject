package ast.expression;


import ast.ASMUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class SizeOf implements Expression {
    public static final int WORD_SIZE = 32;
    private String type;
    public SizeOf(String type) {
        this.type = type;
    }

    @Override
    public void codegen(ClassWriter cw, MethodVisitor mv) throws Exception  {
        String descpriptor = ASMUtils.type2descriptor.getOrDefault(type, "");
        if (descpriptor.equals(""))
            throw new Exception("not a correct type");
        int size = Type.getType(descpriptor).getSize() * WORD_SIZE;
        System.out.println("sizeof " + type + " is " + size);
        mv.visitLdcInsn(size);
    }
}
