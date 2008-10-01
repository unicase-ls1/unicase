package org.unicase.ui.stem.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;

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
	
	public ArrayList<ModelElement> getAffectedElements(AbstractOperation operation){
		ArrayList<ModelElement> list = new ArrayList<ModelElement>();
//		ActionItem createActionItem = TaskFactory.eINSTANCE.createActionItem();
//		createActionItem.setName("Blah");
		if (operation instanceof SingleReferenceOperation) {
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			if (op.getNewValue() != null) {
				list.add(getModelElement(op.getNewValue()));
			}
			if (op.getOldValue() != null) {
				list.add(getModelElement(op.getOldValue()));
			}
		}
		if (operation instanceof MultiReferenceOperation) {
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			for (ModelElementId id : op.getReferencedModelElements()) {
				list.add(getModelElement(id));
			}
		}
		if (operation instanceof MultiReferenceMoveOperation){
			MultiReferenceMoveOperation op = (MultiReferenceMoveOperation) operation;
			list.add(getModelElement(op.getReferencedModelElementId()));
		}
		return list;
	}
	
	public ImageDescriptor getOverlayImage(AbstractOperation operation){
		String overlay = null;
		if (operation instanceof CreateDeleteOperation) {
			CreateDeleteOperation op = (CreateDeleteOperation) operation;
			if (op.isDelete()) {
				overlay = "icons/delete_overlay.png";
			} else {
				overlay = "icons/add_overlay.png";
			}
		} else if (operation instanceof AttributeOperation) {
			AttributeOperation op = (AttributeOperation) operation;
			if (op.getNewValue() == null) {
				overlay = "icons/delete_overlay.png";
			} else if (op.getOldValue() == null) {
				overlay = "icons/add_overlay.png";
			} else {
				overlay = "icons/modify_overlay.png";
			}
		} else if (operation instanceof SingleReferenceOperation) {
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			if (op.getNewValue() == null) {
				overlay = "icons/delete_overlay.png";
			} else if (op.getOldValue() == null) {
				overlay = "icons/add_overlay.png";
			} else {
				overlay = "icons/modify_overlay.png";
			}
		} else if (operation instanceof MultiAttributeOperation) {
			overlay = "icons/modify_overlay.png";
		} else if (operation instanceof MultiReferenceOperation) {
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			if (op.getReferencedModelElements().size() > 0) {
				overlay = "icons/link_overlay.png";
			}
		}
		ImageDescriptor overlayDescriptor = org.unicase.ui.common.Activator
		.getImageDescriptor(overlay);
		return overlayDescriptor;
	}
	
	public Image getImage(ILabelProvider emfProvider, AbstractOperation operation){
		Image image = null;
		if (operation instanceof CreateDeleteOperation) {
			CreateDeleteOperation op = (CreateDeleteOperation) operation;
			image = emfProvider.getImage(op.getModelElement());
		} else if (operation instanceof AttributeOperation) {
			AttributeOperation op = (AttributeOperation) operation;
			image = emfProvider.getImage(null);
		} else if (operation instanceof SingleReferenceOperation) {
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			if (op.getNewValue() == null) {
				image = emfProvider.getImage(op.getOldValue());
			} else if (op.getOldValue() == null) {
				image = emfProvider.getImage(op.getNewValue());
			} else {
				image = emfProvider.getImage(op.getNewValue());
			}
		} else if (operation instanceof MultiAttributeOperation) {
			image = emfProvider.getImage(null);
		} else if (operation instanceof MultiReferenceOperation) {
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			if (op.getReferencedModelElements().size() > 0) {
				image = emfProvider.getImage(op
						.getReferencedModelElements().get(0));
			}
		}
		return image;
	}
}
