package org.unicase.ui.navigator.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

public class CreateContainmentHandler extends AbstractHandler {

	/**
	 * The Id for EClass parameter to command. A model element of this EClass
	 * type is created in this handler.
	 */
	public static final String COMMAND_ECLASS_PARAM = "org.unicase.ui.navigator.eClassParameter";

	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the command parameter (EClass)
		Object o = event.getObjectParameterForExecution(COMMAND_ECLASS_PARAM);
		if (o instanceof EClass) {
			final EClass newMEType = (EClass) o;
			final ModelElement newMEInstance;
			// create a new model element from this EClass
			newMEInstance = (ModelElement) ActionHelper.createModelElement(
					newMEType.getEPackage().getEFactoryInstance(), newMEType);
			newMEInstance.setName("new " + newMEType.getName());

			// if model element if MEDiagram, set the diagram type
			// if(newMEInstance instanceof MEDiagram) {
			// Object p =
			// event.getObjectParameterForExecution(COMMAND_DIAGRAMTYPE_PARAM);
			// DiagramType newDiagramType = (DiagramType) p;
			// ((MEDiagram) newMEInstance).setType(newDiagramType);
			// newMEInstance.setName("new " + newDiagramType.getLiteral());
			// }

			// add this newly created model element to LeafSection
			final ModelElement selectedME = ActionHelper
					.getSelectedModelElement();
			if (selectedME != null) {

				TransactionalEditingDomain domain = WorkspaceManager
						.getInstance().getCurrentWorkspace().getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@SuppressWarnings("unchecked")
					@Override
					protected void doExecute() {
						// get EStructuralFeature of selected ME
						List<EReference> containments = selectedME.eClass()
								.getEAllContainments();
						EReference ref = null;
						for (EReference containment : containments) {
							if (containment.getEReferenceType().equals(
									newMEType)) {
								ref = containment;
								break;
							} else if (containment
									.getEReferenceType().isSuperTypeOf(newMEType)) {
								ref = containment;
								break;
							}
						}

						// note that in DynamicContainmentCommands context menu
						// items
						// are created only for references that are many
						if (ref.isMany()) {
							Object object = selectedME.eGet(ref);
							EList<EObject> eList = (EList<EObject>) object;
							eList.add(newMEInstance);
														
							//ActionHelper.openModelElement(newMEInstance);
						}

					}
				});

			}
		}
		return null;
	}
}
