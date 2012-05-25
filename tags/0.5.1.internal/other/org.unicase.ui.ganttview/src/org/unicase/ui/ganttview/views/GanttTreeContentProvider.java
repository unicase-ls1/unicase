package org.unicase.ui.ganttview.views;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.ganttview.util.GanttViewHelper;

public class GanttTreeContentProvider extends AdapterFactoryContentProvider {
	/**
	 * default constructor.
	 */
	public GanttTreeContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public Object[] getElements(Object object) {

		Object[] elements = super.getElements(object);
		EList<WorkPackage> result = new BasicEList<WorkPackage>();

		if (object instanceof WorkPackage) {
			for (Object element : elements) {
				if (element instanceof WorkPackage) {
					result.add((WorkPackage) element);
				}
			}
		} else if (object instanceof Project) {
			result.addAll(getElementsForProject(object));
		}

		return result.toArray(new Object[result.size()]);

	}

	private EList<WorkPackage> getElementsForProject(Object object) {
		Project project = (Project) object;
		EList<WorkPackage> dummyList = new BasicEList<WorkPackage>();
		project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(), dummyList);

		EList<WorkPackage> result = GanttViewHelper.getRootWorkPackages(dummyList);

		return result;
	}

	@Override
	public Object[] getChildren(Object object) {
		Object[] elements = super.getElements(object);
		EList<WorkPackage> result = new BasicEList<WorkPackage>();

		for (Object element : elements) {
			if (element instanceof WorkPackage) {
				result.add((WorkPackage) element);
			}
		}

		return result.toArray(new Object[result.size()]);
	}

	@Override
	public boolean hasChildren(Object object) {
		return (this.getChildren(object).length > 0);
	}

}
