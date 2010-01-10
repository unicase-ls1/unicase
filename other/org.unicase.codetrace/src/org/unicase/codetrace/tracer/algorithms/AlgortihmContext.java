/********************************************************************************/
/*										*/
/*		LimboFeatureBestContext.java					*/
/*										*/
/*	Find best match using context information for areas			*/
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

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboFeatureBestContext.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */


/*********************************************************************************
 *
 * $Log: LimboFeatureBestContext.java,v $
 * Revision 1.1  2007-11-06 00:56:30  spr
 * Add limbo test files for line number checking.
 *
 * Revision 1.1  2007-08-10 23:51:20  spr
 * Add line number tracking code.
 *
 *
 ********************************************************************************/



package org.unicase.codetrace.tracer.algorithms;


import java.util.Map;
import java.util.TreeMap;

import org.unicase.codetrace.tracer.TracerFacet;
import org.unicase.codetrace.tracer.TracerFile;



public class AlgortihmContext extends Algorithm {



/********************************************************************************/
/*										*/
/*	Private Storage 							*/
/*										*/
/********************************************************************************/

private int	context_size;
private double	threshold_value;
private boolean ignore_space;



/********************************************************************************/
/*										*/
/*	Constructors								*/
/*										*/
/********************************************************************************/

AlgortihmContext()
{
   this(5,0.25,true);
}



AlgortihmContext(int size,double thresh,boolean ignsp)
{
   super("BestContext_" + size + "_" + thresh + "_" + ignsp);

   context_size = size;
   threshold_value = thresh;
   ignore_space = ignsp;
}



/********************************************************************************/
/*										*/
/*	Methods to create a facet						*/
/*										*/
/********************************************************************************/

public TracerFacet createFacet(TracerFile f,int ln)
{
   return new Facet(f,ln);
}





/********************************************************************************/
/*										*/
/*	Class to hold facet							*/
/*										*/
/********************************************************************************/

private class Facet implements TracerFacet {

   private String pre_context;
   private String post_context;

   Facet(TracerFile f,int ln) {
      resetLine(f,ln);
    }

   public Algorithm getAlgorithm()		{ return AlgortihmContext.this; }

   public Map<Integer,Double> getLines(TracerFile lf) {
      Map<Integer,Double> r = new TreeMap<Integer,Double>();
      int ct = lf.getLineCount();
      for (int i = 1; i <= ct; ++i) {
	 String pre = preContext(lf,i);
	 String post = postContext(lf,i);
	 double delta = 0;
	 int prelen = pre.length();
	 if (prelen > 0) delta += stringDiff(pre,pre_context);
	 int postlen = post.length();
	 if (postlen > 0) delta += stringDiff(post,post_context);
	 if (prelen + postlen == 0) continue;
	 double v = (prelen + postlen - delta)/(prelen + postlen);
	 if (v <= threshold_value) continue;
	 r.put(i,v);
       }
      return r;
    }

   public void resetLine(TracerFile lf,int ln) {
      pre_context = preContext(lf,ln);
      post_context = postContext(lf,ln);
    }

   private String preContext(TracerFile lf,int ln) {
      StringBuffer buf = new StringBuffer();
      for (int i = 0; i < context_size; ++i) {
	 String d = lf.getLine(ln-i-1);
	 if (d == null) break;
	 if (ignore_space) d = d.trim();
	 buf.append("\n");
	 buf.append(d);
       }
      return buf.toString();
    }

   private String postContext(TracerFile lf,int ln) {
      StringBuffer buf = new StringBuffer();
      for (int i = 0; i < context_size; ++i) {
	 String d = lf.getLine(ln+i+1);
	 if (d == null) break;
	 if (ignore_space) d = d.trim();
	 buf.append("\n");
	 buf.append(d);
       }
      return buf.toString();
    }

}	// end of subclass Facet





}	// end of class LimboFeatureBestContext





/* end of LimboFeatureBestContext.java */
