import ast.ASMUtils;
import ast.AST;
import ast.expression.Expression;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.*;

public class Main {
    public static void main(String[] args){
        ASMUtils.init();
        FileReader fileReader = null;
        OutputStream outputStream = null;
        try {
            fileReader = new FileReader(args[0]);
            outputStream = new FileOutputStream(args[1]);
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        LexicalScanner lexicalScanner = new LexicalScanner(fileReader);
        CodeGenerator codeGenerator = new CodeGenerator(lexicalScanner);
        parseInput(lexicalScanner, codeGenerator, outputStream);
    }

    private static void parseInput(LexicalScanner lexicalScanner, CodeGenerator codeGenerator, OutputStream fos) {
        Parser parser = new Parser(lexicalScanner, codeGenerator, "src/table.npt");
        try {
            // Parse given file
            parser.parse();
            // Get Root of AST
            AST result = codeGenerator.getResult();
            // Call AST Root function
//


            // Create a Test class to put expression java bytecode inside it.
            // In java, every code must be put inside a class.
            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER, "Test", null, "java/lang/Object", null);

            // Create constructor of Test class to call it's super class.
            // Every class has a default constructor which call super constructor. (In this example, Object constructor)
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            methodVisitor.visitCode();
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(0, 0);
            methodVisitor.visitEnd();

            result.codegen(classWriter, methodVisitor);

            try {
                fos.write(classWriter.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Code compiled successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateHTML() throws IOException {
        HtmlGen.init();
        FileReader fileReader = new FileReader("test.txt");
        LexicalScanner s = new LexicalScanner(fileReader);
        FileWriter fileWriter = new FileWriter("x.html");
        Symbol symbol = s.nextToken();
        String result = "";
        while (!symbol.getTokenType().getSubType().equals("$")) {
            result = "<pre    style=\"color:";
            result += (String)(HtmlGen.type2color.get(symbol.getTokenType().getType()));
            result += ";\">";
            result += (String)(symbol.getValue());
            result += "</pre>";
            fileWriter.write(result);
            fileWriter.flush();
            //System.out.println(result);
            symbol = s.nextToken();
        }
        fileWriter.flush();
        fileWriter.close();
    }

}