import ast.expression.Expression;

import java.io.*;

public class Main {
    public static void main(String[] args){
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
        parseInput(lexicalScanner, codeGenerator);
    }

    private static void parseInput(LexicalScanner lexicalScanner, CodeGenerator codeGenerator) {
        Parser parser = new Parser(lexicalScanner, codeGenerator, "src/table.npt");
        try {
            // Parse given file
            parser.parse();
            // Get Root of AST
            Expression result = codeGenerator.getResult();
            // Call AST Root function
            result.codegen();
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