package org.unicase.docExport.exportModel.renderers.elements;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This class represents a table in the renderer.
 * 
 * @author Sebastian Höcht
 */
public class UTable extends UCompositeSection {

	private static final int BORDER_DEFAULT = 0;
	private float borderLeft = BORDER_DEFAULT;
	private float borderBottom = BORDER_DEFAULT;
	private float borderRight = BORDER_DEFAULT;
	private float borderTop = BORDER_DEFAULT;
	
	private float cellBorderLeft = 1;
	private float cellBorderRight = 1;
	private float cellBorderTop = 1;
	private float cellBorderBottom = 1;
	
	private int widthPercentage = 90;
	
	private float[] columnsWidths;

	private int columnsCount = 2;
	private ArrayList<UEntry> entries = new ArrayList<UEntry>();
	
	/**
	 * @param columnCount the amount of columns of this table
	 */
	public UTable(int columnCount) {
		this.setColumnsCount(columnCount);
	}
	
	/**
	 * @param entry the entry (cell) which shall be added to the table
	 */
	public void addEntry(UEntry entry) {
		entries.add(entry);
	}
	
	/**
	 * Adds an UEntry containing the text.
	 * @param text the content of the UEntry
	 */
	public void addEntry(String text) {
		UEntry uEntry = new UEntry(text);
		uEntry.setBorderLeft(cellBorderLeft);
		uEntry.setBorderRight(cellBorderRight);
		uEntry.setBorderTop(cellBorderTop);
		uEntry.setBorderBottom(cellBorderBottom);

		entries.add(uEntry);
	}
	
	/**
	 * Adds an UEntry containing the text.
	 * @param paragraph the paragraph containing the text of the new entry
	 */
	public void addEntry(UParagraph paragraph) {
		UEntry uEntry = new UEntry(paragraph.getText(), paragraph.getOption());
		uEntry.setBorderLeft(cellBorderLeft);
		uEntry.setBorderRight(cellBorderRight);
		uEntry.setBorderTop(cellBorderTop);
		uEntry.setBorderBottom(cellBorderBottom);

		entries.add(uEntry);
	}	
	
	/**
	 * @return all entries in this table
	 */
	public ArrayList<UEntry> getEntries() {
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
	 * @return the borderLeft
	 */
	public float getBorderLeft() {
		return borderLeft;
	}

	/**
	 * @param borderLeft the borderLeft to set
	 */
	public void setBorderLeft(float borderLeft) {
		this.borderLeft = borderLeft;
	}

	/**
	 * @return the borderBottom
	 */
	public float getBorderBottom() {
		return borderBottom;
	}

	/**
	 * @param borderBottom the borderBottom to set
	 */
	public void setBorderBottom(float borderBottom) {
		this.borderBottom = borderBottom;
	}

	/**
	 * @return the borderRight
	 */
	public float getBorderRight() {
		return borderRight;
	}

	/**
	 * @param borderRight the borderRight to set
	 */
	public void setBorderRight(float borderRight) {
		this.borderRight = borderRight;
	}

	/**
	 * @return the borderTop
	 */
	public float getBorderTop() {
		return borderTop;
	}

	/**
	 * @param borderTop the borderTop to set
	 */
	public void setBorderTop(float borderTop) {
		this.borderTop = borderTop;
	}
	
	/**
	 * @return the cellBorderLeft
	 */
	public float getCellBorderLeft() {
		return cellBorderLeft;
	}

	/**
	 * @param cellBorderLeft the cellBorderLeft to set
	 */
	public void setCellBorderLeft(float cellBorderLeft) {
		this.cellBorderLeft = cellBorderLeft;
	}

	/**
	 * @return the cellBorderRight
	 */
	public float getCellBorderRight() {
		return cellBorderRight;
	}

	/**
	 * @param cellBorderRight the cellBorderRight to set
	 */
	public void setCellBorderRight(float cellBorderRight) {
		this.cellBorderRight = cellBorderRight;
	}

	/**
	 * @return the cellBorderTop
	 */
	public float getCellBorderTop() {
		return cellBorderTop;
	}

	/**
	 * @param cellBorderTop the cellBorderTop to set
	 */
	public void setCellBorderTop(float cellBorderTop) {
		this.cellBorderTop = cellBorderTop;
	}

	/**
	 * @return the cellBorderBottom
	 */
	public float getCellBorderBottom() {
		return cellBorderBottom;
	}

	/**
	 * @param cellBorderBottom the cellBorderBottom to set
	 */
	public void setCellBorderBottom(float cellBorderBottom) {
		this.cellBorderBottom = cellBorderBottom;
	}

	/**
	 * 
	 * @param width the new width of the cell border
	 */
	public void setCellBorder(float width) {
		cellBorderLeft = width;
		cellBorderRight = width;
		cellBorderTop = width;
		cellBorderBottom = width;
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

}
