package org.unicase.documentexport.renderers.elements;

import java.util.Vector;

import org.unicase.documentexport.renderers.options.TextOption;

public class USection extends UCompositeSection {

	private String title = "";
	
	public TextOption option;

	public USection() {
		
	}
	
	public USection(String title) {
		this.title = title;
	}

	public USection(String title, TextOption option) {
		this.setTitle(title);
		this.option = option;
	}
	
	public USection(TextOption option) {
		this.option = option;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
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
}
