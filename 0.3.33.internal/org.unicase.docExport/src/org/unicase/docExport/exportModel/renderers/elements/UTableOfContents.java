/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * A Table Of Contents which is automatically generated from an USection.
 * 
 * @see USection
 * @author Sebastian Hoecht
 */
public class UTableOfContents extends UDocument {

	private USection rootSection;
	private TextOption textOption = OptionsFactory.eINSTANCE.createTextOption();

	/**
	 * @param rootSection the rootSection where the table of content begins
	 * @param textOption the textOption which decorates the text
	 */
	public UTableOfContents(USection rootSection, TextOption textOption) {
		this.rootSection = rootSection;
		this.textOption = textOption;
	}

	/**
	 * @param rootSection the rootSection to set
	 */
	public void setRootSection(USection rootSection) {
		this.rootSection = rootSection;
	}

	/**
	 * @return the rootSection
	 */
	public USection getRootSection() {
		return rootSection;
	}

	/**
	 * @param textOption the textOption to set
	 */
	public void setTextOption(TextOption textOption) {
		this.textOption = textOption;
	}

	/**
	 * @return the textOption
	 */
	public TextOption getTextOption() {
		return textOption;
	}
}
