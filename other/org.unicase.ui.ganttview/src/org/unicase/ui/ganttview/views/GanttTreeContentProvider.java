package org.unicase.ui.ganttview.views;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class GanttTreeContentProvider extends AdapterFactoryContentProvider {

	public GanttTreeContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public Object[] getElements(Object object) {

		if (object instanceof Project) {
			EList<WorkPackage> elementsForProject = getElementsForProject(object);
			return elementsForProject.toArray(new Object[elementsForProject.size()]);
		} else if (object instanceof WorkPackage) {
			Set<ModelElement> elementsForWorkPackage = getElementsForWorkPackage(object);
			return elementsForWorkPackage.toArray(new Object[elementsForWorkPackage.size()]);
		} else {
			return super.getElements(object);
		}
	}

	private EList<WorkPackage> getElementsForProject(Object object) {
		Project project = (Project) object;
		EList<WorkPackage> dummyList = new BasicEList<WorkPackage>();
		return project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(), dummyList);

	}

	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof WorkPackage) {
			Set<ModelElement> elementsForWorkPackage = getElementsForWorkPackage(object);
			return elementsForWorkPackage.toArray(new Object[elementsForWorkPackage.size()]);
		} else {
			return super.getChildren(object);
		}
	}

	/**
	 * . Returns all model elements being annotated by WorkItems contained in this WorkPackage.
	 * 
	 * @param object WorkPackage
	 * @return
	 */
	private Set<ModelElement> getElementsForWorkPackage(Object object) {

		Set<ModelElement> ret = new HashSet<ModelElement>();
		WorkPackage workPackage = (WorkPackage) object;
		List<WorkItem> containedWorkItems = workPackage.getAllContainedWorkItems();
		for (WorkItem workItem : containedWorkItems) {
			if (workItem instanceof WorkPackage) {
				ret.add(workItem);
			}
		}
		return ret;
	}
}
