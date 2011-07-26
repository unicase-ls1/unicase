package org.unicase.papyrus.diagram.part;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.diagram.services.UnicaseUMLIconRegistry;

public class UMLDiagramTypeLabelProvider extends LabelProvider {
	
	public String getText(Object object) {
		if(object instanceof UMLDiagramType) {
			return ((UMLDiagramType) object).getName();
		} else {
			return super.getText(object);
		}
	}
	
	public Image getImage(Object object){
		Image result = UnicaseUMLIconRegistry.getInstance().getEditorIcon(object);
		if(result == null) {
			result = super.getImage(object);
		}
		return result;
		
	};
	
}
