package org.unicase.model.classDiagram.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.unicase.model.classDiagram.edit.parts.Association1EditPart;
import org.unicase.model.classDiagram.edit.parts.Association2EditPart;
import org.unicase.model.classDiagram.edit.parts.Association3EditPart;
import org.unicase.model.classDiagram.edit.parts.Association4EditPart;
import org.unicase.model.classDiagram.edit.parts.ClassEditPart;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.impl.ClassImpl;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.diagram.commands.CommandFactory;
import org.unicase.ui.common.diagram.commands.CreateConnectionViewCommandProvider;
import org.unicase.ui.common.diagram.commands.CreateNodeViewCommandProvider;
import org.unicase.ui.common.diagram.util.CommandUtility;
import org.unicase.ui.common.diagram.util.EditPartUtility;
import org.unicase.ui.common.diagram.util.ViewAdapter;
import org.unicase.ui.common.util.CollectionFilter;

/**
 * An Edit Policy providing a {@link CompoundCommand} in response to a {@link ShowRelatedElementsRequest}.
 * The command shows representations or previews of classes and associations 
 * on the canvas which are semantically connected to the request's class.     
 * In the future, this should be extended to generic diagram nodes and connections.    
 *  
 * @author schroech
 *
 */
public class MEDiagramShowElementsEditPolicy extends AbstractEditPolicy {

	private Map<EObject,ViewDescriptor> objectViewDescriptorMap;

	private SelectionChangeListener selectionChangeListener = new SelectionChangeListener();

	private ClassEditPart primaryClassEditPart;

	/**
	 * Default constructor. 
	 */
	public MEDiagramShowElementsEditPolicy() {
		objectViewDescriptorMap = new HashMap<EObject,ViewDescriptor>();
	}

	/**
	 * Private class listening for selection change events on the edit policies host.
	 * Tracks the current selection and hides or shows classes in response.
	 * 
	 * @author schroech
	 *
	 */
	private class SelectionChangeListener implements ISelectionChangedListener {

		/**
		 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			if (getObjectViewDescriptorMap().size() == 0) {
				return;
			}

			Object diagram = EditPartUtility.getElement(getHost());
			if (!(diagram instanceof MEDiagram)) {
				return;
			}

			EditPart selectedEditPart = getSelectedEditPart(event);
			if (selectedEditPart == null) {
				return;
			}

			Set<EditPart> editParts = getRelatedEditParts();
			if (editParts.size() == 0) {
				return;
			}

			CompoundCommand cc = new CompoundCommand("Delete existing views, create new ones for selected EditParts");

			CommandFactory.addDeleteFromViewCommands(cc, editParts);
			addAddCommands(cc, selectedEditPart, editParts);

			Command wrappedCommand = CommandUtility.wrapInToggleCanonicalModeCommands(cc, Collections.singleton(getHost()));

			reset();

			((DiagramEditPart) getHost()).getDiagramEditDomain()
			.getDiagramCommandStack().execute(wrappedCommand);
		}

		private void addAddCommands(CompoundCommand cc, EditPart selectedEditPart, Set<EditPart> editParts) {
			if (selectedEditPart == null) {
				return;
			}

			if (editParts == null
				|| editParts.size() == 0) {
				return;
			}

			CompoundCommand addCompound = new CompoundCommand("Add views");

			if(editParts.contains(selectedEditPart)) {

				Class classToAdd = getClassToAdd(selectedEditPart);
				Set<Association> associationsToAdd = getAssociationsToAdd(classToAdd, selectedEditPart);
				Rectangle editPartBounds = getEditPartBounds(selectedEditPart);

				if (classToAdd != null) {

					CompoundCommand addElementCompound = new CompoundCommand("Add element");

					CreateNodeViewCommandProvider provider = new CreateNodeViewCommandProvider(
						getHost(),
						classToAdd);

					CreateViewRequest request = provider.getRequest();
					request.setLocation(editPartBounds.getLocation());
					request.setSize(editPartBounds.getSize());

					Command createNodeViewCommand = provider.getCommand();

					Command strippedCommand = CommandUtility.stripToggleCanonicalModeCommands(createNodeViewCommand);
					addElementCompound.add(strippedCommand);

					Command createDiagramElementAddCommand = CommandFactory.createDiagramElementAddCommand(classToAdd, getHost());
					addElementCompound.add(createDiagramElementAddCommand);

					Command wrappedCommand = CommandUtility.wrapInToggleCanonicalModeCommands(addElementCompound, Collections.singleton(getHost()));
					addCompound.add(wrappedCommand);
				}

				for (Association association : associationsToAdd) {
					Command createDiagramElementAddCommand = CommandFactory.createDiagramElementAddCommand(association, getHost());
					addCompound.add(createDiagramElementAddCommand);
				}

			}

			Command unwrap = addCompound.unwrap();
			if (unwrap != UnexecutableCommand.INSTANCE) {
				cc.add(unwrap);	
			}
		}

		private Rectangle getEditPartBounds(EditPart selectedEditPart) {
			Rectangle editPartBounds = null;
			if (selectedEditPart instanceof ClassEditPart) {
				editPartBounds = ((GraphicalEditPart)selectedEditPart).getFigure().getBounds();	

			}else if (selectedEditPart instanceof Association1EditPart
				|| selectedEditPart instanceof Association2EditPart
				|| selectedEditPart instanceof Association3EditPart
				|| selectedEditPart instanceof Association4EditPart) {

				Association associationToAdd = (Association) EditPartUtility.getElement(selectedEditPart);
				Class source = associationToAdd.getSource();
				Class target = associationToAdd.getTarget();
				if (!((MEDiagram) (EditPartUtility.getElement(getHost()))).getElements().contains(source)){
					EditPart sourceEditPart = ((ConnectionEditPart)selectedEditPart).getSource();
					editPartBounds = ((GraphicalEditPart)sourceEditPart).getFigure().getBounds();
				}else if (!((MEDiagram) (EditPartUtility.getElement(getHost()))).getElements().contains(target)){
					EditPart targetEditPart = ((ConnectionEditPart)selectedEditPart).getTarget();
					editPartBounds = ((GraphicalEditPart)targetEditPart).getFigure().getBounds();
				}
			}

			return editPartBounds;
		}

		private Set<Association> getAssociationsToAdd(Class classToAdd, EditPart selectedEditPart) {
			if (selectedEditPart == null) {
				return Collections.EMPTY_SET;
			}

			Set<Association> associationsToAdd = new HashSet<Association>();

			if (selectedEditPart instanceof ClassEditPart) {
				associationsToAdd.addAll(classToAdd.getOutgoingAssociations());
				associationsToAdd.addAll(classToAdd.getIncomingAssociations());
			}else if (selectedEditPart instanceof Association1EditPart
				|| selectedEditPart instanceof Association2EditPart
				|| selectedEditPart instanceof Association3EditPart
				|| selectedEditPart instanceof Association4EditPart) {

				Association associationToAdd = (Association) EditPartUtility.getElement(selectedEditPart);
				associationsToAdd.add(associationToAdd);
			}

			return associationsToAdd;
		}

		private Class getClassToAdd(EditPart selectedEditPart) {
			Class classToAdd = null;
			if (selectedEditPart instanceof ClassEditPart) {
				classToAdd = (Class) EditPartUtility.getElement(selectedEditPart);

			}else if (selectedEditPart instanceof Association1EditPart
				|| selectedEditPart instanceof Association2EditPart
				|| selectedEditPart instanceof Association3EditPart
				|| selectedEditPart instanceof Association4EditPart) {

				Association associationToAdd = (Association) EditPartUtility.getElement(selectedEditPart);
				Class source = associationToAdd.getSource();
				Class target = associationToAdd.getTarget();
				if (!((MEDiagram) (EditPartUtility.getElement(getHost()))).getElements().contains(source)){
					classToAdd = source;
				}else if (!((MEDiagram) (EditPartUtility.getElement(getHost()))).getElements().contains(target)){
					classToAdd = target;	
				}

			}
			return classToAdd;
		}

		private EditPart getSelectedEditPart(SelectionChangedEvent event) {
			EditPart selectedEditPart = null;
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection).getFirstElement();
				if (firstElement instanceof EditPart) {
					selectedEditPart = (EditPart) firstElement;
				}
			}
			return selectedEditPart;
		}
	}

	private void reset() {
		getObjectViewDescriptorMap().clear();
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		getHost().getViewer().addSelectionChangedListener(selectionChangeListener);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 */
	@Override
	public void deactivate() {
		super.deactivate();

		reset();
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request 
	 * the request
	 * This edit policy solely responds to {@link ShowRelatedElementsRequest} 
	 * 
	 * @return the command
	 * This edit policy solely returns a compound command
	 * 
	 */
	@Override
	public Command getCommand(Request request) {
		if (RequestConstants.REQ_SHOW_RELATED_ELEMENTS.equals(request.getType())) {
			return getShowRelatedElementsCommand(request);
		}
		return null;
	}


	private Command getShowRelatedElementsCommand(Request request) {
		//Start Sanity check
		if (!(request instanceof ShowRelatedElementsRequest)) {
			return null;
		}


		ShowRelatedElementsRequest relatedElementsRequest = (ShowRelatedElementsRequest) request;

		Object selectedShape = null;
		List selectedShapes = relatedElementsRequest.getSelectedShapes();
		if (selectedShapes.size() == 0) {
			return null;
		}

		selectedShape = selectedShapes.get(0);
		if (!(selectedShape instanceof ClassEditPart)) {
			return null;
		}

		primaryClassEditPart = (ClassEditPart) selectedShape;
		EObject element = EditPartUtility.getElement(primaryClassEditPart);
		if (!(element instanceof ClassImpl)) {
			return null;
		}

		//End Sanity check
		
		CompoundCommand cc = new CompoundCommand("Show RelatedElements");

		Collection<Association> invisibleRelatedAssociations = getInvisibleRelatedAssociations(primaryClassEditPart);
		Collection<Class> invisibleRelatedClasses = getInvisibleRelatedClasses(primaryClassEditPart);

		for (Class currentClass : invisibleRelatedClasses) {
			CreateNodeViewCommandProvider provider = new CreateNodeViewCommandProvider(
				getHost(),
				currentClass);

			ViewDescriptor viewDescriptor = provider.getViewDescriptor();
			getObjectViewDescriptorMap().put(currentClass, viewDescriptor);

			Command command = provider.getCommand();

			cc.add(command);

			Command createColorCommand = CommandFactory.createColorizeCommand(currentClass, (DiagramEditPart) getHost());
			cc.add(createColorCommand);
		}

		for (Association currentAssociation: invisibleRelatedAssociations) {
			CreateConnectionViewCommandProvider provider = new CreateConnectionViewCommandProvider(
				(DiagramEditPart) getHost(),
				currentAssociation,
				getViewAdapter(currentAssociation.getSource()),
				getViewAdapter(currentAssociation.getTarget()));

			ViewDescriptor viewDescriptor = provider.getViewDescriptor();
			getObjectViewDescriptorMap().put(currentAssociation, viewDescriptor);

			Command command = provider.getCommand();
			cc.add(command);

			Command createColorCommand = CommandFactory.createColorizeCommand(currentAssociation, (DiagramEditPart) getHost());
			cc.add(createColorCommand);
		}

		Collection<ViewDescriptor> viewDescriptors = getObjectViewDescriptorMap().values();
		List<ViewDescriptor> nodeViewDescriptorsToArrange = new ArrayList<ViewDescriptor>();
		List<ViewDescriptor> connectionViewDescriptorsToArrange = new ArrayList<ViewDescriptor>();

		ViewDescriptor viewDescriptor = CommandFactory.createViewDescriptorForNode(element);
		viewDescriptor.setView(primaryClassEditPart.getNotationView());
		nodeViewDescriptorsToArrange.add(viewDescriptor);

		for (ViewDescriptor currentViewDescriptor : viewDescriptors) {
			if (currentViewDescriptor.getViewKind().equals(Edge.class)) {
				connectionViewDescriptorsToArrange.add(currentViewDescriptor);	
			}else{
				nodeViewDescriptorsToArrange.add(currentViewDescriptor);
			}
		}

		CommandFactory.addArrangeCommand(cc, nodeViewDescriptorsToArrange, getHost());
		CommandFactory.addArrangeCommand(cc, connectionViewDescriptorsToArrange, getHost());

		cc.unwrap();

		return cc;
	}

	private Collection<Association> getAllRelatedAssociations(org.unicase.model.classes.Class theClass) {
		Set<Association> allRelatedAssociations
		= new HashSet<Association>();

		EList<Association> incomingAssociations = theClass.getIncomingAssociations();
		EList<Association> outgoingAssociations = theClass.getOutgoingAssociations();

		allRelatedAssociations.addAll(incomingAssociations);
		allRelatedAssociations.addAll(outgoingAssociations);

		return allRelatedAssociations;
	}

	private Collection<org.unicase.model.classes.Class> getAllRelatedClasses(org.unicase.model.classes.Class theClass) {
		Set<org.unicase.model.classes.Class> allRelatedClasses
		= new HashSet<org.unicase.model.classes.Class>();

		EList<Association> incomingAssociations = theClass.getIncomingAssociations();
		EList<Association> outgoingAssociations = theClass.getOutgoingAssociations();

		for (Association association : outgoingAssociations) {
			org.unicase.model.classes.Class target = association.getTarget();
			if (target != null
				&& target != theClass) {
				allRelatedClasses.add(target);
			}
		}
		for (Association association : incomingAssociations) {
			org.unicase.model.classes.Class source = association.getSource();
			if (source != null
				&& source != theClass) {
				allRelatedClasses.add(source);
			}
		}

		return allRelatedClasses;
	}

	private Collection<Association> getInvisibleRelatedAssociations(ClassEditPart classEditPart) {
		Set<Association> invisibleRelatedAssociations
		= new HashSet<Association>();

		Collection<ConnectionEditPart> connectedConnectionEditParts = getConnectedConnectionEditParts(classEditPart);
		Collection<Association> visibleRelatedAssociations = EditPartUtility.getElements(connectedConnectionEditParts,
			Association.class);

		Collection<Association> allRelatedAssociations = null;
		EObject element = EditPartUtility.getElement(classEditPart);
		if (!(element instanceof org.unicase.model.classes.Class)) {
			return Collections.EMPTY_LIST;
		}

		allRelatedAssociations = getAllRelatedAssociations((org.unicase.model.classes.Class) element);

		invisibleRelatedAssociations.addAll(allRelatedAssociations);
		invisibleRelatedAssociations.removeAll(visibleRelatedAssociations);

		return invisibleRelatedAssociations;
	}

	private Collection<org.unicase.model.classes.Class> getInvisibleRelatedClasses(ClassEditPart classEditPart) {
		Set<org.unicase.model.classes.Class> invisibleRelatedClasses
		= new HashSet<org.unicase.model.classes.Class>();

		Collection<ShapeEditPart> connectedShapeEditParts = getConnectedShapeEditParts(classEditPart);
		Collection<Class> visibleConnectedClasses = EditPartUtility.getElements(connectedShapeEditParts,
			org.unicase.model.classes.Class.class);

		EObject element = EditPartUtility.getElement(classEditPart);
		if (!(element instanceof org.unicase.model.classes.Class)) {
			return Collections.EMPTY_LIST;
		}

		Collection<Class> allRelatedClasses = null;
		allRelatedClasses = getAllRelatedClasses((org.unicase.model.classes.Class) element);

		invisibleRelatedClasses.addAll(allRelatedClasses);
		invisibleRelatedClasses.removeAll(visibleConnectedClasses);

		List<org.unicase.model.classes.Class> visibleRelatedClasses = new ArrayList<Class>();
		for (Class invisibleRelatedClass : invisibleRelatedClasses) {
			EditPart findEditPart = ((GraphicalEditPart) getHost()).findEditPart(null,invisibleRelatedClass);
			if (findEditPart != null) {
				visibleRelatedClasses.add(invisibleRelatedClass);
			}
		}

		invisibleRelatedClasses.removeAll(visibleRelatedClasses);

		return invisibleRelatedClasses;  
	}


	private Collection<ConnectionEditPart> getConnectedConnectionEditParts(ClassEditPart classEditPart) {
		Set<ConnectionEditPart> connectedConnectionEditParts = new HashSet<ConnectionEditPart>();

		List sourceConnections = classEditPart.getSourceConnections();
		List targetConnections = classEditPart.getTargetConnections();


		for (Object object : targetConnections) {
			if (object instanceof ConnectionEditPart) {
				connectedConnectionEditParts.add((ConnectionEditPart) object);
			}
		}

		for (Object object : sourceConnections) {
			if (object instanceof ConnectionEditPart) {
				connectedConnectionEditParts.add((ConnectionEditPart) object);
			}
		}

		return connectedConnectionEditParts;
	}

	private Collection<ShapeEditPart> getConnectedShapeEditParts(ShapeEditPart editPart){
		Set<ShapeEditPart> connectedShapeEditParts = new HashSet<ShapeEditPart>();

		List sourceConnections = editPart.getSourceConnections();
		List targetConnections = editPart.getTargetConnections();

		for (Object object : targetConnections) {
			if (object instanceof ConnectionEditPart) {
				EditPart target = ((ConnectionEditPart) object).getTarget();
				if (target instanceof GraphicalEditPart) {
					connectedShapeEditParts.add((ShapeEditPart) target);
				}
			}
		}

		for (Object object : sourceConnections) {
			if (object instanceof ConnectionEditPart) {
				EditPart source = ((ConnectionEditPart) object).getSource();
				if (source instanceof GraphicalEditPart) {
					connectedShapeEditParts.add((ShapeEditPart) source);
				}
			}
		}

		return connectedShapeEditParts;
	}

	private IAdaptable getViewAdapter(EObject object) {
		IAdaptable viewAdapter;	
		viewAdapter = getObjectViewDescriptorMap().get(object);

		if (viewAdapter == null) {
			EditPart editPart = ((GraphicalEditPart) getHost()).findEditPart(null, object);
			if (editPart == null) {
				return null;
			}
			View view = EditPartUtility.getView(editPart);
			viewAdapter = new ViewAdapter(view);
		}

		return viewAdapter;
	}

	/**
	 * @return
	 * The {@link EditPart}s related to the currently selected {@link EditPart}
	 */
	public Set<EditPart> getRelatedEditParts() {
		Set<EObject> keySet = getObjectViewDescriptorMap().keySet();

		Set<EditPart> editParts = new HashSet<EditPart>();  
		if (primaryClassEditPart != null) {
			editParts.addAll(EditPartUtility.findConnectionEditParts(primaryClassEditPart, keySet));	
		}

		Set<EditPart> foundEditParts = EditPartUtility.findEditParts((GraphicalEditPart) getHost(), keySet);
		editParts.addAll(foundEditParts);
		return editParts;
	}

	/**
	 * @return
	 * The {@link Edge}s related to the currently selected {@link EditPart}
	 */
	public Collection<? extends Edge> getRelatedEdges(){
		Set<Edge> edges = new HashSet<Edge>();
		Collection<ViewDescriptor> values = getObjectViewDescriptorMap().values();
		Collection<ConnectionViewDescriptor> edgeDescriptors = CollectionFilter.filter(values, ConnectionViewDescriptor.class);
		for (ConnectionViewDescriptor connectionViewDescriptor : edgeDescriptors) {
			Object view = connectionViewDescriptor.getAdapter(View.class);
			if (view instanceof Edge) {
				edges.add((Edge) view);
			}
		}
		return edges;
	}

	/**
	 * @return
	 * The {@link EObject}s of the nodes related to the currently selected {@link EditPart}
	 */
	public Collection<? extends EObject> getRelatedNodeElements(){
		Set<EObject> keySet = getObjectViewDescriptorMap().keySet();
		Collection<Class> classes = CollectionFilter.filter(keySet, Class.class);
		return classes;
	}


	private void setObjectViewDescriptorMap(Map<EObject,ViewDescriptor> viewDescriptors) {
		this.objectViewDescriptorMap = viewDescriptors;
	}

	private Map<EObject,ViewDescriptor> getObjectViewDescriptorMap() {
		return objectViewDescriptorMap;
	}
}
