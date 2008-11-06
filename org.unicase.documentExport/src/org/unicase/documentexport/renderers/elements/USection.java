package org.unicase.documentexport.renderers.elements;

import java.util.Vector;

import org.unicase.documentexport.documentTemplate.renderers.options.OptionsFactory;
import org.unicase.documentexport.documentTemplate.renderers.options.TextOption;

/**
 * 
 * @author Sebastian Höcht
 */
public class USection extends UCompositeSection {

	private String title = "";
	
	private TextOption option = OptionsFactory.eINSTANCE.createTextOption();

	/**
	 * default constructor.
	 */
	public USection() {
	}
	
	/**
	 * @param title the Title of the section
	 */
	public USection(String title) {
		this.setTitle(title);
	}

	/**
	 * @param title the title of the section
	 * @param option the TextOption which decorates the section numbering and title
	 */
	public USection(String title, TextOption option) {
		this.setTitle(title);
		this.setOption(option);
	}
	
	/**
	 * @param option the TextOption which decorates the section numbering and title
	 */
	public USection(TextOption option) {
		this.setOption(option);
	}
	
	/**
	 * @return all subSections of this section
	 */
	public Vector<USection> getSubSections() {
		Vector<USection> ret = new Vector<USection>();
		
		Vector<UDocument> children = getChildren();	
		for (UDocument child : children) {
			if (child instanceof USection) {
				ret.add((USection)(child));
			}		
		}

		return ret;
	}
	
	/**
	 * @return all paragraphs of this section
	 */
	public Vector<UParagraph> getParagraphs() {
		Vector<UParagraph> ret = new Vector<UParagraph>();
		
		Vector<UDocument> children = getChildren();
		for (UDocument child : children) {
			if (child instanceof UParagraph) {
				ret.add((UParagraph)(child));
			}
		}
		
		return ret;	
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(TextOption option) {
		this.option = option;
	}

	/**
	 * @return the option
	 */
	@Override
	public TextOption getOption() {
		return option;
	}
}
