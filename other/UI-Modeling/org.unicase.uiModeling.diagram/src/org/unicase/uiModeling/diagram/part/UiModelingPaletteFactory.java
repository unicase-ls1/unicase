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
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
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
		paletteRoot.add(createUiModelingTools1Group());
	}

	/**
	 * Creates "UiModelingTools" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createUiModelingTools1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
			org.unicase.uiModeling.diagram.part.Messages.UiModelingTools1Group_title);
		paletteContainer.setId("createUiModelingTools1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(org.unicase.uiModeling.diagram.part.Messages.UiModelingTools1Group_desc);
		paletteContainer.add(createWindow1CreationTool());
		paletteContainer.add(createLabel2CreationTool());
		paletteContainer.add(createTextField3CreationTool());
		paletteContainer.add(createButton4CreationTool());
		paletteContainer.add(createText5CreationTool());
		paletteContainer.add(createImage6CreationTool());
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
	private ToolEntry createLabel2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_3003);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_2004);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Label2CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Label2CreationTool_desc, types);
		entry.setId("createLabel2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTextField3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_3005);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_2005);
		NodeToolEntry entry = new NodeToolEntry(
			org.unicase.uiModeling.diagram.part.Messages.TextField3CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.TextField3CreationTool_desc, types);
		entry.setId("createTextField3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createButton4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_2006);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Button4CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Button4CreationTool_desc, types);
		entry.setId("createButton4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createText5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_3004);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_2007);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Text5CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Text5CreationTool_desc, types);
		entry.setId("createText5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImage6CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_3002);
		types.add(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_2008);
		NodeToolEntry entry = new NodeToolEntry(org.unicase.uiModeling.diagram.part.Messages.Image6CreationTool_title,
			org.unicase.uiModeling.diagram.part.Messages.Image6CreationTool_desc, types);
		entry.setId("createImage6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes
			.getImageDescriptor(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_3002));
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
