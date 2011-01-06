/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.reviewview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.urml.stakeholderview.reviewview.input.UrmlTreeHandler;

/**
 *  The view for reviewing the requirements.
 *  It provides the creating of new danger/hazards 
 * 
 * @author kterzieva
 */

public class ReviewView extends ViewPart {

	private TableViewer listViewer;
	private IndexHandling indexHandler;
	private ILabelProvider reviewViewLabelProvider;
	private TableViewerColumn viewerNameColumn;
	private Composite rightComposite, buttonComposite, editorComposite, navigatorComposite, referenceComposite;
	private Sash sash;
	private ReviewViewContentFactory contentFactory;
	private UrmlModelElement currentlyDisplayedElement;
	private Button openModelElement, up, down;

	
	@Override
	public void createPartControl(final Composite parent) {
		// **** Creation of the UI Components ***
		createLeftSide(parent);
		// the sash (controler) is added to the main view
		sash = new Sash(parent, SWT.VERTICAL);
		createRightSide(parent);
		//Finally, after all UI compontents are created, set the global layout
		setupGlobalLayout(parent);

		// **** Create necessary fields ***
		contentFactory = new ReviewViewContentFactory(editorComposite);
		indexHandler = new IndexHandling(this, listViewer);
		
		// *** Setup listeners for the different buttons and other UI actions ***
		setupListeners();
		
		//Test code for filling the view with elements. To be replaced later
		try {
			indexHandler.setInput(UrmlTreeHandler
					.getStakeholderSetfromProjects(UrmlTreeHandler
							.getTestProject()));
			//later getStakeholderElementSet(stakeholder);
		} catch (NoWorkspaceException e1) {
			e1.printStackTrace();
		}
	}

	private void createLeftSide(final Composite parent) {
		// the list viewer (controler) is added to the maim view (parent)
		listViewer = new TableViewer(parent);
		listViewer.setContentProvider(ArrayContentProvider.getInstance());
		reviewViewLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		listViewer.setLabelProvider(reviewViewLabelProvider);
		viewerNameColumn = new TableViewerColumn(listViewer, SWT.NONE);
		viewerNameColumn.getColumn().setText("Test");
		viewerNameColumn.getColumn().setWidth(2000);

		// LabelProvider für jede Spalte setzen
		viewerNameColumn.setLabelProvider(new CellLabelProvider() {
			public void update(ViewerCell cell) {
				cell.setText(reviewViewLabelProvider.getText(cell
						.getElement()));
				cell.setImage(reviewViewLabelProvider.getImage(cell
						.getElement()));
			}
		});
	}
	


	private void createRightSide(Composite parent) {
		
		// new composite for the right site
		rightComposite = new Composite(parent, SWT.NONE);
		GridLayout gridLay = new GridLayout(1, false);
		rightComposite.setLayout(gridLay);
		
		navigatorComposite = new Composite(rightComposite, SWT.NONE);
		GridLayout navigatorLayout = new GridLayout(2, false);
		navigatorComposite.setLayout(navigatorLayout);
		
		GridData navigatorCompositeLayoutData = new GridData(SWT.FILL, SWT.DEFAULT, false, false);
		navigatorComposite.setLayoutData(navigatorCompositeLayoutData);
		navigatorComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		//Create button composite
		buttonComposite = new Composite(navigatorComposite, SWT.NONE);
		GridLayout buttonLayout = new GridLayout(2, true);
		buttonComposite.setLayout(buttonLayout);
		
		//defines where the composite is located and how it looks like
		//we use GridData because of the parent layout 
		GridData buttonCompositeLayoutData = new GridData(SWT.FILL, SWT.DEFAULT, false, false);
		buttonComposite.setLayoutData(buttonCompositeLayoutData);
		buttonComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		//Create buttons
		up = new Button(buttonComposite, SWT.PUSH);
		down = new Button(buttonComposite, SWT.PUSH);
		openModelElement = new Button(navigatorComposite, SWT.PUSH);
		openModelElement.setEnabled(false);

		GridData data = new GridData(SWT.FILL, SWT.DEFAULT, false, true);
		up.setLayoutData(data);
		up.setText("Up");
		up.setAlignment(SWT.CENTER);
		
		GridData dataDown = new GridData(SWT.FILL, SWT.DEFAULT, false, true);
		down.setLayoutData(dataDown);
		down.setText("Down");
		down.setAlignment(SWT.CENTER);
	
		GridData dataOpen = new GridData(SWT.END, SWT.DEFAULT, true, true);
		openModelElement.setLayoutData(dataOpen);
		openModelElement.setText("Open in MEE");
		openModelElement.setAlignment(SWT.CENTER);

		//Create empty editor composite
		editorComposite = new Composite(rightComposite, SWT.NONE);
	
		//defines how the children of editorComposite will be located, data for the children
		GridLayoutFactory.swtDefaults().numColumns(2).spacing(10, 20).applyTo(editorComposite);

		//defines how the editorComposite is located within rightComposite, data for parent
		GridData editorCompositeLayoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
		editorComposite.setLayoutData(editorCompositeLayoutData);
		editorComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		editorComposite.getParent().setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		referenceComposite = new Composite(rightComposite, SWT.NONE);
		GridLayout dangerLayout = new GridLayout(1, true);
		referenceComposite.setLayout(dangerLayout);
		
		GridData dangerCompositeLayoutData = new GridData(SWT.BEGINNING, SWT.DEFAULT, true, false);
		referenceComposite.setLayoutData(dangerCompositeLayoutData);
		referenceComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

	}


	private void setupGlobalLayout(final Composite parent) {
		final FormLayout form = new FormLayout();
		parent.setLayout(form);

		// edges position of the leftData-controller can be set using form
		// attachments
		FormData leftData = new FormData();
		leftData.left = new FormAttachment(0, 0);
		leftData.right = new FormAttachment(sash, 0);
		leftData.top = new FormAttachment(0, 0);
		leftData.bottom = new FormAttachment(100, 0);
		//?
		listViewer.getControl().setLayoutData(leftData);

		final int limit = 150, percent = 50;
		final FormData sashData = new FormData();
		sashData.left = new FormAttachment(percent, 0);
		sashData.top = new FormAttachment(0, 0);
		sashData.bottom = new FormAttachment(100, 0);
		sash.setLayoutData(sashData);
		
		sash.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				Rectangle sashRect = sash.getBounds();
				Rectangle shellRect = parent.getClientArea();
				int right = shellRect.width - sashRect.width - limit;
				e.x = Math.max(Math.min(e.x, right), limit);
				viewerNameColumn.getColumn().setWidth(e.x - 5);
				if (e.x != sashRect.x) {
					sashData.left = new FormAttachment(0, e.x);
					parent.layout();
				}
			}
		});

		FormData rightData = new FormData();
		rightData.left = new FormAttachment(sash, 0);
		rightData.right = new FormAttachment(100, 0);
		rightData.top = new FormAttachment(0, 0);
		rightData.bottom = new FormAttachment(100, 0);
		rightComposite.setLayoutData(rightData);
	}
	
	private void setupListeners(){

		
		indexHandler.createOpenListener(listViewer);		
		up.addSelectionListener(indexHandler.createUpDownListener(true));
		down.addSelectionListener(indexHandler.createUpDownListener(false));
		
		openModelElement.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				UnicaseActionHelper.openModelElement(currentlyDisplayedElement, this.getClass().getName());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
	}
	
	/**
	 * Open an model element in the review view.
	 * 
	 * @param urmlElement the urml element
	 */
	
	public void openElement(UrmlModelElement urmlElement) {
		this.currentlyDisplayedElement = urmlElement;
		openModelElement.setEnabled(true);
		contentFactory.createElementContent(urmlElement);
	}

	@Override
	public void setFocus() {

	}
}
