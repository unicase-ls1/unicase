/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.Project;

/**
 * Dialog for the execution of an operation.
 * 
 * @author herrmi
 */
public class ExecuteOperationDialog extends TitleAreaDialog {

	private final SemanticCompositeOperation operation;

	private final Project project;

	private AdapterFactoryLabelProvider labelProvider;

	private ComposedAdapterFactory adapterFactory;

	/**
	 * Constructor.
	 * 
	 * @param operation the operation
	 * @param project the project
	 */
	public ExecuteOperationDialog(SemanticCompositeOperation operation, Project project) {
		super(Display.getDefault().getActiveShell());

		this.project = project;
		this.operation = operation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Execute Operation");
		shell.setSize(400, 300);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		parent = (Composite) super.createDialogArea(parent);
		setTitle(OperationHelper.getAnnotation(operation, "label"));
		setMessage(OperationHelper.getAnnotation(operation, "description"));

		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);

		ParameterViewer parameterViewer = new ParameterViewer(this, parent, project);
		parameterViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

		parameterViewer.setInput(operation);

		return parent;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		validate();
		return contents;
	}

	/**
	 * Update the constraints of the operation.
	 */
	void validate() {
		Diagnostic diagnostic = OperationHelper.validate(operation, project);
		if (diagnostic.getSeverity() == Diagnostic.ERROR) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
			setErrorMessage(diagnostic.getChildren().get(0).getMessage());
		} else {
			setErrorMessage(null);
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.TrayDialog#close()
	 */
	@Override
	public boolean close() {
		labelProvider.dispose();
		adapterFactory.dispose();
		return super.close();
	}

	/**
	 * Returns the labelProvider.
	 * 
	 * @return the label provider
	 */
	public AdapterFactoryLabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * Returns the adapter factory.
	 * 
	 * @return the adapter factory
	 */
	public ComposedAdapterFactory getAdapterFactory() {
		return adapterFactory;
	}
}
