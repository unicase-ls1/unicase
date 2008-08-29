/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

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

/**.
 * LabelProvider for annotated model element column in IterationPlaningView
 * @author Helming
 *
 */
public class TaskObjectLabelProvider extends ColumnLabelProvider implements IColorProvider{

	

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	/**.
	 * Constructor
	 */
	public TaskObjectLabelProvider() {
		super();
		this.adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}
	
	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if(element instanceof Annotation){
			Annotation annotation = (Annotation) element;
			ModelElement modelElement=null;
			if (annotation.getAnnotatedModelElements().size()>0){
				modelElement = annotation.getAnnotatedModelElements().get(0);
			}
			
			if(modelElement!=null){
				return getAdapterFactoryLabelProvider().getImage(modelElement);
			}
			//JH Take only the first?
			
		}
		return null;
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if(element instanceof Annotation){
			Annotation annotation = (Annotation) element;
			ModelElement modelElement=null;
			if (annotation.getAnnotatedModelElements().size()>0){
				modelElement = annotation.getAnnotatedModelElements().get(0);
			}
			if(modelElement!=null){
				return getAdapterFactoryLabelProvider().getText(modelElement);
			}
			//JH Take only the first?
			
		}
		return "N/A";
	}
	
	/**.
	 * {@inheritDoc}
	 */
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

	/**.
	 * this returns the adapterFactoryLabelProvider used to retrieve text and images
	 * @return AdapterFactoryLabelProvider
	 */
	public AdapterFactoryLabelProvider getAdapterFactoryLabelProvider() {
		return adapterFactoryLabelProvider;
	}

}
