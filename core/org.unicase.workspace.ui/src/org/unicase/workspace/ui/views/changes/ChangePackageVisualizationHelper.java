/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsDescriptionProvider;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;

/**
 * A helper class for the visualization of change packages.
 * 
 * @author koegel
 * @author shterev
 */
public class ChangePackageVisualizationHelper {

	private Project project;
	private Map<ModelElementId, ModelElement> modelElementMap;
	private Map<ChangePackage, Set<ModelElementId>> touchedModelElements;
	private List<ChangePackage> changePackages;
	private OperationsDescriptionProvider operationDescriptionProvider;

	/**
	 * Constructor.
	 * 
	 * @param changePackages a list of change packages
	 * @param project a project
	 */
	public ChangePackageVisualizationHelper(List<ChangePackage> changePackages, Project project) {
		this.operationDescriptionProvider = new OperationsDescriptionProvider(project);
		this.modelElementMap = new HashMap<ModelElementId, ModelElement>();
		this.touchedModelElements = new HashMap<ChangePackage, Set<ModelElementId>>();
		for (ChangePackage changePackage : changePackages) {
			initModelELementMap(changePackage);
		}
		this.changePackages = changePackages;
		this.project = project;
	}

	private void initModelELementMap(ChangePackage changePackage) {
		EList<AbstractOperation> operations = changePackage.getOperations();
		Set<ModelElementId> modelElements = new HashSet<ModelElementId>();
		touchedModelElements.put(changePackage, modelElements);
		for (AbstractOperation abstractOperation : operations) {
			modelElements.add(abstractOperation.getModelElementId());
			extractModelElements(modelElements, abstractOperation);
		}
	}

	private void extractModelElements(Set<ModelElementId> modelElements, AbstractOperation abstractOperation) {
		if (abstractOperation instanceof CreateDeleteOperation) {
			ModelElement modelElement = ((CreateDeleteOperation) abstractOperation).getModelElement();
			modelElementMap.put(modelElement.getModelElementId(), modelElement);
		} else if (abstractOperation instanceof SingleReferenceOperation) {
			SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) abstractOperation;
			ModelElementId newValue = singleReferenceOperation.getNewValue();
			ModelElementId oldValue = singleReferenceOperation.getOldValue();
			if (newValue != null) {
				modelElements.add(newValue);
			}
			if (oldValue != null) {
				modelElements.add(oldValue);
			}
		} else if (abstractOperation instanceof MultiReferenceOperation) {
			MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) abstractOperation;
			modelElements.addAll(multiReferenceOperation.getReferencedModelElements());
		} else if (abstractOperation instanceof MultiReferenceMoveOperation) {
			modelElements.add(((MultiReferenceMoveOperation) abstractOperation).getReferencedModelElementId());
		} else if (abstractOperation instanceof CompositeOperation) {
			for (AbstractOperation subOperation : ((CompositeOperation) abstractOperation).getSubOperations()) {
				extractModelElements(modelElements, subOperation);
			}
		}
	}

	/**
	 * Get a model element instance from the project for the given id.
	 * 
	 * @param modelElementId the id
	 * @return the model element instance
	 */
	public ModelElement getModelElement(ModelElementId modelElementId) {
		if (project.contains(modelElementId)) {
			return project.getModelElement(modelElementId);
		} else {
			return modelElementMap.get(modelElementId);
		}
	}

	/**
	 * Get all elements affected by the operation.
	 * 
	 * @param operation the operation
	 * @return a set of model elements
	 */
	public Set<EObject> getAffectedElements(AbstractOperation operation) {
		Set<EObject> set = new HashSet<EObject>();
		if (operation instanceof ReferenceOperation) {
			ReferenceOperation op = (ReferenceOperation) operation;
			Set<ModelElementId> others = op.getOtherInvolvedModelElements();
			for (ModelElementId id : others) {
				ModelElement modelElement = getModelElement(id);
				if (modelElement != null) {
					set.add(modelElement);
				} else {
					// AS: hiding elements that cannot be displayed
					// set.add(id);
				}
			}
		}
		return set;
	}

	/**
	 * Get the overlay image for an operation.
	 * 
	 * @param operation the operation
	 * @return the ImageDescriptor
	 */
	public ImageDescriptor getOverlayImage(AbstractOperation operation) {
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
			} else {
				overlay = "icons/link_overlay.png";
			}
		} else if (operation instanceof MultiAttributeOperation) {
			overlay = "icons/modify_overlay.png";
		} else if (operation instanceof MultiReferenceOperation) {
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			if (op.getReferencedModelElements().size() > 0) {
				overlay = "icons/link_overlay.png";
			}
		} else if (operation instanceof MultiReferenceMoveOperation) {
			overlay = "icons/link_overlay.png";
		} else {
			overlay = "icons/modify_overlay.png";
		}

		ImageDescriptor overlayDescriptor = org.unicase.ui.common.Activator.getImageDescriptor(overlay);
		return overlayDescriptor;
	}

	/**
	 * Get an image for the operation.
	 * 
	 * @param emfProvider the label provider
	 * @param operation the operation
	 * @return an image
	 */
	public Image getImage(ILabelProvider emfProvider, AbstractOperation operation) {
		Image image = null;
		if (operation instanceof CreateDeleteOperation) {
			CreateDeleteOperation op = (CreateDeleteOperation) operation;
			image = emfProvider.getImage(op.getModelElement());
		} else if (operation instanceof AttributeOperation) {
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
				image = emfProvider.getImage(op.getReferencedModelElements().get(0));
			}
		} else if (operation instanceof MultiReferenceMoveOperation) {
			MultiReferenceMoveOperation op = (MultiReferenceMoveOperation) operation;
			image = emfProvider.getImage(op.getReferencedModelElementId());
		}
		return image;
	}

	/**
	 * Get all model elements that are changed by a change package.
	 * 
	 * @param changePackage the change package
	 * @return a set of touched model elements
	 */
	public Set<EObject> getAllModelElements(ChangePackage changePackage) {
		Set<EObject> set = new HashSet<EObject>();
		Set<ModelElementId> tempSet = this.touchedModelElements.get(changePackage);
		for (ModelElementId id : tempSet) {
			ModelElement modelElement = getModelElement(id);
			if (modelElement != null) {
				set.add(modelElement);
			} else {
				// AS: hiding elements that cannot be displayed
				// set.add(id);
			}
		}
		return set;
	}

	/**
	 * Get all operations for this ModelElement in the current ChangePackage.
	 * 
	 * @param me the ModelElement
	 * @param changePackage the changePackage
	 * @return the operations
	 */
	public Set<EObject> getOperations(ModelElement me, ChangePackage changePackage) {
		Set<EObject> set = new HashSet<EObject>();
		for (AbstractOperation op : changePackage.getOperations()) {
			if (op.getModelElementId().equals(me.getModelElementId())) {
				set.add(op);
			} else if (op instanceof ReferenceOperation) {
				ReferenceOperation rop = (ReferenceOperation) op;
				Set<ModelElementId> others = rop.getOtherInvolvedModelElements();
				if (others.contains(me.getModelElementId())) {
					set.add(rop);
				}
			}
		}
		return set;
	}

	/**
	 * Get all operations for this ModelElement in the current list of ChangePackages.
	 * 
	 * @param me the ModelElement
	 * @return the operations
	 */
	public Set<EObject> getOperations(ModelElement me) {
		Set<EObject> set = new HashSet<EObject>();
		for (ChangePackage cp : changePackages) {
			set.addAll(getOperations(me, cp));
		}
		return set;
	}

	/**
	 * Returns a verbose description for an operation.
	 * 
	 * @param op the operation to provide description for
	 * @return the description
	 */
	public String getDescription(AbstractOperation op) {
		return operationDescriptionProvider.getDescription(op);
	}
}
