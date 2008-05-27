package org.unicase.ui.meeditor;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.unicase.model.ModelElement;


public class MEEditorInput implements IEditorInput {

	ModelElement modelElement;

	public MEEditorInput(ModelElement me) {
		super();
		this.modelElement = me;
	}

	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor descriptor = ImageDescriptor
				.createFromImage(new AdapterFactoryLabelProvider(
						new ComposedAdapterFactory(
								ComposedAdapterFactory.Descriptor.Registry.INSTANCE))
						.getImage(modelElement));

		return descriptor;
	}

	public String getName() {
		return modelElement.getName();
	}

	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getToolTipText() {
		// TODO Auto-generated method stub
		return "";
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelElement getModelElement() {
		return modelElement;
	}

	public void setModelElement(ModelElement modelElement) {
		this.modelElement = modelElement;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MEEditorInput) {
			MEEditorInput other = (MEEditorInput) obj;
			boolean ret = modelElement.equals(other.getModelElement());
			return ret;
		} else {
			return super.equals(obj);
		}
	}

}
