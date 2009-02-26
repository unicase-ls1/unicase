/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.util;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.ProjectSpace;

/**
 * This class offer helper methods for the unicase URLs.
 * 
 * @author Shterev
 */
public final class URLHelper {
	
	private static AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
		ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	private URLHelper() {

	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param meId The id of the model element
	 * @param projectSpace the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElementId meId, ProjectSpace projectSpace) {

		ModelElement modelElement = projectSpace.getProject().getModelElement(meId);
		if (modelElement != null) {
			return getHTMLLinkForModelElement(modelElement, projectSpace);
		}
		return "(deleted element)";
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param modelElement The model element
	 * @param projectSpace the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElement modelElement, ProjectSpace projectSpace) {
		if (modelElement == null) {
			return "";
		}
		StringBuilder ret = new StringBuilder("<a href=\"unicase://current:0/");
		ret.append(projectSpace.getProjectName());
		ret.append("%");
		ret.append(projectSpace.getProjectId().getId());
		ret.append("/");
		String name = modelElement.getName().replaceAll("\"", "\\'");
		ret.append(name);
		ret.append("%");
		ret.append(modelElement.getIdentifier());
		ret.append("\">");
		if (name.length() > 33) {
			name = name.substring(0, 30) + "...";
		}
		ret.append(name);
		ret.append("</a>");
		return ret.toString();
	}
	
	/**
	 * Returns a composite containing both the icon and the model element link.
	 * @param parent the parent composite.
	 * @param modelElement the model element
	 * @param projectSpace the project space
	 * @return the link composite
	 */
	public static Composite getModelElementLink(Composite parent, final ModelElement modelElement, ProjectSpace projectSpace){
		Composite c = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).spacing(3,0).applyTo(c);
		
		final Composite icon = new Composite(c, SWT.NONE);
		GridDataFactory.fillDefaults().hint(16,16).applyTo(icon);
		icon.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Rectangle area = icon.getClientArea();
				e.gc.drawImage(labelProvider.getImage(modelElement), area.x, area.y);
			}
		});
		
		Link link = new Link(c, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(link);
		link.setText(getHTMLLinkForModelElement(modelElement, projectSpace));
		link.addSelectionListener(URLSelectionListener.getInstance(projectSpace));
		
		return c;
	}
}
