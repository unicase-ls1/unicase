package org.unicase.papyrus.own;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.unicase.papyrus.UMLDiagramType;

public class UMLDiagramTypeLabelProvider extends LabelProvider {
	
	private static Map<UMLDiagramType, Image> diagramTypeToImage;
	
	public String getText(Object object) {
		if(object instanceof UMLDiagramType) {
			return ((UMLDiagramType) object).getName();
		} else {
			return super.getText(object);
		}
	}
	
	public Image getImage(Object object){
		if(object instanceof UMLDiagramType) {
			return getDiagramTypeToImage().get(object);
		} else {
			return super.getImage(object);
		}
		
	};
	
	private Map<UMLDiagramType, Image> getDiagramTypeToImage() {
		Class<UMLDiagramType> theClass = UMLDiagramType.class;
		Display display = Display.getCurrent();
		if(diagramTypeToImage == null) {
			diagramTypeToImage = new LinkedHashMap<UMLDiagramType, Image>();
			diagramTypeToImage.put(UMLDiagramType.ACTIVITY, 
					new Image(display, theClass.getResourceAsStream("/icons/Activity.gif")));
			diagramTypeToImage.put(UMLDiagramType.CLASS, 
					new Image(display, theClass.getResourceAsStream("/icons/Class.gif")));
			diagramTypeToImage.put(UMLDiagramType.COMMUNICATION, 
					new Image(display, theClass.getResourceAsStream("/icons/Communication.gif")));
			diagramTypeToImage.put(UMLDiagramType.COMPOSITE, 
					new Image(display, theClass.getResourceAsStream("/icons/Composite.gif")));
			diagramTypeToImage.put(UMLDiagramType.SEQUENCE, 
					new Image(display, theClass.getResourceAsStream("/icons/Sequence.gif")));
			diagramTypeToImage.put(UMLDiagramType.STATE_MACHINE, 
					new Image(display, theClass.getResourceAsStream("/icons/StateMachine.gif")));
			diagramTypeToImage.put(UMLDiagramType.USE_CASE, 
					new Image(display, theClass.getResourceAsStream("/icons/UseCase.gif")));
		}
		return diagramTypeToImage;
	}
}
