/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.codetrace.tracer;


import java.util.Map;
import java.util.Map.Entry;

public class Test {
	
	
	@SuppressWarnings("unused")
	private static void debug(Map<Integer,Double> in){
		for(Entry<Integer,Double> cur: in.entrySet()){
			System.out.println(cur.getKey() + ": " + cur.getValue());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	//	TracerFactory t = new TracerFactory();
		//t.addAlgorithm(new AlgorithmLineContext(4,0.35,false),0.4);
		//t.addAlgorithm(new AlgorithmBestMatch(1,0.5,true),0.6);

		
	//	TracerLocation tf = t.createLocation("org.unicase.codetrace", "test.tx", 564);

	}

}
