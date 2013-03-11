/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class UiModelingPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDefault1Group());
		paletteRoot.add(createWindowelements2Group());
		paletteRoot.add(createTextTools3Group());
		paletteRoot.add(createFormElements4Group());
	}

	/**
	 * Creates "Default" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
			org.unicase.uiModeling.diagram.part.Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.unicase.uiModeling.diagram.part.Messages.Default1Group_desc);
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(new PaletteSeparator());
		return paletteContainer;
	}

	/**
	 * Creates "Window elements" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createWindowelements2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
			org.unicase.uiModeling.diagram.part.Messages.Windowelements2Group_title);
		paletteContainer.setId("createWindowelements2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.unicase.uiModeling.diagram.part.Messages.Windowelements2Group_desc);
		paletteContainer.add(createWindow1CreationTool());
		paletteContainer.add(createImage2CreationTool());
		paletteContainer.add(createButton3CreationTool());
		paletteContainer.add(createImageButton4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "TextTools" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createTextTools3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
			org.unicase.uiModeling.diagram.part.Messages.TextTools3Group_title);
		paletteContainer.setId("createTextTools3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.unicase.uiModeling.diagram.part.Messages.TextTools3Group_desc);
		paletteContainer.add(createLabel1CreationTool());
		paletteContainer.add(createTextField2CreationTool());
		paletteContainer.add(createText3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Form Elements" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createFormElements4Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
			org.unicase.uiModeling.diagram.part.Messages.FormElements4Group_title);
		paletteContainer.setId("createFormElements4Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.unicase.uiModeling.diagram.part.Messages.FormElements4Group_desc);
		paletteContainer.add(createRadioGroup1CreationTool());
		paletteContainer.add(createRadioButton2CreationTool());
		paletteContainer.add(createCheckboxGroup3CreationTool());
		paletteContainer.add(createCheckbox4CreationTool());
		paletteContainer.add(createDropdownList5CreationTool());
		paletteContainer.add(createDropdownItem6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createWindow1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Window1CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Window1CreationTool_desc,
			Collections.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Window_2003));
		entry.setId("createWindow1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Window_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImage2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_3002);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_2008);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Image2CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Image2CreationTool_desc, types);
		entry.setId("createImage2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createButton3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_2006);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Button3CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Button3CreationTool_desc, types);
		entry.setId("createButton3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImageButton4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.ImageButton4CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.ImageButton4CreationTool_desc,
			Collections.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.ImageButton_2012));
		entry.setId("createImageButton4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.ImageButton_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLabel1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_3003);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_2004);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Label1CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Label1CreationTool_desc, types);
		entry.setId("createLabel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTextField2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_3005);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_2005);
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.TextField2CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.TextField2CreationTool_desc, types);
		entry.setId("createTextField2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createText3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_3004);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_2007);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Text3CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Text3CreationTool_desc, types);
		entry.setId("createText3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRadioGroup1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.RadioGroup1CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.RadioGroup1CreationTool_desc,
			Collections.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009));
		entry.setId("createRadioGroup1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRadioButton2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.RadioButton2CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.RadioButton2CreationTool_desc,
			Collections.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006));
		entry.setId("createRadioButton2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCheckboxGroup3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.CheckboxGroup3CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.CheckboxGroup3CreationTool_desc,
			Collections
				.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010));
		entry.setId("createCheckboxGroup3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCheckbox4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.Checkbox4CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Checkbox4CreationTool_desc,
			Collections.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007));
		entry.setId("createCheckbox4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDropdownList5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.DropdownList5CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.DropdownList5CreationTool_desc,
			Collections
				.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownList_2011));
		entry.setId("createDropdownList5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownList_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDropdownItem6CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.DropdownItem6CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.DropdownItem6CreationTool_desc,
			Collections
				.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownItem_3008));
		entry.setId("createDropdownItem6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownItem_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
