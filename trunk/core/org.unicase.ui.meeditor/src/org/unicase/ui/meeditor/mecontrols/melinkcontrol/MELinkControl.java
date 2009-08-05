/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.ModelElement;
import org.unicase.model.NonDomainElement;
import org.unicase.model.util.ModelElementChangeObserver;
import org.unicase.ui.common.util.ModelElementClassTooltip;
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
	private ModelElementChangeObserver observer;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain the editing domain
	 * @param modelElement the ME
	 * @param toolkit gui toolkit used for rendering
	 * @param contextModelElement the context model element
	 * @param reference the reference link
	 */
	public MELinkControl(EditingDomain editingDomain, EObject modelElement, FormToolkit toolkit,
		EObject contextModelElement, EReference reference) {
		super(editingDomain, modelElement, toolkit);
		this.contextModelElement = contextModelElement;
		this.reference = reference;
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(final Composite parent, int style) {
		linkComposite = getToolkit().createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(3, false));
		labelProvider = new MELinkLabelProvider();
		ArrayList<ModelElement> list = new ArrayList<ModelElement>();
		list.add((ModelElement) getModelElement());
		observer = new ModelElementChangeObserver() {

			@Override
			protected void onNotify(Notification notification, ModelElement element) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						if (!hyperlink.isDisposed()) {
							hyperlink.setText(labelProvider.getText(getModelElement()));
							linkComposite.layout(true);
							parent.getParent().layout(true);
						}
					}
				});
			}

			@Override
			protected void onElementDeleted(ModelElement element) {
				// nothing to do
			}
		};
		((ModelElement) getModelElement()).getProject().addProjectChangeObserver(observer);
		observer.observeElement((ModelElement) getModelElement());
		Image image = labelProvider.getImage(getModelElement());
		ImageHyperlink imageHyperlink = getToolkit().createImageHyperlink(linkComposite, style);
		imageHyperlink.setImage(image);
		imageHyperlink.setData(getModelElement().eClass());
		ModelElementClassTooltip.enableFor(imageHyperlink);
		hyperlink = getToolkit().createHyperlink(linkComposite, labelProvider.getText(getModelElement()), style);
		IHyperlinkListener listener = new MEHyperLinkAdapter((ModelElement) getModelElement(),
			(ModelElement) contextModelElement, reference.getName());
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);
		ImageHyperlink deleteLink = getToolkit().createImageHyperlink(linkComposite, style);
		Image deleteImage = null;
		if (reference.isContainment() && (getModelElement() instanceof NonDomainElement)) {
			deleteImage = org.unicase.ui.common.Activator.getImageDescriptor("icons/delete.gif").createImage();
		} else {
			deleteImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);
		}
		deleteLink.setImage(deleteImage);

		deleteLink.addMouseListener(new MEHyperLinkDeleteAdapter(contextModelElement, reference, getModelElement()));
		return linkComposite;
	}

	/**
	 * Disposes the Composite of this {@link MELinkControl}.
	 */
	@Override
	public void dispose() {
		((ModelElement) getModelElement()).getProject().removeProjectChangeObserver(observer);
		labelProvider.dispose();
		if (linkComposite != null) {
			linkComposite.dispose();
		}
	}
}
