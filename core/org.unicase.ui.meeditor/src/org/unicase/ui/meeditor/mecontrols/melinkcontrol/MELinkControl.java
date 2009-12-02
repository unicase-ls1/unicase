/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.metamodel.provider.ShortLabelProvider;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.ui.common.util.ModelElementClassTooltip;

/**
 * GUI Control for the ME reference links.
 * 
 * @author helming
 * @author shterev
 */
public class MELinkControl {

	private Composite linkComposite;
	private EReference eReference;
	private Hyperlink hyperlink;
	private ILabelProvider labelProvider;
	private ModelElementChangeListener observer;
	private ILabelProviderListener labelProviderListener;
	private ImageHyperlink imageHyperlink;
	private ModelElement link;
	private ModelElement contextModelElement;

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(final Composite parent, int style, IItemPropertyDescriptor itemPropertyDescriptor,
		final ModelElement link, ModelElement contextModelElement, FormToolkit toolkit) {
		Object feature = itemPropertyDescriptor.getFeature(link);
		this.eReference = (EReference) feature;
		this.link = link;
		this.contextModelElement = contextModelElement;

		linkComposite = toolkit.createComposite(parent, style);
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
		list.add(link);
		observer = new ModelElementChangeListener() {

			public void onChange(Notification notification) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						if (hyperlink != null && !hyperlink.isDisposed()) {
							ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
							String text = shortLabelProvider.getText(link);
							hyperlink.setText(text);
							hyperlink.setToolTipText(text);
							linkComposite.layout(true);
							parent.getParent().layout(true);
						}
					}

				});
			}

			public void onRuntimeExceptionInListener(RuntimeException exception) {
				(link).removeModelElementChangeListener(observer);
			}
		};
		(link).addModelElementChangeListener(observer);

		Image image = labelProvider.getImage(link);
		imageHyperlink = toolkit.createImageHyperlink(linkComposite, style);
		imageHyperlink.setImage(image);
		imageHyperlink.setData(link.eClass());
		ModelElementClassTooltip.enableFor(imageHyperlink);
		ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		hyperlink = toolkit.createHyperlink(linkComposite, (shortLabelProvider.getText(link)), style);
		hyperlink.setToolTipText(shortLabelProvider.getText(link));
		IHyperlinkListener listener = new MEHyperLinkAdapter(link, contextModelElement, eReference.getName());
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);

		ImageHyperlink deleteLink = toolkit.createImageHyperlink(linkComposite, style);
		Image deleteImage = null;
		if (eReference.isContainment() && (link instanceof NonDomainElement)) {
			deleteImage = org.unicase.ui.common.Activator.getImageDescriptor("icons/delete.gif").createImage();
		} else {
			deleteImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);
		}
		deleteLink.setImage(deleteImage);

		deleteLink.addMouseListener(new MEHyperLinkDeleteAdapter(contextModelElement, eReference, link));
		return linkComposite;
	}

	private void updateIcon() {
		imageHyperlink.setImage(labelProvider.getImage(link));
	}

	/**
	 * Disposes the Composite of this {@link MELinkControl}.
	 */

	public void dispose() {
		if (link != null) {
			link.removeModelElementChangeListener(observer);
		}
		labelProvider.removeListener(labelProviderListener);
		labelProvider.dispose();
		if (linkComposite != null) {
			linkComposite.dispose();
		}
	}

	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement link2,
		ModelElement contextModelElement2) {
		return 0;
	}

}
