/**
 * 
 */
package traceRecovery.handler;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.photran.internal.core.analysis.binding.ScopingNode;

import traceability.fortran.FortranSourceCodeParser;
import traceRecovery.Java.JavaParser;
import traceRecovery.Java.JavaParser.JMethod;

/**
 * @author taher
 * 
 */
public class SearchHelp {
	String path;

	public SearchHelp(String path) {
		this.path = path;
	}

	public ArrayList<String> getComments() {
		JavaParser parser = new JavaParser();
		parser.setSource(new File(path));
		return parser.getComments();

	}
	
	public String getClassName(){
		JavaParser parser = new JavaParser();
		parser.setSource(new File(path));
		return parser.getDeclaredClass().className;
	}
	
	public ArrayList<String> getCommentsF(){
		FortranSourceCodeParser parser = new  FortranSourceCodeParser(new File(path));
		return parser.getComments();
	}
	
	public ArrayList <ScopingNode> getSubroutines(){
		FortranSourceCodeParser parser = new FortranSourceCodeParser(new File(path));
		return parser.getSubroutines();
	}
	
	public ArrayList<String> getMethods()
	{
		JavaParser parser = new JavaParser();
		parser.setSource(new File(path));
		
		 ArrayList <JMethod> method = parser.getDeclaredClass().methodDeclarations;
		 ArrayList<String> name = new ArrayList<String>();
		 
		 for(int i =0 ; i< method.size() ; i++){
			 name.add(method.get(i).methodName);
		 }
		 
		 return name;
		
	}

}