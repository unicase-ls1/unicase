package org.unicase.papyrus.diagram.services;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.UMLModel;
import org.unicase.papyrus.diagram.part.UMLImageUtil;
import org.unicase.papyrus.diagram.services.UnicaseUMLIconRegistry;

public class UnicaseUMLIconRegistry implements IPageIconsRegistry {
	
	private static UnicaseUMLIconRegistry instance;

	private UnicaseUMLIconRegistry() {
		
	}

	public Image getEditorIcon(Object object) {
		if(object instanceof Diagram) {
			UMLModel model = (UMLModel) ((Diagram) object).getElement(); 
			return getIcon(model.getDiagramType());
		}
		if(object instanceof UMLModel) {
			return getIcon(((UMLModel) object).getDiagramType()); 
		}
		if(object instanceof UMLDiagramType) {
			return getIcon((UMLDiagramType) object);
		}
		return null;
	}

	private Image getIcon(UMLDiagramType diagramType) {
		switch(diagramType) {
			case ACTIVITY:
				return UMLImageUtil.getInstance().getActivityImage();
			case CLASS:
				return UMLImageUtil.getInstance().getClassImage();
			case COMMUNICATION:
				return UMLImageUtil.getInstance().getCommunicationImage();
			case COMPOSITE:
				return UMLImageUtil.getInstance().getCompositeImage();
			case SEQUENCE:
				return UMLImageUtil.getInstance().getSequenceImage();
			case STATE_MACHINE:
				return UMLImageUtil.getInstance().getStateMachineImage();
			case USE_CASE:
				return UMLImageUtil.getInstance().getUseCaseImage();
			case PACKAGE:
				return UMLImageUtil.getInstance().getPackageImage();
			default:
				return null;
		}
	}
	
	public static UnicaseUMLIconRegistry getInstance() {
		if(instance == null) {
			instance = new UnicaseUMLIconRegistry();
		}
		return instance;
	}

}
