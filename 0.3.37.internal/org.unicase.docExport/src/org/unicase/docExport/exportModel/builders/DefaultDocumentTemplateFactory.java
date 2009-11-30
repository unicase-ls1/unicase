/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.builders;

import org.unicase.docExport.exportModel.DocumentTemplateFactory;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.UColor;

/**
 * This class create a new DocumentTemplate. Therefore all available ModelElement types have to be added. For each
 * ModelElement type, a DefaultModelElementRenderer is created. The default LayoutOptions are set. This is a factory
 * method design pattern.
 */
public final class DefaultDocumentTemplateFactory {

	private DefaultDocumentTemplateFactory() {
	}

	/**
	 * Build Pattern: Builds a Default Template. Create the default LayoutOptions and fills the list of
	 * modelELementRenderers with DefaultModelElementRenderers.
	 * 
	 * @return a new Template
	 */
	public static Template build() {
		Template template = DocumentTemplateFactory.eINSTANCE.createTemplate();

		LayoutOptions layoutOptions = OptionsFactory.eINSTANCE.createLayoutOptions();
		template.setLayoutOptions(layoutOptions);

		UColor darkBlue = OptionsFactory.eINSTANCE.createUColor();
		darkBlue.setBlue(90);
		darkBlue.setGreen(40);
		darkBlue.setRed(0);

		layoutOptions.setHeaderText("Chair for Applied Software Engineering \n DOLLI2-Project");
		layoutOptions.getHeaderTextOption().setFontFamily(FontFamily.HELVETICA);
		layoutOptions.getHeaderTextOption().setFontSize(10);
		layoutOptions.getHeaderTextOption().setBold(true);

		layoutOptions.getSectionTextOption().setBold(true);
		layoutOptions.getSectionTextOption().setFontSize(20);
		layoutOptions.getSectionTextOption().setFontColor(darkBlue);

		layoutOptions.getModelElementTextOption().setFontSize(12);
		layoutOptions.getModelElementTextOption().setBold(true);
		layoutOptions.getModelElementTextOption().setFontColor(darkBlue);

		layoutOptions.getDefaultTextOption().setFontSize(10);

		layoutOptions.setHideAnnotations(true);
		layoutOptions.setHideAttachments(true);
		layoutOptions.setHideIncomingDocumentReferences(true);

		layoutOptions.getDocumentTitleTextOption().setFontSize(24);
		layoutOptions.getDocumentTitleTextOption().setTextAlign(TextAlign.CENTER);
		layoutOptions.getDocumentTitleTextOption().setBold(true);

		return template;
	}
}
