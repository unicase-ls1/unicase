/**
 * 
 */
package traceability.handler;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import org.apache.lucene.analysis.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.store.FSDirectory;
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
import traceability.fortran.FortranCodeIndexer;
import traceability.fortran.FortranSourceCodeAnalyzer;
import traceability.fortran.FortranSourceCodeParser;
import traceability.java.JavaParser;
import traceability.java.JavaParser.JMethod;
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
	public ArrayList<String> text;
	Project project;

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

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


			ArrayList<Hits> hits = new ArrayList<Hits>();

			ArrayList<Link> links = new ArrayList<Link>();

			IndexReader reader = IndexReader.open(fsDir);

			ArrayList<QueryScorer> scorer = new ArrayList<QueryScorer>();

			text = new ArrayList<String>();

			for (int i = 0; i < query.getModelElements().size(); i++) {
				org.apache.lucene.search.Query q = parser.parse(query
						.getModelElements().get(i).getDescription());

				scorer.add(new QueryScorer(q, reader, "class"));
				Highlighter h = new Highlighter(scorer.get(i));

				hits.add(is.search(q));

				for (int j = 0; j < hits.get(i).length(); j++) {

					String tex = h.getBestFragment(analyzer, "class", hits
							.get(i).doc(j).get("class"));
					if (tex != null) {

						StringTokenizer tok = new StringTokenizer(tex, "\n");

						while (tok.hasMoreElements()) {
							String line = tok.nextToken();
							if (containsHighlightedText(line)) {
								// line = line.replace("<B>", "");
								// line = line.replace("</B>", "");
								CodeLocation location = TraceFactory.eINSTANCE
										.createCodeLocation();
								System.out.println(line);
								location.setLineContent(line);
								location.setName(hits.get(i).doc(j)
										.get("filename"));
								location.setDescription(hits.get(i).doc(j)
										.get("path"));

								Link link = TraceRecoveryFactory.eINSTANCE
										.createLink();
								link.setConfidence(hits.get(i).score(j));
								link.setDescription("linking from ME to code");
								link.setSource(query.getModelElements().get(i));
								link.setTarget(location);
								link.setType("linking from ME to code");
								links.add(link);
								text.add(line);

							}
						}
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
		File[] dirFiles = file.listFiles();
		ArrayList<File> files = new ArrayList<File>();
		for (int i = 0; i < dirFiles.length; i++) {
			files.add(dirFiles[i]);
		}
		isDir = true;
		createQeuryCode(files, type);

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
		try {
			if (!isDir) {
				q = TraceRecoveryFactory.eINSTANCE.createQuery();
			}
			if (type.toLowerCase() == "java") {

				for (int i = 0; i < file.size(); i++) {
					if (file.get(i).isDirectory()) {

						createQueryCodeDir(file.get(i), type);

					} else if (file.get(i).getName().endsWith(".java")) {
						JavaParser parser = new JavaParser();
						parser.setSource(file.get(i));
						parser.getDeclaredClass();
						JavaSourceCodeAnalyzer analyzer = new JavaSourceCodeAnalyzer();

						// System.out.println("this is the value of the analyzer "
						// + parser.getDeclaredClass().className);

						String className = parser.getDeclaredClass().className;

						StringReader str = new StringReader(className);

						TokenStream token = analyzer.tokenStream("className",
								str);

						Token tok = token.next();

						CodeLocation loc = TraceFactory.eINSTANCE
								.createCodeLocation();
						loc.setDescription(tok.termText());
						loc.setName(className);

						q.getModelElements().add(loc);

						ArrayList<String> comments = parser.getComments();
						String comm = "";

						if (comments != null) {

							for (int j = 0; j < comments.size(); j++) {
								str = new StringReader(comments.get(j));
								token = analyzer.tokenStream("comment", str);

								if (token == null) {
									break;
								}
								tok = token.next();
								if (tok != null) {
									comm = "";
									while (tok != null) {
										comm += " " + tok.termText();

										tok = token.next();
									}

									loc = TraceFactory.eINSTANCE
											.createCodeLocation();
									loc.setDescription(comm);
									loc.setName(className + ".java");
									q.getModelElements().add(loc);
								}

							}
						}

						ArrayList<JMethod> methods = parser.getDeclaredClass().methodDeclarations;
						comm = "";
						for (int j = 0; j < methods.size(); j++) {

							comm = "";

							str = new StringReader(methods.get(j).methodName);
							token = analyzer.tokenStream("method", str);

							if (token == null) {
								break;
							}
							tok = token.next();
							if (tok != null) {
								while (tok != null) {
									comm += " " + tok.termText();

									tok = token.next();
								}

								System.out.println(comm
										+ " this is the string at the end");
							}
							loc = TraceFactory.eINSTANCE.createCodeLocation();
							loc.setDescription(comm);
							loc.setName(className);
							q.getModelElements().add(loc);
						}
					}

				}
			} else if (type.toLowerCase() == "fortran") {
				for (int i = 0; i < file.size(); i++) {
					if (file.get(i).getName().endsWith("f90")
							|| file.get(i).getName().endsWith("f95")
							|| file.get(i).getName().endsWith("for")) {

						FortranSourceCodeParser parser = new FortranSourceCodeParser(
								file.get(i));
						ArrayList subroutines = parser.getSubroutines();
						ArrayList<String> comments = parser.getComments();
						
						String name = file.get(i).getName();

						// FortranSourceCodeAnalyzer analyzer = new
						// FortranSourceCodeAnalyzer();
						CodeLocation loc;
						for (int j = 0; j < comments.size(); j++) {
							loc = TraceFactory.eINSTANCE.createCodeLocation();
							loc.setDescription(comments.get(j));
							loc.setName(name);
							q.getModelElements().add(loc);

						}

						for (int j = 0; j < subroutines.size(); j++) {
							loc = TraceFactory.eINSTANCE.createCodeLocation();
							loc.setDescription(((ScopingNode) subroutines
									.get(i)).getName(true));
							loc.setName(name);
							q.getModelElements().add(loc);

						}
					}
				}
			}
			isDir = false;
			return q;
		} catch (IOException e) {
			e.printStackTrace();
			return null;

			// analyzer.tokenStream("class", reader)

		}

	}

	// public static void main(String[] args) {
	// Search search = new Search();
	// search.createQeuryCode(
	// new File(
	// "/home/taher/workspace/org.unicase.traceRecovery/src/traceability/handler/Search.java"),
	// "java");
	// }

	/**
	 * this will run a recovery from code to model elemnt
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

			text = new ArrayList<String>();

			for (int i = 0; i < query.getModelElements().size(); i++) {

			
				
				org.apache.lucene.search.Query quer = QueryParser.parse(query
						.getModelElements().get(i).getDescription(), "text",
						new StandardAnalyzer());
				
				scorer.add(new QueryScorer(quer, reader, "text"));
				
				hits.add(is.search(quer));

			}

			for (int i = 0; i < hits.size(); i++) {
				Highlighter h = new Highlighter(scorer.get(i));
				for (int j = 0; j < hits.get(i).length(); j++) {
					Link link = TraceRecoveryFactory.eINSTANCE.createLink();
					link.setConfidence(hits.get(i).score(j));
					link.setDescription("linking from code to model element");
					link.setSource(query.getModelElements().get(i));
					link.setType("linking from code to Model Element");

					String tex = h.getBestFragment(analyzer, "text", hits.get(i).doc(j).get("text") );
					
					// CodeLocation loc = TraceFactory.eINSTANCE
					// .createCodeLocation();
					// loc.setName(hits.get(i).doc(j).get("name"));
					//
					// link.setTarget(loc);

					ModelElementId id = MetamodelFactory.eINSTANCE
							.createModelElementId();
					id.setId(hits.get(i).doc(j).get("id"));

					UnicaseModelElement element = (UnicaseModelElement) project.getModelElement(id);
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
			// TODO Auto-generated catch block
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
	 * will create the link between the code and model elements.
	 * 
	 * @param hit
	 *            this is the result of the search
	 * @param query
	 *            this is the query which will contain the model elements of the
	 *            source
	 * @param type
	 *            this is the type if it is from ME to code or vice versa.
	 * @return returns all the links between the model elements and the code
	 * @throws IOException
	 *             will throw and exception if while trying to use any input
	 *             output fails
	 */
	public ArrayList<Link> createLinks(ArrayList<Hits> hit, Query query,
			String type) throws IOException {

		ArrayList<Link> links = new ArrayList<Link>();

		for (int i = 0; i < hit.size(); i++) {
			Link link = TraceRecoveryFactory.eINSTANCE.createLink();
			for (int j = 0; j < hit.get(i).length(); j++) {
				Document doc = hit.get(i).doc(j);
				link.setConfidence(hit.get(i).score(j));
				link.setCreationDate(Calendar.getInstance().getTime());
				link.setDescription("linking between code and data");
				link.setSource(query.getModelElements().get(i));
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
