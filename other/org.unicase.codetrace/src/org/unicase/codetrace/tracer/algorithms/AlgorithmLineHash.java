/********************************************************************************/
/*										*/
/*		LimboFeatureLineHash.java					*/
/*										*/
/*	Hash code of a line as a feature for that line				*/
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

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboFeatureLineHash.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */

/*********************************************************************************
 *
 * $Log: LimboFeatureLineHash.java,v $
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

import org.unicase.codetrace.tracer.CodeLocation;
import org.unicase.codetrace.tracer.TracerFacet;
import org.unicase.codetrace.tracer.TracerFile;

public class AlgorithmLineHash extends Algorithm {

	/********************************************************************************/
	/*										*/
	/* Private Storage */
	/*										*/
	/********************************************************************************/

	private boolean ignore_space;

	/********************************************************************************/
	/*										*/
	/* Constructors */
	/*										*/
	/********************************************************************************/

	AlgorithmLineHash(boolean ignsp) {
		super("LineHash" + "_" + ignsp);

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

		private int line_hash;

		Facet(TracerFile f, int ln) {
			resetLine(f, ln);
		}

		public Algorithm getAlgorithm() {
			return AlgorithmLineHash.this;
		}

		public Map<Integer, Double> getLines(TracerFile lf) {
			Map<Integer, Double> r = new TreeMap<Integer, Double>();
			int ct = lf.getLineCount();
			int fnd = 0;
			for (int i = 1; i <= ct; ++i) {
				String d = lf.getLine(i);
				if (ignore_space)
					d = d.trim();
				if (d.hashCode() == line_hash) {
					++fnd;
					r.put(i, 1.0);
				}
			}
			if (fnd == 0)
				return null;
			return r;
		}

		public void resetLine(TracerFile lf, int ln) {
			String d = lf.getLine(ln);
			if (ignore_space)
				d = d.trim();
			line_hash = d.hashCode();
		}

		@Override
		public void addToCodeLocation(CodeLocation c) {
			// TODO Auto-generated method stub

		}

	} // end of subclass Facet

	@Override
	public TracerFacet createFacetFromCodeLocation(CodeLocation c) {
		// TODO Auto-generated method stub
		return null;
	}

} // end of class LimboFeatureLineHash

/* end of LimboFeatureLineHash.java */
