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
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
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
 * @author shterev
 */
public class MELinkControl extends AbstractMEControl {

	private Composite linkComposite;
	private EObject contextModelElement;
	private EReference reference;
	private Hyperlink hyperlink;
	private ILabelProvider labelProvider;
	private ILabelProviderListener labelListener;

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
		linkComposite = getToolkit().createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(3, false));
		labelProvider = new MELinkLabelProvider();
		labelListener = new ILabelProviderListener(){
			public void labelProviderChanged(LabelProviderChangedEvent event) {
				if(hyperlink==null){
					//no hyperlink defined yet -> nothing to refresh
					return;
				}
				hyperlink.setText(labelProvider.getText(getModelElement()));
				linkComposite.layout();
			}
		};
		labelProvider.addListener(labelListener);
		Image image = labelProvider.getImage(getModelElement());
		ImageHyperlink imageHyperlink = getToolkit().createImageHyperlink(linkComposite, style);
		imageHyperlink.setImage(image);
		hyperlink = getToolkit().createHyperlink(linkComposite, labelProvider.getText(getModelElement()), style);
		IHyperlinkListener listener = new MEHyperLinkAdapter((ModelElement) getModelElement());
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);
		ImageHyperlink deleteLink = getToolkit().createImageHyperlink(linkComposite, style);
		deleteLink.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));

		deleteLink.addHyperlinkListener(new MEHyperLinkDeleteAdapter(contextModelElement, reference, getModelElement()));
		return linkComposite;
	}

	/**
	 * Disposes the Composite of this {@link MELinkControl}.
	 */
	@Override
	public void dispose() {
		labelProvider.removeListener(labelListener);
		if (linkComposite!=null){
			linkComposite.dispose();
		}
	}
}
