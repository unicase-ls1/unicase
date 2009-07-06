package org.unicase.docExport.docWriter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UDocument;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.USeperator;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTextPart;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.workspace.util.WorkspaceUtil;

import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;

/**
 * This class is the superclass of all DocWriters that use the iText library for writing
 * an UDocument. Probably there will be DocWriters for PDF, RTF and HTML
 * 
 * @author Sebastian Höcht
 */
public abstract class ITextWriter  {

	/**
	 * Defines the width of the left indention of sections. 
	 * The real width normally is mulitplicated with the depth of the section.
	 */
	public static final int INDENTION_WIDTH = 15;

	private static final String DEFAULT_FONT = FontFactory.HELVETICA;;
	
	/**
	 * The iText document which has to be opened and closed in the subclass.
	 * The doc is used to write some information into the document like text, images, tables
	 * etc.
	 */
	private Document doc = new Document();
	

	/**
	 * @return the doc
	 */
	protected Document getDoc() {
		return doc;
	}


	/**
	 * @param doc the doc to set
	 */
	protected void setDoc(Document doc) {
		this.doc = doc;
	}
	
	/**
	 * Write the root UCompositeSection.
	 * General layout Options have to be rendered here like page numbering, logo etc.
	 * The children of the type USection of uDoc are written as Chapters with increasing
	 * chapter numbers. All other children are also written.
	 * 
	 * @param uDoc the UCompositeSection used to write the doc.
	 * @throws DocumentException when writing a Document, there may be a DocumentException...
	 */
	protected void writeDocument(UCompositeSection uDoc) throws DocumentException {
		if (uDoc.getOption() != null && uDoc.getOption() instanceof LayoutOptions) {

		}
		
		int chapterNumber = 1;
		for (UDocument child : uDoc.getChildren()) {
			if (child instanceof USection) {
				writeSection(doc, (USection)child, chapterNumber);
				chapterNumber++;
			}
			else {
				writeUDocument(doc, child);
			} 
		}
	}
	

	/**
	 * An UCompositeSection is just a container for other UDocument elements. Therefore
	 * this methods iterates through all children and writes them to the document.
	 * 
	 * @param parent the parent iText Object
	 * @param compositeSection the UCompositeSection which shall be written
	 * @throws DocumentException ...
	 */
	protected void writeCompositeSection(Object parent, UCompositeSection compositeSection) throws DocumentException {
		for (UDocument child : compositeSection.getChildren()) {
			writeUDocument(parent, child);
		}
	}

	/**
	 * Writing a section is very fundamental for the structure of a document. This function will be
	 * called recursively because an USection can also have children.
	 * The Problem in this function is the following: iText has three different types of
	 * parents, where an USection can be written:
	 * 1) The iText document itself: you have to create a new Chapter and supply the chapter number
	 * 2) An iText Chapter: you have to use the Chapter::addSection() function 
	 * 3) An iText Section: you have to use the Section::addSection() function
	 * 
	 * @param parent the parent iText Object
	 * @param child the USection that shall be written in this function
	 * @param chapterNumber -
	 * @throws DocumentException -
	 */
	protected void writeSection(Object parent, USection child, int chapterNumber) throws DocumentException {
		
		if (parent instanceof Document) {
			UParagraph titleUParagraph = child.getTitlParagraph();
			
			Paragraph chapterP = getParagraph(titleUParagraph);

			Chapter chapter = new Chapter(chapterP, chapterNumber);
			chapter.setNumberDepth(0);
			chapter.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);
			chapter.setTriggerNewPage(false);		
			
			
			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(chapter, subChild);
			}

			((Document)parent).add(chapter);		
		}
		else if (parent instanceof Chapter) {
			UParagraph titleUParagraph = child.getTitlParagraph();
			
			Paragraph chapterP = getParagraph(titleUParagraph);			
			
			Chapter chapter = (Chapter) parent;
			Section subSection = chapter.addSection(chapterP);
			subSection.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);

			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(subSection, subChild);
			}
		}
		else if (parent instanceof Section) {
			UParagraph titleUParagraph = child.getTitlParagraph();
			
			Paragraph chapterP = getParagraph(titleUParagraph);			
			
			Section section = (Section) parent;
			Section subSection = section.addSection(chapterP);
			subSection.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);

			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(subSection, subChild);
			}			
		} else {
			WorkspaceUtil.log(
					"unkown parent of USection: " + parent.getClass(),
					new Exception(),
					IStatus.WARNING
				);
		}
	}

	/**
	 * Check the type of the uDoc and use the correct function to write it.
	 * @param parent the iText parent Object where the uDoc shall be written
	 * @param uDoc the UDocument which shall be written
	 * @throws DocumentException -
	 */
	protected void writeUDocument(Object parent, UDocument uDoc) throws DocumentException {
		if (uDoc instanceof USection) {
			writeSection(parent, (USection)uDoc, 0);
		} else if (uDoc instanceof UTable) {
			writeTable(parent, (UTable)uDoc);
		} else if (uDoc instanceof UParagraph) {
			writeParagraph(parent, (UParagraph)uDoc);
		} else if (uDoc instanceof UCompositeSection) {
			writeCompositeSection(parent, (UCompositeSection)uDoc);
		} else if (uDoc instanceof UList){
			writeList(parent, (UList) uDoc);
		} else if (uDoc instanceof UTextPart){
			writeTextPart(parent, (UTextPart) uDoc);
		} else if (uDoc instanceof USeperator){
			writeSeperator(parent, (USeperator) uDoc);
		} else {
			WorkspaceUtil.log(
					"there is no handler for the UDocument type " + uDoc.getClass(), 
					new Exception(), 
					IStatus.WARNING
				);
		}
	}

	/**
	 * write a simple horizontal seperator to the document. Probably this will be
	 * a single horizontal line.
	 * @param parent the iText parent object
	 * @param seperator the seperator object to write
	 * @throws DocumentException -
	 */
	protected abstract void writeSeperator(Object parent, USeperator seperator) throws DocumentException;


	/**
	 * Write an UParagraph to an iText parent. The type of the parent has to be checked,
	 * because there is no super class or interface in iText ...
	 * 
	 * @param parent the iText parent object
	 * @param child the UParagraph to write
	 * @throws DocumentException -
	 */
	protected void writeParagraph(Object parent, UParagraph child) throws DocumentException {
		Paragraph paragraph = getParagraph(child.getText(), child.getOption(), child.getIndentionLeft());
		
		addItextObject(parent, paragraph);
	}
	
	/**
	 * Write an UTextPart to an iText parent. The type of the parent has to be checked,
	 * because there is no super class or interface in iText ...
	 * 
	 * @param parent the iText parent object
	 * @param child the UParagraph to write
	 * @throws DocumentException -
	 */
	protected void writeTextPart(Object parent, UTextPart child) throws DocumentException {
		Chunk chunk =  new Chunk(child.getText(), getFont(child.getOption()));
		
		addItextObject(parent, chunk);
	}	
	
	/**
	 * 
	 * @param parent the iText parent object
	 * @param uList the uList with the information how to write the list
	 * @throws DocumentException -
	 */
	protected void writeList(Object parent, UList uList) throws DocumentException {
		
		ListStyle listStyle = uList.getListOption().getListStyle();
		if (listStyle == ListStyle.BULLETED) {
			List list = new List(false);
			list.setIndentationLeft(INDENTION_WIDTH  * uList.getIndentionLeft());
			for (String text : uList.getContents()) {
				list.add(text);
			}
			addItextObject(parent, list);
		} else if (listStyle == ListStyle.ALPHA) {
			List list = new List(true, true);
			list.setIndentationLeft(INDENTION_WIDTH  * uList.getIndentionLeft());
			for (String text : uList.getContents()) {
				list.add(text);
			}
			addItextObject(parent, list);
		} else if (listStyle == ListStyle.NUMBERED) {
			List list = new List(true);
			list.setIndentationLeft(INDENTION_WIDTH  * uList.getIndentionLeft());
			for (String text : uList.getContents()) {
				list.add(text);
			}
			addItextObject(parent, list);
		} else if (listStyle == ListStyle.JUST_NEW_LINES) {
			for (String text : uList.getContents()) {
				Paragraph par = new Paragraph(text);
				par.setIndentationLeft(INDENTION_WIDTH * uList.getIndentionLeft());
				addItextObject(parent, par);
			}
		} else if (listStyle == ListStyle.SEPERATED_LIST) {
			String text = "";
			for (String innerText : uList.getContents()) {
				text += innerText + ", ";
			}
			if (text.length() > 3) {
				text = text.substring(0, text.length() -3);
			}
			
			Paragraph par = new Paragraph(text);
			par.setIndentationLeft(INDENTION_WIDTH * uList.getIndentionLeft());
			addItextObject(parent, par);
		} else {
			WorkspaceUtil.log(
					"The ListStyle " + listStyle.getLiteral() + " hasn't been implemented yet",
					new Exception(), 
					IStatus.WARNING
				);
		}

	}
	
	/**
	 * Write a table to the parent. Writing a table isn't easy with iText, because there is no
	 * minimal super class of a Table which could be used in all document types (HTML, PDF, RTF etc.)
	 * Therefore this method has to be implemented in the subclass.
	 * An UTable can have some RendererOptions.
	 * 
	 * @param parent the iText parent object
	 * @param child the UTable to write to the parent
	 * @throws DocumentException -
	 */
	protected abstract void writeTable(Object parent, UTable child) throws DocumentException;
	


	
	
	/**
	 * @see ITextWriter#getParagraph(String, TextOption, int)
	 * 
	 * @param text the text which shall be written
	 * @param option the option containing font information
	 * @return the iText paragraph
	 */
	protected Paragraph getParagraph(String text, TextOption option) {
		return getParagraph(text, option, 0);
	}
	
	/**
	 * Returns a new iText Paragraph which look is decorated by the TextoOption and
	 * the depth of the indention.
	 * 
	 * @param text The text (content) of the Paragraph
	 * @param option some TextOption which can decorate the look of the text
	 * @param indentionLeft the depth of the indention
	 * @return a new iText Paragraph
	 */
	protected Paragraph getParagraph(String text, TextOption option, int indentionLeft) {
		Paragraph ret = new Paragraph(text, getFont(option));
		ret.setIndentationLeft(indentionLeft * INDENTION_WIDTH);
		return ret;
	}		

	/**
	 * Returns a new iText Paragraph which look is decorated by the TextoOption and
	 * the depth of the indention. Additionally, UTextParts are added as chunks of the Paragraph,
	 * if there are UTextParts contained in this UParagraph (same with UParagraph as child)
	 * 
	 * @param paragraph the paragraph containting the information to write
	 * @return a new iText Paragraph
	 * @throws DocumentException -
	 */
	protected Paragraph getParagraph(UParagraph paragraph) throws DocumentException {
		Paragraph ret = new Paragraph(paragraph.getText(), getFont(paragraph.getOption()));
		for (UDocument child : paragraph.getChildren()) {
			if (child instanceof UParagraph) {
				writeParagraph(ret, (UParagraph) child);
			} else if (child instanceof UTextPart) {
				writeTextPart(ret, (UTextPart) child);
			} else if (child instanceof UImage) {
				BufferedImage image = convertToAWT(((UImage) child).getImage().getImageData());
				
				try {
					Image image2 = Image.getInstance(image, null);
					image2.setAlignment(Image.LEFT | Image.UNDERLYING);
					int indentionLeft = ((UImage) child).getIndentionLeft();
					image2.setIndentationLeft(indentionLeft);
					
					
					ret.add(image2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				WorkspaceUtil.log(
						"Only UParagraph and UTextPart are possible children of an UParagraph", 
						new Exception(), 
						IStatus.WARNING
					);
			}
		}
		ret.setIndentationLeft(paragraph.getIndentionLeft() * INDENTION_WIDTH);
		return ret;
	}		
	
	/**
	 * Returns an iText Font using the information in the TextOption.
	 * 
	 * @param option the TextOption which contains size, font-family, color etc. information.
	 * @return the iText Font
	 */
	protected Font getFont(TextOption option) {
		if (option == null) {
			WorkspaceUtil.log(
					"The TextOption is null - Helvetica will be used. This shouldn't happen!", 
					new Exception(), 
					IStatus.ERROR
				);
			return FontFactory.getFont(FontFactory.HELVETICA);
		}
		Font font = FontFactory.getFont(getFontName(option), option.getFontSize(), (Color)option.getFontColor());
		font.setStyle(getFontStyle(option));
		return font;
	}
	
	/**
	 * Returns the iText Font style bitmap using the information of the TextOption.
	 * 
	 * @param option contains some Font style information.
	 * @return the iText Font style bitmap.
	 */
	protected int getFontStyle(TextOption option) {
		int style;
		if (!option.isBold()) {
			style = Font.NORMAL;
		} else  {
			style = Font.BOLD;
		}	
		if (option.isUnderline()) {
			style |= Font.UNDERLINE;
		}
				
		return style;
	}
	
	/**
	 * Returns the iText FontName constant of the font-family store in the TextOption.
	 * The font Family default to DEFAULT_FONT it the font-family is unknown or empty
	 * 
	 * @param option the TextOption containing the font-family information
	 * @return the iText FontName
	 */
	protected String getFontName(TextOption option) {
		if (option.getFontFamily() == FontFamily.HELVETICA) {
			return FontFactory.HELVETICA;
		} else if (option.getFontFamily() == FontFamily.TIMES_NEW_ROMAN) {
			return FontFactory.TIMES_ROMAN;
		} else if (option.getFontFamily() == FontFamily.VERDANA) {
			return FontFactory.COURIER;
		} else if (option.getFontFamily() == FontFamily.ARIAL) {
			return FontFactory.HELVETICA;
		}
		
			WorkspaceUtil.log(
					"Unknown Font family: " + option.getFontFamily().getLiteral() +
						". The default font will be used.", 
					new Exception(), 
					IStatus.WARNING
				);
			
		return DEFAULT_FONT;
	}
	
	/**
	 * 
	 * @param parent the iText parent object
	 * @param toAdd the iText object, which shall be added
	 * @throws DocumentException -
	 */
	protected void addItextObject(Object parent, Object toAdd) throws DocumentException {
		if (parent instanceof Document) {
			Paragraph container = new Paragraph();
			container.add(toAdd);
			((Document)parent).add(container);
		} else if (parent instanceof Chapter) {
			((Chapter)parent).add(toAdd);
		} else if (parent instanceof Section) {
			((Section)parent).add(toAdd);
		} else if (parent instanceof Paragraph) {
			((Paragraph)parent).add(toAdd);
		} else {
			WorkspaceUtil.log(
					"The parent of the type " + parent.getClass().getSimpleName() + " " +
							"can't be used here. Nothing will be written to the document.", 
					new Exception(), 
					IStatus.ERROR
				);
		}	
	}

	
	
	/**
	 * 
	 * @param data hacked
	 * @return hacked
	 */
	//hack code copied from java examples web page
	  public static BufferedImage convertToAWT(ImageData data) {
		    ColorModel colorModel = null;
		    PaletteData palette = data.palette;
		    if (palette.isDirect) {
		      colorModel = new DirectColorModel(data.depth, palette.redMask,
		          palette.greenMask, palette.blueMask);
		      BufferedImage bufferedImage = new BufferedImage(colorModel,
		          colorModel.createCompatibleWritableRaster(data.width,
		              data.height), false, null);
		      WritableRaster raster = bufferedImage.getRaster();
		      int[] pixelArray = new int[3];
		      for (int y = 0; y < data.height; y++) {
		        for (int x = 0; x < data.width; x++) {
		          int pixel = data.getPixel(x, y);
		          RGB rgb = palette.getRGB(pixel);
		          pixelArray[0] = rgb.red;
		          pixelArray[1] = rgb.green;
		          pixelArray[2] = rgb.blue;
		          raster.setPixels(x, y, 1, 1, pixelArray);
		        }
		      }
		      return bufferedImage;
		    } else {
		      RGB[] rgbs = palette.getRGBs();
		      byte[] red = new byte[rgbs.length];
		      byte[] green = new byte[rgbs.length];
		      byte[] blue = new byte[rgbs.length];
		      for (int i = 0; i < rgbs.length; i++) {
		        RGB rgb = rgbs[i];
		        red[i] = (byte) rgb.red;
		        green[i] = (byte) rgb.green;
		        blue[i] = (byte) rgb.blue;
		      }
		      if (data.transparentPixel != -1) {
		        colorModel = new IndexColorModel(data.depth, rgbs.length, red,
		            green, blue, data.transparentPixel);
		      } else {
		        colorModel = new IndexColorModel(data.depth, rgbs.length, red,
		            green, blue);
		      }
		      BufferedImage bufferedImage = new BufferedImage(colorModel,
		          colorModel.createCompatibleWritableRaster(data.width,
		              data.height), false, null);
		      WritableRaster raster = bufferedImage.getRaster();
		      int[] pixelArray = new int[1];
		      for (int y = 0; y < data.height; y++) {
		        for (int x = 0; x < data.width; x++) {
		          int pixel = data.getPixel(x, y);
		          pixelArray[0] = pixel;
		          raster.setPixel(x, y, pixelArray);
		        }
		      }
		      return bufferedImage;
		    }
		  }
}
