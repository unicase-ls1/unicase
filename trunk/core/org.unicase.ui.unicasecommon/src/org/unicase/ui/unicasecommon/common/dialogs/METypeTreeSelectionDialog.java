/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.dialogs;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecp.common.MEClassLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.unicase.ui.unicasecommon.common.ModelTreeContentProvider;

/**
 * This dialog is similar to NewModelElementWizard.
 * 
 * @author Hodaie
 */
public class METypeTreeSelectionDialog extends TitleAreaDialog implements Listener {

	private TreeViewer treeViewer;
	private boolean multiSelection;
	private EClass[] result;

	/**
	 * default constructor.
	 * 
	 * @param parent The parent composite
	 * @param multiSelection if multiselection is allowed.
	 */
	public METypeTreeSelectionDialog(Shell parent, boolean multiSelection) {
		super(parent);
		this.multiSelection = multiSelection;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout());
		setTitle("Model element type");
		setMessage("Please select model element type.");

		Tree tree;
		if (!multiSelection) {
			tree = new Tree(contents, SWT.SINGLE);
		} else {
			tree = new Tree(contents, SWT.MULTI);
		}
		treeViewer = new TreeViewer(tree);
		treeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		treeViewer.setContentProvider(new ModelTreeContentProvider());
		treeViewer.setLabelProvider(new MEClassLabelProvider());
		// give an empty object, otherwise it does not initialize
		treeViewer.setInput(new Object());
		treeViewer.getTree().addListener(SWT.Selection, this);
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if (checkSelection()) {
					okPressed();
				}

			}

		});

		return contents;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		IStructuredSelection ssel = (IStructuredSelection) treeViewer.getSelection();

		Object[] objs = ssel.toArray();
		EClass[] eClazz = new EClass[objs.length];

		for (int i = 0; i < objs.length; i++) {
			eClazz[i] = (EClass) objs[i];
		}
		this.result = eClazz;
		this.setReturnCode(Window.OK);
		super.okPressed();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		this.result = new EClass[0];
		super.cancelPressed();
	}

	/**
	 * {@inheritDoc}
	 */
	public void handleEvent(Event event) {
		checkSelection();

	}

	@SuppressWarnings("unchecked")
	private boolean checkSelection() {

		ISelection sel = treeViewer.getSelection();
		IStructuredSelection ssel = (IStructuredSelection) sel;
		for (Iterator iter = ssel.iterator(); iter.hasNext();) {
			if (iter.next() instanceof EPackage) {
				setErrorMessage("Selection is invalid");
				getButton(Dialog.OK).setEnabled(false);
				return false;
			}
		}
		if (!getButton(Dialog.OK).getEnabled()) {
			getButton(Dialog.OK).setEnabled(true);
			setErrorMessage(null);

		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return
	 */
	public EClass[] getResult() {
		return result;
	}

}
