package org.unicase.ui.ganttview.views;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

public class GanttTreeContentProvider extends AdapterFactoryContentProvider {

	public GanttTreeContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public Object[] getElements(Object object) {
		// TODO Auto-generated method stub
		return super.getElements(object);
	}

	@Override
	public Object[] getChildren(Object object) {
		// TODO Auto-generated method stub
		return super.getChildren(object);
	}

}
