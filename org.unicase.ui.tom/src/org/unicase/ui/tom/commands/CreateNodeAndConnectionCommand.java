package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
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

public class CreateNodeAndConnectionCommand extends AbstractCommand {

	private final EditPart sourceEditPart;
	private final EditPart targetEditPart;
	private final Point sourcePoint;
	private final Point targetPoint;
	private CreateNodeCommand sourceCreationCommand;
	private CreateNodeCommand targetCreationCommand;
	private IElementType connectionElementType = null;
	private IElementType nodeElementType = null;

	protected CreateNodeAndConnectionCommand(
			DiagramEditPart editor,
			Point sourcePoint,
			Point targetPoint,
			EditPart sourceEditPart,
			EditPart targetEditPart) {
		super(editor);
		this.sourcePoint = sourcePoint;
		this.targetPoint = targetPoint;
		this.sourceEditPart = sourceEditPart;
		this.targetEditPart = targetEditPart;
	}

	public CreateNodeAndConnectionCommand(
			DiagramEditPart editor,
			Point sourcePoint, 
			EditPart targetObject) {
		this(editor, sourcePoint, null, null, targetObject);
	}

	public CreateNodeAndConnectionCommand(
			DiagramEditPart editor,
			EditPart sourceObject,
			Point targetPoint) {
		this(editor, null, targetPoint, sourceObject, null);
	}

	public CreateNodeAndConnectionCommand(
			DiagramEditPart editor,
			EditPart sourceObject,
			EditPart targetObject ){
		this(editor, null, null, sourceObject, targetObject);
	}

	public CreateNodeAndConnectionCommand(
			DiagramEditPart editor,
			Point sourcePoint,
			Point targetPoint) {
		this(editor, sourcePoint, targetPoint, null, null);
	}


	public Request createRequest() {
		CreateConnectionViewAndElementRequest newRequest 
		= new CreateConnectionViewAndElementRequest(
				getConnectionElementType(),
				((IHintedType) getConnectionElementType()).getSemanticHint(),
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
		if (getTargetEditPart() != null) {
			EObjectAdapter existingObjectAdapter = new EObjectAdapter((EObject) getTargetEditPart().getModel());
			return existingObjectAdapter;
		}else{
			if (getTargetCreationCommand() != null) {
				return getCreatedObjectAdapter(getTargetCreationCommand());
			}
		}
		return null;
	}

	private CreateNodeCommand getSourceCreationCommand(){
		if (getSourceEditPart() == null) {
			if (sourceCreationCommand == null) {
				if (getNodeElementType() == null) {
					sourceCreationCommand = new CreateDefaultNodeCommand(getDiagramEditPart(), sourcePoint);	
				}else{
					sourceCreationCommand = new CreateNodeCommand(getDiagramEditPart(), sourcePoint, getNodeElementType());
				}	
			}
		}
		return sourceCreationCommand;
	}

	private CreateNodeCommand getTargetCreationCommand(){
		if (getTargetEditPart() == null) {
			if (targetCreationCommand == null) {
				if (getNodeElementType() == null) {
					targetCreationCommand = new CreateDefaultNodeCommand(getDiagramEditPart(), targetPoint);	
				}else{
					targetCreationCommand = new CreateNodeCommand(getDiagramEditPart(), targetPoint, getNodeElementType());
				}
					
			}
		}
		return targetCreationCommand;
	}

	private IAdaptable getSourceAdapter() {
		if (getSourceEditPart() != null) {
			EObjectAdapter existingObjectAdapter = new EObjectAdapter((EObject) getSourceEditPart().getModel());
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

	public EditPart getTargetEditPart() {
		return targetEditPart;
	}

	public EditPart getSourceEditPart() {
		return sourceEditPart;
	}

	public Point getSourcePoint() {
		return sourcePoint;
	}

	public Point getTargetPoint() {
		return targetPoint;
	}

	public void setConnectionElementType(IElementType connectionElementType) {
		this.connectionElementType = connectionElementType;
	}

	public IElementType getConnectionElementType() {
		return connectionElementType;
	}

	public void setNodeElementType(IElementType nodeElementType) {
		this.nodeElementType = nodeElementType;
	}

	public IElementType getNodeElementType() {
		return nodeElementType;
	}
}
