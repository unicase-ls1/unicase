package org.unicase.papyrus.custom.part;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
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
		Display display = Display.getCurrent();
		if(diagramTypeToImage == null) {
			diagramTypeToImage = new LinkedHashMap<UMLDiagramType, Image>();
			diagramTypeToImage.put(UMLDiagramType.ACTIVITY, 
					UMLImageUtil.getInstance().getActivityImage());
			diagramTypeToImage.put(UMLDiagramType.CLASS, 
					new Image(display, getClass().getResourceAsStream("/icons/Class.gif")));
			diagramTypeToImage.put(UMLDiagramType.COMMUNICATION, 
					new Image(display, getClass().getResourceAsStream("/icons/Communication.gif")));
			diagramTypeToImage.put(UMLDiagramType.COMPOSITE, 
					new Image(display, getClass().getResourceAsStream("/icons/Composite.gif")));
			diagramTypeToImage.put(UMLDiagramType.SEQUENCE, 
					new Image(display, getClass().getResourceAsStream("/icons/Sequence.gif")));
			diagramTypeToImage.put(UMLDiagramType.STATE_MACHINE, 
					new Image(display, getClass().getResourceAsStream("/icons/StateMachine.gif")));
			diagramTypeToImage.put(UMLDiagramType.USE_CASE, 
					new Image(display, getClass().getResourceAsStream("/icons/UseCase.gif")));
		}
		return diagramTypeToImage;
	}
}
