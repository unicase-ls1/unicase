/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import java.util.ArrayList;
import java.util.Vector;

import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.SectionOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * A basic section which can be nested by any depth. This element should be used for all document structuring, because
 * depending on the DocWriter specific document structuring element will be used automatically.
 * 
 * @author Sebastian Hoecht
 */
public class USection extends UCompositeSection {

	private static final int SECTION_NUMBER_DEFAULT = 1;
	private static final int SECTION_DEPTH_DEFAULT = 0;
	private UParagraph titleParagraph;
	private int sectionNumber = SECTION_NUMBER_DEFAULT;
	private int depth = SECTION_DEPTH_DEFAULT;
	private SectionOption sectionOption = OptionsFactory.eINSTANCE.createSectionOption();

	private int indentionLeft;

	/**
	 * default constructor.
	 */
	public USection() {
	}

	/**
	 * @param title the Title of the section
	 */
	public USection(String title) {
		this.titleParagraph = new UParagraph(title);
	}

	/**
	 * @param title the title of the section
	 * @param option the TextOption which decorates the section numbering and title
	 */
	public USection(String title, TextOption option) {
		this.titleParagraph = new UParagraph(title);
		titleParagraph.setOption(option);
	}

	/**
	 * WARNING: The LayoutOption SectionTextOption normally will be used instead of the TextOption of this Paragraph!
	 * 
	 * @param title the Paragraph of the title
	 */
	public USection(UParagraph title) {
		this.titleParagraph = title;
	}

	/**
	 * @return all subSections of this section
	 */
	public Vector<USection> getSubSections() {
		Vector<USection> ret = new Vector<USection>();

		Vector<UDocument> children = getChildren();
		for (UDocument child : children) {
			if (child instanceof USection) {
				ret.add((USection) (child));
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
				ret.add((UParagraph) (child));
			}
		}

		return ret;
	}

	/**
	 * @param paragraph the UParagraph of the title to set
	 */
	public void setTitle(UParagraph paragraph) {
		this.titleParagraph = paragraph;
	}

	/**
	 * @return the UParagraph title
	 */
	public UParagraph getTitlParagraph() {
		return titleParagraph;
	}

	/**
	 * @param doc the UDocument which shall be appended as a child.
	 */
	@Override
	public void add(UDocument doc) {

		if (doc instanceof USection) {
			((USection) doc).setSectionNumber(getSectionCount() + 1);
			((USection) doc).setDepth(depth + 1);
		}

		getChildren().add(doc);

		doc.setParent(this);
	}

	private int getSectionCount() {
		Vector<UDocument> children = getChildren();

		int sectionCount = 0;

		for (UDocument child : children) {
			if (child instanceof USection) {
				sectionCount++;
			}
		}

		return sectionCount;
	}

	/**
	 * @return the sectionNumber
	 */
	public int getSectionNumber() {
		return sectionNumber;
	}

	/**
	 * set the sectionNumber.
	 * 
	 * @param number the new section number
	 */
	public void setSectionNumber(int number) {
		sectionNumber = number;
	}

	/**
	 * returns the section number of this section as a string depending on the sectionOption.
	 * 
	 * @return the sectionNumber (i.e. 1 or A or I)
	 */
	public String getSectionNumberAsString() {
		SectionNumberingStyle style = getSectionOption().getSectionNumberingStyle();
		if (style.equals(SectionNumberingStyle.ALPHA)) {
			return String.valueOf(((char) (sectionNumber + 64))) + ")";
		} else if (style.equals(SectionNumberingStyle.NONE)) {
			return "";
		} else {
			return String.valueOf(sectionNumber);
		}
	}

	/**
	 * @return a string like 2.4.1
	 */
	public String getFullSectionNumbering() {

		ArrayList<String> numbers = new ArrayList<String>();

		// The first section doesn't get numbered, because the root
		// model element is always the first section, which only occurs once..
		// so the first section is the document title
		// if (getParent() instanceof USection) {
		// numbers.add(getSectionNumberAsString());
		// }

		UDocument parent = this;
		while (parent != null && parent instanceof USection) {
			USection section = (USection) parent;
			if (parent.getParent() instanceof USection) {
				if (!section.getSectionNumberAsString().equals("")) {
					numbers.add(section.getSectionNumberAsString());
				}
			}
			parent = parent.getParent();

			if (section.getSectionOption().isLeaveOutPreviousSectionNumbering()) {
				break;
			}
		}

		String ret = "";

		for (int i = numbers.size() - 1; i >= 0; i--) {
			ret += String.valueOf(numbers.get(i)) + ".";
		}

		if (ret.length() > 1) {
			ret = ret.substring(0, ret.length() - 1);
		}
		return (ret);
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param sectionOption the sectionOption to set
	 */
	public void setSectionOption(SectionOption sectionOption) {
		this.sectionOption = sectionOption;
	}

	/**
	 * @return the sectionOption
	 */
	public SectionOption getSectionOption() {
		return sectionOption;
	}

	/**
	 * @param indentionLeft the indentionLeft to set
	 */
	public void setIndentionLeft(int indentionLeft) {
		this.indentionLeft = indentionLeft;
	}

	/**
	 * @return the indentionLeft
	 */
	public int getIndentionLeft() {
		return indentionLeft;
	}
}
