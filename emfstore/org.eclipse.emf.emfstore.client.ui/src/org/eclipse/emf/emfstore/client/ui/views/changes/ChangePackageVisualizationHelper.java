/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.changes;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.emfstore.client.ui.Activator;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.ModelFactory;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.provider.AbstractOperationCustomLabelProvider;
import org.eclipse.emf.emfstore.server.model.provider.CustomOperationLabelProviderManager;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.UnkownFeatureException;
import org.eclipse.emf.emfstore.server.model.versioning.operations.provider.AbstractOperationItemProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * A helper class for the visualization of change packages.
 * 
 * @author koegel
 * @author shterev
 * @author emueller
 */
public class ChangePackageVisualizationHelper {

	private Map<ModelElementId, EObject> modelElementMap;

	private CustomOperationLabelProviderManager customLabelProviderManager;
	private DefaultOperationLabelProvider defaultOperationLabelProvider;

	/**
	 * Constructor.
	 * 
	 * @param changePackages a list of change packages
	 * @param project a project
	 */
	public ChangePackageVisualizationHelper(List<ChangePackage> changePackages, Project project) {
		this.modelElementMap = new HashMap<ModelElementId, EObject>();

		for (ChangePackage changePackage : changePackages) {
			initModelElementMap(changePackage);
		}

		for (ModelElementId id : project.getAllModelElementIds()) {
			modelElementMap.put(id, project.getModelElement(id));
		}

		defaultOperationLabelProvider = new DefaultOperationLabelProvider();
		this.customLabelProviderManager = new CustomOperationLabelProviderManager();
	}

	private void initModelElementMap(ChangePackage changePackage) {
		List<AbstractOperation> operations = changePackage.getLeafOperations();
		for (AbstractOperation abstractOperation : operations) {
			if (abstractOperation instanceof CreateDeleteOperation) {
				for (Map.Entry<EObject, ModelElementId> entry : ((CreateDeleteOperation) abstractOperation)
					.getEObjectToIdMap().map().entrySet()) {
					ModelElementId orgModelElementId = entry.getValue();
					EObject modelElement = entry.getKey();
					modelElementMap.put(ModelUtil.clone(orgModelElementId), modelElement);
				}
			}
		}
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

		// TODO: ChainSaw
		ImageDescriptor overlayDescriptor = Activator.getImageDescriptor(overlay);
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

		// check if a custom label provider can provide an image
		Image image = getCustomOperationProviderLabel(operation);
		if (image != null) {
			return image;
		}

		return emfProvider.getImage(operation);
	}

	private Image getCustomOperationProviderLabel(AbstractOperation operation) {
		AbstractOperationCustomLabelProvider customLabelProvider = customLabelProviderManager
			.getCustomLabelProvider(operation);
		if (customLabelProvider != null) {
			try {
				return (Image) customLabelProvider.getImage(operation);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				ModelUtil.logWarning("Image load from custom operation item provider failed!", e);
			}
		}
		return null;
	}

	/**
	 * @param op the operation to generate a description for
	 * @return the description for given operation
	 */
	public String getDescription(AbstractOperation op) {

		// check of a custom operation label provider can provide a label
		AbstractOperationCustomLabelProvider customLabelProvider = customLabelProviderManager
			.getCustomLabelProvider(op);
		if (customLabelProvider != null) {
			return decorate(customLabelProvider, op);
		}

		if (op instanceof CompositeOperation) {
			CompositeOperation compositeOperation = (CompositeOperation) op;
			// artificial composite because of opposite ref, take description of
			// mainoperation
			if (compositeOperation.getMainOperation() != null) {
				return getDescription(compositeOperation.getMainOperation());
			}
		}
		return decorate(defaultOperationLabelProvider, op);
	}

	private String decorate(AbstractOperationCustomLabelProvider labelProvider, AbstractOperation op) {
		String namesResolved = resolveIds(labelProvider, labelProvider.getDescription(op),
			AbstractOperationItemProvider.NAME_TAG__SEPARATOR);
		String allResolved = resolveIds(labelProvider, namesResolved,
			AbstractOperationItemProvider.NAME_CLASS_TAG_SEPARATOR);
		if (op instanceof ReferenceOperation) {
			return resolveTypes(allResolved, (ReferenceOperation) op);
		}
		return allResolved;
	}

	private String resolveTypes(String unresolvedString, ReferenceOperation op) {
		EObject modelElement = getModelElement(op.getModelElementId());
		String type;
		if (modelElement == null) {
			type = "ModelElement";
		} else {
			try {
				EStructuralFeature feature = op.getFeature(modelElement);
				type = feature.getEType().getName();
			} catch (UnkownFeatureException e) {
				type = "ModelElement";
			}
		}

		return unresolvedString.replace(AbstractOperationItemProvider.REFERENCE_TYPE_TAG_SEPARATOR, type);
	}

	private String resolveIds(AbstractOperationCustomLabelProvider labelProvider, String unresolvedString,
		String devider) {
		String[] strings = unresolvedString.split(devider);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			if (i % 2 == 1) {
				ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
				modelElementId.setId(strings[i]);
				stringBuilder.append(labelProvider.getModelElementName(modelElementMap, modelElementId));
			} else {
				stringBuilder.append(strings[i]);
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * Get all model elements of type T from the given collection of model elements.
	 * 
	 * @param <T> Type of the model elements in the resulting collection
	 * @param <S> Type of the Collection of model element ids
	 * @param modelElementIds the collection of model element ids
	 * @param resultCollection the transparent parameter of the collection of type T that will be return as result also
	 * @return the collection of model elements of type T
	 */
	public <T extends Collection<EObject>, S extends Collection<ModelElementId>> T getModelElements(S modelElementIds,
		T resultCollection) {
		for (ModelElementId modelElementId : modelElementIds) {
			EObject modelElement = getModelElement(modelElementId);
			if (modelElement != null) {
				resultCollection.add(modelElement);
			}
		}
		return resultCollection;
	}

	/**
	 * Get a model element instance from the project for the given id.
	 * 
	 * @param modelElementId the id
	 * @return the model element instance
	 */
	public EObject getModelElement(ModelElementId modelElementId) {
		if (modelElementId == null) {
			return null;
		}

		return modelElementMap.get(modelElementId);
	}
}
