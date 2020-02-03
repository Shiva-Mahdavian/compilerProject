import java.io.IOException;
/* user codes */
%%
/* options and decleration */
%class LexicalScanner
%line
%column
%unicode
%function next_token
%type Symbol

%{
    StringBuilder string = new StringBuilder();

    private Symbol symbol (TokenType tokenType)
    {
        System.err.println("symbol type " + tokenType + " \"" + yytext() +  "\"");
        return new Symbol (tokenType, yytext());
    }

    private Symbol symbol (TokenType tokenType, Object value)
    {
        System.err.println("symbol type " + tokenType + " \"" + yytext() +  "\"");
        return new Symbol (tokenType, value);
    }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | {Blank}
Blank      = [ \t\f]

/* numbers */
DecIntegerLiteral = 0 | [1-9][0-9]*
DecLongLiteral = {DecIntegerLiteral}[lL]
DoubleLiteral  = ({DL1}|{DL2}|{DL3})
DL1 = [0-9]+\.[0-9]*
DL2 = \.[0-9]+
DL3 = [0-9]+
FloatLiteral = {DoubleLiteral}[fF]
HexIntegerLiteral = 0[xX]0*{HexDigit}{1,8}
HexLongLiteral = 0[xX]0*{HexDigit}{1,16}[lL]
HexDigit = [0-9a-fA-F]
ScientificFormLiteral = {DoubleLiteral}{Exponent}
Exponent = [eE][+-]?[0-9]+


Identifier = [a-zA-Z_][0-9a-zA-Z_]*

StringCharacter = [^\r\n\"]
CharCharacter = [^\r\n\'\\]|\\\\|\\n|\\r|\\'|\\t

%state STRING
%state CHARACTER
%state MULTILINECOMMENT
%state SINGLELINECOMMENT

%%
/* lexical rules */
<YYINITIAL> {
     \"                             { yybegin(STRING); string.setLength(0); string.append("\""); }
    "\'"                            { yybegin(CHARACTER); string.setLength(0); string.append("\'"); }
    "("                             { return symbol(new TokenType( Type.Other, "opening_paren")); }
    ")"                             { return symbol(new TokenType( Type.Other, "closing_paren")); }
    "["                             { return symbol(new TokenType( Type.Other, "opening_brace")); }
    "]"                             { return symbol(new TokenType( Type.Other, "closing_brace")); }
    "+"                             { return symbol(new TokenType( Type.Other, "add")); }
    "-"                             { return symbol(new TokenType( Type.Other, "minus")); }
    "*"                             { return symbol(new TokenType( Type.Other, "production")); }
    "/"                             { return symbol(new TokenType( Type.Other, "division")); }
    "%"                             { return symbol(new TokenType( Type.Other, "mod")); }
    "="                             { return symbol(new TokenType( Type.Other, "assignment")); }
    "=="                            { return symbol(new TokenType( Type.Other, "equal")); }
    "!="                            { return symbol(new TokenType( Type.Other, "not_equal")); }
    "<="                            { return symbol(new TokenType( Type.Other, "less_equal")); }
    "<"                             { return symbol(new TokenType( Type.Other, "less")); }
    ">"                             { return symbol(new TokenType( Type.Other, "greater")); }
    ">="                            { return symbol(new TokenType( Type.Other, "greater_equal")); }
    "~"                             { return symbol(new TokenType( Type.Other, "bitwise_negation")); }
    "&"                             { return symbol(new TokenType( Type.Other, "arithmetic_and")); }
    "and"                           { return symbol(new TokenType( Type.Reserved, "logical_and")); }
    "or"                            { return symbol(new TokenType( Type.Reserved, "logical_or")); }
    "|"                             { return symbol(new TokenType( Type.Other, "arithmetic_or")); }
    "^"                             { return symbol(new TokenType( Type.Other, "arithmetic_xor")); }
    "+="                            { return symbol(new TokenType( Type.Other, "addition_assignment")); }
    "-="                            { return symbol(new TokenType( Type.Other, "subtraction_assignment")); }
    "*="                            { return symbol(new TokenType( Type.Other, "multiplication_assignment")); }
    "/="                            { return symbol(new TokenType( Type.Other, "division_assignment")); }
    "%="                            { return symbol(new TokenType( Type.Other, "mod_assignment")); }
    "begin"                         { return symbol(new TokenType( Type.Reserved, "opening_block")); }
    "end"                           { return symbol(new TokenType( Type.Reserved, "closing_block")); }
    "."                             { return symbol(new TokenType( Type.Other, "dot")); }
    ","                             { return symbol(new TokenType( Type.Other, "comma")); }
    ":"                             { return symbol(new TokenType( Type.Other, "colon")); }
    ";"                             { return symbol(new TokenType( Type.Other, "semicolon")); }
    "++"                            { return symbol(new TokenType( Type.Other, "p_increament")); }
    "--"                            { return symbol(new TokenType( Type.Other, "p_decreament")); }


    "function"                      { return symbol(new TokenType( Type.Reserved, "function")); }
    "void"                          { return symbol(new TokenType( Type.Reserved, "void")); }
    "record"                        { return symbol(new TokenType( Type.Reserved, "record")); }
    "const"                         { return symbol(new TokenType( Type.Reserved, "const")); }
    "auto"                          { return symbol(new TokenType( Type.Reserved, "auto")); }
    "return"                        { return symbol(new TokenType( Type.Reserved, "break")); }
    "break"                         { return symbol(new TokenType( Type.Reserved, "continue")); }
    "len"                           { return symbol(new TokenType( Type.Reserved, "len")); }
    "if"                            { return symbol(new TokenType( Type.Reserved, "if")); }
    "else"                          { return symbol(new TokenType( Type.Reserved, "else")); }
    "switch"                        { return symbol(new TokenType( Type.Reserved, "switch")); }
    "of"                            { return symbol(new TokenType( Type.Reserved, "of")); }
    "case"                          { return symbol(new TokenType( Type.Reserved, "case")); }
    "default"                       { return symbol(new TokenType( Type.Reserved, "default")); }
    "for"                           { return symbol(new TokenType( Type.Reserved, "for")); }
    "repeat"                        { return symbol(new TokenType( Type.Reserved, "repeat")); }
    "until"                         { return symbol(new TokenType( Type.Reserved, "until")); }
    "foreach"                       { return symbol(new TokenType( Type.Reserved, "foreach")); }
    "in"                            { return symbol(new TokenType( Type.Reserved, "in")); }
    "sizeof"                        { return symbol(new TokenType( Type.Reserved, "sizeof")); }
    "int"                           { return symbol(new TokenType( Type.Reserved, "int")); }
    "long"                          { return symbol(new TokenType( Type.Reserved, "long")); }
    "double"                        { return symbol(new TokenType( Type.Reserved, "double")); }
    "float"                         { return symbol(new TokenType( Type.Reserved, "float")); }
    "char"                          { return symbol(new TokenType( Type.Reserved, "char")); }
    "string"                        { return symbol(new TokenType( Type.Reserved, "string")); }
    "bool"                          { return symbol(new TokenType( Type.Reserved, "bool")); }
    "true"                          { return symbol(new TokenType( Type.Reserved, "true")); }
    "false"                         { return symbol(new TokenType( Type.Reserved, "false")); }
    "new"                           { return symbol(new TokenType( Type.Reserved, "new")); }
    "not"                           { return symbol(new TokenType( Type.Reserved, "not")); }
    "println"                       { return symbol(new TokenType( Type.Reserved, "println")); }
    "input"                         { return symbol(new TokenType( Type.Reserved, "input")); }


    "/#"                            { yybegin(MULTILINECOMMENT); string.setLength(0); string.append("/#"); }
    "##"                            { yybegin(SINGLELINECOMMENT); string.setLength(0); string.append("##"); }

    {Identifier}                    { return symbol(new TokenType( Type.Identifier, "id")); }
    {DecIntegerLiteral}             { return symbol(new TokenType( Type.Integer, "int_const")); }
    {DecLongLiteral}                { return symbol(new TokenType( Type.Integer, "long_int_const")); }
    {DoubleLiteral}                 { return symbol(new TokenType( Type.Real, "double_const")); }
    {FloatLiteral}                  { return symbol(new TokenType( Type.Real, "float_const")); }
    {HexIntegerLiteral}             { return symbol(new TokenType( Type.Integer, "hex_integer")); }
    {HexLongLiteral}                { return symbol(new TokenType( Type.Integer, "long_hex_integer")); }
    {ScientificFormLiteral}         { return symbol(new TokenType( Type.Real, "sci")); }

    {WhiteSpace}+                   { return symbol(new TokenType( Type.Other, "whiteSpace")); }

    [^]                             { throw new RuntimeException("Illegal character \""+yytext()+
                                                                  "\" at line "+yyline+", column "+yycolumn); }
    <<EOF>>                         {return symbol(new TokenType( Type.Other, "$"));}
}

<STRING> {
    \"                              {yybegin(YYINITIAL);  string.append("\""); StringBuilder temp = string ; string = new StringBuilder(); return symbol(new TokenType( Type.String, "string_const"), temp.toString() ); }
    {StringCharacter}+              { string.append( yytext() ); }
}

<MULTILINECOMMENT> {
    "#/"                            {yybegin(YYINITIAL);  string.append("/#"); StringBuilder temp = string ; string = new StringBuilder(); return symbol(new TokenType( Type.Comment, "mullti_line_comment"), temp.toString() ); }
    .                               { string.append( yytext() ); }
    {WhiteSpace}                    { string.append( yytext() ); }
}

<SINGLELINECOMMENT> {
    {LineTerminator}                { yybegin(YYINITIAL); string.append("\n"); StringBuilder temp = string ; string = new StringBuilder(); return symbol(new TokenType( Type.Comment, "single_line_comment"), temp.toString() ); }
    {StringCharacter}+              { string.append( yytext() ); }
    {Blank}+                        { string.append( yytext() ); }
}

<CHARACTER> {
    \'                              { yybegin(YYINITIAL);  string.append("\'"); StringBuilder temp = string ; string = new StringBuilder(); return symbol(new TokenType( Type.Char, "char_const"), temp.toString() ); }
    {CharCharacter}\'               { string.append( yytext() ); yybegin(YYINITIAL);  string.append("\'"); StringBuilder temp = string ; string = new StringBuilder(); return symbol(new TokenType( Type.Char, "CHAR_CONST"), temp.toString() ); }
}