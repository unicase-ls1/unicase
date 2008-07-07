/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * GUI Control for the ME reference links.
 * 
 * @author helming
 */
public class MELinkControl extends AbstractMEControl {

	private Composite linkComposite;
	private EObject contextModelElement;
	private EReference reference;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain
	 *            the editing domain
	 * @param modelElement
	 *            the ME
	 * @param toolkit
	 *            gui toolkit used for rendering
	 * @param contextModelElement
	 *            the context model element
	 * @param reference
	 *            the reference link
	 */
	public MELinkControl(EditingDomain editingDomain, EObject modelElement, FormToolkit toolkit, EObject contextModelElement, EReference reference) {
		super(editingDomain, modelElement, toolkit);
		this.contextModelElement = contextModelElement;
		this.reference = reference;
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		linkComposite = toolkit.createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(3, false));
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		Image image = labelProvider.getImage(modelElement);
		ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(linkComposite, style);
		imageHyperlink.setImage(image);
		Hyperlink hyperlink = toolkit.createHyperlink(linkComposite, labelProvider.getText(modelElement), style);
		IHyperlinkListener listener = new MEHyperLinkAdapter((ModelElement) modelElement);
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);
		ImageHyperlink deleteLink = toolkit.createImageHyperlink(linkComposite, style);
		deleteLink.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));

		deleteLink.addHyperlinkListener(new MEHyperLinkDeleteAdapter(contextModelElement, reference, modelElement));
		return linkComposite;
	}

	/**
	 * Disposes the Composite of this {@link MELinkControl}.
	 */
	public void dispose() {
		linkComposite.dispose();
	}
}
