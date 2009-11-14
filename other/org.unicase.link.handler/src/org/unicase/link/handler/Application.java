package org.unicase.link.handler;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import it.sauronsoftware.junique.JUnique;
import it.sauronsoftware.junique.AlreadyLockedException;


/**
 * Controls all aspects of the application's execution
 * 
 * 
 * @author fxulusoy
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context) {
		boolean isRunning = false;
		Display display = PlatformUI.createDisplay();
		String id = context.getBrandingId();
	
		try {
			JUnique.acquireLock(id, new URIMessageHandler());
			isRunning = true;
		} catch (AlreadyLockedException e) {
			// One instance of an application is still running.
			isRunning = false;
		}
		Integer appReturnCode;
		try {
			if (isRunning) {
				int returnCode = PlatformUI.createAndRunWorkbench(display,
						new ApplicationWorkbenchAdvisor());
				if (returnCode == PlatformUI.RETURN_RESTART)
					appReturnCode = IApplication.EXIT_RESTART;
				else
					appReturnCode = IApplication.EXIT_OK;
			} else {
				String[] args = (String[]) context.getArguments().get(
						IApplicationContext.APPLICATION_ARGS);
				if (args.length > 0) {
					StringBuilder strB = new StringBuilder().append(args[0]);
					JUnique.sendMessage(id, strB.toString());
				}
				appReturnCode = IApplication.EXIT_OK;
			}

		} finally {
			display.dispose();
		}
		return appReturnCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
