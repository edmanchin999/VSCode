package grammar;
%%
%public
%type Void
letter = [A-Za-z]
newline = \r|\n|\r\n
%%
{letter}+ { System.out.println( yytext() ); }
{newline} { }
. { }
