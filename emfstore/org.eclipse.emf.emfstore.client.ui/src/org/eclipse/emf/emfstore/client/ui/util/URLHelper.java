/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.unicase.ui.util.ModelElementTooltip;

/**
 * This class offer helper methods for the unicase URLs.
 * 
 * @author Shterev
 */
public final class URLHelper {

	/**
	 * Cuts the names of the elements to the default value.
	 * 
	 * @see URLHelper#LIMIT
	 */
	public static final int DEFAULT = 0;

	/**
	 * Do not cut the names of the elements until the MAXLIMIT is reached.
	 */
	public static final int UNLTD = -1;

	/**
	 * The default limit of the name's length.
	 */
	public static final int LIMIT = 30;

	/**
	 * The maximal limit of the name's length.
	 */
	public static final int MAXLIMIT = 1000;

	private static AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	private URLHelper() {

	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param meId The id of the model element
	 * @param projectSpace the project space
	 * @param style the string limit or @see {@link #DEFAULT} {@link #UNLTD}
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElementId meId, ProjectSpace projectSpace, int style) {

		EObject modelElement = projectSpace.getProject().getModelElement(meId);
		if (modelElement != null) {
			return getHTMLLinkForModelElement(modelElement, projectSpace, style);
		}
		return "(deleted element)";
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param modelElement The model element
	 * @param projectSpace the project space
	 * @param style the string limit or @see {@link #DEFAULT} {@link #UNLTD}
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(EObject modelElement, ProjectSpace projectSpace, int style) {
		if (modelElement == null) {
			return "";
		}
		StringBuilder ret = new StringBuilder("<a href=\"unicase://current:0/");
		ret.append(projectSpace.getProjectName());
		ret.append("%");
		if (projectSpace.getProjectId() == null) {
			// the project is not shared yet
			ret.append("0");
		} else {
			ret.append(projectSpace.getProjectId().getId());
		}
		ret.append("/");
		String name = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getText(modelElement);
		ModelElementId modelElementId = projectSpace.getProject().getModelElementId(modelElement);

		if (name != null) {
			name = name.replaceAll("\"", "\\'");
		} else {
			name = "Unnamed Element";
		}
		ret.append(name);
		ret.append("%");
		ret.append(modelElementId.getId());
		ret.append("\">");
		int limit = style;
		if (style == UNLTD) {
			limit = MAXLIMIT;
		} else if (style == DEFAULT || style < -1) {
			limit = LIMIT;
		}
		if (name.length() > limit + 3) {
			name = name.substring(0, limit) + "...";
		}
		ret.append(name);
		ret.append("</a>");
		return ret.toString();
	}

	/**
	 * Returns a composite containing both the icon and the model element link.
	 * 
	 * @param parent the parent composite.
	 * @param modelElementId the model element id
	 * @param projectSpace the project space
	 * @param style the string limit or @see {@link #DEFAULT} {@link #UNLTD}
	 * @return the link composite
	 */
	public static Control getModelElementLink(Composite parent, ModelElementId modelElementId,
		ProjectSpace projectSpace, int style) {
		EObject modelElement = projectSpace.getProject().getModelElement(modelElementId);
		if (modelElement != null) {
			return getModelElementLink(parent, modelElement, projectSpace, style);
		}
		Label deleted = new Label(parent, SWT.WRAP);
		deleted.setText("(deleted element)");
		return deleted;
	}

	/**
	 * Returns a composite containing both the icon and the model element link.
	 * 
	 * @param parent the parent composite.
	 * @param modelElement the model element
	 * @param projectSpace the project space
	 * @param style the string limit or @see {@link #DEFAULT} {@link #UNLTD}
	 * @return the link composite
	 */
	public static Control getModelElementLink(Composite parent, final EObject modelElement, ProjectSpace projectSpace,
		int style) {
		Composite c = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).spacing(3, 0).applyTo(c);

		final Composite icon = new Composite(c, SWT.NONE);
		GridDataFactory.fillDefaults().hint(16, 16).applyTo(icon);
		icon.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Rectangle area = icon.getClientArea();
				e.gc.drawImage(labelProvider.getImage(modelElement), area.x, area.y);
			}
		});

		Link link = new Link(c, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(link);
		link.setText(getHTMLLinkForModelElement(modelElement, projectSpace, style));
		link.addSelectionListener(URLSelectionListener.getInstance(projectSpace));
		link.setData(modelElement);
		ModelElementTooltip.enableFor(link);

		return c;
	}
}
