package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;

public class TaskObjectLabelProvider extends ColumnLabelProvider implements IColorProvider{

	

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	public TaskObjectLabelProvider() {
		super();
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof Annotation){
			Annotation annotation = (Annotation) element;
			ModelElement modelElement=null;
			if (annotation.getAnnotatedModelElements().size()>0){
				modelElement = annotation.getAnnotatedModelElements().get(0);
			}
			
			if(modelElement!=null){
				return adapterFactoryLabelProvider.getImage(modelElement);
			}
			//JH Take only the first?
			
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		if(element instanceof Annotation){
			Annotation annotation = (Annotation) element;
			ModelElement modelElement=null;
			if (annotation.getAnnotatedModelElements().size()>0){
				modelElement = annotation.getAnnotatedModelElements().get(0);
			}
			if(modelElement!=null){
				return adapterFactoryLabelProvider.getText(modelElement);
			}
			//JH Take only the first?
			
		}
		return "N/A";
	}
	
	@Override
	public Color getBackground(Object element) {
		Display display = PlatformUI.getWorkbench().getDisplay();
		if (element instanceof ModelElement) {
			ModelElement me = (ModelElement) element;
			if (me.getState().equals(MEState.OPEN)) {
				return display.getSystemColor(SWT.COLOR_YELLOW);
			}
			if (me.getState().equals(MEState.CLOSED)) {
				return display.getSystemColor(SWT.COLOR_GREEN);
			}

		}
		return super.getBackground(element);
	}

}
