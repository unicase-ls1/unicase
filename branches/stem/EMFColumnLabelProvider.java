package org.unicase.ui.stem.views;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.decorators.DecoratorManager;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;

public class EMFColumnLabelProvider extends ColumnLabelProvider {

	private DecoratingLabelProvider decoratingLabelProvider;

	public EMFColumnLabelProvider() {
		super();
		IDecoratorManager decoratorManager = new DecoratorManager();
		decoratingLabelProvider = new DecoratingLabelProvider(
				new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
				decoratorManager.getLabelDecorator());

	}

	@Override
	public Image getImage(Object element) {
		Image image = decoratingLabelProvider.getImage(element);
		decoratingLabelProvider.getLabelDecorator().decorateImage(image,
				element);
		return image;
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

	@Override
	public String getText(Object element) {
		// TODO Auto-generated method stub
		return decoratingLabelProvider.getText(element);
	}

}
