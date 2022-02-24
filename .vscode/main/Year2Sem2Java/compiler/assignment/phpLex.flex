%%
%public
%type Driver
%class phpLex

letter = [A-Za-z]+
digit = [0-9]+
identifier = [A-Za-z]+[0-9]*[A-Za-z]+[0-9]*
newline = \r|\n|\r\n
keyword = "php"|"echo"|"class"|"function"|"this"|"new"|"if"|"else"|"null"|"NULL"

%%
{keyword} 			{}
\"({letter}|{digit}|"*"|\s)+\" 	{return new Driver("String Literal", yytext());}
{identifier} 			{return new Driver("Identifier", yytext());}
{newline}			{}
.				{}