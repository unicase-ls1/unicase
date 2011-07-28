/**
 * 
 */
package traceability.fortran;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.photran.internal.core.SyntaxException;
import org.eclipse.photran.internal.core.analysis.binding.ScopingNode;
import org.eclipse.photran.internal.core.lexer.ASTLexerFactory;
import org.eclipse.photran.internal.core.lexer.LexerException;
import org.eclipse.photran.internal.core.lexer.sourceform.UnpreprocessedFreeSourceForm;
import org.eclipse.photran.internal.core.parser.ASTExecutableProgramNode;
import org.eclipse.photran.internal.core.parser.Parser;




/**
 * @author liya
 *
 */
public class FortranSourceCodeParser {
//	   private IAccumulatingLexer              lexer;
//	   private Parser		parser;
	   private File f;
	
	public FortranSourceCodeParser(File f){
			this.f = f;
//			try {
//				lexer = new ASTLexerFactory().createLexer(new StringReader(null), null, filename);
//				parser = new Parser();
//	            
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}

	public void parse(){
		
		
	}
			
	public ArrayList getSubroutines(){
		
//		FortranAST ast = new FortranAST(null, parser.parse(lexer), lexer.getTokenList());
//		List<Definition> defs = ast.getRoot().getAllDefinitions();
//		ast.getRoot();
		ArrayList<ScopingNode> subroutines = new ArrayList<ScopingNode>();
//        PhotranVPG vpg = PhotranVPG.getInstance();
//        IFortranAST ast = vpg.acquireTransientAST((IFile)ResourcesPlugin.getWorkspace().getRoot().findMember(fileName));
//        List<ScopingNode> scopes = ast.getRoot().getAllContainedScopes();
//        Iterator<ScopingNode> iterator = scopes.iterator();
//        while(iterator.hasNext()){
//        	ScopingNode node = iterator.next();
//			if(node.isSubprogram()){
//        		subroutines.add(node);
//        	}
//        }
        try {
			ASTExecutableProgramNode ast = new Parser().parse(new ASTLexerFactory().createLexer(f, new UnpreprocessedFreeSourceForm()));
			List<ScopingNode> scopes = ast.getAllContainedScopes();
			Iterator<ScopingNode> iterator = scopes.iterator();
	        while(iterator.hasNext()){
	        	ScopingNode node = iterator.next();
				if(node.isSubprogram()){
	        		subroutines.add(node);
	        	}
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LexerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subroutines;
	}


	public ArrayList <String> getComments(){
//		IASTTranslationUnit unit =  new Parser().parse();
//		NodeCommentMap commentMap = ASTCommenter.getCommentedNodeMap(unit);	
		ArrayList <String> comments = new ArrayList  <String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			FixedFormLexerPrepass prepass = new FixedFormLexerPrepass(reader);
//			prepass.read();
			prepass.readComments();
			comments = prepass.getComments();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comments;
	}

}
