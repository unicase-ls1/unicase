package org.unicase.documentexport.renderers.elements;

import java.util.ArrayList;

/**
 * This class represents a table in the renderer.
 * 
 * @author Sebastian Höcht
 */
public class UTable extends UCompositeSection {
	
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
		entries.add(new UEntry(text));
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
}
