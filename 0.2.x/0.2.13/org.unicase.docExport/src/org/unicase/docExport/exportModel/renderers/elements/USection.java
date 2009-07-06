package org.unicase.docExport.exportModel.renderers.elements;

import java.util.Vector;

import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * 
 * @author Sebastian Höcht
 */
public class USection extends UCompositeSection {

	private static final int DEPTH_DEFAULT = 0;
	private String title = "";
	private UParagraph titleParagraph;
	private int depth = DEPTH_DEFAULT;
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
		this.titleParagraph= new UParagraph(title);
		this.setTitle(title);
	}

	/**
	 * @param title the title of the section
	 * @param option the TextOption which decorates the section numbering and title
	 */
	public USection(String title, TextOption option) {
		this.titleParagraph = new UParagraph(title);
		titleParagraph.setOption(option);
		this.setTitle(title);
	}
	
	/**
	 * WARNING: The LayoutOption SectionTextOption normally will be used instead of the
	 * TextOption of this Paragraph!
	 * 
	 * @param title the Paragraph of the title
	 */
	public USection(UParagraph title) {
		this.titleParagraph = title;
		this.option = titleParagraph.getOption();
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
	
	/**
	 * @param doc the UDocument which shall be appended as a child.
	 */
	@Override
	public void add(UDocument doc) {
		getChildren().add(doc);
		if (doc instanceof USection)  {
			((USection) doc).setDepth(this.depth + 1);
		}
		
		doc.setParent(this);
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
}
