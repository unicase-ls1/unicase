/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.views;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;

/**
 * @author Sebastian Höcht
 */
public class TreeLabelProvider implements ILabelProvider {

	/**
	 * constructs a TreeLabelProvider.
	 */
	public TreeLabelProvider() {

	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText(Object element) {
		if (element instanceof Template) {
			return ((Template) element).getName();
		} else if (element instanceof ModelElementRendererMapping) {
			ModelElementRendererMapping mapping = (ModelElementRendererMapping) element;
			String rendererName = mapping.getRenderer().getClass().getSimpleName();
			rendererName = rendererName.substring(0, rendererName.length() - 4);
			if (rendererName.equals("DefaultModelElementRenderer")) {
				rendererName = "-";
			}
			return mapping.getEClassName() + "   (" + rendererName + ")";
		} else if (element instanceof RendererOption) {
			return ((RendererOption) element).getName();
		} else {
			return "unknown";
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
