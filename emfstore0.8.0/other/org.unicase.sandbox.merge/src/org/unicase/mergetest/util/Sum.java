package org.unicase.mergetest.util;

import java.util.ArrayList;
import java.util.List;

public class Sum {

	private List<Float> values;
	
	public Sum()  {
		values = new ArrayList<Float>();
	}
	
	public void add(Float value) {
		values.add(value);
	}
	
	public Float getAverage() {
		float sum = 0;
		for(Float value : values) {
			sum += value;
		}
		return sum/((float) values.size());
	}
	
	public int valueSize() {
		return values.size();
	}
	
}
