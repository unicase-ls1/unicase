/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.unicase.ui.meeditor.Activator;

import com.onpositive.richtexteditor.io.html.DefaultHTMLLoader;
import com.onpositive.richtexteditor.model.ISimpleRichTextModel;
import com.onpositive.richtexteditor.viewer.RichTextViewer;

/**
 * A RichTextViewer for unicase.
 * 
 * @author shterev
 */
public class UnicaseRichTextViewer extends RichTextViewer {

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent composite
	 * @param style the style
	 */
	public UnicaseRichTextViewer(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Sets the input string as the html input for the viewer.
	 * 
	 * @param html the input.
	 */
	public void setHTML(String html) {
		DefaultHTMLLoader loader = new DefaultHTMLLoader(getLayerManager());
		ISimpleRichTextModel model = loader.parse(html);
		changeDocument(model);
	}

	/**
	 * @return the plain text from this viewer.
	 */
	public String getPlainText() {
		return getDocument().get().replaceAll("\\<.*?\\>", "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initActions() {
		if (configuration.isCreateToolbar()) {
			fillToolbarManager(toolbarManager);
		}
	}

	private void fillToolbarManager(IContributionManager toolbarManager) {
		// List<IContributionItem> itemsList = createActionsList();
		// for (Iterator iterator = itemsList.iterator(); iterator.hasNext();) {
		// IContributionItem contributionItem = (IContributionItem) iterator.next();
		// toolbarManager.add(contributionItem);
		// }

		IAction boldAction = super.factory.getBoldAction();
		ImageDescriptor imageDescriptorBold = Activator.getImageDescriptor("icons/text_bold.png");
		boldAction.setImageDescriptor(imageDescriptorBold);
		toolbarManager.add(boldAction);

		IAction italicAction = super.factory.getItalicAction();
		ImageDescriptor imageDescriptorItalic = Activator.getImageDescriptor("icons/text_italic.png");
		italicAction.setImageDescriptor(imageDescriptorItalic);
		toolbarManager.add(italicAction);

		IAction strikeThroughAction = super.factory.getStrikeThroughAction();
		ImageDescriptor imageDescriptorStrikethrough = Activator.getImageDescriptor("icons/text_strikethrough.png");
		strikeThroughAction.setImageDescriptor(imageDescriptorStrikethrough);
		toolbarManager.add(strikeThroughAction);

		toolbarManager.add(new Separator());

		// IAction newLinkAction = super.factory.getNewLinkAction();
		// ImageDescriptor imageDescriptorLink = Activator.getImageDescriptor("icons/text_link.png");
		// newLinkAction.setImageDescriptor(imageDescriptorLink);
		// toolbarManager.add(newLinkAction);

		IAction bulletedListAction = super.factory.getBulletedListAction();
		ImageDescriptor imageDescriptorBullets = Activator.getImageDescriptor("icons/text_list_bullets.png");
		bulletedListAction.setImageDescriptor(imageDescriptorBullets);
		toolbarManager.add(bulletedListAction);

		// IAction numberedListAction = super.factory.getNumberedListAction();
		// ImageDescriptor imageDescriptorNumbers = Activator.getImageDescriptor("icons/text_list_numbers.png");
		// numberedListAction.setImageDescriptor(imageDescriptorNumbers);
		// toolbarManager.add(numberedListAction);

		toolbarManager.add(new Separator());

		// IContributionItem styleContributionItem = factory.getStyleContributionItem();
		// toolbarManager.add(styleContributionItem);

		IAction foregroundColorAction = super.factory.getForegroundColorAction();
		toolbarManager.add(foregroundColorAction);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected StyledText createTextWidget(Composite parent, int styles) {
		return super.createTextWidget(parent, styles | SWT.BORDER);
	};

}
