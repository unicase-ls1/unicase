package edu.tum.in.bruegge.epd.kinect.gesture.impl;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageCalculator {

	private final Queue<Float> window = new LinkedList<Float>();
	private final int numPeriods;
	private float sum;
	
	public MovingAverageCalculator(int numPeriods) {
		this.numPeriods = numPeriods;
	}
	
	public void addValue(float num) {
		sum += num;
		window.add(num);
		if (window.size() > numPeriods) {
			sum -= window.remove();
		}
	}
	
	public float getMovingAvg() {
		return (window.size() == 0) ? 0 : sum / window.size();
	}
	
	public float calculateMovingAvg(float sensorValue) {
		this.addValue(sensorValue);
		return this.getMovingAvg();
	}
}
