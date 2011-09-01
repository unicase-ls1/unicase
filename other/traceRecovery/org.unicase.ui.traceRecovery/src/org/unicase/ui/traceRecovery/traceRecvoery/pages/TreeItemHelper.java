/**
 * 
 */
package org.unicase.ui.traceRecovery.traceRecvoery.pages;

import java.io.File;

import org.eclipse.swt.widgets.TreeItem;

/**
 * @author taher
 *helps in setting the parent of tree items for teh directories tree.
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
	/**
	 * constructor that will take the parent and the directory and link them together
	 * @param parent
	 * 			this is the parent of this directory so this is the directory 1 step up
	 * @param dir
	 * 			this is the current directory we are trying to add
	 */
	public TreeItemHelper(TreeItem parent, File dir){
		this.parent = parent;
		this.dir = dir;
	}
	
	

}
