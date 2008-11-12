/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Provides the {@link ChangesTreeComposite} with a {@link CheckboxTreeViewer}.
 * @author Shterev
 *
 */
public class ChangesCheckboxTreeComposite extends ChangesTreeComposite{

	/**
	 * Default constructor.
	 * @param parent
	 *            parent
	 * @param style
	 *            style
	 */
	public ChangesCheckboxTreeComposite(Composite parent, int style){
		super(parent,style);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createTreeViewer() {
		setTreeViewer(new CheckboxTreeViewer(this, SWT.FULL_SELECTION));
		final CheckboxTreeViewer checkBoxViewer = (CheckboxTreeViewer)getTreeViewer();
		checkBoxViewer.addCheckStateListener(new ICheckStateListener(){
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				if(element instanceof ChangePackage){
					Object[] elements = ((ChangesTreeContentProvider)checkBoxViewer.getContentProvider()).getChildren(element);
					for(Object op : elements){
						checkBoxViewer.setChecked(op, event.getChecked());
				}}
				if(element instanceof AbstractOperation){
					EObject container = ((AbstractOperation)element).eContainer();
					if(event.getChecked()){
						checkBoxViewer.setGrayChecked(container, true);
					}else{
						Object[] elements = ((ChangesTreeContentProvider)checkBoxViewer.getContentProvider()).getChildren(container);
						boolean empty = true;
						for(Object o : elements){
							if(checkBoxViewer.getChecked(o)){
								empty = false;
								break;
							}
						}
						checkBoxViewer.setGrayChecked(container, !empty);
				}}
			}
		});
	}
}
