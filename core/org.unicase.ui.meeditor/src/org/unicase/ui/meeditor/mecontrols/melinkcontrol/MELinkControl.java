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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ui.common.util.ModelElementClassTooltip;
import org.unicase.ui.common.util.ShortLabelProvider;

/**
 * GUI Control for the ME reference links.
 * 
 * @author helming
 * @author shterev
 */
public class MELinkControl {

	protected Composite linkComposite;
	private EReference eReference;
	private Hyperlink hyperlink;
	private ILabelProvider labelProvider;
	private ILabelProviderListener labelProviderListener;
	private ImageHyperlink imageHyperlink;
	protected EObject link;
	protected EObject contextModelElement;
	protected FormToolkit toolkit;
	private org.unicase.ui.meeditor.ModelElementChangeListener modelElementChangeListener;
	private ECPModelelementContext context;

	public ECPModelelementContext getContext() {
		return context;
	}

	public void setContext(ECPModelelementContext context) {
		this.context = context;
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(final Composite parent, int style, IItemPropertyDescriptor itemPropertyDescriptor,
		final EObject link, EObject contextModelElement, FormToolkit toolkit, ECPModelelementContext context) {
		this.context = context;
		Object feature = itemPropertyDescriptor.getFeature(link);
		this.eReference = (EReference) feature;
		this.link = link;
		this.contextModelElement = contextModelElement;
		this.toolkit = toolkit;
		return createControl(parent, style);

	}

	protected Control createControl(final Composite parent, int style) {
		linkComposite = toolkit.createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(3, false));

		createHyperlink(parent, style);
		createDeleteAction(style);
		return linkComposite;
	}

	protected void createDeleteAction(int style) {
		ImageHyperlink deleteLink = toolkit.createImageHyperlink(linkComposite, style);
		Image deleteImage = null;
		if (eReference.isContainment() && (context.getMetaModelElementContext().isNonDomainElement(link.eClass()))) {
			deleteImage = org.unicase.ui.common.Activator.getImageDescriptor("icons/delete.gif").createImage();
		} else {
			deleteImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);
		}
		deleteLink.setImage(deleteImage);

		deleteLink.addMouseListener(new MEHyperLinkDeleteAdapter(contextModelElement, eReference, link, context));
	}

	protected void createHyperlink(final Composite parent, int style) {
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

		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(link);
		modelElementChangeListener = new org.unicase.ui.meeditor.ModelElementChangeListener(link) {

			@Override
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
		};

		Image image = labelProvider.getImage(link);
		imageHyperlink = toolkit.createImageHyperlink(linkComposite, style);
		imageHyperlink.setImage(image);
		imageHyperlink.setData(link.eClass());
		ModelElementClassTooltip.enableFor(imageHyperlink);
		ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		hyperlink = toolkit.createHyperlink(linkComposite, (shortLabelProvider.getText(link)), style);
		hyperlink.setToolTipText(shortLabelProvider.getText(link));
		IHyperlinkListener listener = new MEHyperLinkAdapter(link, contextModelElement, eReference.getName(), context);
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);
	}

	private void updateIcon() {
		imageHyperlink.setImage(labelProvider.getImage(link));
	}

	/**
	 * Disposes the Composite of this {@link MELinkControl}.
	 */

	public void dispose() {
		if (modelElementChangeListener != null) {
			modelElementChangeListener.remove();
		}
		if (labelProvider != null) {
			labelProvider.removeListener(labelProviderListener);
			labelProvider.dispose();
		}
		if (linkComposite != null) {
			linkComposite.dispose();
		}
	}

	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject link2, EObject contextModelElement2) {
		return 0;
	}

}
