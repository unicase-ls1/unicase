package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;

public class FlatTabColumnLabelProvider  extends ColumnLabelProvider implements IColorProvider{ 

	protected AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	
	
	public FlatTabColumnLabelProvider() {
		super();
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

//	@Override
//	public String getColumnText(Object object, int columnIndex) {
//		if (columnIndex == 1) {
//			return ((ModelElement) object).getState();
//		} else {
//			return super.getColumnText(object, columnIndex);
//		}
//
//	}

//	@Override
//	public Color getBackground(Object object) {
//		ModelElement me = (ModelElement) object;
//		if (me.getState().equals(MEState.CLOSED)) {
//			return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
//		} else {
//			// return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
//			return adapterFactoryLabelProvider.getBackground(object);
//		}
//	}

	@Override
	public String getText(Object element) {
		
		return adapterFactoryLabelProvider.getText(element);
	}

	

//	@Override
//	public Image getColumnImage(Object object, int columnIndex) {
//		if (columnIndex == 1) {
//			return null;
//		}
//		return super.getColumnImage(object, columnIndex);
//	}

}
