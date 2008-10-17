package org.unicase.documentexport.docWriter;


import org.unicase.documentexport.renderers.elements.UCompositeSection;

public interface  DocWriter {
	
	public abstract void export(String fileName, UCompositeSection doc);
}
