package org.unicase.papyrus.sysml.diagram.part;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

final public class SysMLImageUtil {
	
	private static Bundle bundle = Platform.getBundle("org.unicase.papyrus.sysml.diagram");
	
	private static String imageDirectoryPath = "/icons/";

	private SysMLImageUtil() {
		
	}
	
	public static Image getBlockDefinitionImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("BlockDefinition.gif"));
	}
	
	public static Image getInternalBlockImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("InternalBlock.gif"));
	}
	
	public static Image getParametricImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Parametric.gif"));
	}
	
	public static Image getRequirementImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Requirement.gif"));
	}
	
	private static InputStream getImageStream(String fileName) throws IOException {
		URL imageURL = bundle.getEntry(imageDirectoryPath + fileName);
		return imageURL.openStream();
	}
	
}
