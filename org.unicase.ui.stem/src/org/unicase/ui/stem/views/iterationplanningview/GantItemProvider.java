package org.unicase.ui.stem.views.iterationplanningview;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.WorkspaceManager;

public class GantItemProvider extends
		TransactionalAdapterFactoryContentProvider implements IContentProvider {

	public class WPComparator implements Comparator<EObject> {

		public int compare(EObject o1, EObject o2) {
			WorkPackage wp1 = (WorkPackage) o1;
			WorkPackage wp2 = (WorkPackage) o2;
			return wp1.getName().compareTo(wp2.getName());
		}

	}

	public GantItemProvider() {
		super(WorkspaceManager.getInstance().getCurrentWorkspace()
				.getEditingDomain(), new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * . {@inheritDoc} returns WorkPackages contained in a Project
	 */
	@Override
	public Object[] getElements(Object object) {
		List<EObject> ret = new ArrayList<EObject>();
		if (object instanceof Project) {
			Project project = (Project) object;
			EList<WorkPackage> allModelElementsbyClass = project
					.getAllModelElementsbyClass(TaskPackage.eINSTANCE
							.getWorkPackage(), new BasicEList<WorkPackage>());
			for (WorkPackage workPackage : allModelElementsbyClass) {
				if (workPackage.getContainingWorkpackage() == null) {
					ret.add(workPackage);
				}
			}


		}
		Collections.sort(ret, new WPComparator());
		return ret.toArray();
	}
	
	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		Object[] children = super.getChildren(object);
		List<Object> ret = new ArrayList<Object>();
		for(Object child:children){
			if(child instanceof WorkPackage){
				ret.add(child);
			}
		}
		return ret.toArray();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {
		Object[] children = super.getChildren(object);
		List<Object> ret = new ArrayList<Object>();
		for(Object child:children){
			if(child instanceof WorkPackage){
				ret.add(child);
			}
		}
		return (ret.size()>0);
	}

}
