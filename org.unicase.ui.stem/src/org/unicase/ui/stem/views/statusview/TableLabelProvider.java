package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;

public class TableLabelProvider extends AdapterFactoryLabelProvider implements IColorProvider{

	public TableLabelProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	@Override
	public String getColumnText(Object object, int columnIndex) {
		if (columnIndex == 1) {
			return ((ModelElement) object).getState();
		} else {
			return super.getColumnText(object, columnIndex);
		}

	}

	@Override
	public Color getBackground(Object object) {
		ModelElement me = (ModelElement) object;
		if (me.getState().equals(MEState.CLOSED)) {
			return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
		} else {
			// return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
			return super.getBackground(object);
		}
	}

	

	@Override
	public Image getColumnImage(Object object, int columnIndex) {
		if (columnIndex == 1) {
			return null;
		}
		return super.getColumnImage(object, columnIndex);
	}

}
