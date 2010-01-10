/********************************************************************************/
/*										*/
/*		LimboFeatureAreaContext.java					*/
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

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboFeatureAreaContext.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */


/*********************************************************************************
 *
 * $Log: LimboFeatureAreaContext.java,v $
 * Revision 1.1  2007-11-06 00:56:30  spr
 * Add limbo test files for line number checking.
 *
 * Revision 1.1  2007-08-10 23:51:20  spr
 * Add line number tracking code.
 *
 *
 ********************************************************************************/



package org.unicase.codetrace.tracer.algorithms;


import java.util.*;

import org.unicase.codetrace.tracer.TracerFacet;
import org.unicase.codetrace.tracer.TracerFile;



public class AlgorithmAreaContext extends Algorithm {



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

AlgorithmAreaContext(int size,double thresh,boolean ignsp)
{
   super("AreaContext_" + size + "_" + thresh + "_" + ignsp);

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

   private int [] prior_hash;
   private int [] post_hash;
   private BitSet hash_used;

   Facet(TracerFile f,int ln) {
      resetLine(f,ln);
      hash_used = new BitSet(context_size);
    }

   public Algorithm getAlgorithm()		{ return AlgorithmAreaContext.this; }

   public Map<Integer,Double> getLines(TracerFile lf) {
      Map<Integer,Double> r = new TreeMap<Integer,Double>();
      int ct = lf.getLineCount();
      int pct = prior_hash.length;
      int qct = post_hash.length;
      for (int i = 1; i <= ct; ++i) {
	 double tot = 0;
	 for (int j = 0; j < pct; ++j) tot += 1.0/(j+1);
	 for (int j = 0; j < qct; ++j) tot += 1.0/(j+1);

	 double npre = 0;
	 hash_used.clear();
	 for (int j = 0; j < pct; ++j) {
	    String d = lf.getLine(i-j-1);
	    if (d == null) continue;
	    if (ignore_space) d = d.trim();
	    for (int k = 0; k < pct; ++k) {
	       if (!hash_used.get(k) && prior_hash[k] == d.hashCode()) {
		  npre += 1.0/(j+1);
		  hash_used.set(k);
		  break;
		}
	     }
	  }
	 double npost = 0;
	 hash_used.clear();
	 for (int j = 0; j < qct; ++j) {
	    String d = lf.getLine(i+j+1);
	    if (d == null) continue;
	    if (ignore_space) d = d.trim();
	    for (int k = 0; k < qct; ++k) {
	       if (!hash_used.get(k) && post_hash[k] == d.hashCode()) {
		  npost += 1.0/(j+1);
		  hash_used.set(k);
		  break;
		}
	     }
	  }
	 if (qct == 0 && pct == 0) continue;
	 double v = (npre + npost) / (tot);
	 if (v >= threshold_value) r.put(i,v);
       }
      return r;
    }

   public void resetLine(TracerFile lf,int ln) {
      int pct = (ln - context_size > 1 ? context_size : ln-1);
      prior_hash = new int[pct];
      for (int i = 0; i < pct; ++i) {
	 String d = lf.getLine(ln-pct+i);
	 if (ignore_space) d = d.trim();
	 prior_hash[i] = d.hashCode();
       }
      int fct = lf.getLineCount();
      pct = (fct - ln > context_size ? context_size : fct-ln);
      post_hash = new int[pct];
      for (int i = 0; i < pct; ++i) {
	 String d = lf.getLine(ln+i+1);
	 if (ignore_space) d = d.trim();
	 post_hash[i] = d.hashCode();
       }
    }

}	// end of subclass Facet





}	// end of class LimboFeatureAreaContext





/* end of LimboFeatureAreaContext.java */
