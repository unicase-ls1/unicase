/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.attachment.UrlAttachment;

/**
 * GUI Control for the ME reference links.
 * 
 * @author helming
 * @author shterev
 */
public class MEURLLinkControl extends MELinkControl {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.unicase.metamodel.ModelElement, org.unicase.metamodel.ModelElement)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject link2, EObject contextModelElement2) {
		if (link2 instanceof UrlAttachment) {
			return PRIORITY;
		} else {
			return -1;
		}
	}

	private ImageHyperlink urlHyperlink;

	private static final int PRIORITY = 2;

	private EObject link;
	private EObject contextModelElement;
	private EReference eReference;
	private Hyperlink hyperlink;
	private ImageHyperlink imageHyperlink;
	private DecoratingLabelProvider labelProvider;
	private ILabelProviderListener labelProviderListener;
	private ModelElementChangeListener modelElementChangeListener;
	private ModelElementChangeListener modelElementChangeListener2;
	private ComposedAdapterFactory adapterFactory;

	@Override
	public Control createControl(final Composite parent, int style, IItemPropertyDescriptor itemPropertyDescriptor,
		final EObject link, EObject contextModelElement, FormToolkit toolkit, ECPModelelementContext context) {
		this.link = link;
		this.contextModelElement = contextModelElement;
		Object feature = itemPropertyDescriptor.getFeature(link);
		this.eReference = (EReference) feature;
		return super.createControl(parent, style, itemPropertyDescriptor, link, contextModelElement, toolkit, context);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createControl(Composite parent, int style) {

		linkComposite = toolkit.createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(4, false));
		createHyperlink(parent, style);
		setupAdditionalControlComponents(style);
		createDeleteAction(style);
		return linkComposite;
	}

	/**
	 * Set up additional controls to the left of the default link.
	 * 
	 * @param style Style
	 */
	private void setupAdditionalControlComponents(int style) {
		if (link.eClass().getInstanceClass().equals(UrlAttachment.class)) {
			urlHyperlink = toolkit.createImageHyperlink(linkComposite, style);
			Image launchImage = Activator.getImageDescriptor("icons/world_link.png").createImage();
			urlHyperlink.setImage(launchImage);

			modelElementChangeListener2 = new ModelElementChangeListener(link) {

				@Override
				public void onChange(Notification notification) {
					updateAdditionalControlComponents();

				}
			};
			String url = ((UrlAttachment) link).getUrl();
			if (url == null) {
				url = "";
			}
			urlHyperlink.setToolTipText(url);
			urlHyperlink.addHyperlinkListener(new HyperlinkAdapter() {
				@Override
				public void linkActivated(HyperlinkEvent event) {
					String url = ((UrlAttachment) link).getUrl();
					if (url == null) {
						return;
					}
					ExtProgramFactoryFacade.launchURL(url);
					super.linkActivated(event);

				}
			});
		}
	}

	/**
	 * Pass change notification to additional control components.
	 */
	private void updateAdditionalControlComponents() {
		if ((urlHyperlink != null) && (!urlHyperlink.isDisposed())) {
			String url = ((UrlAttachment) link).getUrl();
			if (url == null) {
				url = "";
			}
			urlHyperlink.setToolTipText(url);
		}
	}

	/**
	 * Disposes the Composite of this {@link MEURLLinkControl}.
	 */
	@Override
	public void dispose() {
		super.dispose();
		modelElementChangeListener2.remove();
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
		if (adapterFactory != null) {
			adapterFactory.dispose();
		}
	}

	private void createHyperlink(final Composite parent, int style) {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		labelProvider = new DecoratingLabelProvider(adapterFactoryLabelProvider, decoratorManager.getLabelDecorator());
		labelProviderListener = new ILabelProviderListener() {
			public void labelProviderChanged(LabelProviderChangedEvent event) {
				imageHyperlink.setImage(labelProvider.getImage(link));
			}
		};
		labelProvider.addListener(labelProviderListener);

		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(link);
		new ModelElementChangeListener(link) {

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
		IHyperlinkListener listener = new MEHyperLinkAdapter(link, contextModelElement, eReference.getName());
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);
	}

}
