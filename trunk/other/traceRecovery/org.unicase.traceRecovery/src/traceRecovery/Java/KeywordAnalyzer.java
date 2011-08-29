/**
 * 
 */
package traceRecovery.Java;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharTokenizer;
import org.apache.lucene.analysis.TokenStream;

/**
 * @author taher
 *an analyzer of keywords
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
