/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.handler;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * TODO: javadoc.
 * @author -insert author-
 *
 */
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	/**
	 * TODO: javadoc.
	 * @param configurer -insert doc-
	 */
    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

	/**
	 * TODO: javadoc.
	 * @return -insert doc-
	 * @param configurer -insert doc-
	 */
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
	/**
	 * TODO: javadoc.
	 */
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(400, 300));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
    }

	/**
	 * TODO: javadoc.
	 */
	@Override
	public void postWindowOpen() {
		super.postWindowOpen();
//		String[] args = Platform.getApplicationArgs();
//		if(args.length>0){
//			StringBuilder strB = new StringBuilder().append(args[0]);
//			JUnique.sendMessage(Platform.getProduct().getId(), strB.toString());	
//		}
		
	}
    
    
}
