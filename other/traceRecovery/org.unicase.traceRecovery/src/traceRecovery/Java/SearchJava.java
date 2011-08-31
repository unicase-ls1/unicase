/**
 * 
 */
package traceRecovery.Java;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.index.IndexWriter;
import org.unicase.model.trace.CodeLocation;
import org.unicase.model.trace.TraceFactory;

import traceRecovery.Directory;
import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;
import traceRecovery.Java.JavaParser.JMethod;
import traceRecovery.handler.Indexer;
import traceRecovery.handler.Search;

/**
 * @author taher
 * 
 */
public class SearchJava extends Search {

	Query q;

	public SearchJava() {
		// super.setIndex(new JavaSourceCodeIndexer());
		// super.setAnalyzer("java");
		// super.set
//		super("nothing");

	}

	
	boolean isDir = false;
	
	@Override
	public void createQueryCodeDir(File file, String type) {
		File[] dirFiles = file.listFiles();
		ArrayList<File> files = new ArrayList<File>();
		for (int i = 0; i < dirFiles.length; i++) {
			files.add(dirFiles[i]);
		}
		isDir = true;
		createQeuryCode(files, type);

	}
	


	
	@Override
	public Query createQeuryCode(ArrayList<File> file, String type) {
		try {

			if(!isDir){
				q = TraceRecoveryFactory.eINSTANCE.createQuery();
			}
			

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

						TokenStream token = analyzer.tokenStream("class", str);

						String n = "";
						Token tok = null;
						while ((tok = token.next()) != null) {
							n += " " + tok.termText();

						}

						CodeLocation loc = TraceFactory.eINSTANCE
								.createCodeLocation();
						loc.setDescription(n);
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
				isDir = false;
				return q;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	

	public void setIndexer( Directory codeDir,
			Directory sourceDir) {
		setDir(sourceDir);
		File file = new File(getDir().getPath());
		IndexWriter writer;
		try {
			writer = new IndexWriter(file,
					new JavaSourceCodeAnalyzer(), true);
			setIndex(new Indexer(writer, codeDir, sourceDir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
