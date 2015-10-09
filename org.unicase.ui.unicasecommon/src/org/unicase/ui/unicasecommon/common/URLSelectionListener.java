/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.exceptions.MEUrlResolutionException;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.internal.server.model.url.ModelElementUrl;
import org.eclipse.emf.emfstore.internal.server.model.url.ModelElementUrlFragment;
import org.eclipse.emf.emfstore.internal.server.model.url.UrlFactory;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * A singleton selection listener that resolves EMFStore URLs and opens the
 * element in a MEEditor.
 * 
 * @author Shterev
 */
public final class URLSelectionListener implements SelectionListener {

	private ProjectSpace projectSpace;
	private static HashMap<ProjectSpace, URLSelectionListener> map = new HashMap<ProjectSpace, URLSelectionListener>();

	/**
	 * Default constructor.
	 * 
	 * @param projectSpace
	 *            the project space needed for resolving the urls.
	 */
	private URLSelectionListener(ProjectSpace projectSpace) {
		super();
		this.projectSpace = projectSpace;
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		//

	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetSelected(SelectionEvent e) {
		String text = e.text;
		try {
			ModelElementUrl modelElementUrl = UrlFactory.eINSTANCE
					.createModelElementUrl(text);
			EObject modelElement = null;
			ModelElementUrlFragment modelElementUrlFragment = modelElementUrl
					.getModelElementUrlFragment();
			try {
				modelElement = projectSpace.resolve(modelElementUrlFragment);
			} catch (MEUrlResolutionException e1) {
			}

			ECPHandlerHelper.openModelElement(modelElement,
					(ECPProject) ESWorkspaceProviderImpl.getInstance()
							.getWorkspace().getLocalProject(modelElement));
		} catch (MalformedURLException ex) {
			WorkspaceUtil.logException("Invalid EMFStore URL pattern", ex);
		}

	}

	/**
	 * Gets the singleton instance for this project space.
	 * 
	 * @param projectSpace
	 *            the project space.
	 * @return the singleton instance.
	 */
	public static URLSelectionListener getInstance(ProjectSpace projectSpace) {
		URLSelectionListener instance = map.get(projectSpace);
		if (instance == null) {
			instance = new URLSelectionListener(projectSpace);
			map.put(projectSpace, instance);
		}
		return instance;
	}

}
