/********************************************************************************/
/*										*/
/*		LimboShape.java 						*/
/*										*/
/*	Collection of facets that represents a location 			*/
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

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboShape.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */

/*********************************************************************************
 *
 * $Log: LimboShape.java,v $
 * Revision 1.1  2007-11-06 00:56:30  spr
 * Add limbo test files for line number checking.
 *
 * Revision 1.1  2007-08-10 23:51:20  spr
 * Add line number tracking code.
 *
 *
 ********************************************************************************/

package org.unicase.codetrace.tracer;

import java.util.*;

public class TracerLocation {

	/********************************************************************************/
	/*										*/
	/* Private Storage */
	/*										*/
	/********************************************************************************/

	private Map<TracerFacet, Double> facet_values;
	private boolean isValid;
	private int sourceLine;
	private String projectName;
	private String pathInProject;
	private double thresholdValue;
	

	public String getProjectName() {
		return projectName;
	}

	public String getPathInProject() {
		return pathInProject;
	}

	/********************************************************************************/
	/*										*/
	/* Constructors */
	/*										*/
	/********************************************************************************/

	TracerLocation(String projectName, String pathInProject) {
		facet_values = new HashMap<TracerFacet, Double>();
		this.pathInProject = pathInProject;
		this.projectName = projectName;
		sourceLine = -1;
		isValid = false;
		thresholdValue = 0.35;
	}

	/********************************************************************************/
	/*										*/
	/* Setup methods */
	/*										*/
	/********************************************************************************/

	void addFacet(TracerFacet tf, double v) {
		if (v > 1)
			v = 1;
		if (tf == null)
			return;

		facet_values.put(tf, v);
		isValid = false;
	}

	/*
	void revalidate(String file) {
		isValid = false;
		sourceFile = file;
	}*/

	void setThreshold(double v) {
		thresholdValue = v;
	}

	double getThreshold() {
		return thresholdValue;
	}

	/********************************************************************************/
	/*										*/
	/* Access methods */
	/*										*/
	/********************************************************************************/

	/*
	protected String getSourceFile() {
		validate();
		if (!isValid)
			return null;

		return sourceFile;
	}
	*/

	public int getLine() {
		//Zum testen
		isValid = false;
		validate();
		return sourceLine;
	}

	/********************************************************************************/
	/*										*/
	/* Computation methods */
	/*										*/
	/********************************************************************************/

	private synchronized void validate() {
		if (isValid)
			return;
		if (pathInProject == null || projectName == null)
			return;
		sourceLine = -1;

		TracerFile tf = TracerFile.getFileByName(EclipseWorkspaceManager.getPathOfFile(projectName,pathInProject));
		if (tf == null)
			return;

		Map<Integer, Double> values = new LinkedHashMap<Integer, Double>();

		for (Map.Entry<TracerFacet, Double> ent : facet_values.entrySet()) {
			double vx = ent.getValue();
			if (vx == 0)
				continue;
			Map<Integer, Double> fvs = ent.getKey().getLines(tf);
			if (fvs != null) {
				// normalize(fvs);
				for (Map.Entry<Integer, Double> e1 : fvs.entrySet()) {
					double v0 = ent.getValue();
					double v1 = e1.getValue();
					if (v0 < 0)
						v0 = -v0;
					v0 *= v1;
					Double v = values.get(e1.getKey());
					if (v != null)
						v0 += v;
					if (v0 > 0) {
						values.put(e1.getKey(), v0);
					}
				}
			}
		}

		for (Map.Entry<TracerFacet, Double> ent : facet_values.entrySet()) {
			double vx = ent.getValue();
			if (vx > 0)
				continue;
			Map<Integer, Double> fvs = ent.getKey().getLines(tf);
			for (Iterator<Map.Entry<Integer, Double>> it = values.entrySet()
					.iterator(); it.hasNext();) {
				Map.Entry<Integer, Double> e1 = it.next();
				int ln = e1.getKey();
				if (!fvs.containsKey(ln) || fvs.get(ln).doubleValue() == 0) {
					it.remove();
				}
			}
		}

		if (values.isEmpty())
			return;

		// normalize(values);

		double bestv = -1;
		int bestln = -1;
		for (Map.Entry<Integer, Double> ent : values.entrySet()) {
			if (ent.getValue() > bestv) {
				bestv = ent.getValue();
				bestln = ent.getKey();
			}
		}

		if (bestln < 0)
			return;
		if (bestv < thresholdValue)
			return;

		sourceLine = bestln;
		isValid = true;

		for (TracerFacet fct : facet_values.keySet()) {
			fct.resetLine(tf, bestln);
		}
	}

	private void normalize(Map<Integer, Double> vals) {
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
	
	public int compareTo(TracerLocation tl)
	{
	   throw new Error("Compare to not supported yet!");
	}

} 
