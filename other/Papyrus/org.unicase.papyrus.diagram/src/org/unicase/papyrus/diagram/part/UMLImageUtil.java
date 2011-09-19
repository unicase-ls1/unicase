package org.unicase.papyrus.diagram.part;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

final public class UMLImageUtil {
	
	private static Bundle bundle = Platform.getBundle("org.unicase.papyrus.diagram");
	
	private static String imageDirectoryPath = "/icons/";

	private UMLImageUtil() {
		
	}
	
	public static Image getActivityImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Activity.gif"));
	}
	
	public static Image getClassImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Class.gif"));
	}
	
	public static Image getCommunicationImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Communication.gif"));
	}
	
	public static Image getCompositeImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Composite.gif"));
	}
	
	public static Image getSequenceImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Sequence.gif"));
	}
	
	public static Image getStateMachineImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("StateMachine.gif"));
	}
	
	public static Image getUseCaseImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("UseCase.gif"));
	}
	
	public static Image getPackageImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Package.gif"));
	}
	
	private static InputStream getImageStream(String fileName) throws IOException {
		URL imageURL = bundle.getEntry(imageDirectoryPath + fileName);
		return imageURL.openStream();
	}
	
}
