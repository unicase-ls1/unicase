package org.unicase.wireframe.diagram.part;

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
import org.unicase.wireframe.diagram.providers.WireframeElementTypes;

/**
 * @generated
 */
public class WireframePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createWireframeTools1Group());
	}

	/**
	 * Creates "WireframeTools" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createWireframeTools1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.WireframeTools1Group_title);
		paletteContainer.setId("createWireframeTools1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.WireframeTools1Group_desc);
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
		NodeToolEntry entry = new NodeToolEntry(Messages.Window1CreationTool_title, Messages.Window1CreationTool_desc,
			Collections.singletonList(WireframeElementTypes.Window_2003));
		entry.setId("createWindow1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WireframeElementTypes.getImageDescriptor(WireframeElementTypes.Window_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLabel2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(WireframeElementTypes.Label_3003);
		types.add(WireframeElementTypes.Label_2004);
		NodeToolEntry entry = new NodeToolEntry(Messages.Label2CreationTool_title, Messages.Label2CreationTool_desc,
			types);
		entry.setId("createLabel2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WireframeElementTypes.getImageDescriptor(WireframeElementTypes.Label_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTextField3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(WireframeElementTypes.TextField_3005);
		types.add(WireframeElementTypes.TextField_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.TextField3CreationTool_title,
			Messages.TextField3CreationTool_desc, types);
		entry.setId("createTextField3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WireframeElementTypes.getImageDescriptor(WireframeElementTypes.TextField_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createButton4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(WireframeElementTypes.Button_3001);
		types.add(WireframeElementTypes.Button_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.Button4CreationTool_title, Messages.Button4CreationTool_desc,
			types);
		entry.setId("createButton4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WireframeElementTypes.getImageDescriptor(WireframeElementTypes.Button_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createText5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(WireframeElementTypes.Text_3004);
		types.add(WireframeElementTypes.Text_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.Text5CreationTool_title, Messages.Text5CreationTool_desc,
			types);
		entry.setId("createText5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WireframeElementTypes.getImageDescriptor(WireframeElementTypes.Text_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImage6CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(WireframeElementTypes.Image_3002);
		types.add(WireframeElementTypes.Image_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.Image6CreationTool_title, Messages.Image6CreationTool_desc,
			types);
		entry.setId("createImage6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(WireframeElementTypes.getImageDescriptor(WireframeElementTypes.Image_3002));
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
