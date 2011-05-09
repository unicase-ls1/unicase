package org.unicase.changetracking.commands;

import org.unicase.changetracking.exceptions.MisuseException;


public class ChangeTrackingCommandResult {
	
	public static enum Result{
		SUCCESS, WARNING, ERROR, CANCELLED, MISUSE
	}

	private Result result;
	private Throwable exception;
	private String message;

	public ChangeTrackingCommandResult(Result result, String message) {
		this.result = result;
		this.message = message;
	}
	


	public ChangeTrackingCommandResult(MisuseException e) {
		this.message = e.getMessage();
		this.result = Result.MISUSE;
	}

	public ChangeTrackingCommandResult(Throwable e) {
		this.exception = e;
		this.message = e.getMessage();
		this.result = Result.ERROR;
	}
	
	private static String getDefaultCaption(Result result) {
		switch(result){
		case CANCELLED: return null;
		case ERROR: return "Unexpected error!";
		case MISUSE: return "Error";
		case SUCCESS: return "Success!";
		case WARNING: return "Attention!";
		}
		return null;
	}

	public Result getResult() {
		return result;
	}
	
	public Throwable getException() {
		return exception;
	}

	public String getMessage() {
		return message;
	}
	
	public String getCaption(){
		return getDefaultCaption(result);
	}

}
