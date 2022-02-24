import java.io.*;

public class Driver{
String token;
String lexeme;

Driver(String token, String lexeme){
	this.token = token;
	this.lexeme = lexeme;
}

public String toString(){
	return token + ": " +lexeme;
}

public static void main( String[] argv ) {
	try{
		if(argv.length!=1){
			throw new Error("java Main Filename");
		}
		FileReader filein = new FileReader(argv[0]);
		phpLex lexemes = new phpLex(filein);
		try{
			while(!lexemes.yyatEOF()){
				Driver token = lexemes.yylex();
				if(token!=null){
					System.out.println(token.toString());
					}
				}
			}
		catch(IOException exception){
			System.out.println("Lexemes IOException");
			}
		}
	catch(Exception exception){
		System.out.println("Exception");
		exception.printStackTrace();
		}
	}
}