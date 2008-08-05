package org.unicase.ui.stem.views;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;

public class TaskObjectLabelProvider extends ColumnLabelProvider {

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	public TaskObjectLabelProvider() {
		super();
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
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
	

}
