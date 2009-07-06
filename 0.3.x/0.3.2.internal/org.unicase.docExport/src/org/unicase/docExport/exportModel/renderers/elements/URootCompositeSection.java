package org.unicase.docExport.exportModel.renderers.elements;

import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;


/**
 * 
 * @author Sebastian Höcht
 *
 */
public class URootCompositeSection extends UCompositeSection {

	private LayoutOptions option;
	/**
	 * @return the layout options of the document.
	 */
	public LayoutOptions getLayoutOptions() {
		return option;
	}
	
	/**
	 * @param option the option to set
	 */
	public void setLayoutOptions(LayoutOptions option) {
		this.option = option;
	}
	
}
