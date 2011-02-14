/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.linkrecommendation.wizards;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author henning femmer
 */
public class LinkTypeSelectionPage extends WizardPage {

	private static final String TITLE = "Link Type Selection";
	private static final String DESCRIPTION = "Select the type of links you want to trace.";

	private Table referenceTable;
	private TableColumn ref, classColumn;

	private CheckboxTableViewer tableViewer;

	private Map<EReference, List<EClass>> references;

	/**
	 * the constructor.
	 */
	protected LinkTypeSelectionPage() {
		super(TITLE);
		this.setTitle(TITLE);
		this.setDescription(DESCRIPTION);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(null);

		referenceTable = new Table(composite, SWT.CHECK | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.HIDE_SELECTION);
		referenceTable.setBounds(new org.eclipse.swt.graphics.Rectangle(5, 5, 650, 400));
		referenceTable.setHeaderVisible(true);
		ref = new TableColumn(referenceTable, SWT.NONE);
		ref.setWidth(250);
		ref.setText("Reference Type");
		classColumn = new TableColumn(referenceTable, SWT.NONE);
		classColumn.setWidth(400);
		classColumn.setText("For ModelElement Types");

		tableViewer = new CheckboxTableViewer(referenceTable);
		tableViewer.setLabelProvider(new MyTableLabelProvider());
		setControl(composite);
	}

	/**
	 * replaces the content of the table with the references.
	 * 
	 * @param classes the classes
	 */
	public void setElements(Collection<EClass> classes) {
		// referenceTable.clearAll();
		// referenceTable.setItemCount(0);

		if (references != null) {
			tableViewer.remove(references.keySet());
			tableViewer.setItemCount(0);
		}

		references = new TreeMap<EReference, List<EClass>>(new Comparator<EReference>() {
			public int compare(EReference o1, EReference o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (EClass cl : classes) {
			for (EReference ref : cl.getEAllReferences()) {
				if (references.containsKey(ref)) {
					references.get(ref).add(cl);
				} else {
					LinkedList<EClass> newList = new LinkedList<EClass>();
					newList.add(cl);
					references.put(ref, newList);
				}
			}
		}

		tableViewer.add(references.keySet().toArray());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		Collection<EReference> references = new HashSet<EReference>();
		for (TableItem ti : tableViewer.getTable().getItems()) {
			if (ti.getChecked() && ti.getData() != null) {
				Object obj = ti.getData();
				if (obj instanceof EReference) {
					references.add((EReference) obj);
				}
			}
		}

		((RecoveryWizard) getWizard()).getResultsPage().setRelevantReferences(references);
		return super.getNextPage();
	}

	/**
	 * This class provides lables for the table.
	 * 
	 * @author Henning Femmer
	 */
	private class MyTableLabelProvider extends AdapterFactoryLabelProvider {
		public MyTableLabelProvider() {
			super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return super.getImage(element);
			} else if (columnIndex == 1 && references.containsKey(element) && references.get(element).size() >= 1) {
				return super.getImage(references.get(element).get(0));
			} else {
				return null;
			}
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return super.getText(element);
			case 1:
				return this.getClassesString((EReference) element);
			default:
				return "";
			}
		}

		/**
		 * @param ref
		 * @return
		 */
		private String getClassesString(EReference ref) {
			if (ref == null || !references.containsKey(ref)) {
				return "";
			}

			String classString = "";
			Iterator<EClass> iter = references.get(ref).iterator();
			while (iter.hasNext()) {
				EClass cl = iter.next();
				classString += cl.getName();
				if (iter.hasNext()) {
					classString += ", ";
				}
			}
			return classString;
		}
	}
}
