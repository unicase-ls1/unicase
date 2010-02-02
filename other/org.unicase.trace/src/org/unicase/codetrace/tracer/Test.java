package org.unicase.codetrace.tracer;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.unicase.codetrace.tracer.algorithms.Algorithm;
import org.unicase.codetrace.tracer.algorithms.AlgorithmBestMatch;
import org.unicase.codetrace.tracer.algorithms.AlgorithmLineContext;

public class Test {
	
	
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
