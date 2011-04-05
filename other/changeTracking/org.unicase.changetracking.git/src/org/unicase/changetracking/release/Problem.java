package org.unicase.changetracking.release;

public class Problem {
	
	public static enum Severity{
		ERROR, WARNING;
	}

	private final Severity severity;
	private final String message;

	public Problem(Severity s, String message){
		this.severity = s;
		this.message = message;
	}
	
	public Severity getSeverity() {
		return severity;
	}

	public String getMessage() {
		return message;
	}
}
