/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.tracer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The representation of a file and its content.
 * The content is stored as an array of lines. This representation is used to speed up the
 * creation and finding of CodeLocations. The class maintains a fileCache to store often used
 * files.
 * @author jfinis
 *
 */
public final class TracerFile {

	/********************************************************************************/
	/*										*/
	/* Private storage */
	/*										*/
	/********************************************************************************/

	private String fileName;
	private String[] lineData;
	private long lastModified;
	
	private static Map<String,TracerFile> fileCache = new HashMap<String,TracerFile>();
	

	/********************************************************************************/
	/*										*/
	/* Constructors */
	/*										*/
	/********************************************************************************/

	private TracerFile(File f) {
		try {
			fileName = f.getCanonicalPath();
		} catch (IOException e) {
			fileName = f.getPath();
		}

		lineData = null;
		lastModified = f.lastModified();

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			List<String> ldata = new ArrayList<String>();
			for (;;) {
				String ln = br.readLine();
				if (ln == null) {
					break;
				}
				ldata.add(ln);
			}
			br.close();
			lineData = ldata.toArray(new String[ldata.size()]);
		} catch (IOException e) {
			System.err.println("Problem reading file " + f + ": " + e);
		}
		
		fileCache.put(fileName, this);
	}

	/********************************************************************************/
	/*										*/
	/* Access methods */
	/*										*/
	/********************************************************************************/

	boolean isValid() {
		return lineData != null;
	}

	public String getFileName() {
		return fileName;
	}

	public long getLastModified() {
		return lastModified;
	}

	public String getLine(int n) {
		if (n <= 0)
			return null;
		if (n > lineData.length)
			return null;

		return lineData[n - 1];
	}

	public int getLineCount() {
		return lineData.length;
	}
	
	public static TracerFile getFileByName(String name){
		File f = new File(name);
		String fileName;
		try {
			fileName = f.getCanonicalPath();
		} catch (IOException e) {
			fileName = f.getPath();
		}
		
		//File in cache?
		if(fileCache.containsKey(fileName)){
			TracerFile tf = fileCache.get(fileName);
			
			//Cached and cache is still valid
			if(tf.getLastModified()>= f.lastModified()) return tf;
			
			//Cache invalid, overwrite!
			return new TracerFile(f);
			
		}
		
		//File not in cache, create new one
		return new TracerFile(f);
	}

}
