/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.views.listeners;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.unicase.xmi.exceptions.XMIFileTypeException;

/**
 * Thread that is run when a folder's files are processed
 * in the search for loadable projects.
 * @author matti, markus
 *
 */
public class ProgressMonitorThread implements IRunnableWithProgress {

	private final String dirPath;
	private final List<String> loadableProcessedFiles;

	/**
	 * Creates a new thread that is trying to load projects from a folder.
	 * @param dirPath Folder that it's trying to load.
	 * @param loadableProcessedFiles List where the loadable files are saved in.
	 */
	public ProgressMonitorThread(String dirPath, List<String> loadableProcessedFiles) {
				this.dirPath = dirPath;
				this.loadableProcessedFiles = loadableProcessedFiles;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		// open up the path
		File dir = new File(dirPath);
		ResourceSet resourceSet = new ResourceSetImpl();
		
		if(dir.isDirectory()) {
			// open directory
			File[] files = dir.listFiles();
			int numFiles = files.length;
			
			monitor.beginTask("Loading files", numFiles);
			
			// Go through all files of the directory and try to load them
			for(File f: files) {
				String fullPath = f.getAbsolutePath();
				
				try {
					resourceSet.getResource(URI.createFileURI(fullPath), true);
					loadableProcessedFiles.add(fullPath); // adding to list
				}
				catch(WrappedException e) {
					// ignore -> it's simply not loadable
				}
				monitor.worked(1);
			}
		}
		else {
			new XMIFileTypeException(dirPath + " is not a directory.");
		}
		monitor.done();
	}

}
