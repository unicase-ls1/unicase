package org.unicase.docExport.docWriter;

import java.util.ArrayList;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public final class DocWriterRegistry {
	
	private DocWriterRegistry() {
		
	}
	
	/**
	 * returns all possible DocWriter instances.
	 * @return instances of the DocWriters
	 */
	public static ArrayList<DocWriter> getDocWriters() {
		ArrayList<DocWriter> docWriters = new ArrayList<DocWriter>();
		
		docWriters.add(new FopPdfWriter());
		docWriters.add(new FopRtfWriter());
		docWriters.add(new FopTxtWriter());
//		docWriters.add(new HtmlWriter());
		
//		docWriters.add(new BirtPdfWriter());		
		
		return docWriters;
	}
}
