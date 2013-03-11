/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class UiModelingModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.PanelEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(10);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Window_2003);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_2004);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_2005);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_2006);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_2007);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_2008);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownList_2011);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.ImageButton_2012);
			return types;
		}
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006);
			return types;
		}
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007);
			return types;
		}
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownItem_3008);
			return types;
		}
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_3002);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_3003);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_3004);
			types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_3005);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance()
				.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(org.unicase.uiModeling.diagram.part.Messages.UiModelingModelingAssistantProviderMessage);
		dialog.setTitle(org.unicase.uiModeling.diagram.part.Messages.UiModelingModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
