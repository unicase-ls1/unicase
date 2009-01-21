package org.unicase.docExport.exportModel.renderers.elements;

import java.awt.Color;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This class represents a table in the renderer.
 * 
 * @author Sebastian Höcht
 */
public class UTable extends UCompositeSection {


	private BoxModelOption defaultCellBoxModel = OptionsFactory.eINSTANCE.createBoxModelOption();
	private int widthPercentage = 90;
	
	private float[] columnsWidths;

	private int columnsCount = 2;
	private ArrayList<UTableCell> entries = new ArrayList<UTableCell>();
	
	/**
	 * @param columnCount the amount of columns of this table
	 */
	public UTable(int columnCount) {
		this.setColumnsCount(columnCount);
		this.getBoxModel().setBackgroundColor(new Color(255, 255, 255));
		defaultCellBoxModel.setBackgroundColor(new Color(255, 255, 255));
	}
	
	/**
	 * @param entry the entry (cell) which shall be added to the table
	 */
	public void addCell(UTableCell entry) {
		entries.add(entry);
	}
	
	/**
	 * Adds an UEntry containing the text.
	 * @param text the content of the UEntry
	 */
	public void addCell(String text) {
		UTableCell uEntry = new UTableCell(text);
		uEntry.setBoxModel(defaultCellBoxModel);
		entries.add(uEntry);
	}
	
	
	/**
	 * Adds an UEntry containing the text.
	 * @param text the content of the UEntry
	 * @param option the TextOption which decorates the Text
	 */
	public void addCell(String text, TextOption option) {
		UTableCell uEntry = new UTableCell(text, option);
		entries.add(uEntry);
	}
	
	/**
	 * Adds an UEntry containing the text.
	 * @param paragraph the paragraph containing the text of the new entry
	 */
	public void addCell(UParagraph paragraph) {
		UTableCell uEntry = new UTableCell(paragraph.getText(), paragraph.getOption());

		entries.add(uEntry);
	}	
	
	/**
	 * @return all entries in this table
	 */
	public ArrayList<UTableCell> getEntries() {
		return entries;
	}

	/**
	 * @param columnsCount the columnsCount to set
	 */
	public void setColumnsCount(int columnsCount) {
		this.columnsCount = columnsCount;
	}

	/**
	 * @return the columnsCount
	 */
	public int getColumnsCount() {
		return columnsCount;
	}	

	/**
	 * @return the widthPercentage
	 */
	public int getWidthPercentage() {
		return widthPercentage;
	}

	/**
	 * @param widthPercentage the widthPercentage to set
	 */
	public void setWidthPercentage(int widthPercentage) {
		this.widthPercentage = widthPercentage;
	}
	

	/**
	 * @return the columnsWidths
	 */
	public float[] getColumnsWidths() {
		if (columnsWidths == null) {
			return new float[] {};
		}
		return columnsWidths;
	}

	/**
	 * @param columnsWidths the columnsWidths to set
	 */
	public void setColumnsWidths(float[] columnsWidths) {
		if (columnsWidths.length != columnsCount) {
			WorkspaceUtil.log(
					"the widths array must contain " + columnsCount + " entires", 
					new Exception(), 
					IStatus.WARNING
				);
			return;
		}
		this.columnsWidths = columnsWidths;
	}

	/**
	 * @param defaultCellBoxModel the defaultCellBoxModel to set
	 */
	public void setDefaultCellBoxModel(BoxModelOption defaultCellBoxModel) {
		this.defaultCellBoxModel = defaultCellBoxModel;
	}

	/**
	 * @return the defaultCellBoxModel
	 */
	public BoxModelOption getDefaultCellBoxModel() {
		return defaultCellBoxModel;
	}

}
