/**
 * 
 */
package traceability.java;

import java.io.Reader;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseTokenizer;
import org.apache.lucene.analysis.PorterStemFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * @author liya
 *
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
	public TokenStream tokenStream(String fieldName,
	                    Reader reader) {
	    if (fieldName.equals("comment"))
	        return   new PorterStemFilter(
	        new StopFilter(
	        new LowerCaseTokenizer(reader),englishStopSet));
	    else
	        return   new StopFilter(
	        new LowerCaseTokenizer(reader),javaStopSet);
	 }


}
