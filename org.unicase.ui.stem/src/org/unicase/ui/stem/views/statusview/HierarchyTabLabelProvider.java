package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;

public class HierarchyTabLabelProvider extends AdapterFactoryLabelProvider
		implements IColorProvider {

	public HierarchyTabLabelProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public Color getBackground(Object object) {
		if (((ModelElement) object).getState().equals(MEState.CLOSED)) {
			return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
		} else {
			return super.getBackground(object);
		}
	}

}
