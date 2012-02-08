/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.part;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

/**
 * Utility class for images regarding UML diagrams.
 * 
 * @author mharut
 */
public final class UMLImageUtil {

	private static Bundle bundle = Platform.getBundle("org.unicase.papyrus.diagram");

	private static String imageDirectoryPath = "/icons/";

	private UMLImageUtil() {
		// nothing to do
	}

	/**
	 * Creates and returns a new icon for Papyrus UML activity diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getActivityImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Activity.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus UML class diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getClassImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Class.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus UML communication diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getCommunicationImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Communication.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus UML composite diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getCompositeImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Composite.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus UML sequence diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getSequenceImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Sequence.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus UML state machine diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getStateMachineImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("StateMachine.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus UML use case diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getUseCaseImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("UseCase.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus UML package diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getPackageImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Package.gif"));
	}

	private static InputStream getImageStream(String fileName) throws IOException {
		URL imageURL = bundle.getEntry(imageDirectoryPath + fileName);
		return imageURL.openStream();
	}

}
