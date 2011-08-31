/**
 * 
 */
package traceRecovery.handler;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.lucene.analysis.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.store.FSDirectory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.photran.internal.core.analysis.binding.ScopingNode;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.trace.CodeLocation;
import org.unicase.model.trace.TraceFactory;

import traceRecovery.Directory;
import traceRecovery.Link;
import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;
import traceRecovery.Fortran.FortranCodeIndexer;
import traceRecovery.Fortran.FortranSourceCodeAnalyzer;
import traceRecovery.Fortran.SearchFortran;
import traceRecovery.Java.JavaSourceCodeAnalyzer;
import traceRecovery.Java.JavaSourceCodeIndexer;
import traceRecovery.Java.KeywordAnalyzer;
import traceRecovery.Java.SearchJava;

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
	public ArrayList<String> text;
	Project project;

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	Highlighter h1, h2, h;

	/**
	 * will run to try to link between the objects.
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

			QueryParser parser = new QueryParser("class", analyzer);

			QueryParser parser1 = new QueryParser("method", analyzer);

			QueryParser parser2 = new QueryParser("comment", analyzer);

			ArrayList<Hits> hits = new ArrayList<Hits>();

			IndexReader reader = IndexReader.open(fsDir);

			ArrayList<QueryScorer> scorer = new ArrayList<QueryScorer>();

			ArrayList<Integer> mod = new ArrayList<Integer>();

			text = new ArrayList<String>();

			for (int i = 0; i < query.getModelElements().size(); i++) {
				org.apache.lucene.search.Query q = parser2.parse(query
						.getModelElements().get(i).getDescription());
				org.apache.lucene.search.Query q1 = parser1.parse(query
						.getModelElements().get(i).getDescription());
				org.apache.lucene.search.Query q2 = parser.parse(query
						.getModelElements().get(i).getDescription());

				scorer.add(new QueryScorer(q, reader, "comment"));
				scorer.add(new QueryScorer(q1, reader, "method"));
				scorer.add(new QueryScorer(q2, reader, "class"));

				h = new Highlighter(scorer.get(i));
				h1 = new Highlighter(scorer.get(i + 1));
				h2 = new Highlighter(scorer.get(i + 2));

				Hits hit = is.search(q);
				Hits hit1 = is.search(q1);
				Hits hit2 = is.search(q2);

				if (hit.length() > 0) {
					hits.add(hit);
				}
				if (hit1.length() > 0) {
					hits.add(hit1);
				}
				if (hit2.length() > 0) {
					hits.add(hit2);
				}
				if (hit.length() > 0 || hit1.length() > 0 || hit2.length() > 0) {
					mod.add(i);
				}

			}

			// IndexReader r = is.getIndexReader();
			//
			// TermEnum term = r.terms(new Term("comment", ""));
			//
			// String terms = "";
			// while ("comment".equals(term.term().field())) {
			// terms += " " + term.term().text() + " ";
			//
			// if (!term.next()) {
			// break;
			// }
			//
			//
			// }

			for (int i = 0; i < mod.size(); i++) {

				for (int j = 0; j < hits.get(i).length(); j++) {

					String terms = "";
					String className = "";
					ArrayList<String> comments = new ArrayList<String>();
					ArrayList<ScopingNode> subroutines = new ArrayList<ScopingNode>();

					ArrayList<String> methods = new ArrayList<String>();

					String method;
					method = "";
					JavaSourceCodeAnalyzer anal = new JavaSourceCodeAnalyzer();

					if (index.getWriter().getAnalyzer() instanceof JavaSourceCodeAnalyzer) {

						SearchHelp help = new SearchHelp(hits.get(i).doc(j)
								.get("path"));
						comments = help.getComments();

						methods = help.getMethods();
						className = help.getClassName();

						for (int k = 0; k < methods.size(); k++) {
//							 method = methods.get(i)+ "\n";
							method = anal
									.method(anal.methodName(new StringReader(
											methods.get(i))))
									+ "\n";
						}

					} else if (index.getWriter().getAnalyzer() instanceof FortranSourceCodeAnalyzer) {
						SearchHelp help = new SearchHelp(hits.get(i).doc(j)
								.get("path"));
						comments = help.getCommentsF();
						subroutines = help.getSubroutines();
					}

					 for(int k = 0 ; k <subroutines.size(); k++){
					 className += subroutines.get(i) +"\n";
					 }

					className = anal.method(anal.methodName(new StringReader(
							className)));
//					
//					method = anal.method(anal.methodName(new StringReader(method)));

					for (int k = 0; k < comments.size(); k++) {
						terms += comments.get(k) + "\n";
					}

					String tex = h.getBestFragment(analyzer, "class", className
							+ " ");

					String t = h1.getBestFragment(analyzer, "method", method
							+ " ");

					String t2 = h2.getBestFragment(analyzer, "comment", terms
							+ " ");

					if (tex == null && t == null && t2 == null) {
						create(tex, hits, i, j, query,
								"linking from ME to code");
					}
					if (tex != null) {
						create(tex, hits, i, j, query,
								"linking from ME to code");
					}
					if (t != null) {
						create(t, hits, i, j, query, "linking from ME to code");
					}
					if (t2 != null) {
						create(t2, hits, i, j, query, "linking from ME to code");
					}

				}
			}

			// System.out.println(hits.get(0).doc(0).get("code")
			// + " this is the code that was retrived");

			return links;

		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}

	}

	ArrayList<Link> links = new ArrayList<Link>();

	File f = new File("/home/taher/Downloads/eclipse (developer)/taher.xml");

	java.net.URI u = f.toURI();
	URI uri = URI.createURI(u.toString());
	Resource resource = new XMLResourceImpl(uri);

	public void create(String tex, ArrayList<Hits> hits, int i, int j,
			Query query, String type) throws IOException {

		if (tex != null) {

			StringTokenizer tok = new StringTokenizer(tex, "\n");

			while (tok.hasMoreElements()) {
				String line = tok.nextToken();
				if (containsHighlightedText(line)) {
					// line = line.replace("<B>", "");
					// line = line.replace("</B>", "");
					CodeLocation location = TraceFactory.eINSTANCE
							.createCodeLocation();
					// System.out.println(line);
					// location.setLineContent(line);
					location.setName(hits.get(i).doc(j).get("filename"));
					location.setDescription(hits.get(i).doc(j).get("path"));

					Link link = TraceRecoveryFactory.eINSTANCE.createLink();
					link.setConfidence(hits.get(i).score(j));
					link.setDescription(line);
					link.setSource(query.getModelElements().get(i));
					link.setTarget(location);
					link.setType(type);

					Resource r = new XMLResourceImpl(uri);
					r.getContents().add(location);

					resource.getContents().add(link);
					resource.save(null);
					links.add(link);
					text.add(line);

				}
			}
		} else {
			// StringTokenizer tok = new StringTokenizer(tex, "\n");

			// while (tok.hasMoreElements()) {
			// String line = tok.nextToken();
			// if (containsHighlightedText(line)) {
			// line = line.replace("<B>", "");
			// line = line.replace("</B>", "");
			CodeLocation location = TraceFactory.eINSTANCE.createCodeLocation();
			// System.out.println(line);
			// location.setLineContent(line);
			location.setName(hits.get(i).doc(j).get("filename"));
			location.setDescription(hits.get(i).doc(j).get("path"));

			Link link = TraceRecoveryFactory.eINSTANCE.createLink();
			link.setConfidence(hits.get(i).score(j));
			link.setDescription("");
			link.setSource(query.getModelElements().get(i));
			link.setTarget(location);
			link.setType(type);
			links.add(link);
			text.add("");

		}

	}

	boolean isDir = false;
	Query q;

	/**
	 * will dig through the the directory to supply with the files in it
	 * 
	 * @param file
	 *            this is the directory to be diged
	 * @param type
	 *            this is the type of the parser
	 */
	public void createQueryCodeDir(File file, String type) {
		// File[] dirFiles = file.listFiles();
		// ArrayList<File> files = new ArrayList<File>();
		// for (int i = 0; i < dirFiles.length; i++) {
		// files.add(dirFiles[i]);
		// }
		// isDir = true;
		// createQeuryCode(files, type);

		if (type.toLowerCase() == "java") {
			SearchJava java = new SearchJava();
			java.createQueryCodeDir(file, type);
		} else if(type.toLowerCase() == "fortran"){
			SearchFortran fortran = new SearchFortran();
			fortran.createQueryCodeDir(file, type);
		}

	}

	/**
	 * will create the query from the code files
	 * 
	 * @param file
	 *            this is the code file that will be used to create the query
	 * @param type
	 *            this is the type of the parser that should be used
	 * @return the is the query that is returned after doing the parsing and
	 *         analyzing
	 */
	public Query createQeuryCode(ArrayList<File> file, String type) {
		return null;

	}

	// }

	// public static void main(String[] args) {
	// Search search = new Search();
	// search.createQeuryCode(
	// new File(
	// "/home/taher/workspace/org.unicase.traceRecovery/src/traceability/handler/Search.java"),
	// "java");
	// }

	/**
	 * this will run a recovery from code to model element
	 * 
	 * @param query
	 *            this is the query that the search will use to run
	 * @param dir
	 *            this is the directory to find the indexed file
	 * @return this will return and arraylist of links that cause the hit
	 */
	public ArrayList<Link> runRecoveryCodeToME(Query query, Directory dir) {
		try {
			File indexDir = new File(dir.getPath());
			org.apache.lucene.store.Directory fsDir = FSDirectory.getDirectory(
					indexDir, false);

			analyzer.addAnalyzer("text", new StandardAnalyzer());

			IndexSearcher is = new IndexSearcher(fsDir);

			ArrayList<Link> links = new ArrayList<Link>();

			ArrayList<Hits> hits = new ArrayList<Hits>();

			IndexReader reader = IndexReader.open(fsDir);

			ArrayList<QueryScorer> scorer = new ArrayList<QueryScorer>();

			QueryParser parser = new QueryParser("text", analyzer);

			text = new ArrayList<String>();

			for (int i = 0; i < query.getModelElements().size(); i++) {

				if (!query.getModelElements().get(i).getDescription()
						.equals("")) {
					org.apache.lucene.search.Query quer = parser.parse(query
							.getModelElements().get(i).getDescription());

					scorer.add(new QueryScorer(quer, reader, "text"));

					hits.add(is.search(quer));
				}

			}

			for (int i = 0; i < hits.size(); i++) {
				Highlighter h = new Highlighter(scorer.get(i));
				for (int j = 0; j < hits.get(i).length(); j++) {
					Link link = TraceRecoveryFactory.eINSTANCE.createLink();
					link.setConfidence(hits.get(i).score(j));
					link.setDescription("linking from code to model element");
					link.setSource(query.getModelElements().get(i));
					link.setType("linking from code to Model Element");

					String tex = h.getBestFragment(analyzer, "text", hits
							.get(i).doc(j).get("text"));

					// CodeLocation loc = TraceFactory.eINSTANCE
					// .createCodeLocation();
					// loc.setName(hits.get(i).doc(j).get("name"));
					//
					// link.setTarget(loc);

					ModelElementId id = MetamodelFactory.eINSTANCE
							.createModelElementId();
					id.setId(hits.get(i).doc(j).get("id"));

					UnicaseModelElement element = (UnicaseModelElement) project
							.getModelElement(id);
					link.setTarget(element);

					links.add(link);
					text.add(tex);

				}
			}

			return links;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * checks if the text contains any highlighted text
	 * 
	 * @param text
	 *            this is the text to check
	 * @return returns true if contains and false otherwise
	 */
	public boolean containsHighlightedText(String text) {
		if (text.contains("<B>")) {
			return true;
		}
		return false;
	}

	/**
	 * searches for a certain word in the text
	 * 
	 * @param query
	 *            the query word that u want to search for
	 * @param dir
	 *            this is the index directory
	 * @return this will return an arraylist of files that contain the word
	 */
	public ArrayList<File> searchForWordInCode(Query query, Directory dir) {
		try {
			File indexDir = new File(dir.getPath());
			analyzer.addAnalyzer("import", new KeywordAnalyzer());
			org.apache.lucene.store.Directory fsDir = FSDirectory.getDirectory(
					indexDir, false);

			IndexSearcher is = new IndexSearcher(fsDir);

			QueryParser parser = new QueryParser("code", analyzer);

			ArrayList<Hits> hits = new ArrayList<Hits>();

			for (int i = 0; i < query.getModelElements().size(); i++) {
				hits.add(is.search(parser.parse(query.getModelElements().get(i)
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
			} else if (indexer.toLowerCase() == "me") {
				IndexWriter writer = new IndexWriter(file,
						new StandardAnalyzer(), true);
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

	public void indexMe(ArrayList<UnicaseModelElement> me, Directory index) {
		try {
			this.dir = index;
			File file = new File(this.dir.getPath());

			IndexWriter writer = new IndexWriter(file, new StandardAnalyzer(),
					true);

			for (int i = 0; i < me.size(); i++) {
				this.index.IndexME(me.get(i), writer);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * will index the directory
	 */
	public void index() {
		try {
			index.indexDir(this.index.getWriter(), this.index.getCodeDir(),
					this.index.getIndexDir());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * will index a certain array list of directories
	 * 
	 * @param dir
	 *            this is the arraylist of the directires to index
	 */
	public void index(ArrayList<String> dir) {
		try {
			JavaSourceCodeIndexer javaIndexer = new JavaSourceCodeIndexer();
			FortranCodeIndexer fortranIndexer = new FortranCodeIndexer();

			for (int i = 0; i < dir.size(); i++) {
				Directory codeDir = TraceRecoveryFactory.eINSTANCE
						.createDirectory();
				codeDir.setPath(dir.get(i));

				index.indexDir(this.index.getWriter(), codeDir,
						this.index.getIndexDir(), javaIndexer, fortranIndexer);
			}
			this.index.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the index
	 */
	public Indexer getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(Indexer index) {
		this.index = index;
	}

	/**
	 * @return the analyzer
	 */
	public PerFieldAnalyzerWrapper getAnalyzer() {
		return analyzer;
	}

	/**
	 * @param analyzer
	 *            the analyzer to set
	 */
	public void setAnalyzer(PerFieldAnalyzerWrapper analyzer) {
		this.analyzer = analyzer;
	}

	/**
	 * @return the dir
	 */
	public Directory getDir() {
		return dir;
	}

	/**
	 * @param dir
	 *            the dir to set
	 */
	public void setDir(Directory dir) {
		this.dir = dir;
	}

}