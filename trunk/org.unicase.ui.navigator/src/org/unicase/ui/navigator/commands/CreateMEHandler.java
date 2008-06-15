package org.unicase.ui.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.ModelElement;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.meeditor.MEEditorInput;

/**
 * 
 * @author Hodaie
 * 
 *         This is the handler for createME command
 *         (org.unicase.ui.navigator.createME). This command is just a command
 *         definition with a parameter. This command is not shown itself in the
 *         context menu. In DynamicMECreationCommands class the actually
 *         required command to create a Model element are created and assigned
 *         the ID of this generic createME command. When the user selects one of
 *         these commands this handler is executed. The generic createME command
 *         gets an EClass as parameter, and the handler creates a ModelElement
 *         of this EClass, adds it to the selected LeafSection and opens it for
 *         editing.
 * 
 */
public class CreateMEHandler extends AbstractHandler implements IHandler {

	/**
	 * The Id for EClass parameter to command. A model element of this EClass
	 * type is created in this handler.
	 */
	public static final String COMMAND_ECLASS_PARAM = "org.unicase.ui.navigator.eClassParameter";

	/**
	 * The Id for MEEditor. We need this to open the created model element.
	 */
	private static final String MEEDITOR_PLUGIN_ID = "org.unicase.ui.meeditor";

	/**
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the command parameter (EClass)
		Object o = event.getObjectParameterForExecution(COMMAND_ECLASS_PARAM);
		if (o instanceof EClass) {
			EClass newMEType = (EClass) o;
			final ModelElement newMEInstance;
			// create a new model element from this EClass
			newMEInstance = (ModelElement) newMEType.getEPackage()
					.getEFactoryInstance().create(newMEType);
			newMEInstance.setName("new " + newMEType.getName());
			// add this newly created model element to LeafSection
			final LeafSection leafSection = getLeafSection(event);
			if (leafSection != null) {
				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					protected void doExecute() {
						leafSection.getModelElements().add(newMEInstance);
					}
				});

				openModelElement(newMEInstance);
			}
		}
		return null;

	}

	private void openModelElement(ModelElement newMEInstance) {
		MEEditorInput input = new MEEditorInput(newMEInstance);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage()
					.openEditor(input, MEEDITOR_PLUGIN_ID, true);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Gets the leaf section right clicked on Navigator.
	 * 
	 * @param event
	 * @return LeafSection;
	 */
	private LeafSection getLeafSection(ExecutionEvent event) {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof LeafSection)) {
			return null;
		}

		return (LeafSection) o;

	}

}
