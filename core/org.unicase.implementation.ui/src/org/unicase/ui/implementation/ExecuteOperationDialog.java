package org.unicase.ui.implementation;

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

public class ExecuteOperationDialog extends TitleAreaDialog {

	private final SemanticCompositeOperation operation;

	private final Project project;

	private AdapterFactoryLabelProvider labelProvider;

	private ComposedAdapterFactory adapterFactory;

	public ExecuteOperationDialog(SemanticCompositeOperation operation,
			Project project) {
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
		shell.setText(operation.eClass().getName());
		shell.setSize(400, 300);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent = (Composite) super.createDialogArea(parent);
		setTitle("Set the parameters.");

		adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);

		ParameterViewer parameterViewer = new ParameterViewer(this, parent,
				project);
		parameterViewer.getTable().setLayoutData(
				new GridData(GridData.FILL_BOTH));

		parameterViewer.setInput(operation);

		return parent;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		validate();
		return contents;
	}

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

	@Override
	public boolean close() {
		labelProvider.dispose();
		adapterFactory.dispose();
		return super.close();
	}

	/** Returns labelProvider. */
	public AdapterFactoryLabelProvider getLabelProvider() {
		return labelProvider;
	}

	/** Returns adapterFactory. */
	public ComposedAdapterFactory getAdapterFactory() {
		return adapterFactory;
	}
}
