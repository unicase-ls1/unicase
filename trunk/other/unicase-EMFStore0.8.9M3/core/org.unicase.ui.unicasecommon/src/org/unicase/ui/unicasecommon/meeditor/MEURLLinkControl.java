/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.utilities.ExtProgramFactoryFacade;
import org.eclipse.emf.ecp.editor.Activator;
import org.eclipse.emf.ecp.editor.ModelElementChangeListener;
import org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MELinkControl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
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

	private ModelElementChangeListener modelElementChangeListener2;

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
					EObject urlAttachement = link;
					ModelElementId contextModelElementId = ModelUtil.getProject(contextModelElement).getModelElementId(
						contextModelElement);
					ModelElementId urlModelElementId = ModelUtil.getProject(urlAttachement).getModelElementId(
						urlAttachement);
					MEURLControl.logEvent(contextModelElementId, urlModelElementId,
						WorkspaceManager.getProjectSpace(urlAttachement), "org.unicase.ui.meeditor");
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
	}

}
