package org.unicase.patchAttachment.exported;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.compare.internal.patch.WorkspaceFileDiffResult;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Utility class for UI 
 * @author jfinis
 *
 */
public final class UIUtil {
	
	/**
	 * Util class.
	 */
	private UIUtil(){}
	
	// Constants for determining the type of progress. Subclasses may
	// pass one of these values to the run method.
	
	/**
	 * Run with a progress monitor dialog
	 */
	public final static int PROGRESS_DIALOG = 1;
	
	/**
	 * Run only with a busy cursor.
	 */
	public final static int PROGRESS_BUSYCURSOR = 2;
	
	/**
	 * Runs a runnable either with a progress monitor or a busy cursor
	 * @param runnable the runnable to run
	 * @param progressKind with cursor or dialog?
	 */
	 public static void run(final IRunnableWithProgress runnable, int progressKind) {
		final Exception[] exceptions = new Exception[] {null};
		switch (progressKind) {
			case PROGRESS_BUSYCURSOR :
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() {
						try {
							runnable.run(new NullProgressMonitor());
						} catch (InvocationTargetException e) {
							exceptions[0] = e;
						} catch (InterruptedException e) {
							exceptions[0] = null;
						}
					}
				});
				break;
			default :
			case PROGRESS_DIALOG :
				try {
					new ProgressMonitorDialog(getShell()).run(true, true, runnable);
				} catch (InvocationTargetException e) {
					exceptions[0] = e;
				} catch (InterruptedException e) {
					exceptions[0] = null;
				}
				break;
		}
		if (exceptions[0] != null) {
			WorkspaceUtil.logException("An exception has occurred", exceptions[0]);
		}
	}

	 /**
	  * Gets the default active eclipse shell.
	  * @return the active shell
	  */
	private static Shell getShell() {
		return PlatformUI.getWorkbench().
        getActiveWorkbenchWindow().getShell();
	}
	
	/**
	 * Returns the active unicase project or null if none is active.
	 * @return the active unicase project
	 */
	public static Project getActiveProject() {
		final ProjectSpace ps = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace();
		if(ps == null) {
			return null;
		}
		if (ps.getProject() != null) {
			return ps.getProject();
		} else {
			return null;
		}

	}
}
