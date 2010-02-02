/********************************************************************************/
/*										*/
/*		LimboFacet.java 						*/
/*										*/
/*	Representation of information about a feature for a location		*/
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

/* RCS: $Header: /pro/spr_cvs/pro/wadi/javasrc/edu/brown/cs/wadi/limbotest/LimboFacet.java,v 1.1 2007-11-06 00:56:30 spr Exp $ */

/*********************************************************************************
 *
 * $Log: LimboFacet.java,v $
 * Revision 1.1  2007-11-06 00:56:30  spr
 * Add limbo test files for line number checking.
 *
 * Revision 1.1  2007-08-10 23:51:20  spr
 * Add line number tracking code.
 *
 *
 ********************************************************************************/
package org.unicase.codetrace.tracer;

import java.util.Map;

import org.unicase.codetrace.tracer.algorithms.Algorithm;
import org.unicase.model.trace.CodeLocation;

public interface TracerFacet {

	Algorithm getAlgorithm();

	Map<Integer, Double> getLines(TracerFile tf);

	void resetLine(TracerFile tf, int ln);
	
	void addToCodeLocation(CodeLocation c);

}
