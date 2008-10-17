/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.statusview;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.util.MEState;

/**
 * .
 * 
 * This is the LabelProvider for users tab. This class just takes care of
 * background colors. Assignables that are closed are shown in green. If all
 * Assignables of an OrgUnit are closed, it will be also shown green.
 * 
 * @author Hodaie
 * 
 */

public class UserTabLabelProvider extends AdapterFactoryLabelProvider implements
		IColorProvider {

	private UserTabContentProvider contentProvider;

	/**.
	 * Constructor
	 * @param contentProvider ContentProvider. This is used to check if all children (assignables)
	 * 							of an OrgUnit are closed.
	 */
	public UserTabLabelProvider(UserTabContentProvider contentProvider) {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		this.contentProvider = contentProvider;
	}

	
	/**.
	 * {@inheritDoc}
	 * 
	 * Assignables that are closed are shown in green. 
	 * If all Assignables of an OrgUnit are closed, 
	 * it will be also shown green.
	 */
	@Override
	public Color getBackground(Object object) {
		if (object instanceof OrgUnit) {
			if (isAllTodosDone((OrgUnit) object)) {
				return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
			}

		} else if (object instanceof ModelElement) {
			if (((ModelElement) object).getState().equals(MEState.CLOSED)) {
				return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
			}
		}

		return super.getBackground(object);

	}

	
	private boolean isAllTodosDone(OrgUnit orgUnit) {
		List<Object> assignables = Arrays.asList(contentProvider
				.getChildren(orgUnit));
		for (Object obj : assignables) {
			if (obj instanceof ModelElement) {
				ModelElement assignable = (ModelElement) obj;
				if (!assignable.getState().equals(MEState.CLOSED)) {
					return false;
				}
			}

		}
		return true;
	}

}
