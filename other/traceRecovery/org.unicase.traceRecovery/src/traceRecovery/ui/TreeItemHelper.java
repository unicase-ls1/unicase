/**
 * 
 */
package traceRecovery.ui;

import java.io.File;
import java.util.Queue;

import org.eclipse.swt.widgets.TreeItem;

/**
 * @author taher
 *
 */
public class TreeItemHelper {
	TreeItem parent;
	/**
	 * @return the parent
	 */
	public TreeItem getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeItem parent) {
		this.parent = parent;
	}

	/**
	 * @return the dir
	 */
	public File getDir() {
		return dir;
	}

	/**
	 * @param dir the dir to set
	 */
	public void setDir(File dir) {
		this.dir = dir;
	}

	File dir;
	
	public TreeItemHelper(TreeItem parent, File dir){
		this.parent = parent;
		this.dir = dir;
	}
	
	

}
