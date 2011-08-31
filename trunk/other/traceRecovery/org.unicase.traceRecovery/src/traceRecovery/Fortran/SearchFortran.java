/**
 * 
 */
package traceRecovery.Fortran;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.photran.internal.core.analysis.binding.ScopingNode;
import org.unicase.model.trace.CodeLocation;
import org.unicase.model.trace.TraceFactory;

import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;
import traceRecovery.handler.Search;

/**
 * @author taher
 * 
 */
public class SearchFortran extends Search {

	public SearchFortran() {
//		super("fortran");
	}

	boolean isDir = false;

	Query q;

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
		if (!isDir) {
			q = TraceRecoveryFactory.eINSTANCE.createQuery();
		}

		for (int i = 0; i < file.size(); i++) {
			if (file.get(i).isDirectory()) {
				createQueryCodeDir(file.get(i), type);
			}
			if (file.get(i).getName().endsWith("f90")
					|| file.get(i).getName().endsWith("f95")
					|| file.get(i).getName().endsWith("for")) {

				FortranSourceCodeParser parser = new FortranSourceCodeParser(
						file.get(i));
				ArrayList<ScopingNode> subroutines = parser.getSubroutines();
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
					loc.setDescription((subroutines.get(i)).getName(true));
					loc.setName(name);
					q.getModelElements().add(loc);

				}
			}
		}
		isDir = false;
		return q;
	}

}
