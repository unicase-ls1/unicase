/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.unicase.emfstore.esmodel.versioning.operations.provider.AbstractOperationItemProvider;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.util.UiUtil;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A helper class for the visualization of change packages.
 * 
 * @author koegel
 * @author shterev
 */
public class ChangePackageVisualizationHelper {

	private static final int MAX_NAME_SIZE = 30;
	private Project project;
	private Map<ModelElementId, EObject> modelElementMap;
	private static final String UNKOWN_ELEMENT = "(Unkown Element)";
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	private List<ChangePackageVisualizer> list;

	/**
	 * Constructor.
	 * 
	 * @param changePackages a list of change packages
	 * @param project a project
	 */
	public ChangePackageVisualizationHelper(List<ChangePackage> changePackages, Project project) {
		this.modelElementMap = new HashMap<ModelElementId, EObject>();
		this.project = project;
		for (ChangePackage changePackage : changePackages) {
			initModelElementMap(changePackage);
		}

		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	private void initModelElementMap(ChangePackage changePackage) {
		List<AbstractOperation> operations = changePackage.getLeafOperations();
		for (AbstractOperation abstractOperation : operations) {
			if (abstractOperation instanceof CreateDeleteOperation) {
				EObject modelElement = ((CreateDeleteOperation) abstractOperation).getModelElement();
				modelElementMap.put(abstractOperation.getModelElementId(), modelElement);
				for (EObject sibling : ModelUtil.getAllContainedModelElements(modelElement, false)) {
					ModelElementId siblingId = project.getModelElementId(sibling);
					modelElementMap.put(siblingId, sibling);
				}
			}
		}
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
		} else if (project.contains(modelElementId)) {
			EObject modelElement = project.getModelElement(modelElementId);
			// if (modelElement instanceof ModelElementEObjectWrapper) {
			// return ((ModelElementEObjectWrapper) modelElement)
			// .getWrappedEObject();
			// }
			return modelElement;
		} else {
			return modelElementMap.get(modelElementId);
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

		ImageDescriptor overlayDescriptor = org.unicase.ui.common.Activator.getImageDescriptor(overlay);
		return overlayDescriptor;
	}

	void initChangePackageVisualizer() {
		IConfigurationElement[] attributecontrols = Platform.getExtensionRegistry().getConfigurationElementsFor("myID");
		for (IConfigurationElement e : attributecontrols) {
			try {
				ChangePackageVisualizer visualizer = (ChangePackageVisualizer) e.createExecutableExtension("class");
				list.add(visualizer);

			} catch (CoreException e2) {
				WorkspaceUtil.logException(e2.getMessage(), e2);
			}
		}
		// Put this at get description or getImage
		for (ChangePackageVisualizer changePackageVisualizer : list) {
			// changePackageVisualizer.canRender(operation);
			// Take the highest visulaizer
			// Test Performance, if bad chaseh map operation / visusliazer
		}
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
	 * @param op the operation to generate a description for
	 * @return the description for given operation
	 */
	public String getDescription(AbstractOperation op) {

		if (op instanceof CompositeOperation) {
			CompositeOperation compositeOperation = (CompositeOperation) op;
			// artificial composite because of opposite ref, take description of
			// mainoperation
			if (compositeOperation.getMainOperation() != null) {
				return getDescription(compositeOperation.getMainOperation());
			}
		}
		return decorate(adapterFactoryLabelProvider.getText(op), op);
	}

	private String decorate(String undecoratedString, AbstractOperation op) {
		String namesResolved = resolveIds(undecoratedString, AbstractOperationItemProvider.NAME_TAG__SEPARATOR);
		String allResolved = resolveIds(namesResolved, AbstractOperationItemProvider.NAME_CLASS_TAG_SEPARATOR);
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
		if (type.equals("UnicaseModelElement")) {
			type = "ModelElement";
		}
		return unresolvedString.replace(AbstractOperationItemProvider.REFERENCE_TYPE_TAG_SEPARATOR, type);
	}

	private String resolveIds(String unresolvedString, String devider) {
		String[] strings = unresolvedString.split(devider);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			if (i % 2 == 1) {
				ModelElementId modelElementId = MetamodelFactory.eINSTANCE.createModelElementId();
				modelElementId.setId(strings[i]);
				if (devider.equals(AbstractOperationItemProvider.NAME_CLASS_TAG_SEPARATOR)) {
					stringBuilder.append(getModelElementClassAndName(modelElementId));
				} else {
					stringBuilder.append(getModelElementName(modelElementId));
				}
			} else {
				stringBuilder.append(strings[i]);
			}
		}
		return stringBuilder.toString();
	}

	private String getModelElementName(ModelElementId modelElementId) {
		EObject modelElement = getModelElement(modelElementId);
		if (modelElement == null) {
			return UNKOWN_ELEMENT;
		}
		return " \"" + trim(adapterFactoryLabelProvider.getText(modelElement)) + "\"";
	}

	private String trim(Object object) {
		if (object == null) {
			return "(Unkown Element)";
		}
		String string = object.toString();
		String result = string.trim();
		if (result.length() > MAX_NAME_SIZE) {
			return result.substring(0, MAX_NAME_SIZE) + "...";
		}
		if (result.length() == 0) {
			return "(empty name)";
		}
		return result;
	}

	private String getModelElementClassAndName(ModelElementId modelElementId) {
		if (modelElementId == null) {
			return UNKOWN_ELEMENT;
		}
		return getModelElementClassAndName(getModelElement(modelElementId));
	}

	private String getModelElementClassAndName(EObject modelElement) {
		if (modelElement == null) {
			return UNKOWN_ELEMENT;
		}
		String className;
		// if (modelElement instanceof ModelElementEObjectWrapper) {
		// className = ((ModelElementEObjectWrapper) modelElement)
		// .getWrappedEObject().eClass().getName();
		// } else {
		className = modelElement.eClass().getName();
		// }
		return className + " \"" + trim(UiUtil.getNameForModelElement(modelElement)) + "\"";
	}

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
}
