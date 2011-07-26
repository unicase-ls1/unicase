package org.unicase.papyrus.diagram.part;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

final public class UMLImageUtil {
	
	private static UMLImageUtil instance;

	private UMLImageUtil() {
		
	}
	
	public Image getActivityImage() {
		return new Image(Display.getCurrent(),
				getClass().getResourceAsStream("/icons/Activity.gif"));
	}
	
	public Image getClassImage() {
		return new Image(Display.getCurrent(),
				getClass().getResourceAsStream("/icons/Class.gif"));
	}
	
	public Image getCommunicationImage() {
		return new Image(Display.getCurrent(),
				getClass().getResourceAsStream("/icons/Communication.gif"));
	}
	
	public Image getCompositeImage() {
		return new Image(Display.getCurrent(),
				getClass().getResourceAsStream("/icons/Composite.gif"));
	}
	
	public Image getSequenceImage() {
		return new Image(Display.getCurrent(),
				getClass().getResourceAsStream("/icons/Sequence.gif"));
	}
	
	public Image getStateMachineImage() {
		return new Image(Display.getCurrent(),
				getClass().getResourceAsStream("/icons/StateMachine.gif"));
	}
	
	public Image getUseCaseImage() {
		return new Image(Display.getCurrent(),
				getClass().getResourceAsStream("/icons/UseCase.gif"));
	}
	
	public Image getPackageImage() {
		return new Image(Display.getCurrent(),
				getClass().getResourceAsStream("/icons/Package.gif"));
	}
	
	public static UMLImageUtil getInstance() {
		if(instance == null) {
			instance = new UMLImageUtil();
		}
		return instance;
	}

}
