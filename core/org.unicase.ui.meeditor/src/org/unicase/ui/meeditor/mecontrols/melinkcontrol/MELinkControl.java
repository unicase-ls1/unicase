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
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.ModelElement;
import org.unicase.model.NonDomainElement;
import org.unicase.model.attachment.UrlAttachment;
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
	private ILabelProviderListener labelProviderListener;
	private ImageHyperlink imageHyperlink;
	private ImageHyperlink urlHyperlink;

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
		linkComposite.setLayout(new GridLayout(3 + getNumberOfAdditionalControlComponents(), false));
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
		list.add((ModelElement) getModelElement());
		observer = new ModelElementChangeObserver() {

			@Override
			protected void onNotify(Notification notification, ModelElement element) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						if (!hyperlink.isDisposed()) {
							hyperlink.setText(((ModelElement) getModelElement()).getShortName());
							hyperlink.setToolTipText(((ModelElement) getModelElement()).getShortName());
							updateAdditionalControlComponents();
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
		imageHyperlink = getToolkit().createImageHyperlink(linkComposite, style);
		imageHyperlink.setImage(image);
		imageHyperlink.setData(getModelElement().eClass());
		ModelElementClassTooltip.enableFor(imageHyperlink);
		hyperlink = getToolkit().createHyperlink(linkComposite, ((ModelElement) getModelElement()).getShortName(),
			style);
		hyperlink.setToolTipText(((ModelElement) getModelElement()).getShortName());
		IHyperlinkListener listener = new MEHyperLinkAdapter((ModelElement) getModelElement(),
			(ModelElement) contextModelElement, reference.getName());
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);

		setupAdditionalControlComponents(style);

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
	 * Set up additional controls to the left of the default link
	 * 
	 * @param style Style
	 */
	private void setupAdditionalControlComponents(int style) {
		if (((ModelElement) getModelElement()).eClass().getInstanceClass().equals(UrlAttachment.class)) {
			urlHyperlink = getToolkit().createImageHyperlink(linkComposite, style);
			Image launchImage = org.unicase.ui.meeditor.Activator.getImageDescriptor("icons/world_link.png")
				.createImage();
			urlHyperlink.setImage(launchImage);

			String url = ((UrlAttachment) getModelElement()).getUrl();
			if (url == null) {
				url = "";
			}
			urlHyperlink.setToolTipText(url);
			urlHyperlink.addHyperlinkListener(new HyperlinkAdapter() {
				@Override
				public void linkActivated(HyperlinkEvent event) {
					String url = ((UrlAttachment) getModelElement()).getUrl();
					if (url == null)
						return;
					Program.launch(url);
					super.linkActivated(event);
				}
			});
		}
	}

	/**
	 * Get the number of additional control elements to the left of the default link
	 * 
	 * @return Number of controls
	 */
	private int getNumberOfAdditionalControlComponents() {
		if (((ModelElement) getModelElement()).eClass().getInstanceClass().equals(UrlAttachment.class))
			return 1;
		return 0;
	}

	/**
	 * Pass change notification to additional control components
	 */
	private void updateAdditionalControlComponents() {
		if ((urlHyperlink != null) && (!urlHyperlink.isDisposed())) {
			String url = ((UrlAttachment) getModelElement()).getUrl();
			if (url == null) {
				url = "";
			}
			urlHyperlink.setToolTipText(url);
		}
	}

	private void updateIcon() {
		imageHyperlink.setImage(labelProvider.getImage(getModelElement()));
	}

	/**
	 * Disposes the Composite of this {@link MELinkControl}.
	 */
	@Override
	public void dispose() {
		((ModelElement) getModelElement()).getProject().removeProjectChangeObserver(observer);
		labelProvider.removeListener(labelProviderListener);
		labelProvider.dispose();
		if (linkComposite != null) {
			linkComposite.dispose();
		}
	}
}
