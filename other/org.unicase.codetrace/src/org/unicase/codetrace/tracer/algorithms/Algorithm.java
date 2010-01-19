/********************************************************************************/
/*										*/
/*		LimboFeature.java						*/
/*										*/
/*	Abstract Class defining a potential feature for location information	*/
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

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboFeature.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */

/*********************************************************************************
 *
 * $Log: LimboFeature.java,v $
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

import org.unicase.codetrace.tracer.CodeLocation;
import org.unicase.codetrace.tracer.TracerFacet;
import org.unicase.codetrace.tracer.TracerFile;

public abstract class Algorithm {

	/********************************************************************************/
	/*										*/
	/* Private Storage */
	/*										*/
	/********************************************************************************/

	private String feature_name;

	/********************************************************************************/
	/*										*/
	/* Constructors */
	/*										*/
	/********************************************************************************/

	protected Algorithm(String nm) {
		feature_name = nm;
	}

	/********************************************************************************/
	/*										*/
	/* Access methods */
	/*										*/
	/********************************************************************************/

	String getName() {
		return feature_name;
	}

	/********************************************************************************/
	/*										*/
	/* Facet creation methods */
	/*										*/
	/********************************************************************************/

	public abstract TracerFacet createFacet(TracerFile file, int ln);
	
	public abstract TracerFacet createFacetFromCodeLocation(CodeLocation c);

	/********************************************************************************/
	/*										*/
	/* Helper methods */
	/*										*/
	/********************************************************************************/

	protected static int stringDiff(CharSequence s, CharSequence t) {
		int n = s.length();
		int m = t.length();
		if (n == 0)
			return m;
		if (m == 0)
			return n;

		int[][] d = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++)
			d[i][0] = i;
		for (int j = 0; j <= m; j++)
			d[0][j] = j;

		for (int i = 1; i <= n; ++i) {
			char s_i = s.charAt(i - 1);
			for (int j = 1; j <= m; ++j) {
				char t_j = t.charAt(j - 1);
				int cost = (s_i == t_j ? 0 : 1);
				d[i][j] = min3(d[i - 1][j] + 1, d[i][j - 1] + 1,
						d[i - 1][j - 1] + cost);
			}
		}

		return d[n][m];
	}

	private static int min3(int a, int b, int c) {
		if (b < a)
			a = b;
		if (c < a)
			a = c;
		return a;
	}

	protected static int prefixCount(CharSequence s, CharSequence t,
			boolean cntwhite, boolean ignwhite) {
		int result = 0;

		int si = 0;
		int ti = 0;

		if (ignwhite) {
			while (si < s.length() && Character.isWhitespace(s.charAt(si)))
				++si;
			while (ti < t.length() && Character.isWhitespace(t.charAt(ti)))
				++ti;
		}

		while (si < s.length() && ti < t.length()) {
			int sc = s.charAt(si);
			if (sc != t.charAt(ti))
				break;
			if (cntwhite || !Character.isWhitespace(sc))
				++result;
			++si;
			++ti;
		}

		return result;
	}

	static double smartDiff(CharSequence s, CharSequence t) {
		int n = s.length();
		int m = t.length();
		if (n == 0)
			return m;
		if (m == 0)
			return n;

		double[][] d = new double[n + 1][m + 1];
		for (int i = 0; i <= n; i++)
			d[i][0] = i;
		for (int j = 0; j <= m; j++)
			d[0][j] = j;

		boolean isvalid = false;
		int p = prefixCount(s, t, true, false);
		if (p > 2) {
			boolean haveid = false;
			for (int i = 0; i < p; ++i) {
				char pc = s.charAt(i);
				if (Character.isJavaIdentifierStart(pc))
					haveid = true;
				else if (haveid && (pc == '=' || pc == '('))
					isvalid = true;
			}
		}

		boolean incmmt = false;
		for (int i = 1; i <= n; i++) {
			char s_i = s.charAt(i - 1);
			if (isvalid && s_i == '/' && i >= 2 && s.charAt(i - 2) == '/')
				incmmt = true;
			for (int j = 1; j <= m; j++) {
				char t_j = t.charAt(j - 1);
				double cost = 0;
				if (s_i != t_j) {
					if (incmmt)
						cost = 0.10;
					else if (isvalid)
						cost = 0.15;
					else
						cost = 1.50;
				}
				double ins = 1.0;
				double del = 1.0;
				if (Character.isWhitespace(s_i))
					ins = 0.1;
				if (Character.isWhitespace(t_j))
					del = 0.1;
				d[i][j] = dmin3(d[i - 1][j] + ins, d[i][j - 1] + del,
						d[i - 1][j - 1] + cost);
			}
		}

		return d[n][m];
	}

	private static double dmin3(double a, double b, double c) {
		if (b < a)
			a = b;
		if (c < a)
			a = c;
		return a;
	}

	protected void normalize(Map<Integer, Double> vals) {
		double tot = 0;
		double totsq = 0;
		for (Double d : vals.values()) {
			double v = d.doubleValue();
			if (v > 0) {
				tot += v;
				totsq += v * v;
			}
		}

		if (tot == 0)
			return;

		totsq = Math.sqrt(totsq);
		for (Map.Entry<Integer, Double> ent : vals.entrySet()) {
			double v = ent.getValue();
			if (v > 0)
				ent.setValue(v / totsq);
		}
	}

} // end of class LimboFeature

/* end of LimboFeature.java */

