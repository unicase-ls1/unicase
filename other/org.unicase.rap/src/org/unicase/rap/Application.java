/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap;

import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.rwt.lifecycle.IEntryPoint;
import org.eclipse.rwt.lifecycle.UICallBack;
import org.eclipse.ui.application.WorkbenchAdvisor;

/**
 * This class controls all aspects of the application's execution 
 * and is contributed through the plugin.xml.
 * 
 * @author Edgar Mueller, Fatih Ulusoy
 */
public class Application implements IEntryPoint {

	/**
	 * {@inheritDoc}
	 */
	public int createUI() {
		UICallBack.activate(getClass().getName());
		final Display result = PlatformUI.createDisplay();
		WorkbenchAdvisor advisor = new ApplicationWorkbenchAdvisor();
		return PlatformUI.createAndRunWorkbench(result, advisor);
	}

}
