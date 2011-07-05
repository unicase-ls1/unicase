/**
 * 
 */
package traceability.java;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseTokenizer;
import org.apache.lucene.analysis.PorterStemFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * @author taher
 *	will be the analyzer used to analyze the java code before indexing
 */
public class JavaSourceCodeAnalyzer extends Analyzer {
	private Set javaStopSet;
	private Set englishStopSet;
	private static final String[] JAVA_STOP_WORDS = {
	    "public","private","protected","interface",
	    "abstract","implements","extends","null","new",
	    "switch","case", "default" ,"synchronized" ,
	    "do", "if", "else", "break","continue","this",
	    "assert" ,"for","instanceof", "transient",
	    "final", "static" ,"void","catch","try",
	    "throws","throw","class", "finally","return",
	    "const" , "native", "super","while", "import",
	    "package" ,"true", "false" };
	private static final String[] ENGLISH_STOP_WORDS ={
	    "a", "an", "and", "are","as","at","be", "but",
	    "by", "for", "if", "in", "into", "is", "it",
	    "no", "not", "of", "on", "or", "s", "such",
	    "that", "the", "their", "then", "there","these",
	    "they", "this", "to", "was", "will", "with" };
	public JavaSourceCodeAnalyzer(){
	    super();
	    javaStopSet = StopFilter.makeStopSet(JAVA_STOP_WORDS);
	    englishStopSet = StopFilter.makeStopSet(ENGLISH_STOP_WORDS);
	}
	@Override
	/**
	 * returns the token stream to get the tokens of the word after performing certain tokinisation
	 */
	public TokenStream tokenStream(String fieldName,
	                    Reader reader) {
	    if (fieldName.equals("comment"))
	        return   new PorterStemFilter(
	        new StopFilter(
	        new LowerCaseTokenizer(reader),englishStopSet));
	    else if (fieldName.equals("method")){
	    	ArrayList<String> methodName = methodName(reader);
	    	StringReader read = new StringReader(method(methodName));
	    	return new LowerCaseTokenizer(read);
	    	
	    } else
	        return   new StopFilter(
	        new LowerCaseTokenizer(reader),javaStopSet);
	 }
	
	
	/**
	 * will split the method name if combined
	 * @param reader
	 * 			this is the reader containing the text
	 * @return
	 * 		returns the arraylist of the names
	 */
	public ArrayList<String> methodName(Reader reader){
		try {
			int chr = reader.read();
			char read = '.';
			ArrayList<String> methodName = new ArrayList<String>();
			String readNow = "";
			if(chr != -1){
				read = (char) chr;
				readNow+=read;
				while(chr != -1){
					chr = reader.read();
					if(chr == -1){
						methodName.add(readNow);
						break;
					}
					read = (char) chr;
					if(Character.isUpperCase(read)){
						methodName.add(readNow);
						readNow = ""+read;
					}else{
						readNow += read;
					}
				}
				return methodName;
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
		
		
	}
	
	/**
	 * changes the method name to a sentence if contains more than a word
	 * @param methodName
	 * 		the arraylist that contains the names 
	 * @return
	 * 		returns the string after doing the concatenation
	 */
	public String method(ArrayList<String> methodName){
		
		String text = methodName.get(0);
		
		for(int i=1; i < methodName.size(); i++){
			text = text + " " + methodName.get(i);
		}
		
		return text;
	}


}
