package org.unicase.ui.ganttview.views;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;

public class GanttTreeLabelProvider extends AdapterFactoryLabelProvider implements IColorProvider {

	public GanttTreeLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

}
