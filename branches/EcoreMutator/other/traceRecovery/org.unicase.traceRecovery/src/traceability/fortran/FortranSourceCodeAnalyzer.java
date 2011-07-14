/**
 * 
 */
package traceability.fortran;

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
public class FortranSourceCodeAnalyzer extends Analyzer{
	private Set fortranStopSet;
	private Set englishStopSet;
	private static final String[] FORTRAN_STOP_WORDS = {
	    "PROGRAM", "IMPLICIT", "NONE", "END", ".TRUE.", ".FALSE.",
	    "IF", "THEN", "DO", "INTEGER", "REAL",
	    "LOGICAL", "COMPLEX", "CHARACTER", "LIST",
	    "PARAMETER", "KIND", "FUNCTION", "SUBROUTINE", "MODULE",
	    "CONTAINS", "PUBLIC", "PRIVATE", "USE", "ONLY", "INTERFACE"};
	private static final String[] ENGLISH_STOP_WORDS ={
	    "a", "an", "and", "are","as","at","be", "but",
	    "by", "for", "if", "in", "into", "is", "it",
	    "no", "not", "of", "on", "or", "s", "such",
	    "that", "the", "their", "then", "there","these",
	    "they", "this", "to", "was", "will", "with" };
	public FortranSourceCodeAnalyzer(){
	    super();
	    fortranStopSet = StopFilter.makeStopSet(FORTRAN_STOP_WORDS);
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
	        new LowerCaseTokenizer(reader),fortranStopSet);
	 }


}
