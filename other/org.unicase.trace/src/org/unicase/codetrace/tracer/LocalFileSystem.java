package org.unicase.codetrace.tracer;

import org.eclipse.core.filesystem.provider.FileInfo;
import org.eclipse.core.filesystem.provider.FileSystem;
import org.eclipse.core.filesystem.provider.FileTree;
import org.eclipse.core.internal.filesystem.InternalFileSystemCore;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;

public class LocalFileSystem extends FileTree {
	
	public LocalFileSystem(IFileStore treeRoot) {
		super(treeRoot);
		IWorkspace root = ResourcesPlugin.getWorkspace();
	    IProject[] projects = root.getRoot().getProjects();
	    IFileSystem fs = EFS.getLocalFileSystem();
	    String value = "/Test/src/snippet";
		IPath path = new Path(value);
		IFileStore rootStore = fs.getStore(path);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public IFileInfo[] getChildInfos(IFileStore store) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IFileStore[] getChildStores(IFileStore store) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IFileInfo getFileInfo(IFileStore store) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
