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
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

/**
 * This dialog represents the possibility to select an element from a list where the list is sorted and additional
 * information can be provided. In addition first a filter can be selected for the items displayed in the list.
 * 
 * @author engelmann
 * @author lee
 */
public class MEExtendedSuggestedSelectionDialog extends
MESuggestedSelectionDialog {

	private ECPModelelementContext currentContext;
	private HashMap<String, ECPModelelementContext> currentContextNeighbours;
	private EObject baseElement;
	private EReference eReference;
	private boolean isAssociationClass;
	private AdapterFactoryLabelProvider labelProvider;
	
	/**
	 * The constructor.
	 * 
	 * @param title The title of the dialog
	 * @param message the message displayed
	 * @param blockOnOpen block
	 * @param baseElement The element, to which the selection is made and to which other elements are compared.
	 * @param reference the reference for which this is used
	 * @param context the current context
	 * @param isAssociationClass checks whether this dialog was called as a reference or an association class
	 */
	public MEExtendedSuggestedSelectionDialog(String title, String message, 
			boolean blockOnOpen, EObject baseElement, EReference reference, 
			ECPModelelementContext context, boolean isAssociationClass) {
		super(title, message, blockOnOpen, baseElement, reference,
				context.getAllModelElements());
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.baseElement = baseElement;
		this.eReference = reference;
		this.isAssociationClass = isAssociationClass;
		this.currentContext = context;
		updateModelElements();
	}

	private void updateModelElements() {
		setModelElements(createAllModelElementsList());
		createNeighbourList();
	}
	
	@Override
	public void setModelElements(Collection<EObject> modelElements) {
		super.setModelElements(modelElements);
		updateFilteredItemList();
	}


	private void updateFilteredItemList() {
		Text pattern = (Text)this.getPatternControl();
		if(pattern != null){
			//FIXME: not a nice solution to refresh filtering
			pattern.setText("dummy");
			pattern.update();
			pattern.setText("**");
			pattern.update();
		}	  		
	}

	private void createNeighbourList() {
		currentContextNeighbours = new HashMap<String, ECPModelelementContext>();
		for (ECPModelelementContext tempContext : currentContext.getNeighbors()) {
			String text = labelProvider.getText(tempContext);
			if(ECPProject.class.isAssignableFrom(tempContext.getClass())){
				ECPProject project = (ECPProject) tempContext;
				text = labelProvider.getText(project.getRootObject());
			}
			
			currentContextNeighbours.put(text, tempContext);
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

		final Button button = new Button(parent, SWT.ARROW | SWT.DOWN);
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
		MenuItem xmiItem = new MenuItem(menu, SWT.PUSH);
		xmiItem.setText("Open XMI Dialog");
		xmiItem.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				OpenXMIDialog dialog = new OpenXMIDialog(PlatformUI
						.getWorkbench().getDisplay().getActiveShell(),"Import from XMI", "Please choose a location to an XMI-File");
				dialog.open();
				setModelElements(dialog.getObjectList());
			}
		});
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Rectangle rect = button.getBounds();
				Point pt = new Point(rect.x, rect.y + rect.height);
				pt = button.toDisplay(pt);
				menu.setLocation(pt.x, pt.y);
				menu.setVisible(true);
			}
		});
		Control firstChild = parent.getChildren()[0];
		button.moveAbove(firstChild);
		return null;
	}
}
