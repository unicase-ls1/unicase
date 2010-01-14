/********************************************************************************/
/*										*/
/*		LimboFactory.java						*/
/*										*/
/*	Factory class for locations						*/
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

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboFactory.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */


/*********************************************************************************
 *
 * $Log: LimboFactory.java,v $
 * Revision 1.1  2007-11-06 00:56:30  spr
 * Add limbo test files for line number checking.
 *
 * Revision 1.1  2007-08-10 23:51:20  spr
 * Add line number tracking code.
 *
 *
 ********************************************************************************/



package org.unicase.codetrace.tracer;



import java.io.*;
import java.util.*;

import org.unicase.codetrace.tracer.algorithms.Algorithm;
import org.unicase.codetrace.tracer.algorithms.AlgorithmBestMatch;
import org.unicase.codetrace.tracer.algorithms.AlgorithmLineContext;



public class TracerFactory {



/********************************************************************************/
/*										*/
/*	Local storage								*/
/*										*/
/********************************************************************************/

private List<String> class_path;
private List<String> boot_path;
private List<String> source_path;

private Map<Algorithm,Double> feature_set;
private double threshold_value;

private static TracerFactory theInstance;


private static Map<File,int []> line_map = new HashMap<File,int []>();
private static Map<File,TracerFile> file_data = new HashMap<File,TracerFile>();



/********************************************************************************/
/*										*/
/*	Constructors								*/
/*										*/
/********************************************************************************/

private TracerFactory()
{
   feature_set = new HashMap<Algorithm,Double>();
   threshold_value = -1;

   class_path = new ArrayList<String>();
   addToPath(class_path,System.getProperty("java.class.path"));
   source_path = new ArrayList<String>();
   addToPath(source_path,System.getenv("SOURCEPATH"));
}

public static TracerFactory getInstance(){
	if(theInstance==null){
		theInstance = new TracerFactory();
		theInstance.addAlgorithm(new AlgorithmLineContext(4,0.35,false),0.4);
		theInstance.addAlgorithm(new AlgorithmBestMatch(1,0.5,true),0.6);
	}
	return theInstance;
}




/********************************************************************************/
/*										*/
/*	Setup methods								*/
/*										*/
/********************************************************************************/

void addAlgorithm(Algorithm a,double v)
{
   feature_set.put(a,v);
}



void removeAlgorithm(Algorithm a)
{
   feature_set.remove(a);
}



void setThreshold(double v)			{ threshold_value = v; }



/********************************************************************************/
/*										*/
/*	Path setting methods							*/
/*										*/
/********************************************************************************/

public void setClassPath(String cp)
{
   class_path.clear();
   addToPath(class_path,cp);
}

public void addToClassPath(String cp)
{
   addToPath(class_path,cp);
}


public void setBootPath(String bp)
{
   boot_path.clear();
   addToPath(boot_path,bp);
}

public void addToBootPath(String bp)
{
   addToPath(boot_path,bp);
}


public void setSourcePath(String sp)
{
   source_path.clear();
   addToPath(source_path,sp);
}

public void addToSourcePath(String sp)
{
   addToPath(source_path,sp);
}



private void addToPath(List<String> p,String s)
{
   if (s == null) return;

   for (StringTokenizer tok = new StringTokenizer(s,File.pathSeparator); tok.hasMoreTokens(); ) {
      String t = tok.nextToken();
      p.add(t);
    }
}






/********************************************************************************/
/*										*/
/*	Location Creation methods						*/
/*										*/
/********************************************************************************/

public TracerLocation createLocation(String projectName, String pathInProject,int line)
{
   if (projectName == null || pathInProject == null || line < 0) return null;
   TracerFile lf = TracerFile.getFileByName(EclipseWorkspaceManager.getPathOfFile(projectName, pathInProject));
   if (lf == null) return null;

   TracerLocation shape = new TracerLocation(projectName,pathInProject);
   for (Map.Entry<Algorithm,Double> ent : feature_set.entrySet()) {
	   Algorithm alg = ent.getKey();
      double v = ent.getValue();
      TracerFacet f = alg.createFacet(lf,line);
      shape.addFacet(f,v);
    }

   if (threshold_value >= 0) shape.setThreshold(threshold_value);

   return shape;
}




/********************************************************************************/
/*										*/
/*	Line number methods							*/
/*										*/
/********************************************************************************/

static int getOffset(String fnm,int ln,int ch)
{
   File f = new File(fnm);
   int fln = (int) f.length();

   int [] lmap = getLineMap(f);
   if (lmap == null) return -1;
   if (ln <= 0) return 0;
   if (ln-1 >= lmap.length) return fln;

   int off = lmap[ln-1];
   if (ch <= 0) return off;

   int lln = 0;
   if (ln >= lmap.length) lln = fln - off;
   else lln = lmap[ln]-off;
   if (lln > 0) {
      if (ch-1 >= lln) off += lln-1;
      else off += ch-1;
    }
   return off;
}




private static int [] getLineMap(File f)
{
   if (f == null || !f.exists() || !f.canRead()) return null;

   int [] r = line_map.get(f);
   if (r != null) return r;

   List<Integer> rl = new ArrayList<Integer>();

   try {
      int pos = 0;
      BufferedReader br = new BufferedReader(new FileReader(f));
      rl.add(0);
      for ( ; ; ) {
	 int ch = br.read();
	 if (ch < 0) break;
	 ++pos;
	 if (ch == '\n') rl.add(pos);
       }
      rl.add(pos);
      br.close();
    }
   catch (IOException e) {
      System.err.println("Problem reading file: " + e);
      return null;
    }

   r = new int[rl.size()];
   for (int i = 0; i < r.length; ++i) r[i] = rl.get(i);
   line_map.put(f,r);

   return r;
}




}



