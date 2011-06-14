/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.xmiworkspace.commands.ImportProjectHandler;
import org.eclipse.emf.ecp.xmiworkspace.views.ImportProjectDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;

/**
 * This dialog represents the possibility to select an element from a list where the list is sorted and additional
 * information can be provided. In addition first a filter can be selected for the items displayed in the list.
 * 
 * @author Birgit Engelmann
 */
public class MEExtendedSuggestedSelectionDialog extends
MESuggestedSelectionDialog {

	private ECPModelelementContext currentContext;
	private HashMap<String, ECPModelelementContext> currentContextNeighbours;
	private EObject baseElement;
	private EReference eReference;
	private boolean isAssociationClass;
	
	/**
	 * The constructor.
	 * 
	 * @param title The title of the dialog
	 * @param message the message displayed
	 * @param blockOnOpen block
	 * @param elements The elements, which can be selected.
	 * @param baseElement The element, to which the selection is made and to which other elements are compared.
	 * @param reference the reference for which this is used
	 */
	//	public MEExtendedSuggestedSelectionDialog(String title, String message,
	//			boolean blockOnOpen, EObject baseElement, EReference reference,
	//			Collection<EObject> elements) {
	//		super(title, message, blockOnOpen, baseElement, reference, elements);
	//	}

	public MEExtendedSuggestedSelectionDialog(String title, String message, 
			boolean blockOnOpen, EObject baseElement, EReference reference, 
			ECPModelelementContext context, boolean isAssociationClass) {
		super(title, message, blockOnOpen, baseElement, reference,
				context.getAllModelElements());
		this.baseElement = baseElement;
		this.eReference = reference;
		this.isAssociationClass = isAssociationClass;
		this.currentContext = context;
		//		currentContextNeighbours = new HashMap<String, ECPModelelementContext>();
		updateModelElements();
	}

	private void updateModelElements() {
		setModelElements(createAllModelElementsList());

		currentContextNeighbours = new HashMap<String, ECPModelelementContext>();
		for (ECPModelelementContext tempContext : currentContext.getNeighbors()) {
			currentContextNeighbours.put(tempContext.toString(), tempContext);
		}		
	}

	private Collection<EObject> createAllModelElementsList() {
		if (isAssociationClass) {
			return currentContext.getAllModelElementsbyClass(baseElement.eClass(), false);
		} else {
			Collection<EObject> result = null;
			result = currentContext.getAllModelElementsbyClass(eReference.getEReferenceType(), true);
			result.remove(baseElement);
			return result;
		}
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		final Button button = new Button(comp, SWT.PUSH);
		//button.setImage(image);
		button.setText("Contexts");
		final Menu menu = new Menu(parent.getShell(), SWT.POP_UP);
		for (String key : currentContextNeighbours.keySet()) {
			MenuItem item = new MenuItem(menu, SWT.PUSH);
			item.setText(key);
			item.addListener(SWT.Selection, new Listener(){
				public void handleEvent(Event event) {
					currentContext = currentContextNeighbours.get(((MenuItem)event.widget).getText());
					updateModelElements();
				}
			});
		}
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Rectangle rect = button.getBounds();
				Point pt = new Point(rect.x, rect.y + rect.height);
				pt = button.toDisplay(pt);
				menu.setLocation(pt.x, pt.y);
				menu.setVisible(true);
			}
		});
		
		final Button xmiButton = new Button(comp, SWT.PUSH);
		xmiButton.setText("Open XMI Dialog");
		xmiButton.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				OpenXMIDialog dialog = new OpenXMIDialog(PlatformUI
						.getWorkbench().getDisplay().getActiveShell());
				dialog.open();
				currentContext = dialog.getContext();
				updateModelElements();
			}
			
		});
		
		
		Control firstChild = parent.getChildren()[0];
		comp.moveAbove(firstChild);

		return null;
	}

}
