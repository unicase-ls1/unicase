/**
 * 
 */
package traceability.java;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharTokenizer;
import org.apache.lucene.analysis.TokenStream;

/**
 * @author liya
 *
 */
public class KeywordAnalyzer extends Analyzer {
	@Override
	public TokenStream tokenStream(String fieldName, Reader reader) {
		return new CharTokenizer(reader){
			@Override
			protected boolean isTokenChar(char c) {
			return true;
		}
	};
}


}
