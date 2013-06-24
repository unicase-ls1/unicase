/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.equinox.internal.p2.ui.model.ElementUtils;
import org.eclipse.equinox.internal.p2.ui.model.MetadataRepositoryElement;
import org.eclipse.equinox.p2.ui.ProvisioningUI;

/**
 * Workbench window advisor for unicase.
 * 
 * @author naugthon
 */
@SuppressWarnings("restriction")
public class UnicaseWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	/**
	 * Default constructor.
	 * 
	 * @param configurer the configurer
	 */
	public UnicaseWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#createActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)
	 */
	@Override
	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		return new UnicaseActionBarAdvisor(configurer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#preWindowOpen()
	 */
	@Override
	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(1024, 768));
		configurer.setShowCoolBar(false);
		configurer.setShowStatusLine(true);
		configurer.setShowProgressIndicator(true);
		configurer.setTitle("UNICASE");
	}

	@Override
	public void postWindowOpen() {
		try {
			final MetadataRepositoryElement unicaseRepository = new MetadataRepositoryElement(null, new URI(
				"http://unicase.googlecode.com/svn/updatesite/release/0.5.2"), true);
			final MetadataRepositoryElement papyrusRepository = new MetadataRepositoryElement(null, new URI(
				"http://unicase.googlecode.com/svn/trunk/other/Papyrus/updatesite/RCP"), true);
			ElementUtils.updateRepositoryUsingElements(ProvisioningUI.getDefaultUI(), new MetadataRepositoryElement[] { unicaseRepository,
				papyrusRepository }, null);
		} catch (URISyntaxException e) {
		}

	}
}
