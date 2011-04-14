/**
 * 
 */
package traceability.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

import traceability.java.JavaParser.JClass;
import traceability.java.JavaParser.JMethod;

/**
 * @author liya
 *
 */
public class JavaSourceCodeIndexer {
	private static final String IMPLEMENTS = "implements";
	private static final String IMPORT = "import";
	private static final String CLASS = "class";
	private static final String METHOD = "method";
	private static final String CODE = "code";
	private static final String COMMENT = "comment";
	private static final String RETURN = "return";
	private static final String PARAMETER = "parameter";
	private static final String EXTENDS = "extends";

	public JavaSourceCodeIndexer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try {
			File indexDir = new File(
					"lucene-index");
			File dataDir = new File(
					"code");
			IndexWriter writer = new IndexWriter(indexDir,
					new JavaSourceCodeAnalyzer(), true);
			indexDirectory(writer, dataDir);
			int numFiles = writer.docCount();
			writer.close();
			System.out.println("Indexing "+ numFiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void indexDirectory(IndexWriter writer, File dir)
			throws IOException {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory())
				indexDirectory(writer, f);
			else if (f.getName().endsWith(".java"))
				indexFile(writer, f);
		}
	}

	public static void indexFile(IndexWriter writer, File f) {
		if (f.isHidden() || !f.exists() || !f.canRead())
			return;
		Document doc = new Document();
		JavaParser parser = new JavaParser();
		parser.setSource(f);
		addImportDeclarations(doc, parser);
		addComments(doc, parser);
		JClass cls = parser.getDeclaredClass();
		addClass(doc, cls);
		doc.add(Field.UnIndexed("filename", f.getName()));
		try {
			writer.addDocument(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addImportDeclarations(Document doc, JavaParser parser) {
		ArrayList imports = parser.getImportDeclarations();
		if (imports == null)
			return;
		for (int i = 0; i < imports.size(); i++) {
			String importName = (String) imports.get(i);
			doc.add(Field.Keyword(IMPORT, importName));
		}
	}

	private static void addComments(Document doc, JavaParser parser) {
		ArrayList comments = parser.getComments();
		if (comments == null)
			return;
		for (int i = 0; i < comments.size(); i++) {
			String docComment = (String) comments.get(i);
			doc.add(Field.Text(COMMENT, docComment));
		}
	}

	private static void addClass(Document doc, JClass cls) {
		doc.add(Field.Text(CLASS, cls.className));
		String superCls = cls.superClass;
		if (superCls != null)
			doc.add(Field.Text(EXTENDS, superCls));
		ArrayList interfaces = cls.interfaces;
		for (int i = 0; i < interfaces.size(); i++) {
			String interfaceName = (String) interfaces.get(i);
			doc.add(Field.Text(IMPLEMENTS, interfaceName));
		}

		addMethods(cls, doc);
		ArrayList innerCls = cls.innerClasses;
		for (int i = 0; i < innerCls.size(); i++) {
			addClass(doc, (JClass) innerCls.get(i));
		}

	}

	private static void addMethods(JClass cls, Document doc) {
		ArrayList methods = cls.methodDeclarations;
		for (int i = 0; i < methods.size(); i++) {
			JMethod method = (JMethod) methods.get(i);
			doc.add(Field.Text(METHOD, method.methodName));
			doc.add(Field.Text(RETURN, method.returnType));
			ArrayList params = method.parameters;
			for (int k = 0; k < params.size(); k++) {
				String paramType = (String) params.get(k);
				doc.add(Field.Text(PARAMETER, paramType));
			}
			String code = method.codeBlock;
			if (code != null)
				doc.add(Field.UnStored(CODE, code));

		}
	}

}
