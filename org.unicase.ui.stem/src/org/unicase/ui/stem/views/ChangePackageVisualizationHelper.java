package org.unicase.ui.stem.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;

public class ChangePackageVisualizationHelper {
	
	private ChangePackage changePackage;
	private Project project;
	private Map<ModelElementId, ModelElement> modelElementMap;
	
	public ChangePackageVisualizationHelper(List<ChangePackage> changePackages, Project project) {
		this.changePackage=changePackage;
		this.modelElementMap=new HashMap<ModelElementId, ModelElement>();
		for (ChangePackage changePackage : changePackages) {
			initModelELementMap(changePackage);
		}
		this.project=project;
	}
	
	private void initModelELementMap(ChangePackage changePackage) {
		EList<AbstractOperation> operations = changePackage.getOperations();
		for (AbstractOperation abstractOperation : operations) {
			if (abstractOperation instanceof CreateDeleteOperation) {
				ModelElement modelElement = ((CreateDeleteOperation) abstractOperation).getModelElement();
				modelElementMap.put(modelElement.getModelElementId(), modelElement);
			}
		}
	}
	
	public ModelElement getModelElement(ModelElementId modelElementId) {
		if (project.contains(modelElementId)) {
			return project.getModelElement(modelElementId);
		}
		else {
			return modelElementMap.get(modelElementId);
		}
	}
}
