/**
 * 
 */
package traceability.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.lucene.analysis.PerFieldAnalyzerWrapper;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;
import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.common.util.EList;

import traceRecovery.Directory;
import traceRecovery.Link;
import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;
import traceability.fortran.FortranSourceCodeAnalyzer;
import traceability.java.JavaSourceCodeAnalyzer;
import traceability.java.JavaSourceCodeIndexer;
import traceability.java.KeywordAnalyzer;

/**
 * the controller that will start to control all the search capabilities of
 * everything.
 * 
 * @author taher
 * 
 */
public class Search {
	private Indexer index;
	private PerFieldAnalyzerWrapper analyzer;
	private Directory dir;

	/**
	 * will run to try to link btween the objects.
	 * 
	 * @param query
	 *            the query(s) that the user is searching for
	 * @param dir
	 *            the directory that the file is found in
	 * @return returns all the links created
	 * @throws IOException
	 *             could throw an IOException
	 */
	public ArrayList<Link> runRecoveryMEToCode(Query query, Directory dir)
			throws IOException {
		try {
			File indexDir = new File(dir.getPath());

			analyzer.addAnalyzer("import", new KeywordAnalyzer());

			org.apache.lucene.store.Directory fsDir = FSDirectory.getDirectory(
					indexDir, false);

			IndexSearcher is = new IndexSearcher(fsDir);

			QueryParser parser = new QueryParser("code", analyzer);

			ArrayList<Hits> hits = new ArrayList<Hits>();

			for (int i = 0; i < query.getModelElement().size(); i++) {
				hits.add(is.search(parser.parse(query.getModelElement().get(i)
						.getDescription())));
			}

			return createLinks(hits, query);

		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<File> searchForWordInCode(Query query, Directory dir) {
		try {
			File indexDir = new File(dir.getPath());
			analyzer.addAnalyzer("import", new KeywordAnalyzer());
			org.apache.lucene.store.Directory fsDir = FSDirectory.getDirectory(
					indexDir, false);

			IndexSearcher is = new IndexSearcher(fsDir);

			QueryParser parser = new QueryParser("code", analyzer);

			ArrayList<Hits> hits = new ArrayList<Hits>();

			for (int i = 0; i < query.getModelElement().size(); i++) {
				hits.add(is.search(parser.parse(query.getModelElement().get(i)
						.getDescription())));
			}

			ArrayList<File> result = new ArrayList<File>();

			for (int i = 0; i < hits.size(); i++) {
				for (int j = 0; j < hits.get(i).length(); j++) {
					File f = new File(hits.get(i).doc(j).get("filename"));
					result.add(f);
				}
			}

			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	/**
	 * will create the link between the code and model elements.
	 * 
	 * @param hit
	 *            this is the result of the search
	 * @param query
	 *            this is the query which will contain the model elements of the
	 *            source
	 * @return returns all the links between the model elements and the code
	 * @throws IOException
	 *             will throw and exception if while trying to use any input
	 *             output fails
	 */
	public ArrayList<Link> createLinks(ArrayList<Hits> hit, Query query)
			throws IOException {

		ArrayList<Link> links = new ArrayList<Link>();

		for (int i = 0; i < hit.size(); i++) {
			Link link = TraceRecoveryFactory.eINSTANCE.createLink();
			for (int j = 0; j < hit.get(i).length(); j++) {
				Document doc = hit.get(i).doc(j);
				link.setConfidence(hit.get(i).score(j));
				link.setCreationDate(Calendar.getInstance().getTime());
				link.setDescription("linking between code and data");
				link.setSource(query.getModelElement().get(i));
				link.setName(doc.get("filename"));
				links.add(link);

			}
		}

		return links;
	}

	/**
	 * will set the used analyzer.
	 * 
	 * @param analyzer
	 *            the string and type of the analyzer
	 * @return returns tha new created analyzer
	 */
	public void setAnalyzer(String analyzer) {
		if (analyzer.toLowerCase() == "java") {
			this.analyzer = new PerFieldAnalyzerWrapper(
					new JavaSourceCodeAnalyzer());
		} else {
			this.analyzer = new PerFieldAnalyzerWrapper(
					new FortranSourceCodeAnalyzer());
		}
	}

	/**
	 * set the index that will be used to index.
	 */
	public void setIndexer(String indexer, Directory codeDir,
			Directory sourceDir) {
		try {
			this.dir = sourceDir;
			File file = new File(dir.getPath());
			if (indexer.toLowerCase() == "java") {
				IndexWriter writer = new IndexWriter(file,
						new JavaSourceCodeAnalyzer(), true);
				this.index = new Indexer(writer, codeDir, sourceDir);
			} else if (indexer.toLowerCase() == "fortran") {
				IndexWriter writer = new IndexWriter(file,
						new FortranSourceCodeAnalyzer(), true);
				this.index = new Indexer(writer, codeDir, sourceDir);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * set the parser that is going to be used.
	 */
	public void setParser() {

	}

	public void index() {
		try {
			index.indexDir(this.index.getWriter(), this.index.getCodeDir(),
					this.index.getIndexDir());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Indexer getIndex() {
		return index;
	}

	public void setIndex(Indexer index) {
		this.index = index;
	}

	public PerFieldAnalyzerWrapper getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(PerFieldAnalyzerWrapper analyzer) {
		this.analyzer = analyzer;
	}

	public Directory getDir() {
		return dir;
	}

	public void setDir(Directory dir) {
		this.dir = dir;
	}
}
