package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.unicase.model.classDiagram.providers.ModelElementTypes;

public class CreateClassAndAssociationCommand extends AbstractCommand {

	private final EObject sourceObject;
	private final EObject targetObject;
	private final Point sourcePoint;
	private final Point targetPoint;
	private CreateClassCommand sourceCreationCommand;
	private CreateClassCommand targetCreationCommand;
	private IElementType elementType;

	private CreateClassAndAssociationCommand(
			DiagramEditPart editor,
			Point sourcePoint,
			Point targetPoint,
			EObject sourceObject,
			EObject targetObject) {
		super(editor);
		this.sourcePoint = sourcePoint;
		this.targetPoint = targetPoint;
		this.sourceObject = sourceObject;
		this.targetObject = targetObject;
		
		elementType = ModelElementTypes.Association_4002;
	}

	public CreateClassAndAssociationCommand(
			DiagramEditPart editor,
			Point sourcePoint, 
			EObject targetObject) {
		this(editor, sourcePoint, null, null, targetObject);
	}

	public CreateClassAndAssociationCommand(
			DiagramEditPart editor,
			EObject sourceObject,
			Point targetPoint) {
		this(editor, null, targetPoint, sourceObject, null);
	}

	public CreateClassAndAssociationCommand(
			DiagramEditPart editor,
			EObject sourceObject,
			EObject targetObject ){
		this(editor, null, null, sourceObject, targetObject);
	}

	public CreateClassAndAssociationCommand(
			DiagramEditPart editor,
			Point sourcePoint,
			Point targetPoint) {
		this(editor, sourcePoint, targetPoint, null, null);
	}


	public Request createRequest() {
		CreateConnectionViewAndElementRequest newRequest 
		= new CreateConnectionViewAndElementRequest(
				elementType,
				((IHintedType) elementType).getSemanticHint(),
				((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());

		return newRequest;
	}

	public org.eclipse.gef.commands.Command getCommand() {
		CompoundCommand compoundCommand;
		compoundCommand = new CompoundCommand("Create classes and association");

		if (getSourceCreationCommand() != null) {
			compoundCommand.add(getSourceCreationCommand().getCommand());	
		}
		if (getTargetCreationCommand() != null) {
			compoundCommand.add(getTargetCreationCommand().getCommand());	
		}

		DeferredCreateConnectionViewAndElementCommand deferredCreateConnectionViewAndElementCommand 
		= new DeferredCreateConnectionViewAndElementCommand(
				(CreateConnectionViewAndElementRequest) getRequest(), 
				getSourceAdapter(), 
				getTargetAdapter(), 
				getDiagramEditPart().getViewer());

		compoundCommand.add(new ICommandProxy(deferredCreateConnectionViewAndElementCommand));

		return compoundCommand;
	}

	@SuppressWarnings("unchecked")
	private IAdaptable getCreatedObjectAdapter(Command command){
		Request classRequest = command.getRequest();
		Object newObject = ((CreateViewAndElementRequest)classRequest).getNewObject();

		IAdaptable newObjectAdapter = null;
		if (newObject instanceof List) {
			newObjectAdapter = (IAdaptable) ((List) newObject).get(0);
		}else{
			newObjectAdapter = (IAdaptable) newObject;
		}
		return newObjectAdapter;
	}

	private IAdaptable getTargetAdapter() {
		if (getTargetObject() != null) {
			EObjectAdapter existingObjectAdapter = new EObjectAdapter(getTargetObject());
			return existingObjectAdapter;
		}else{
			if (getTargetCreationCommand() != null) {
				return getCreatedObjectAdapter(getTargetCreationCommand());
			}
		}
		return null;
	}

	private CreateClassCommand getSourceCreationCommand(){
		if (getSourceObject() == null) {
			if (sourceCreationCommand == null) {
				sourceCreationCommand = new CreateClassCommand(getDiagramEditPart(), sourcePoint);	
			}
		}
		return sourceCreationCommand;
	}

	private CreateClassCommand getTargetCreationCommand(){
		if (getTargetObject() == null) {
			if (targetCreationCommand == null) {
				targetCreationCommand = new CreateClassCommand(getDiagramEditPart(), targetPoint);	
			}
		}
		return targetCreationCommand;
	}

	private IAdaptable getSourceAdapter() {
		if (getSourceObject() != null) {
			EObjectAdapter existingObjectAdapter = new EObjectAdapter(getSourceObject());
			return existingObjectAdapter;
		}else{
			if (getSourceCreationCommand() != null) {
				return getCreatedObjectAdapter(getSourceCreationCommand());
			}
		}
		return null;
	}


	public void execute() {
		org.eclipse.gef.commands.Command command = getCommand();
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}

	public EObject getTargetObject() {
		return targetObject;
	}

	public EObject getSourceObject() {
		return sourceObject;
	}

	public Point getSourcePoint() {
		return sourcePoint;
	}

	public Point getTargetPoint() {
		return targetPoint;
	}
}
