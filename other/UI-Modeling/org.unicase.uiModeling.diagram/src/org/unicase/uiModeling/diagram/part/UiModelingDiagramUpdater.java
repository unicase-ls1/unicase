/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
 * @generated
 */
public class UiModelingDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> getSemanticChildren(View view) {
		switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
			return getPanel_45SemanticChildren(view);
		case org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
			return getWindowWindowWidgetCompartment_7001SemanticChildren(view);
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart.VISUAL_ID:
			return getRadioGroupRadioButtonsCompartment_7002SemanticChildren(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart.VISUAL_ID:
			return getCheckboxGroupCheckboxesCompartment_7003SemanticChildren(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartmentEditPart.VISUAL_ID:
			return getDropdownListDropdownItemsCompartment_7004SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> getPanel_45SemanticChildren(
		View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		org.unicase.uiModeling.Panel modelElement = (org.unicase.uiModeling.Panel) view.getElement();
		LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> result = new LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor>();
		for (Iterator<?> it = modelElement.getWidgets().iterator(); it.hasNext();) {
			org.unicase.uiModeling.Widget childElement = (org.unicase.uiModeling.Widget) it.next();
			int visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(view,
				childElement);
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> getWindowWindowWidgetCompartment_7001SemanticChildren(
		View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		org.unicase.uiModeling.Window modelElement = (org.unicase.uiModeling.Window) containerView.getElement();
		LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> result = new LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor>();
		for (Iterator<?> it = modelElement.getWidgets().iterator(); it.hasNext();) {
			org.unicase.uiModeling.Widget childElement = (org.unicase.uiModeling.Widget) it.next();
			int visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(view,
				childElement);
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> getRadioGroupRadioButtonsCompartment_7002SemanticChildren(
		View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		org.unicase.uiModeling.RadioGroup modelElement = (org.unicase.uiModeling.RadioGroup) containerView.getElement();
		LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> result = new LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor>();
		for (Iterator<?> it = modelElement.getButtons().iterator(); it.hasNext();) {
			org.unicase.uiModeling.RadioButton childElement = (org.unicase.uiModeling.RadioButton) it.next();
			int visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(view,
				childElement);
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> getCheckboxGroupCheckboxesCompartment_7003SemanticChildren(
		View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		org.unicase.uiModeling.CheckboxGroup modelElement = (org.unicase.uiModeling.CheckboxGroup) containerView
			.getElement();
		LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> result = new LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor>();
		for (Iterator<?> it = modelElement.getBoxes().iterator(); it.hasNext();) {
			org.unicase.uiModeling.Checkbox childElement = (org.unicase.uiModeling.Checkbox) it.next();
			int visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(view,
				childElement);
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> getDropdownListDropdownItemsCompartment_7004SemanticChildren(
		View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		org.unicase.uiModeling.DropdownList modelElement = (org.unicase.uiModeling.DropdownList) containerView
			.getElement();
		LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> result = new LinkedList<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor>();
		for (Iterator<?> it = modelElement.getItems().iterator(); it.hasNext();) {
			org.unicase.uiModeling.DropdownItem childElement = (org.unicase.uiModeling.DropdownItem) it.next();
			int visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(view,
				childElement);
			if (visualID == org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID) {
				result.add(new org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getContainedLinks(View view) {
		switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID:
			return getPanel_45ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
			return getWindow_2003ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
			return getLabel_2004ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
			return getTextField_2005ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
			return getButton_2006ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
			return getText_2007ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
			return getImage_2008ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
			return getRadioGroup_2009ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
			return getCheckboxGroup_2010ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
			return getDropdownList_2011ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
			return getImageButton_2012ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
			return getButton_3001ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
			return getImage_3002ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
			return getLabel_3003ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
			return getText_3004ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
			return getTextField_3005ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
			return getRadioButton_3006ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
			return getCheckbox_3007ContainedLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
			return getDropdownItem_3008ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getIncomingLinks(View view) {
		switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
			return getWindow_2003IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
			return getLabel_2004IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
			return getTextField_2005IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
			return getButton_2006IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
			return getText_2007IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
			return getImage_2008IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
			return getRadioGroup_2009IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
			return getCheckboxGroup_2010IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
			return getDropdownList_2011IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
			return getImageButton_2012IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
			return getButton_3001IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
			return getImage_3002IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
			return getLabel_3003IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
			return getText_3004IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
			return getTextField_3005IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
			return getRadioButton_3006IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
			return getCheckbox_3007IncomingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
			return getDropdownItem_3008IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getOutgoingLinks(View view) {
		switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view)) {
		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
			return getWindow_2003OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
			return getLabel_2004OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
			return getTextField_2005OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
			return getButton_2006OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
			return getText_2007OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
			return getImage_2008OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
			return getRadioGroup_2009OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
			return getCheckboxGroup_2010OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
			return getDropdownList_2011OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
			return getImageButton_2012OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
			return getButton_3001OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
			return getImage_3002OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
			return getLabel_3003OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
			return getText_3004OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
			return getTextField_3005OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
			return getRadioButton_3006OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
			return getCheckbox_3007OutgoingLinks(view);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
			return getDropdownItem_3008OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getPanel_45ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getWindow_2003ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getLabel_2004ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getTextField_2005ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getButton_2006ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getText_2007ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImage_2008ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getRadioGroup_2009ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getCheckboxGroup_2010ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getDropdownList_2011ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImageButton_2012ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getButton_3001ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImage_3002ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getLabel_3003ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getText_3004ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getTextField_3005ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getRadioButton_3006ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getCheckbox_3007ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getDropdownItem_3008ContainedLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getWindow_2003IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getLabel_2004IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getTextField_2005IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getButton_2006IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getText_2007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImage_2008IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getRadioGroup_2009IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getCheckboxGroup_2010IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getDropdownList_2011IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImageButton_2012IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getButton_3001IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImage_3002IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getLabel_3003IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getText_3004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getTextField_3005IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getRadioButton_3006IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getCheckbox_3007IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getDropdownItem_3008IncomingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getWindow_2003OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getLabel_2004OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getTextField_2005OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getButton_2006OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getText_2007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImage_2008OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getRadioGroup_2009OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getCheckboxGroup_2010OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getDropdownList_2011OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImageButton_2012OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getButton_3001OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getImage_3002OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getLabel_3003OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getText_3004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getTextField_3005OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getRadioButton_3006OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getCheckbox_3007OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getDropdownItem_3008OutgoingLinks(
		View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */

		public List<org.unicase.uiModeling.diagram.part.UiModelingNodeDescriptor> getSemanticChildren(View view) {
			return UiModelingDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */

		public List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getContainedLinks(View view) {
			return UiModelingDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */

		public List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getIncomingLinks(View view) {
			return UiModelingDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */

		public List<org.unicase.uiModeling.diagram.part.UiModelingLinkDescriptor> getOutgoingLinks(View view) {
			return UiModelingDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
