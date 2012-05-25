package scrm.diagram.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.common.commands.ECPCommand;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.diagram.util.EditPartUtility;

/**
 * This edit policy extends the original {@link DragDropEditPolicy}, in that it
 * adds elements from the original compartment to the elements of the diagram.
 * 
 * @author mharut
 */
public class SCRMDiagramDragDropEditPolicy extends DragDropEditPolicy {

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT: in addition to the actual command, also return a command
	 *            to remove the dropped elements from the original diagram
	 */
	protected Command getDropCommand(ChangeBoundsRequest request) {
		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = request.getEditParts();

		if (editParts.isEmpty()) {
			// nothing to do
			return null;
		}

		final DiagramEditPart diagramEP = EditPartUtility
				.getDiagramEditPart(editParts.get(0));
		final SCRMDiagram scrmDiagram = (SCRMDiagram) diagramEP
				.getDiagramView().getElement();

		// return command to add elements from the original compartment
		return new Command() {
			public void execute() {

				new ECPCommand(scrmDiagram) {

					@Override
					protected void doRun() {
						for (EditPart editPart : editParts) {
							View view = (View) editPart.getAdapter(View.class);
							EObject element = ViewUtil
									.resolveSemanticElement(view);
							EObject container = element.eContainer();
							EObject containee = element;
							List<SCRMModelElement> elements = scrmDiagram.getElements();
							while (container instanceof SCRMSpace) {
								if(!isContained(elements, container)) {
									if(scrmDiagram.getRepresentedSpace() != container) {
										break;
									}
								}
								containee = container;
								container = container.eContainer();
							}
							addToParent(container, containee, element);
							List<EObject> elementsToAdd = gatherElementsToAdd(element);
							elementsToAdd.add(element);
							handleDrop(scrmDiagram, elementsToAdd);
						}
					}

				}.run(true);

			}
		};

	}
	
	private boolean isContained(List<SCRMModelElement> elements,
			EObject container) {
		for(SCRMModelElement element : elements) {
			if(element == container) {
				return true;
			}
			for(Iterator<EObject> iter = element.eAllContents(); iter.hasNext();) {
				EObject eObject = iter.next();
				if(eObject == container) {
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addToParent(EObject container, EObject containee,
			EObject element) {
		EStructuralFeature containingFeature = containee.eContainingFeature();
		List containedObjects = (List) container.eGet(containingFeature);
		containedObjects.add(element);
	}

	private static void handleDrop(SCRMDiagram scrmDiagram,
			List<EObject> elementsToAdd) {
		for (EObject eObject : elementsToAdd) {
			if (!scrmDiagram.getElements().contains(eObject)
					&& eObject instanceof SCRMModelElement) {
				scrmDiagram.getElements().add((SCRMModelElement) eObject);
			}
		}

	}

	private static List<EObject> gatherElementsToAdd(EObject eObject) {
		List<EObject> result = new LinkedList<EObject>();
		result.add(eObject);
		if (!(eObject instanceof SCRMSpace)) {
			for (EObject child : eObject.eContents()) {
				result.addAll(gatherElementsToAdd(child));
			}
		}
		return result;
	}

}
