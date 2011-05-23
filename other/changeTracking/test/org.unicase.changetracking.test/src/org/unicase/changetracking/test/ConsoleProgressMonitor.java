package org.unicase.changetracking.test;

import java.io.PrintStream;

import org.eclipse.core.runtime.IProgressMonitor;

public class ConsoleProgressMonitor implements IProgressMonitor{

	private PrintStream stream;
	
	private int totalWork;
	private int workDone;

	public ConsoleProgressMonitor() {
		stream = System.out;
	}
	
	public void beginTask(String name, int totalWork) {
		stream.println("Staring " + name);
		this.totalWork = totalWork;
		this.workDone = 0;
	}

	public void done() {
		stream.println("DONE");
		
	}

	public void internalWorked(double work) {
	
	}

	public boolean isCanceled() {
		return false;
	}

	public void setCanceled(boolean value) {
				
	}

	public void setTaskName(String name) {
		stream.println("Switching to " + name);
	}

	public void subTask(String name) {
		stream.println(" => Subtask: " + name);
		
	}

	public void worked(int work) {
		workDone += work;
		stream.println("..." + (workDone*100/totalWork) + "%");
	}

}
