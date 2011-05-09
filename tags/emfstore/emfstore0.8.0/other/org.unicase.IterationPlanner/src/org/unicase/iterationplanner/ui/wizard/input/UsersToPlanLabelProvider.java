package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class UsersToPlanLabelProvider extends AdapterFactoryLabelProvider {
	public UsersToPlanLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Color getBackground(Object object) {
		UserAvailability ua = (UserAvailability) object;
		if(ua.hasUndifinedAvailability()){
			return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		}
		return super.getBackground(object);
			
	}

	@Override
	public Image getImage(Object object) {
		if(object instanceof UserAvailability){
			return super.getImage(((UserAvailability) object).getUser());
		}
		return super.getImage(object);
	}

}
