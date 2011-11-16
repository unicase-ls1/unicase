package org.unicase.papyrus.sysml.diagram.part;

import java.io.IOException;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.papyrus.SysMLModel;

public class SysMLDiagramTypeLabelProvider extends LabelProvider {
	
	public String getText(Object object) {
		if(object instanceof SysMLDiagramType) {
			return ((SysMLDiagramType) object).getName();
		} else {
			return super.getText(object);
		}
	}
	
	public Image getImage(Object object){
		if(object instanceof SysMLDiagramType) {
			try {
				switch((SysMLDiagramType) object) {
				case BLOCK_DEFINITION:
					return SysMLImageUtil.getBlockDefinitionImage();
				case INTERNAL_BLOCK:
					return SysMLImageUtil.getInternalBlockImage();
				case PARAMETRIC:
					return SysMLImageUtil.getParametricImage();
				case REQUIREMENT:
					return SysMLImageUtil.getRequirementImage();
				}
			} catch(IOException e) {
				return null;
			}
		}
		return null;
	};
	
}
