package org.unicase.rap.ui.start;

import org.eclipse.rwt.lifecycle.IEntryPoint;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IEntryPoint {
	public int createUI() {
		Display display = PlatformUI.createDisplay();
		PlatformUI.createAndRunWorkbench( display,new ApplicationWorkbenchAdvisor());
		return 0;
		}
}
