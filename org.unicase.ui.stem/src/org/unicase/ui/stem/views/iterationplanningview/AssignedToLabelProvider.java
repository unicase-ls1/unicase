/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.util.MEState;

/**.
 * LabelProvider for Assigned to column in IterationPlanningView
 * @author Helming
 *
 */
public class AssignedToLabelProvider extends ColumnLabelProvider {

	
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	/**.
	 * Constructor
	 */
	public AssignedToLabelProvider() {
		super();
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		EObject assignedTo = getAssignedTo(element);
		if (assignedTo==null){
			return null;
		}
		return adapterFactoryLabelProvider.getImage(assignedTo);
	}

	
	/**.
	 * returns the Assignee of an Assignable element
	 * @param element the Assignable
	 * @return
	 */
	private EObject getAssignedTo(Object element) {
	
		//JH: Model issue. This doesn't work. 
//		if(element instanceof Assignable){
//			((Assignable) element).getAssignee();
//		}
//		return null;
		
		if(element instanceof BugReport){
			return ((BugReport) element).getAssignedTo();
		}
		if(element instanceof ActionItem){
			ActionItem ai = (ActionItem) element;
			if (ai.getAssignedTo().size()>0){
				return ai.getAssignedTo().get(0);
				//JH: return only first?
			}
		}
		return null;
	}

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String getText(Object element) {
		EObject assignedTo = getAssignedTo(element);
		if (assignedTo==null){
			return "N/A";
		}
		return adapterFactoryLabelProvider.getText(assignedTo);
	}
	
	

	
	/**.
	 * {@inheritDoc}
	 * 
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
	
}
