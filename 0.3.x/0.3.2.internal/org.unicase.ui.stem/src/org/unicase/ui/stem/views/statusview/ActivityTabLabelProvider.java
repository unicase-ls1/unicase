package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.task.ActivityType;
import org.unicase.ui.stem.Activator;

/**
 * Label Provider for the activity view.
 * 
 * @author helming
 * 
 */
public class ActivityTabLabelProvider extends AdapterFactoryLabelProvider
		implements IColorProvider {
	/**
	 * default constructor.
	 * 
	 * @param adapterFactory
	 */
	public ActivityTabLabelProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof ActivityType) {
			return Activator.getImageDescriptor("icons/backlog.png")
					.createImage();
		}
		return super.getImage(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof ActivityType) {
			return ((ActivityType) object).getLiteral();
		}
		return super.getText(object);
	}

}
