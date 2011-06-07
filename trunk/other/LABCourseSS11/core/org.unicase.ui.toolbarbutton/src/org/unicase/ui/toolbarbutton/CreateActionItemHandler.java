
package org.unicase.ui.toolbarbutton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.document.LeafSection;
import org.unicase.model.task.*;



/**
 * . This is the handler to add a new Document to a ProjectSpace
 * 
 * @author Engelmann
 */
public class CreateActionItemHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject eObject = ActionHelper.getSelection(event);
		if (!(eObject instanceof ProjectSpace)) {
			return null;
		}
		final ProjectSpace projectSpace = (ProjectSpace) eObject;

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				
				//for testing: (setting a workpackage as property)
				/*Project p = projectSpace.getProject();
				Set<EObject> modelElements = p.getAllModelElements();
				ModelElementId element = null;
				for(EObject modelElement: modelElements){
					if(modelElement instanceof WorkPackage){
						element = ((WorkPackage)modelElement).getModelElementId();
						break;
					}
				}

				if(element != null){
					PreferenceManager.INSTANCE.setProperty(projectSpace, ShortcutActionKey.USERLOCATION, new EObject[]{element});
				*/
				//end of testing part
					ActionItem item = TaskFactory.eINSTANCE.createActionItem();
					try {
						TaskCreator.addTask(projectSpace, ShortcutActionKey.USERTASKLOCATION, item);
					} catch (ModelIdDoesNotExistException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}.run(true);

		return null;
	}

}
