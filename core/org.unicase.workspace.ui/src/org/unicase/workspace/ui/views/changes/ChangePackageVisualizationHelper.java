/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.UnkownFeatureException;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.util.UiUtil;

/**
 * A helper class for the visualization of change packages.
 * 
 * @author koegel
 * @author shterev
 */
public class ChangePackageVisualizationHelper {

	private static final int MAX_NAME_SIZE = 30;
	private Project project;
	private Map<ModelElementId, ModelElement> modelElementMap;
	private Map<ChangePackage, Set<ModelElementId>> touchedModelElements;
	private List<ChangePackage> changePackages;

	/**
	 * Constructor.
	 * 
	 * @param changePackages
	 *            a list of change packages
	 * @param project
	 *            a project
	 */
	public ChangePackageVisualizationHelper(List<ChangePackage> changePackages,
			Project project) {
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

	private void extractModelElements(Set<ModelElementId> modelElements,
			AbstractOperation abstractOperation) {
		if (abstractOperation instanceof CreateDeleteOperation) {
			ModelElement modelElement = ((CreateDeleteOperation) abstractOperation)
					.getModelElement();
			modelElementMap.put(modelElement.getModelElementId(), modelElement);
			modelElements.add(modelElement.getModelElementId());
			for (ModelElement sibling : modelElement
					.getAllContainedModelElements()) {
				modelElementMap.put(sibling.getModelElementId(), sibling);
				modelElements.add(sibling.getModelElementId());
			}
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
			modelElements.addAll(multiReferenceOperation
					.getReferencedModelElements());
		} else if (abstractOperation instanceof MultiReferenceMoveOperation) {
			modelElements.add(((MultiReferenceMoveOperation) abstractOperation)
					.getReferencedModelElementId());
		} else if (abstractOperation instanceof CompositeOperation) {
			for (AbstractOperation subOperation : ((CompositeOperation) abstractOperation)
					.getSubOperations()) {
				extractModelElements(modelElements, subOperation);
			}
		}
	}

	/**
	 * Get a model element instance from the project for the given id.
	 * 
	 * @param modelElementId
	 *            the id
	 * @return the model element instance
	 */
	public ModelElement getModelElement(ModelElementId modelElementId) {
		if (modelElementId == null) {
			return null;
		} else if (project.contains(modelElementId)) {
			return project.getModelElement(modelElementId);
		} else {
			return modelElementMap.get(modelElementId);
		}
	}

	/**
	 * Get all elements affected by the operation.
	 * 
	 * @param operation
	 *            the operation
	 * @return a set of model elements
	 */
	public Set<EObject> getAffectedElements(AbstractOperation operation) {
		Set<EObject> set = new HashSet<EObject>();
		if (operation instanceof CreateDeleteOperation) {
			return set;
		}
		Set<ModelElementId> others = operation.getOtherInvolvedModelElements();
		for (ModelElementId id : others) {
			ModelElement modelElement = getModelElement(id);
			if (modelElement != null) {
				set.add(modelElement);
			}
		}
		return set;
	}

	/**
	 * Get the overlay image for an operation.
	 * 
	 * @param operation
	 *            the operation
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

		ImageDescriptor overlayDescriptor = org.unicase.ui.common.Activator
				.getImageDescriptor(overlay);
		return overlayDescriptor;
	}

	/**
	 * Get an image for the operation.
	 * 
	 * @param emfProvider
	 *            the label provider
	 * @param operation
	 *            the operation
	 * @return an image
	 */
	public Image getImage(ILabelProvider emfProvider,
			AbstractOperation operation) {
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
		} else if (operation instanceof MultiReferenceOperation) {
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			if (op.getReferencedModelElements().size() > 0) {
				image = emfProvider.getImage(op.getReferencedModelElements()
						.get(0));
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
	 * @param changePackage
	 *            the change package
	 * @return a set of touched model elements
	 */
	public Set<EObject> getAllModelElements(ChangePackage changePackage) {
		Set<EObject> set = new HashSet<EObject>();
		Set<ModelElementId> tempSet = this.touchedModelElements
				.get(changePackage);
		if (tempSet == null) {
			return set;
		}
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
	 * @param me
	 *            the ModelElement
	 * @param changePackage
	 *            the changePackage
	 * @return the operations
	 */
	public Set<EObject> getOperations(ModelElement me,
			ChangePackage changePackage) {
		Set<EObject> set = new HashSet<EObject>();
		for (AbstractOperation op : changePackage.getOperations()) {
			if (op.getModelElementId().equals(me.getModelElementId())) {
				set.add(op);
			} else if (op instanceof ReferenceOperation) {
				ReferenceOperation rop = (ReferenceOperation) op;
				Set<ModelElementId> others = rop
						.getOtherInvolvedModelElements();
				if (others.contains(me.getModelElementId())) {
					set.add(rop);
				}
			}
		}
		return set;
	}

	/**
	 * Get all operations for this ModelElement in the current list of
	 * ChangePackages.
	 * 
	 * @param me
	 *            the ModelElement
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
	 * @param op
	 *            the operation to generate a description for
	 * @return the description for given operation
	 */
	public String getDescription(AbstractOperation op) {

		// choose method to call based on operation type
		// anyone a better idea how to do this?
		if (op instanceof AttributeOperation) {
			return getDescriptionAttributeOperation((AttributeOperation) op);
		}
		if (op instanceof SingleReferenceOperation) {
			return getDescriptionSingleReferenceOperation((SingleReferenceOperation) op);
		}
		if (op instanceof MultiReferenceOperation) {
			return getDescriptionMultiReferenceOperation((MultiReferenceOperation) op);
		}
		if (op instanceof CreateDeleteOperation) {
			return getDescriptionCreateDeleteOperation((CreateDeleteOperation) op);
		}
		if (op instanceof MultiReferenceMoveOperation) {
			return getDescriptionMultiReferenceMoveOperation((MultiReferenceMoveOperation) op);
		}
		if (op instanceof CompositeOperation) {
			CompositeOperation compositeOperation = (CompositeOperation) op;
			if (compositeOperation.getMainOperation() != null) {
				return getDescription(compositeOperation.getMainOperation());
			}
			return op.getDescription();
		}

		return getDescriptionUnknownOperation(op);

	}

	private String getDescriptionMultiReferenceMoveOperation(
			MultiReferenceMoveOperation op) {

		String elementName = getModelElementName(op.getModelElementId());
		String movedElementName = getModelElementName(op
				.getReferencedModelElementId());
		return "Reordered " + op.getFeatureName() + " in " + elementName
				+ ", moved " + movedElementName + " from position "
				+ op.getOldIndex() + " to " + op.getNewIndex();
	}

	private String getDescriptionCreateDeleteOperation(CreateDeleteOperation op) {

		ModelElement modelElement = op.getModelElement();
		int childrenCount = modelElement.getAllContainedModelElements().size();
		String description;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(modelElement.eClass().getName());
		stringBuilder.append(" \"");
		stringBuilder.append(UiUtil.getNameForModelElement(modelElement));
		stringBuilder.append("\" ");
		String elementClassAndName = stringBuilder.toString();
		if (op.isDelete()) {
			description = "Deleted " + elementClassAndName;
		} else {
			description = "Created " + elementClassAndName;
		}
		if (childrenCount > 0) {
			description += " including " + childrenCount + " sibling(s)";
		}

		EList<ReferenceOperation> subOperations = op.getSubOperations();
		int subOperationCount = subOperations.size();
		if (op.isDelete() && subOperationCount > 0) {
			ReferenceOperation referenceOperation = subOperations
					.get(subOperationCount - 1);
			ModelElement parentElement = getModelElement(referenceOperation
					.getModelElementId());
			try {
				if (parentElement != null
						&& ((EReference) referenceOperation
								.getFeature(parentElement)).isContainment()) {
					description += " from its parent "
							+ getModelElementName(parentElement);
				}
			} catch (UnkownFeatureException e) {
				// silently skip part about parent
			}
		}
		return description;

	}

	private String getDescriptionMultiReferenceOperation(
			MultiReferenceOperation op) {

		ModelElement modelElement = getModelElement(op.getModelElementId());
		if (modelElement == null) {
			String elemNames = getModelElementClassesAndNames(op
					.getReferencedModelElements(), "element");
			if (op.isAdd()) {
				return "Added " + elemNames + " to " + op.getFeatureName()
						+ " of (unkown element)";
			} else {
				return "Removed " + elemNames + " from " + op.getFeatureName()
						+ " of (unkown element)";
			}
		}

		boolean containment;
		String featureType;
		EReference feature;
		try {
			feature = (EReference) op.getFeature(modelElement);
			containment = feature.isContainment();
			featureType = feature.getEType().getName();
		} catch (UnkownFeatureException e) {
			containment = false;
			featureType = "element";
		}

		String elemNames = getModelElementClassesAndNames(op
				.getReferencedModelElements(), featureType);
		String elementNameAndClass = getModelElementName(modelElement);
		String children = op.getReferencedModelElements().size() > 1 ? "children"
				: "child";
		if (op.isAdd()) {
			if (containment) {
				return "Added " + elemNames + " as " + children + " in "
						+ elementNameAndClass;
			} else {
				return "Added " + elemNames + " to " + op.getFeatureName()
						+ " in " + elementNameAndClass;
			}
		} else {
			if (containment) {
				return "Removed " + elemNames + " as " + children + " in "
						+ elementNameAndClass;
			} else {
				return "Removed " + elemNames + " from " + op.getFeatureName()
						+ " in " + elementNameAndClass;
			}
		}

	}

	private String getDescriptionSingleReferenceOperation(
			SingleReferenceOperation op) {

		ModelElement oldElement = getModelElement(op.getOldValue());
		ModelElement newElement = getModelElement(op.getNewValue());
		String oldName = getModelElementName(oldElement);
		String newName = getModelElementName(newElement);
		ModelElement elem = getModelElement(op.getModelElementId());
		String elementName = getModelElementName(elem);
		if (elem == null) {
			return "Changed " + op.getFeatureName() + " from " + oldName
					+ " to " + newName + " for \"(unkown element)";
		}

		boolean isContainer;
		try {
			isContainer = ((EReference) op.getFeature(elem)).isContainer();
		} catch (UnkownFeatureException e) {
			isContainer = false;
		}
		// changing containment means relocating the item
		if (isContainer && oldElement != null && newElement != null) {
			return "Moved " + elementName + " from " + oldName + " to "
					+ newName;
		} else if (oldElement == null && newElement == null) {
			return "Unset " + op.getFeatureName() + " in " + elementName;
		} else if (oldElement == null && newElement != null) {
			return "Set " + op.getFeatureName() + " in " + elementName + " to "
					+ newName;
		} else if (oldElement != null && newElement == null) {
			return "Unset " + op.getFeatureName() + " in " + elementName
					+ " from previous value " + oldName;
		} else {
			return "Set " + op.getFeatureName() + " in " + elementName + " to "
					+ newName + " from previous value " + oldName;
		}

	}

	private String getDescriptionAttributeOperation(AttributeOperation op) {
		ModelElement elem = getModelElement(op.getModelElementId());
		if (elem == null) {
			return "Changed " + op.getFeatureName() + " from \""
					+ trim(op.getOldValue()) + "\" to \""
					+ trim(op.getNewValue()) + "\""
					+ " for \"(unkown element\"";
		}
		String oldValue;
		String newValue;
		if (op.getFeatureName().equals("description")) {
			oldValue = (op.getOldValue() == null) ? null : ModelUtil
					.getPlainTextFromRichText((String) op.getOldValue());
			newValue = (op.getNewValue() == null) ? null : ModelUtil
					.getPlainTextFromRichText((String) op.getNewValue());
		} else {
			oldValue = (op.getOldValue() == null) ? null : op.getOldValue()
					.toString();
			newValue = (op.getNewValue() == null) ? null : op.getNewValue()
					.toString();
		}
		String elemNameAndClass = getModelElementName(elem);
		if (oldValue == null && newValue == null) {
			return "Unset " + op.getFeatureName() + " in " + elemNameAndClass;
		} else if (oldValue == null && newValue != null) {
			return "Set " + op.getFeatureName() + " in " + elemNameAndClass
					+ " to \"" + trim(newValue) + "\"";
		} else if (oldValue != null && newValue == null) {
			return "Unset " + op.getFeatureName() + " in " + elemNameAndClass
					+ " from previous value \"" + trim(oldValue) + "\"";
		} else {
			return "Set " + op.getFeatureName() + " in " + elemNameAndClass
					+ " to \"" + trim(newValue) + "\" from previous value \""
					+ trim(oldValue) + "\"";
		}

	}

	private String getDescriptionUnknownOperation(AbstractOperation op) {
		return op.getClass().getSimpleName() + " " + op.getDescription();
	}

	private String trim(Object object) {
		return trim(object, false);
	}

	private String trim(Object object, boolean isName) {
		if (object == null) {
			return isName ? "(no name)" : "(null)";
		}
		String string = object.toString();
		String result = string.trim();
		if (result.length() > MAX_NAME_SIZE) {
			return result.substring(0, MAX_NAME_SIZE) + "...";
		}
		if (result.length() == 0) {
			return "(empty)";
		}
		return result;
	}

	/**
	 * Returns a comma separated list of class names and model names. {id1, id2}
	 * will become "Comment 'some comment', LeafSection 'section title'"
	 * 
	 * @param idList
	 *            the list of model element IDs to return the names for
	 * @return
	 */
	private String getModelElementClassesAndNames(EList<ModelElementId> idList,
			String typeName) {

		StringBuilder sb = new StringBuilder();

		if (idList.size() > 2) {
			return idList.size() + " " + typeName + "s";
		}

		for (int i = 0; i < idList.size(); i++) {
			if (i > 0 && i == idList.size() - 1) {
				sb.append(" and ");
			} else if (i > 0) {
				sb.append(", ");
			}
			ModelElementId id = idList.get(i);
			sb.append(getModelElementName(id));

		}
		return sb.toString();
	}

	private String getModelElementName(ModelElementId modelElementId) {
		if (modelElementId == null) {
			return "(unkown element)";
		}
		return getModelElementName(getModelElement(modelElementId));
	}

	private String getModelElementName(ModelElement modelElement) {
		if (modelElement == null) {
			return "(unkown element)";
		}
		return modelElement.eClass().getName() + " \""
				+ trim(UiUtil.getNameForModelElement(modelElement), true)
				+ "\"";
	}
}
