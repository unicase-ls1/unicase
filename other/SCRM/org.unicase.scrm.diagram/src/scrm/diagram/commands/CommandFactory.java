/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package scrm.diagram.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import scrm.SCRMDiagram;
import scrm.diagram.util.DynamicEObjectAdapter;
import scrm.diagram.util.EditPartUtility;
import org.unicase.workspace.WorkspaceManager;

/**
 * Factory class for GMF {@link Command}s.
 * 
 * @author schroech, denglerm
 */
@SuppressWarnings("restriction")
public class CommandFactory {

	private static final CommandFactory INSTANCE = new CommandFactory();

	/**
	 * An Adapter adapting EObjects to IElementTypes.
	 * 
	 * @author schroech
	 */
	public class ElementTypeAdapter extends EObjectAdapter {

		/**
		 * Default constructor.
		 * 
		 * @param element The adaptable element
		 */
		public ElementTypeAdapter(EObject element) {
			super(element);
		}

		/**
		 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
		 * @param adapter The class that should be adapted
		 * @return The {@link Object} adapting to class adapter
		 */
		@SuppressWarnings("rawtypes")
		@Override
		public Object getAdapter(java.lang.Class adapter) {
			Object object = super.getAdapter(adapter);
			if (object == null) {
				if (adapter == IElementType.class) {
					object = ElementTypeRegistry.getInstance().getElementType(getRealObject());
				}
			}
			return object;
		}

	}

	/**
	 * @param viewDescriptors The {@link ViewDescriptor}s which should be arranged
	 * @param editPart The {@link EditPart} which will be asked for the command
	 * @return A layout command, depending on the EditPolicies of the {@link EditPart}
	 */
	public static Command createArrangeCommand(Collection<ViewDescriptor> viewDescriptors, EditPart editPart) {
		ArrangeRequest arrangeRequest = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED, LayoutType.RADIAL);
		ArrayList<ViewDescriptor> viewAdapters = new ArrayList<ViewDescriptor>(viewDescriptors);

		arrangeRequest.setViewAdaptersToArrange(viewAdapters);
		Command command = editPart.getCommand(arrangeRequest);

		return command;
	}

	/**
	 * @param object The object to be colorized
	 * @param host The {@link DiagramEditPart} containing the object's {@link EditPart}
	 * @return A {@link CompoundCommand} containing {@link SetPropertyCommand}s
	 */
	public static Command createColorizeCommand(EObject object, DiagramEditPart host) {

		CompoundCommand cc = new CompoundCommand("Colorize");

		SetPropertyCommand setLineColorCommand = new SetPropertyCommand(host.getEditingDomain(), "Set line color",
			new DynamicEObjectAdapter(object, host), Properties.ID_LINECOLOR,
			FigureUtilities.colorToInteger(DiagramColorConstants.blue));

		Command setLineColorCommandProxy = new ICommandProxy(setLineColorCommand);
		cc.add(setLineColorCommandProxy);

		Color veryLightBlue = new Color(null, 240, 240, 255);
		SetPropertyCommand setFillColorCommand = new SetPropertyCommand(host.getEditingDomain(), "Set fill color",
			new DynamicEObjectAdapter(object, host), Properties.ID_FILLCOLOR,
			FigureUtilities.colorToInteger(veryLightBlue));

		Command setFillColorCommandProxy = new ICommandProxy(setFillColorCommand);
		cc.add(setFillColorCommandProxy);

		SetPropertyCommand setFontColorCommand = new SetPropertyCommand(host.getEditingDomain(), "Set font color",
			new DynamicEObjectAdapter(object, host), Properties.ID_FONTCOLOR,
			FigureUtilities.colorToInteger(DiagramColorConstants.blue));

		Command setFontColorCommandProxy = new ICommandProxy(setFontColorCommand);
		cc.add(setFontColorCommandProxy);

		return cc;
	}

	/**
	 * @param cc The {@link CompoundCommand} to which commands should be added
	 * @param viewDescriptors The {@link ViewDescriptor}s for the creation of the arrange commands
	 * @param editPart The {@link EditPart} which will be asked for the commands
	 */
	public static void addArrangeCommand(CompoundCommand cc, Collection<ViewDescriptor> viewDescriptors,
		EditPart editPart) {
		Command createArrangeCommand = createArrangeCommand(viewDescriptors, editPart);
		cc.add(createArrangeCommand);
	}

	/**
	 * @param editPart The {@link EditPart} whose {@link View} should be deleted
	 * @return A {@link DeleteCommand} wrapped in an {@link ICommandProxy}
	 */
	public static Command createDeleteFromViewCommand(EditPart editPart) {
		View viewToDestroy = EditPartUtility.getView(editPart);
		DeleteCommand deleteCommand = new DeleteCommand(viewToDestroy);
		return new ICommandProxy(deleteCommand);
	}

	/**
	 * @param editPart The {@link EditPart} whose {@link View} should be deleted
	 * @return A {@link DeleteCommand} wrapped in an {@link ICommandProxy}
	 */
	public static Command createDeleteFromDiagramCommand(EditPart editPart) {
		DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain) WorkspaceManager
			.getInstance().getCurrentWorkspace().getEditingDomain(), EditPartUtility.getElement(editPart), false);
		IElementType type = ElementTypeRegistry.getInstance().getElementType(request.getEditHelperContext());
		if (type != null) {
			return new ICommandProxy(new DeleteFromDiagramCommand(request, editPart));
		}
		// return null: a null command within a CompoundCommand is not executed.
		return null;
	}

	/**
	 * @param editPart The {@link EditPart} of the model element which should be deleted
	 * @return A {@link DeleteCommand} wrapped in an {@link ICommandProxy}
	 */
	public static Command createDeleteFromModelCommand(EditPart editPart) {
		DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain) WorkspaceManager
			.getInstance().getCurrentWorkspace().getEditingDomain(), EditPartUtility.getElement(editPart), false);
		IElementType type = ElementTypeRegistry.getInstance().getElementType(request.getEditHelperContext());
		if (type != null) {
			return new ICommandProxy(new DeleteFromModelCommand(request));
		}
		// return null: a null command within a CompoundCommand is not executed.
		return null;
	}

	/**
	 * @param cc The {@link CompoundCommand} that should contain the {@link DeleteCommand}s
	 * @param editParts The {@link EditPart}s whose {@link View}s should be deleted
	 */
	public static void addDeleteFromViewCommands(CompoundCommand cc, Collection<? extends EditPart> editParts) {
		for (EditPart editPart : editParts) {
			Command deleteFromViewCommand = createDeleteFromViewCommand(editPart);
			cc.add(deleteFromViewCommand);
		}
	}

	/**
	 * @param cc The {@link CompoundCommand} that should contain the {@link DeleteCommand}s
	 * @param objects The {@link EObject}s for which commands should be created
	 * @param editPart The {@link EditPart}
	 */
	public static void addCreateViewCommands(CompoundCommand cc, Collection<EObject> objects, EditPart editPart) {
		for (EObject object : objects) {
			Command createViewCommand = createCreateNodeViewCommand(object, editPart);
			if (createViewCommand == null) {
				continue;
			}
			cc.add(createViewCommand);
		}
	}

	/**
	 * @param object The {@link EObject} for which the command should be created
	 * @param editPart The {@link EditPart} which will be asked for the command
	 * @return The command
	 */
	public static Command createCreateNodeViewCommand(EObject object, EditPart editPart) {
		CreateNodeViewCommandProvider provider = new CreateNodeViewCommandProvider(editPart, object);
		Command command = provider.getCommand();
		return command;
	}

	/**
	 * @param cc The {@link CompoundCommand} that should contain the {@link DeleteCommand}s
	 * @param objects The {@link EObject}s for which commands should be created
	 * @param editPart The {@link EditPart} which will be asked for the command
	 * @param addReferences true if references to other diagram elemenets should be added
	 */
	public static void addDiagramElementAddCommands(CompoundCommand cc, List<EObject> objects,
		DiagramEditPart editPart, boolean addReferences) {
		for (EObject object : objects) {
			Command createDiagramElementAddCommand = createDiagramElementAddCommand(object, editPart, addReferences);
			if (createDiagramElementAddCommand == null) {
				continue;
			}
			cc.add(createDiagramElementAddCommand);
		}
	}

	/**
	 * @param object The object
	 * @param editPart The {@link EditPart}
	 * @param addReferences true if connecting references between nodes should also be added
	 * @return The {@link Command}
	 */
	public static Command createDiagramElementAddCommand(EObject object, EditPart editPart, boolean addReferences) {

		EObject model = EditPartUtility.getElement(editPart);
		if (model instanceof SCRMDiagram) {
			return createDiagramElementAddCommand(object, (SCRMDiagram) model, addReferences);
		}
		return null;
	}

	/**
	 * @param object The object
	 * @param meDiagram The {@link MEDiagram}
	 * @param addReferences true if connecting references between nodes should also be added
	 * @return The {@link Command}
	 */
	public static Command createDiagramElementAddCommand(EObject object, SCRMDiagram meDiagram, boolean addReferences) {

		DiagramElementAddRequest request = new DiagramElementAddRequest(meDiagram, ElementTypeRegistry.getInstance()
			.getElementType(object));

		request.setNewElement(object);
		request.setAddReferences(addReferences);

		DiagramElementAddCommand addCommand = new DiagramElementAddCommand(request);

		return new ICommandProxy(addCommand);
	}

	/**
	 * @param object The object for which a {@link ViewDescriptor} should be created
	 * @return A {@link ViewDescriptor} for the object
	 */
	public static ViewDescriptor createViewDescriptorForEdge(EObject object) {
		return CommandFactory.getInstance().createViewDescriptorForObject(object, Edge.class);
	}

	/**
	 * @param object The object for which a {@link ViewDescriptor} should be created
	 * @return A {@link ViewDescriptor} for the object
	 */
	public static ViewDescriptor createViewDescriptorForNode(EObject object) {
		return CommandFactory.getInstance().createViewDescriptorForObject(object, Node.class);
	}

	/**
	 * @param object The object for which a {@link ViewDescriptor} should be created
	 * @param viewKind The viewKind of the object
	 * @return A {@link ViewDescriptor} for the object
	 */
	@SuppressWarnings("rawtypes")
	public ViewDescriptor createViewDescriptorForObject(EObject object, java.lang.Class viewKind) {
		IAdaptable objectAdapter = new ElementTypeAdapter(object);

		IElementType elementType = ElementTypeRegistry.getInstance().getElementType(object);
		if (!(elementType instanceof IHintedType)) {
			return null;
		}
		String hintedElementType = ((IHintedType) elementType).getSemanticHint();
		if (hintedElementType == null) {
			return null;
		}

		ViewDescriptor viewDescriptor;
		if (viewKind == Edge.class) {
			viewDescriptor = new ConnectionViewDescriptor(objectAdapter, hintedElementType, false,
				PreferencesHint.USE_DEFAULTS);
		} else {
			viewDescriptor = new ViewDescriptor(objectAdapter, viewKind, hintedElementType, false,
				PreferencesHint.USE_DEFAULTS);
		}

		return viewDescriptor;
	}

	/**
	 * @return The singleton class instance
	 */
	public static CommandFactory getInstance() {
		return INSTANCE;
	}

}
