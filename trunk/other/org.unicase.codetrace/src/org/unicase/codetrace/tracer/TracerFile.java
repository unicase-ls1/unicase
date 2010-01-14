package org.unicase.codetrace.tracer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TracerFile {

	/********************************************************************************/
	/*										*/
	/* Private storage */
	/*										*/
	/********************************************************************************/

	private String file_name;
	private String[] line_data;
	private long last_modified;
	
	private static Map<String,TracerFile> fileCache = new HashMap<String,TracerFile>();
	

	/********************************************************************************/
	/*										*/
	/* Constructors */
	/*										*/
	/********************************************************************************/

	private TracerFile(File f) {
		try {
			file_name = f.getCanonicalPath();
		} catch (IOException e) {
			file_name = f.getPath();
		}

		line_data = null;
		last_modified = f.lastModified();

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			List<String> ldata = new ArrayList<String>();
			for (;;) {
				String ln = br.readLine();
				if (ln == null)
					break;
				ldata.add(ln);
			}
			br.close();
			line_data = ldata.toArray(new String[ldata.size()]);
		} catch (IOException e) {
			System.err.println("Problem reading file " + f + ": " + e);
		}
		
		fileCache.put(file_name, this);
	}

	/********************************************************************************/
	/*										*/
	/* Access methods */
	/*										*/
	/********************************************************************************/

	boolean isValid() {
		return line_data != null;
	}

	public String getFileName() {
		return file_name;
	}

	public long getLastModified() {
		return last_modified;
	}

	public String getLine(int n) {
		if (n <= 0)
			return null;
		if (n > line_data.length)
			return null;

		return line_data[n - 1];
	}

	public int getLineCount() {
		return line_data.length;
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
