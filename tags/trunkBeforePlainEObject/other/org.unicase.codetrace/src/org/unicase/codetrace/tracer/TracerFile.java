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


	/**
	 * File name.
	 */
	private String fileName;
	
	/**
	 * Content.
	 */
	private String[] lineData;
	
	/**
	 * Modification date.
	 */
	private long lastModified;
	
	/**
	 * The last files are cached for speed enhancement.
	 */
	private static Map<String,TracerFile> fileCache = new HashMap<String,TracerFile>();

	/**
	 * Private constructor, instances are created by static factory method instead.
	 * @param f the file for which to create the tracer file.
	 */
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
		}
		
		fileCache.put(fileName, this);
	}


	/**
	 * Is this instance still valid?
	 * @return validity
	 */
	boolean isValid() {
		return lineData != null;
	}

	/**
	 * The file name.
	 * @return file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Last modification date.
	 * @return last modification date
	 */
	public long getLastModified() {
		return lastModified;
	}

	/**
	 * Gets the content of a line.
	 * @param n line number
	 * @return  the line content or null if the line doesn't exist.
	 */
	public String getLine(int n) {
		if (n <= 0) {
			return null;
		}
		if (n > lineData.length) {
			return null;
		}

		return lineData[n - 1];
	}

	/**
	 * Returns the number of lines in this file.
	 * @return number of lines.
	 */
	public int getLineCount() {
		return lineData.length;
	}
	
	/**
	 * Returns a tracer file for a given file name / path.
	 * @param name the path of the file
	 * @return the file, or null if it doesn't exist
	 */
	public static TracerFile getFileByName(String name){
		File f = new File(name);
		String fileName;
		try {
			fileName = f.getCanonicalPath();
		} catch (IOException e) {
			fileName = f.getPath();
		}
		
		//Does the file exist and is a file
		if(!f.exists()||f.isDirectory()) {
			return null;
		}
		
		//File in cache?
		if(fileCache.containsKey(fileName)){
			TracerFile tf = fileCache.get(fileName);
			
			//Cached and cache is still valid
			if(tf.getLastModified()>= f.lastModified()) {
				return tf;
			}
			
			//Cache invalid, overwrite!
			return new TracerFile(f);
			
		}
		
		//File not in cache, create new one
		return new TracerFile(f);
	}

}
