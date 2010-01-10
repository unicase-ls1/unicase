/********************************************************************************/
/*										*/
/*		LimboFeatureFile.java						*/
/*										*/
/*	Abstract class that keeps copies of old files				*/
/*										*/
/********************************************************************************/
/*	Copyright 2007 Brown University -- Steven P. Reiss		      */
/*********************************************************************************
 *  Copyright 2007, Brown University, Providence, RI.				 *
 *										 *
 *			  All Rights Reserved					 *
 *										 *
 *  Permission to use, copy, modify, and distribute this software and its	 *
 *  documentation for any purpose other than its incorporation into a		 *
 *  commercial product is hereby granted without fee, provided that the 	 *
 *  above copyright notice appear in all copies and that both that		 *
 *  copyright notice and this permission notice appear in supporting		 *
 *  documentation, and that the name of Brown University not be used in 	 *
 *  advertising or publicity pertaining to distribution of the software 	 *
 *  without specific, written prior permission. 				 *
 *										 *
 *  BROWN UNIVERSITY DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS		 *
 *  SOFTWARE, INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND		 *
 *  FITNESS FOR ANY PARTICULAR PURPOSE.  IN NO EVENT SHALL BROWN UNIVERSITY	 *
 *  BE LIABLE FOR ANY SPECIAL, INDIRECT OR CONSEQUENTIAL DAMAGES OR ANY 	 *
 *  DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,		 *
 *  WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS		 *
 *  ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE 	 *
 *  OF THIS SOFTWARE.								 *
 *										 *
 ********************************************************************************/

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboFeatureFile.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */


/*********************************************************************************
 *
 * $Log: LimboFeatureFile.java,v $
 * Revision 1.1  2007-11-06 00:56:30  spr
 * Add limbo test files for line number checking.
 *
 * Revision 1.1  2007-08-10 23:51:20  spr
 * Add line number tracking code.
 *
 *
 ********************************************************************************/



package org.unicase.codetrace.tracer.algorithms;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.unicase.codetrace.tracer.TracerFile;


public abstract class AlgorithmFile extends Algorithm {



/********************************************************************************/
/*										*/
/*	Private Storage 							*/
/*										*/
/********************************************************************************/

private Map<String,Map<Long,String>>	file_map;



/********************************************************************************/
/*										*/
/*	Constructors								*/
/*										*/
/********************************************************************************/

protected AlgorithmFile(String name)
{
   super(name);

   file_map = new HashMap<String,Map<Long,String>>();
}



/********************************************************************************/
/*										*/
/*	File management code							*/
/*										*/
/********************************************************************************/

protected String getFileName(TracerFile lf)
{
   String f = getFileName(lf.getFileName(),lf.getLastModified());
   if (f == null) f = saveFile(lf.getFileName(),lf.getLastModified());
   return f;
}



protected String getFileName(String f,long dlm)
{
   Map<Long,String> m = file_map.get(f);
   if (m == null) return null;
   return m.get(dlm);
}



protected String saveFile(String file,long dlm)
{
   Map<Long,String> m = file_map.get(file);
   if (m == null) {
      m = new HashMap<Long,String>();
      file_map.put(file,m);
    }
   String f = m.get(dlm);
   if (f == null) {
      try {
	 File nf = File.createTempFile("LIMBO","."+dlm);
	 f = nf.getPath();
	 m.put(dlm,f);
	 nf.deleteOnExit();
	 BufferedReader fr = new BufferedReader(new FileReader(file));
	 PrintWriter pw = new PrintWriter(new FileWriter(nf));
	 for ( ; ; ) {
	    String ln = fr.readLine();
	    if (ln == null) break;
	    pw.println(ln);
	  }
	 fr.close();
	 pw.close();
       }
      catch (IOException e) {
	 System.err.println("LIMBO: Problem copying file for diff: " + e);
       }
    }

   return f;
}



}	// end of class LimboFeatureFile




/* end of LimboFeatureFile.java */

