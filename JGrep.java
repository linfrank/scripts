import java.util.regex.*;
import java.io.*;

public class JGrep{

    public static void main(String[] args)throws Exception{

	if(args.length!=1){
	    System.err.println("Greps text from input according to pattern, and outputs the matched patterns and groups in tab-separated format.");
	    System.err.println("Usage: <regex pattern> < input > output ");
	    return;
	}

	//System.err.println("REGEX: "+args[0]);

	Pattern pat=Pattern.compile(args[0]);
	
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in,"utf8"));
	PrintWriter writer=new PrintWriter(new OutputStreamWriter(System.out,"utf8"),true);
	for(String line;(line=reader.readLine())!=null;){
	    Matcher m=pat.matcher(line);
	    while(m.find()){
		writer.print(m.group(0));
		for(int i=1;i<=m.groupCount();i++){
		    writer.print('\t');
		    writer.print(m.group(i));
		}
		writer.println();
	    }
	}
	reader.close();
	writer.close();

    }

}