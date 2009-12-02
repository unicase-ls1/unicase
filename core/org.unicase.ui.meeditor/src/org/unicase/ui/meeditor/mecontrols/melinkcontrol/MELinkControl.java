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
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.metamodel.provider.ShortLabelProvider;
import org.unicase.metamodel.util.ModelElementChangeListener;
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
	private EReference eReference;
	private Hyperlink hyperlink;
	private ILabelProvider labelProvider;
	private ModelElementChangeListener observer;
	private ILabelProviderListener labelProviderListener;
	private ImageHyperlink imageHyperlink;

	private static final int PRIORITY = 1;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(final Composite parent, int style) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.eReference = (EReference) feature;
		linkComposite = getToolkit().createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(3, false));
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		labelProvider = new DecoratingLabelProvider(adapterFactoryLabelProvider, decoratorManager.getLabelDecorator());
		labelProviderListener = new ILabelProviderListener() {
			public void labelProviderChanged(LabelProviderChangedEvent event) {
				updateIcon();
			}
		};
		labelProvider.addListener(labelProviderListener);

		ArrayList<ModelElement> list = new ArrayList<ModelElement>();
		list.add(getModelElement());
		observer = new ModelElementChangeListener() {

			public void onChange(Notification notification) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						if (hyperlink != null && !hyperlink.isDisposed()) {
							ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
							String text = shortLabelProvider.getText(getModelElement());
							hyperlink.setText(text);
							hyperlink.setToolTipText(text);
							linkComposite.layout(true);
							parent.getParent().layout(true);
						}
					}

				});
			}

			public void onRuntimeExceptionInListener(RuntimeException exception) {
				(getModelElement()).removeModelElementChangeListener(observer);
			}
		};
		(getModelElement()).addModelElementChangeListener(observer);

		Image image = labelProvider.getImage(getModelElement());
		imageHyperlink = getToolkit().createImageHyperlink(linkComposite, style);
		imageHyperlink.setImage(image);
		imageHyperlink.setData(getModelElement().eClass());
		ModelElementClassTooltip.enableFor(imageHyperlink);
		ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		hyperlink = getToolkit().createHyperlink(linkComposite, (shortLabelProvider.getText(getModelElement())), style);
		hyperlink.setToolTipText(shortLabelProvider.getText(getModelElement()));
		IHyperlinkListener listener = new MEHyperLinkAdapter(getModelElement(), (ModelElement) contextModelElement,
			eReference.getName());
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);

		ImageHyperlink deleteLink = getToolkit().createImageHyperlink(linkComposite, style);
		Image deleteImage = null;
		if (eReference.isContainment() && (getModelElement() instanceof NonDomainElement)) {
			deleteImage = org.unicase.ui.common.Activator.getImageDescriptor("icons/delete.gif").createImage();
		} else {
			deleteImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);
		}
		deleteLink.setImage(deleteImage);

		deleteLink.addMouseListener(new MEHyperLinkDeleteAdapter(contextModelElement, eReference, getModelElement()));
		return linkComposite;
	}

	private void updateIcon() {
		imageHyperlink.setImage(labelProvider.getImage(getModelElement()));
	}

	/**
	 * Disposes the Composite of this {@link MELinkControl}.
	 */
	@Override
	public void dispose() {
		if (getModelElement() != null) {
			(getModelElement()).removeModelElementChangeListener(observer);
		}
		labelProvider.removeListener(labelProviderListener);
		labelProvider.dispose();
		if (linkComposite != null) {
			linkComposite.dispose();
		}
	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EReference
			&& ((EReference) feature).getEType().getInstanceClass().equals(ModelElement.class)) {

			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
}
