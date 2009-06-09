/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classDiagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class ModelModelingAssistantProvider extends org.unicase.ui.common.diagram.providers.ModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
			List types = new ArrayList();
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Attribute_3001);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Method_3002);
			return types;
		}
		if (editPart instanceof org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart) {
			List types = new ArrayList();
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Package_2002);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
			List types = new ArrayList();
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4001);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4002);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4003);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4004);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007);
			types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006);
			return types;
		}else if (sourceEditPart instanceof org.unicase.model.classDiagram.edit.parts.PackageEditPart) {
			List types = new ArrayList();
			types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006);
			return types;
		}

		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
			List types = new ArrayList();
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4001);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4002);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4003);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4004);
			types
					.add(org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007);
			types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006);
			return types;
		}else if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.PackageEditPart) {
			List types = new ArrayList();
			types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4001);
			}
			if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4002);
			}
			if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4003);
			}
			if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4004);
			}
			if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007);
			}
			if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.PackageEditPart) {
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006);
			}
			return types;
		}
		
		if (sourceEditPart instanceof org.unicase.model.classDiagram.edit.parts.PackageEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart){ 
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006);
			}
			if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.PackageEditPart) {
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006);
			}
			return types;
		}
		
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
			List types = new ArrayList();
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4001) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4002) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4003) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4004) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006) {
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Package_2002);
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			
			return types;
		}
		
		if (targetEditPart instanceof org.unicase.model.classDiagram.edit.parts.PackageEditPart) {
			List types = new ArrayList();
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006) {
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Package_2002);
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassEditPart) {
			List types = new ArrayList();
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4001) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4002) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4003) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4004) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007) {
				types
						.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006) {
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Package_2002);
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			return types;
		}
		
		if (sourceEditPart instanceof org.unicase.model.classDiagram.edit.parts.PackageEditPart) {
			List types = new ArrayList();
			if (relationshipType == org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006) {
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Package_2002);
				types.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	@Override
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog
				.setMessage(org.unicase.model.classDiagram.part.Messages.ModelModelingAssistantProviderMessage);
		dialog
				.setTitle(org.unicase.model.classDiagram.part.Messages.ModelModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
