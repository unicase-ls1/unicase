package org.unicase.papyrus.diagram.services;

import java.io.IOException;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.UMLModel;
import org.unicase.papyrus.diagram.part.UMLImageUtil;
import org.unicase.papyrus.diagram.services.UnicaseUMLIconRegistry;
import org.unicase.workspace.util.WorkspaceUtil;

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
		try {
			switch(diagramType) {
				case ACTIVITY:
					return UMLImageUtil.getActivityImage();
				case CLASS:
					return UMLImageUtil.getClassImage();
				case COMMUNICATION:
					return UMLImageUtil.getCommunicationImage();
				case COMPOSITE:
					return UMLImageUtil.getCompositeImage();
				case SEQUENCE:
					return UMLImageUtil.getSequenceImage();
				case STATE_MACHINE:
					return UMLImageUtil.getStateMachineImage();
				case USE_CASE:
					return UMLImageUtil.getUseCaseImage();
				case PACKAGE:
					return UMLImageUtil.getPackageImage();
				default:
					return null;
			}
		} catch (IOException e) {
			WorkspaceUtil.logException("Failed to load Papyrus icons", e);
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
