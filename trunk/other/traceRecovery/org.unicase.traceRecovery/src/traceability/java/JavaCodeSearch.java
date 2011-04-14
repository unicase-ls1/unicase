/**
 * 
 */
package traceability.java;
import java.io.File;

import org.apache.lucene.analysis.PerFieldAnalyzerWrapper;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * @author liya
 *
 */
public class JavaCodeSearch {
    /** Main for running test case by itself. */
    public static void main(String args[]) {
		try {
			File indexDir = new File("lucene-index");
			String q = "method:next";
			PerFieldAnalyzerWrapper analyzer = new PerFieldAnalyzerWrapper(
					new JavaSourceCodeAnalyzer());
			analyzer.addAnalyzer("import", new KeywordAnalyzer());
			Directory fsDir;
			fsDir = FSDirectory.getDirectory(indexDir, false);
			IndexSearcher is = new IndexSearcher(fsDir);
			QueryParser parser = new QueryParser("code", analyzer);
			Query query = parser.parse(q);
			long start = System.currentTimeMillis();

			Hits hits = is.search(query);
			long end = System.currentTimeMillis();

			System.err.println("Found " + hits.length() + " docs in "
					+ (end - start) + " millisec");
			for (int i = 0; i < hits.length(); i++) {
				Document doc = hits.doc(i);
				System.out.println(doc.get("filename") + " with a score of " + hits.score(i));
			}
			is.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
