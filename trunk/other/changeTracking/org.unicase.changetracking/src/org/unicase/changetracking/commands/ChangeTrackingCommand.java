package org.unicase.changetracking.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.workspace.util.UnicaseCommandWithResult;

public abstract class ChangeTrackingCommand extends UnicaseCommandWithResult<ChangeTrackingCommandResult> implements IRunnableWithProgress{

	
	protected ChangeTrackingCommandResult cancelResult(){
		return new ChangeTrackingCommandResult(ChangeTrackingCommandResult.Result.CANCELLED, null);
	}
	
	protected ChangeTrackingCommandResult errorResult(Throwable e) {
		return new ChangeTrackingCommandResult(e);
	}
	
	protected ChangeTrackingCommandResult successResult(String message) {
		return new ChangeTrackingCommandResult(ChangeTrackingCommandResult.Result.SUCCESS, message);
	}
	
	protected ChangeTrackingCommandResult misuseResult(String message) {
		return new ChangeTrackingCommandResult(ChangeTrackingCommandResult.Result.MISUSE,message);
	}
	
	protected ChangeTrackingCommandResult warningResult(String message) {
		return new ChangeTrackingCommandResult(ChangeTrackingCommandResult.Result.WARNING,message);
	}
	
	
	public boolean needsProgressMonitor(){
		return true;
	}
	
	private IProgressMonitor progressMonitor;
	private ChangeTrackingCommandResult result;

	public void run(IProgressMonitor monitor) {
		this.progressMonitor = monitor;
		this.setResult(run(true));
	}
	
	protected IProgressMonitor getProgressMonitor(){
		if(progressMonitor == null){
			progressMonitor = new NullProgressMonitor();
		}
		return progressMonitor;
	}

	public void setResult(ChangeTrackingCommandResult result) {
		this.result = result;
	}

	
//	@Override
//	public ChangeTrackingCommandResult run() {
//		try{
//		return super.run(false);
//		} catch(MisuseException e){
//			return misuseResult(e.getMessage());
//		} catch (RuntimeException e){
//			return errorResult(e);
//		}
//	}
	
	@Override
	protected void commandBody() {
		try{
			result = doRun();
		} catch(MisuseException e){
			result = misuseResult(e.getMessage());
		} catch (RuntimeException e){
			result = errorResult(e);
		}
	}
	


	public ChangeTrackingCommandResult getCTResult() {
		return result;
	}

	public ChangeTrackingCommandResult run(boolean ignoreExceptions) {
		super.aRun(ignoreExceptions);
		return this.result;
	}
}
