/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

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
public final class UnicaseImageUtil {

	private static Bundle bundle = Platform.getBundle("org.unicase.papyrus.diagram");

	private static String imageDirectoryPath = "/icons/";

	private UnicaseImageUtil() {
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

	/**
	 * Creates and returns a new icon for Papyrus SysML block definition diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getBlockDefinitionImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("BlockDefinition.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus SysML internal block diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getInternalBlockImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("InternalBlock.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus SysML parametric diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getParametricImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Parametric.gif"));
	}

	/**
	 * Creates and returns a new icon for Papyrus SysML requirement diagrams.
	 * 
	 * @return the newly created image
	 * @throws IOException if creating the image fails
	 */
	public static Image getRequirementImage() throws IOException {
		return new Image(Display.getCurrent(), getImageStream("Requirement.gif"));
	}

	private static InputStream getImageStream(String fileName) throws IOException {
		URL imageURL = bundle.getEntry(imageDirectoryPath + fileName);
		return imageURL.openStream();
	}

}
