package org.unicase.documentexport.renderers.elements;

import java.util.ArrayList;

public class UTable extends UCompositeSection {
	
	public int columnsCount = 2;
	public ArrayList<UEntry> entries = new ArrayList<UEntry>();
	
	public UTable(int columnCount) {
		this.columnsCount = columnCount;
	}
	
	public void addEntry(UEntry entry) {
		entries.add(entry);
	}
	
	public void addEntry(String text) {
		entries.add(new UEntry(text));
	}	
}
