package org.unicase.ui.toolbarbutton;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.document.LeafSection;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.preferences.PropertyKey;

public class TaskCreator {

	/**
	 * Creates a new task under the modelElement which is retrieved from the preferences over the
	 * property key. The saved preference value has to be a ModelElementId.
	 * @param projectSpace - the ProjectSpace where the task will be created
	 * @param key - the PropertyKey under which the ModelElementId can be found in the PreferenceManager
	 * @param task - the WorkItem which will be added under the retrieved ModelElement
	 * @throws ModelIdDoesNotExistException 
	 */
	static public void addTask(ProjectSpace projectSpace, PropertyKey key, WorkItem task) throws ModelIdDoesNotExistException{
		final OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace, key);

		ArrayList<EObject> result = new ArrayList<EObject>();
		property.getEObjectListProperty(result);
		EObject givenId = result.get(0);
		
		if(givenId instanceof ModelElementId){
			EObject parentPackage = projectSpace.getProject().getModelElement((ModelElementId)givenId);
			if(parentPackage == null){
				throw new ModelIdDoesNotExistException(givenId);
			}
			
			if (parentPackage instanceof Project) {
				((Project) parentPackage).addModelElement(task);
			} else if (parentPackage instanceof LeafSection) {
				((LeafSection) parentPackage).getModelElements().add(task);
			} else if (parentPackage instanceof WorkPackage) {
				((WorkPackage) parentPackage).getContainedWorkItems().add(task);
			}
		}
	}



}
