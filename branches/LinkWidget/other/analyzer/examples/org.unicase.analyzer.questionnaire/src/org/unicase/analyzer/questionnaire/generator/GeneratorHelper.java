/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer.questionnaire.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author liya
 *
 */
public class GeneratorHelper {

	public static void copyfile(String srFile, String dtFile){
	    try{
	        File f1 = new File(srFile);
	        File f2 = new File(dtFile);
	        InputStream in = new FileInputStream(f1);
	        
	        //For Append the file.
//	        OutputStream out = new FileOutputStream(f2,true);

	        //For Overwrite the file.
	        OutputStream out = new FileOutputStream(f2);

	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0){
	          out.write(buf, 0, len);
	        }
	        in.close();
	        out.close();
	        System.out.println("File copied.");
	      }
	      catch(FileNotFoundException ex){
	        System.out.println(ex.getMessage() + " in the specified directory.");
	      }
	      catch(IOException e){
	        System.out.println(e.getMessage());      
	      }
	    }
}
