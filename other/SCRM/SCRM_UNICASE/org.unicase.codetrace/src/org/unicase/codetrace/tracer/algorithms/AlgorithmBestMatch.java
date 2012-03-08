/********************************************************************************/
/*										*/
/*		LimboFeatureBestMatch.java					*/
/*										*/
/*	Find best match for given line						*/
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

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboFeatureBestMatch.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */

/*********************************************************************************
 *
 * $Log: LimboFeatureBestMatch.java,v $
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
import org.unicase.model.trace.CodeLocation;

public class AlgorithmBestMatch extends Algorithm {

	/********************************************************************************/
	/*										*/
	/* Private Storage */
	/*										*/
	/********************************************************************************/

	private double scale_factor;
	private double threshold_value;
	private boolean ignore_space;

	/********************************************************************************/
	/*										*/
	/* Constructors */
	/*										*/
	/********************************************************************************/

	public AlgorithmBestMatch(double scale, double thresh, boolean ignsp) {
		super("BestMatch_" + scale + "_" + thresh + "_" + ignsp);

		scale_factor = scale;
		threshold_value = thresh;
		ignore_space = ignsp;
	}

	/********************************************************************************/
	/*										*/
	/* Methods to create a facet */
	/*										*/
	/********************************************************************************/

	public TracerFacet createFacet(TracerFile f, int ln) {
		return new Facet(f, ln);
	}

	/********************************************************************************/
	/*										*/
	/* Class to hold facet */
	/*										*/
	/********************************************************************************/

	private class Facet implements TracerFacet {

		private String orig_line;

		Facet(TracerFile f, int ln) {
			resetLine(f, ln);
		}

		Facet(CodeLocation c) {
			orig_line = c.getLineContent();
		}

		public Algorithm getAlgorithm() {
			return AlgorithmBestMatch.this;
		}

		public Map<Integer, Double> getLines(TracerFile lf) {
			Map<Integer, Double> r = new TreeMap<Integer, Double>();
			int ct = lf.getLineCount();
			int dln = orig_line.length();
			for (int i = 1; i <= ct; ++i) {
				String d = lf.getLine(i);
				if (ignore_space)
					d = d.trim();
				if (dln > 0) {
					double delta = stringDiff(d, orig_line);
					double v = (dln - delta) / dln;
					if (v <= threshold_value)
						continue;
					if (scale_factor != 1.0)
						v = Math.pow(v, scale_factor);
					r.put(i, v);
				}
			}
			return r;
		}

		public void resetLine(TracerFile lf, int ln) {
			orig_line = lf.getLine(ln);
			if (ignore_space && orig_line != null)
				orig_line = orig_line.trim();
		}

		public void addToCodeLocation(CodeLocation c) {
			c.setLineContent(orig_line);
		}

	} // end of subclass Facet

	
	public TracerFacet createFacetFromCodeLocation(CodeLocation c) {
		return new Facet(c);
	}

} // end of class LimboFeatureBestMatch

/* end of LimboFeatureBestMatch.java */

