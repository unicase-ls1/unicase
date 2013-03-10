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
		paletteRoot.add(createBasic2Group());
		paletteRoot.add(createTextTools3Group());
		paletteRoot.add(createButtons4Group());
	}

	/**
	 * Creates "Default" palette tool group
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
	 * Creates "Basic" palette tool group
	 * @generated
	 */
	private PaletteContainer createBasic2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
			org.unicase.uiModeling.diagram.part.Messages.Basic2Group_title);
		paletteContainer.setId("createBasic2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.unicase.uiModeling.diagram.part.Messages.Basic2Group_desc);
		paletteContainer.add(createWindow1CreationTool());
		paletteContainer.add(createImage2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "TextTools" palette tool group
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
	 * Creates "Buttons" palette tool group
	 * @generated
	 */
	private PaletteContainer createButtons4Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
			org.unicase.uiModeling.diagram.part.Messages.Buttons4Group_title);
		paletteContainer.setId("createButtons4Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.unicase.uiModeling.diagram.part.Messages.Buttons4Group_desc);
		paletteContainer.add(createButton1CreationTool());
		paletteContainer.add(createRadioGroup2CreationTool());
		paletteContainer.add(createRadioButton3CreationTool());
		paletteContainer.add(createCheckboxGroup4CreationTool());
		paletteContainer.add(createCheckbox5CreationTool());
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
	private ToolEntry createButton1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_2006);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Button1CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Button1CreationTool_desc, types);
		entry.setId("createButton1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRadioGroup2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.RadioGroup2CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.RadioGroup2CreationTool_desc,
			Collections.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009));
		entry.setId("createRadioGroup2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRadioButton3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.RadioButton3CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.RadioButton3CreationTool_desc,
			Collections.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006));
		entry.setId("createRadioButton3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCheckboxGroup4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.CheckboxGroup4CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.CheckboxGroup4CreationTool_desc,
			Collections
				.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010));
		entry.setId("createCheckboxGroup4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCheckbox5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.Checkbox5CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Checkbox5CreationTool_desc,
			Collections.singletonList(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007));
		entry.setId("createCheckbox5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007));
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
