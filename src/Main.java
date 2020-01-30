import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlGen.init();
        FileReader fileReader = new FileReader("test.txt");
        LexicalScanner s = new LexicalScanner(fileReader);
        FileWriter fileWriter = new FileWriter("x.html");
        Symbol symbol = s.next_token();
        String result = "";
        while (!symbol.getTokenType().getSubType().equals("$")) {
            result = "<pre    style=\"color:";
            result += (String)(HtmlGen.type2color.get(symbol.getTokenType().getType()));
            result += ";\">";
            result += (String)(symbol.getValue());
            result += "</pre>";
//            if (symbol.getTokenType().getSubType().equals("whitespace")) {
//                if (symbol.getValue().equals("\n"))
//                    result += "<br>";
//                else if (symbol.getValue().equals("\t")) {
//
//                }
//            }
            fileWriter.write(result);
            fileWriter.flush();
            //System.out.println(result);
            symbol = s.next_token();
        }
        fileWriter.flush();
        fileWriter.close();
    }
}