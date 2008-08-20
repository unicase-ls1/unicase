package org.unicase.ui.stem.views;

import java.util.List;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;

public class ChangesTreeContentProvider extends AdapterFactoryContentProvider
		implements IContentProvider {

	public ChangesTreeContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	

	@Override
	public Object[] getElements(Object object) {
		List<AbstractOperation> ops = (List<AbstractOperation>) object;

		return ops.toArray(new Object[ops.size()]);
	}
	
	
	@Override
	public Object[] getChildren(Object object) {

		if(object instanceof CompositeOperation){
			return getElements(((CompositeOperation)object).getAtomicOperations());
		}else{
			return super.getChildren(object);
		}
			
		
	}



	@Override
	public boolean hasChildren(Object object) {
		if(object instanceof CompositeOperation){
			return true;
		}else{
			return super.hasChildren(object);
		}
	}

}
